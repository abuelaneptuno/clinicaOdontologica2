package com.example.proyecto2.Controller;

import com.example.proyecto2.Exceptions.ResourceNotFoundException;
import com.example.proyecto2.Service.PacienteService;
import com.example.proyecto2.entity.Paciente;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;
    private static final Logger logger = Logger.getLogger(PacienteController.class);

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/new")
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) {
        logger.info("Guardado paciente " + paciente.getId());
        return ResponseEntity.ok(pacienteService.registrarPaciente(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Paciente>> buscar(@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteService.buscar(id);
        return ResponseEntity.ok(paciente);
    }

    @PutMapping("/update")
    public ResponseEntity<String> actualizar(@RequestBody Paciente paciente) throws ResourceNotFoundException {
        pacienteService.actualizar(paciente);
        return ResponseEntity.ok("Se actualizó paciente id "+ paciente.getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        pacienteService.eliminar(id);
        return ResponseEntity.ok("Se eliminó paciente con id "+ id);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos() {
        return ResponseEntity.ok(pacienteService.listar());
    }
}
