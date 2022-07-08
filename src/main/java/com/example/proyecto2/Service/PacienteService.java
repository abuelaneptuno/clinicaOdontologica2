package com.example.proyecto2.Service;

import com.example.proyecto2.Exceptions.ResourceNotFoundException;
import com.example.proyecto2.Repository.PacienteRepository;
import com.example.proyecto2.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente registrarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void eliminar(Long id) throws ResourceNotFoundException {
        if (Objects.nonNull(buscar(id))) {
            pacienteRepository.deleteById(id);
        }
    }

    public Optional<Paciente> buscar(Long id) {
        return pacienteRepository.findById(id);
    }

    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    public Paciente actualizar(Paciente paciente) throws ResourceNotFoundException {
        if (buscar(paciente.getId()) == null) {
            throw new ResourceNotFoundException("No existe el paciente con id "+ paciente.getId());
        }
        return pacienteRepository.save(paciente);
    }
}
