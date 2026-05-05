package co.vinni.ayudas.dominio.modelo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "AYUDAS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AyudaEntity extends PanacheEntity {
    public Long idColaborador;
    public String nombreColaborador;

    @Enumerated(EnumType.STRING)
    public TipoAyuda tipo;

    public String descripcion;
    public Double valor;
    public Integer cantidad;
    public java.time.LocalDate fechaRegistro;

    @Enumerated(EnumType.STRING)
    public EstadoAyuda estado;
}