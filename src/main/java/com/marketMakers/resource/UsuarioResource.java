package com.marketMakers.resource;

import com.marketMakers.model.Usuario;
import com.marketMakers.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody Map<String, Object> body) {
        try {
            Usuario usuario = new Usuario(
                    body.get("id").toString(),
                    body.get("name").toString(),
                    body.get("email").toString());
            usuarioService.save(usuario);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}