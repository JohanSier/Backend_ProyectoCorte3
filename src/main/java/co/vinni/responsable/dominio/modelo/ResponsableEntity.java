package co.vinni.responsable.dominio.modelo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RESPONSABLE")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponsableEntity extends PanacheEntity {

    public String nombre;
    public String apellido;
    public String email;
}
