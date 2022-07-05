package com.example.proyecto2.Controller;

import com.example.proyecto2.Service.PacienteService;
import com.example.proyecto2.Service.TurnoService;
import com.example.proyecto2.entity.Paciente;
import com.example.proyecto2.entity.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private final TurnoService turnoService;

    @Autowired
    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping("/new")
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) {
        return ResponseEntity.ok(turnoService.registrarTurno(turno));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Turno>> buscar(@PathVariable Long id) {
        Optional<Turno> turno = turnoService.buscar(id);
        return ResponseEntity.ok(turno);
    }

    @PutMapping("/update")
    public ResponseEntity<Turno> actualizar(@RequestBody Turno turno) {
        ResponseEntity<Turno> response = null;

        if (turno.getId() != null && turnoService.buscar(turno.getId()) != null) {
            response = ResponseEntity.ok(turnoService.actualizar(turno));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (turnoService.buscar(id) != null) {
            turnoService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Turno>> buscarTodos() {
        return ResponseEntity.ok(turnoService.listar());
    }
}
