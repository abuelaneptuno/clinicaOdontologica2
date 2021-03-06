package com.example.proyecto2.Service;

import com.example.proyecto2.Repository.PacienteRepository;
import com.example.proyecto2.Repository.TurnoRepository;
import com.example.proyecto2.entity.Paciente;
import com.example.proyecto2.entity.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {
    private final TurnoRepository turnoRepository;

    @Autowired
    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public Turno registrarTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    public void eliminar(Long id) {
        turnoRepository.deleteById(id);
    }

    public Optional<Turno> buscar(Long id) {
        return turnoRepository.findById(id);
    }

    public List<Turno> listar() {
        return turnoRepository.findAll();
    }

    public Turno actualizar(Turno turno) {
        return turnoRepository.save(turno);
    }
}
