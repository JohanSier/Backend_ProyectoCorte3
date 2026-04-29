package co.vinni.asistente.dominio.modelo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Asistente")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AsistenteEntity extends PanacheEntity {

    public String nombre;
    public String apellido;
    public String email;
}
