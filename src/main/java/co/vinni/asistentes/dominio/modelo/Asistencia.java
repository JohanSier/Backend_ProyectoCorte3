package co.vinni.asistentes.dominio.modelo;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public class Asistencia {
    public String id_asistencia;
    public String asistente_id;
    public LocalDate fecha;
    public String tipo_servicio;
    public String observaciones;
    public LocalDate fecha_creacion;
}