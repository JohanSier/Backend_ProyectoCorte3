package co.vinni.responsable.dominio.modelo;

import lombok.Builder;

@Builder
public class Responsable {
    public String nombre;
    public String apellido;
    public String email;
}
