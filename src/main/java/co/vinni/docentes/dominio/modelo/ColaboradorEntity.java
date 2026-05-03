package co.vinni.docentes.dominio.modelo;

import java.time.LocalDate;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "COLABORADORES")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorEntity extends PanacheEntity {

    @Enumerated(EnumType.STRING)
    public TiposDocumentos tipoDocumento;
    
    public String numeroDocumento;
    public String nombres;
    public String apellidos;
    public String email;
    public String telefono;
    public String direccion;
    public String ciudad;
    public LocalDate fechaIngreso;
    public LocalDate fechaNacimiento;
    public String genero;
}
