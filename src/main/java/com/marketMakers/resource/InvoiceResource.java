package com.marketMakers.resource;

import com.marketMakers.model.Company;
import com.marketMakers.model.Invoice;
import com.marketMakers.model.Product;
import com.marketMakers.model.User;
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
            //Fake info
            User user = userService.findByUserApp(id);
            Company company = companyService.findAll().iterator().next();
            List<Product> products = getProdutsOnThefederalIncome();

            Invoice invoice = new Invoice();
            invoice.setProducts(products);
            invoice.setCode(body.get("invoiceId").toString().substring(0, 10));
            invoice.setData(new Date());
            invoice.setCompany(company);
            invoice.setUser(user);
            invoiceService.save(invoice);

            //Update dots
            user.setDots(user.getDots() + calcDots(products));
            userService.save(user);

            return new ResponseEntity<>(invoice, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static int calcDots(List<Product> products) {
        return products.stream().mapToInt(p -> Math.toIntExact(p.getQuantity())).sum();
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
}