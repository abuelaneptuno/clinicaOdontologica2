package com.example.proyecto2.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoTest {
    public void creacionCorrecta(){
        @Test
        public void crearUnOdontologo() {
            Odontologo odontologo = new Odontologo(100, "Juan", "Sosa");

            assertEquals("Juan", odontologo.getNombre());
            assertEquals(100, odontologo.getMatricula());
            assertEquals("Sosa", odontologo.getApellido());
        }


    };
}