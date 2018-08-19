package com.marketMakers.resource;

import com.marketMakers.model.Promotion;
import com.marketMakers.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
public class PromotionResource {

    @Autowired
    private PromotionService promotionService;

    @RequestMapping(value = "/api/promocao", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        try {
            Iterable<Promotion> result = promotionService.obterTodasPromocoes();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/promocao/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findOne(@PathVariable("id") Long id) {
        try {
            Promotion result = promotionService.obterPromocao(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/promocao", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Map<String, Object> body) {
        try {
			 	/*Company estabelecimento = promotionService.findEstabelecimento(body.get("estabelecimentoId").toString());
			 	if (estabelecimento != null) {
			 		String valor = (body.get("valor").toString());
			 		Promotion promocao = new Promotion(body.get("descricao").toString(), Double.valueOf(valor), body.get("tipo").toString(), estabelecimento); 
			 		promocao = promotionService.save(promocao);
			 		return new ResponseEntity<>(promocao, HttpStatus.OK);
				}else {
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}*/
            return null;
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/promocao/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Promotion promocao) {
        try {
            Promotion result = promotionService.atualizarPromocao(id, promocao);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/promocao/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            promotionService.deletarPromocao(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
