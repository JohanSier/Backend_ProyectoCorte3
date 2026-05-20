package co.vinni.responsables.dominio.modelo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RESPONSABLES")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponsableEntity extends PanacheEntity {

    @Column(nullable = false)
    public String identificacion;

    @Column(nullable = false)
    public String nombreCompleto;

    @OneToMany(mappedBy = "responsable", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    public List<NinoEntity> ninos = new ArrayList<>();
}