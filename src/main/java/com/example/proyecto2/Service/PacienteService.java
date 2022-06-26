package com.example.proyecto2.Service;

import com.example.proyecto2.Repository.IDao;
import com.example.proyecto2.entity.Paciente;

import java.util.List;

public class PacienteService {
    private IDao<Paciente> pacienteDao;


    public PacienteService(IDao<Paciente>pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public Paciente registrarPaciente(Paciente paciente) {
        return pacienteDao.guardar(paciente);
    }

    public void eliminar(int id) {
        pacienteDao.eliminar(id);
    }

    public Paciente buscar(int id) {
        return pacienteDao.buscar(id);
    }

    public List<Paciente> listar() {
        return pacienteDao.listar();
    }

    public Paciente actualizar(Paciente paciente) {
        return pacienteDao.actualizar(paciente);
    }
}
