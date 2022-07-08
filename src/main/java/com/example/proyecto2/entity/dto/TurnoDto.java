package com.example.proyecto2.entity.dto;

import com.example.proyecto2.entity.Odontologo;
import com.example.proyecto2.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoDto {
    private Long idTurno;
    private Odontologo odontologo;
    private Paciente paciente;
    private Date fecha;
}
