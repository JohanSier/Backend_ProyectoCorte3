package co.vinni.asistentes.dominio.modelo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "ASISTENTES")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AsistenteEntity extends PanacheEntity {

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