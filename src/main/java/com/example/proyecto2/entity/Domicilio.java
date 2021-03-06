package com.example.proyecto2.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name = "DOMICILIOS")
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String provincia;
    private String ciudad;
    private String direccion;

    public Domicilio(String provincia, String ciudad, String direccion) {
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public Domicilio() {
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "direccion=" + direccion +
                ", ciudad='" + ciudad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
