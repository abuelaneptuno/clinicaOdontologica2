package com.example.proyecto2.Repository;

import java.util.List;

public abstract interface IDao<T> {

    T guardar(T t);
    T buscar(int id);
    T eliminar(int id);
    List<T> listar();
    T actualizar(T t);
}
