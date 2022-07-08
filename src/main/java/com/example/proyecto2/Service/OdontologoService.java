package com.example.proyecto2.Service;

import com.example.proyecto2.Exceptions.ResourceNotFoundException;
import com.example.proyecto2.Repository.OdontologoRepository;
import com.example.proyecto2.entity.Odontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    public void eliminar(Long id) throws ResourceNotFoundException {
        if (Objects.nonNull(buscar(id))) {
            odontologoRepository.deleteById(id);
        }
    }

    public List<Odontologo> listar() {
        return odontologoRepository.findAll();
    }

    public Odontologo actualizar(Odontologo odontologo) throws ResourceNotFoundException{
        if (buscar(odontologo.getId()) == null) {
            throw new ResourceNotFoundException("No existe el odontólogo con id "+ odontologo.getId());
        }
        return odontologoRepository.save(odontologo);
    }
    
    public Optional<Odontologo> buscar (Long id) throws ResourceNotFoundException {
        if (odontologoRepository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("No existe el odontólogo con id" + id);
        }
        return odontologoRepository.findById(id);
    }
}
