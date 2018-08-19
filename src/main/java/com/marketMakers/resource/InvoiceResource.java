package com.marketMakers.resource;

import com.marketMakers.model.Company;
import com.marketMakers.model.Invoice;
import com.marketMakers.model.Product;
import com.marketMakers.service.CompanyService;
import com.marketMakers.service.InvoiceService;
import com.marketMakers.service.ProductService;
import com.marketMakers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
public class InvoiceResource {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}/invoice", method = RequestMethod.POST)
    public ResponseEntity save(@PathVariable String id, @RequestBody Map<String, Object> body) {
        try {
            List<Product> products = getProdutsOnThefederalIncome();

            Invoice invoice = new Invoice();
            invoice.setProducts(products);
            invoice.setCode(body.get("invoiceId").toString().substring(0, 10));
            invoice.setData(new Date());
            invoice.setCompany(getCompany());
            invoice.setUser(userService.findAll().iterator().next());
            invoiceService.save(invoice);

            return new ResponseEntity<>(invoice, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Product> getProdutsOnThefederalIncome() {
        Product product01 = new Product(
                "Arroz Tipo 1 Camil",
                "ARZ9098",
                new BigDecimal(10),
                2l,
                "Cereais e Farináceos");
        productService.save(product01);

        Product product02 = new Product(
                "Feijão de corda Broto Legal",
                "AWDS9098",
                new BigDecimal(5),
                7l,
                "Cereais e Farináceos");
        productService.save(product02);

        Product product03 = new Product(
                "Biscoito Wafer Aymoré Chocolate",
                "BCT9098",
                new BigDecimal(2),
                20l,
                "Biscoito");
        productService.save(product03);

        return Arrays.asList(product01, product02, product03);
    }

    public Company getCompany() {
        return companyService.findAll().iterator().next();
    }
}