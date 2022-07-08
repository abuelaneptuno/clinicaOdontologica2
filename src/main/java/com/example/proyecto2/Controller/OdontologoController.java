package com.example.proyecto2.Controller;

import com.example.proyecto2.Exceptions.ResourceNotFoundException;
import com.example.proyecto2.Service.OdontologoService;
import com.example.proyecto2.entity.Odontologo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private final OdontologoService odontologoService;
    private static final Logger logger = Logger.getLogger(OdontologoController.class);

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping("/registrar")
    public Odontologo registrarOdontologo(@RequestBody Odontologo odontologo) {
        return odontologoService.registrarOdontologo(odontologo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Odontologo>> buscar(@PathVariable Long id) {
        Optional<Odontologo> odontologo = null;
        try {
            odontologo = odontologoService.buscar(id);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(odontologo);
    }

    @PutMapping("/update")
    public ResponseEntity<String> actualizar(@RequestBody Odontologo odontologo) throws ResourceNotFoundException {
        odontologoService.actualizar(odontologo);
        return ResponseEntity.ok("Se actualizó odontologo id "+ odontologo.getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        odontologoService.eliminar(id);
        return ResponseEntity.ok("Se eliminó odontólogo con id "+ id);
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarTodos() {

        return ResponseEntity.ok(odontologoService.listar());
    }

}
