package co.vinni.docentes.dominio.modelo;

import lombok.Builder;
import java.time.LocalDate;

@Builder
public class Colaborador {
    
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
