package co.vinni.docentes.dominio.modelo;

public enum TiposDocumentos {

    CC("Cédula de Ciudadanía"),
    TI("Tarjeta de Identidad"),
    RC("Registro Civil"),
    CE("Cédula de Extranjería"),
    PPT("Permiso Protección Temporal"),
    PEP("Permiso Especial de Permanencia"),
    PAS("Pasaporte"),
    NIT("Número de Identificación Tributaria");

    private final String descripcion;

    TiposDocumentos(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}