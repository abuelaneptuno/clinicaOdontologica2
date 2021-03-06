package com.example.proyecto2.entity;

import java.util.Date;

import org.apache.log4j.Logger;

import javax.persistence.*;

@Entity
@Table(name = "turnos")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //REVISAR DISINTOS
    private Long id;

        @ManyToOne
        @JoinColumn(name = "patient_id", nullable = false)
        private Paciente paciente;

        @ManyToOne
        @JoinColumn(name = "odontologist_id", nullable = false)
        private Odontologo odontologo;

        private Date fecha;
        private int horario;

    public Turno() {
    }

    public Turno(Odontologo odontologo, Paciente paciente, Date fecha) {
            this.odontologo = odontologo;
            this.paciente = paciente;
            this.fecha = fecha;
        }

        public Odontologo getOdontologo() {
            return odontologo;
        }

        public void setOdontologo(Odontologo odontologo) {
            this.odontologo = odontologo;
        }

        public Paciente getPaciente() {
            return paciente;
        }

        public void setPaciente(Paciente paciente) {
            this.paciente = paciente;
        }

        public Date getFecha() {
            return fecha;
        }

        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }

        public int getHorario() {
            return horario;
        }

        public void setHorario(int horario) {
            this.horario = horario;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
        public String toString() {
            return "Turno{" +
                    "Odontologo=" + odontologo.getNombre() + " " + odontologo.getApellido() + '\'' +
                    ", Paciente='" + paciente.getNombre() + " " + paciente.getApellido() + '\'' +
                    ", Fecha='" + fecha + '\'' +
                    '}';
        }
}
