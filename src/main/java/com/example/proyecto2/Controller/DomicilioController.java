package com.example.proyecto2.Controller;


import com.example.proyecto2.Service.DomicilioService;
import com.example.proyecto2.Service.PacienteService;
import com.example.proyecto2.entity.Domicilio;
import com.example.proyecto2.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {
    private final DomicilioService domicilioService;

    @Autowired
    public DomicilioController(DomicilioService domicilioService) {
        this.domicilioService = domicilioService;
    }

    @PostMapping("/new")
    public ResponseEntity<Domicilio> guardar(@RequestBody Domicilio domicilio) {
        return ResponseEntity.ok(domicilioService.guardar(domicilio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Domicilio>> buscar(@PathVariable Long id) {
        Optional<Domicilio> domicilio = domicilioService.buscar(id);
        return ResponseEntity.ok(domicilio);
    }

    @PutMapping("/update")
    public ResponseEntity<Domicilio> actualizar(@RequestBody Domicilio domicilio) {
        ResponseEntity<Domicilio> response = null;

        if (domicilio.getId() != null && domicilioService.buscar(domicilio.getId()) != null) {
            response = ResponseEntity.ok(domicilioService.actualizar(domicilio));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (domicilioService.buscar(id) != null) {
            domicilioService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Domicilio>> buscarTodos() {

        return ResponseEntity.ok(domicilioService.listar());
    }
}
