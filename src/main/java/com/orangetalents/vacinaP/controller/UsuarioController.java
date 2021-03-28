package com.orangetalents.vacinaP.controller;

import com.orangetalents.vacinaP.Erro.ResourceNotFoundException;
import com.orangetalents.vacinaP.repository.UsuarioRepository;
import com.orangetalents.vacinaP.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UsuarioController {
    private final UsuarioRepository usuarioDAO;

    @Autowired
    public UsuarioController (UsuarioRepository usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    @GetMapping
    public ResponseEntity<?> listAll (Pageable pageable) {
        return new ResponseEntity<>(usuarioDAO.findAll(pageable), HttpStatus.OK);
    }
    @GetMapping(path = "/find/{name}")
    public ResponseEntity <?> findUsuariosByName (@PathVariable String name){
        return new ResponseEntity<>(usuarioDAO.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
    }



    @PostMapping  //(path = "/usuario")
    public ResponseEntity<?> save ( @RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioDAO.save(usuario), HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        verifyIfUsuariotExists(id);
        usuarioDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> update (@RequestBody Usuario usuario) {
        verifyIfUsuariotExists(usuario.getId());
        usuarioDAO.save(usuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verifyIfUsuariotExists(Long id) {

        if (!usuarioDAO.findById(id).isPresent()) {
            throw new ResourceNotFoundException("Usuario nao encontrado  : " + id);
        }
    }
    }



