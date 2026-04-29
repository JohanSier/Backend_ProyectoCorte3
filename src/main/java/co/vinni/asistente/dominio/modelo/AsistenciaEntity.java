package co.vinni.asistente.dominio.modelo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "ASISTENCIA")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AsistenciaEntity extends PanacheEntity {

    public Long id_asistencia;
    public String asistente_id;
    public Date fecha;
    public String tipo_servicio;
    public String observaciones;
    public Date fecha_creacion;

}
