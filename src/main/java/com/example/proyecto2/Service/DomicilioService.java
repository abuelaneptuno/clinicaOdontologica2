package com.example.proyecto2.Service;

import com.example.proyecto2.Repository.DomicilioRepository;
import com.example.proyecto2.entity.Domicilio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioService {
    private final DomicilioRepository domicilioRepository;

    public DomicilioService(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    public Domicilio guardar(Domicilio domicilio) {
        domicilioRepository.save(domicilio);
        return domicilio;
    }

    public Domicilio buscar(Long id) {
        return domicilioRepository.findById(id).get();
    }

    public List<Domicilio> buscarTodos() {
        return domicilioRepository.findAll();
    }

    public void eliminar(Long id) {
        domicilioRepository.deleteById(id);
    }
}
