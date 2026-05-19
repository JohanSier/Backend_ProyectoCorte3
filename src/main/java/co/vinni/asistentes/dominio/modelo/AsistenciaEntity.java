package co.vinni.asistentes.dominio.modelo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "ASISTENCIA")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AsistenciaEntity extends PanacheEntity {

    public String asistenteId;
    public LocalDate fecha;
    public String tipo_servicio;
    public String observaciones;
    public LocalDate fecha_creacion;
}