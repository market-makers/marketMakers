package com.marketMakers.resource;

import com.marketMakers.model.Nota;
import com.marketMakers.model.Produto;
import com.marketMakers.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
public class NotaResource {

    @Autowired
    private NotaService notaService;

    @RequestMapping(value = "/api/usuario/{usuarioId}/nota", method = RequestMethod.POST)
    public ResponseEntity save(
            @PathVariable String usuarioId,
            @RequestBody(required = true) Map<String, Object> corpo) {
        try {
            //Consultar a receita e retornar as notas
            Iterable<Nota> result = notaService.findAll();
            return new ResponseEntity<>(result.iterator().next(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}