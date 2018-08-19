package com.marketMakers.resource;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marketMakers.model.Estabelecimento;
import com.marketMakers.model.Promocao;
import com.marketMakers.service.PromocaoService;

@CrossOrigin(maxAge = 3600)
@RestController
public class PromocaoResource {
	
	@Autowired
	private PromocaoService promocaoService;
	
	 @RequestMapping(value = "/api/promocao", method = RequestMethod.GET)
	    public ResponseEntity<?> findAll() {
	        try {
	            Iterable<Promocao> result = promocaoService.obterTodasPromocoes();
	            return new ResponseEntity<>(result, HttpStatus.OK);
	        } catch (Exception ex) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	 
	 @RequestMapping(value = "/api/promocao/{id}", method = RequestMethod.GET)
	    public ResponseEntity<?> findOne(@PathVariable("id") Long id) {
	        try {
	        	Promocao result = promocaoService.obterPromocao(id);
	            return new ResponseEntity<>(result, HttpStatus.OK);
	        } catch (Exception ex) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	 
	 @RequestMapping(value = "/api/promocao", method = RequestMethod.POST)
	    public ResponseEntity<?> save(@RequestBody Map<String, Object> body) {
		 try {
			 	Estabelecimento estabelecimento = promocaoService.findEstabelecimento(body.get("estabelecimentoId").toString());
			 	if (estabelecimento != null) {
			 		String valor = (body.get("valor").toString());
			 		Promocao promocao = new Promocao(body.get("descricao").toString(), Double.valueOf(valor), body.get("tipo").toString(), estabelecimento); 
			 		promocao = promocaoService.save(promocao);
			 		return new ResponseEntity<>(promocao, HttpStatus.OK);
				}else {
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
	        } catch (Exception ex) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	 
	 @RequestMapping(value = "/api/promocao/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Promocao promocao) {
	        try {
	        	Promocao result = promocaoService.atualizarPromocao(id, promocao);
	            return new ResponseEntity<>(result, HttpStatus.OK);
	        } catch (Exception ex) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	 
	 @RequestMapping(value = "/api/promocao/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
	        try {
	        	promocaoService.deletarPromocao(id);
	            return new ResponseEntity<>(HttpStatus.OK);
	        } catch (Exception ex) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
}
