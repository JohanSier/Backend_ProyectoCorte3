package co.vinni.docentes.dominio.modelo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ROLES")
@NoArgsConstructor
@AllArgsConstructor
public class RolesEntity extends PanacheEntity {

    @Column(unique = true, nullable = false)
    public String nombres;

    @Column
    public String descripcion;
}