package co.vinni.asistentes.infraestructura.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AsistenteDto(

        @NotBlank(message = "La identificación es requerida")
        String identificacion,

        @NotBlank(message = "El nombre completo es requerido")
        String nombreCompleto,

        @NotNull(message = "La fecha de nacimiento es requerida")
        LocalDate fechaNacimiento,

        @NotNull(message = "La edad es requerida")
        @Min(value = 0, message = "La edad no puede ser negativa")
        Integer edad,

        @NotBlank(message = "El género es requerido")
        String genero,

        @NotBlank(message = "El barrio es requerido")
        String barrio,

        @NotBlank(message = "La identificación del responsable es requerida")
        String identificacionResponsable,

        @NotBlank(message = "El estado del asistente es requerido")
        String estadoAsistente,

        @NotNull(message = "La fecha de ingreso es requerida")
        LocalDate fechaIngreso

) {
}