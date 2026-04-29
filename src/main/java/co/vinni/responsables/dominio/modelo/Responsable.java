package co.vinni.responsables.dominio.modelo;

import lombok.Builder;
import java.util.List;

@Builder
public class Responsable {
    public String identificacion;
    public String nombreCompleto;
    public List<String> nombresNinos;
}
