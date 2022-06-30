package com.example.proyecto2.Service;

import com.example.proyecto2.Repository.OdontologoRepository;
import com.example.proyecto2.entity.Odontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
    private final OdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo registrarOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    public void eliminar(Long id) {
        odontologoRepository.deleteById(id);
    }


    public List<Odontologo> listar() {
        return odontologoRepository.findAll();
    }

    public Odontologo actualizar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }
    
    public Optional<Odontologo> buscar (Long id){
        return odontologoRepository.findById(id);
    }
}
