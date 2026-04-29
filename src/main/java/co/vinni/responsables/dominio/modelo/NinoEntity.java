package co.vinni.responsables.dominio.modelo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "NINOS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NinoEntity extends PanacheEntity {

    @Column(nullable = false)
    public String nombreCompleto;

    @ManyToOne
    @JoinColumn(name = "responsable_id")
    public ResponsableEntity responsable;
}