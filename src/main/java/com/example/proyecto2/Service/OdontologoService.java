package com.example.proyecto2.Service;

import com.example.proyecto2.Repository.IDao;
import com.example.proyecto2.entity.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> odontologoDao;


    public OdontologoService(IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public Odontologo registrarOdontologo(Odontologo odontologo) {
        return odontologoDao.guardar(odontologo);

    }

    public void eliminar(int id) {
        odontologoDao.eliminar(id);
    }

    public Odontologo buscar(int id) {
        return odontologoDao.buscar(id);
    }

    public List<Odontologo> listar() {
        return odontologoDao.listar();
    }

    public Odontologo actualizar(Odontologo odontologo) {
        return odontologoDao.actualizar(odontologo);
    }
}
