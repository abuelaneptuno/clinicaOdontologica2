package com.example.proyecto2.Controller;

import com.example.proyecto2.Repository.Implementaciones.OdontologoDao;
import com.example.proyecto2.Service.OdontologoService;
import com.example.proyecto2.entity.Odontologo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("odontologos")
public class OdontologoController {

    private OdontologoDao odontologoDao = new OdontologoDao();
    private OdontologoService odontologoService = new OdontologoService(odontologoDao);

    @GetMapping
    public ResponseEntity<List<Odontologo>> listar() { return ResponseEntity.ok(odontologoService.listar());}

    @PostMapping()
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo) {

        return ResponseEntity.ok(odontologoService.registrarOdontologo(odontologo));

    }

}
