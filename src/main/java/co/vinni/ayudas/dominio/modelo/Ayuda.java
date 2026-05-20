package co.vinni.ayudas.dominio.modelo;

import lombok.Builder;

@Builder
public class Ayuda {
    public Long idColaborador;
    public String nombreColaborador;
    public TipoAyuda tipo;
    public String descripcion;
    public Double valor;
    public Integer cantidad;
    public java.time.LocalDate fechaRegistro;
    public EstadoAyuda estado;
}