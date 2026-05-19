package co.vinni.asistentes.dominio.modelo;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public class Asistente {
    public String identificacion;
    public String nombreCompleto;
    public LocalDate fechaNacimiento;
    public Integer edad;
    public String genero;
    public String barrio;
    public String identificacionResponsable;
    public String estadoAsistente;
    public LocalDate fechaIngreso;
}