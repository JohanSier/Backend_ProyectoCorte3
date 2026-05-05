package co.vinni.ayudas.infraestructura.dto;

import co.vinni.ayudas.dominio.modelo.TipoAyuda;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record AyudaDto(

        @NotNull(message = "El tipo de ayuda es requerido")
        TipoAyuda tipo,

        @NotNull(message = "El id del colaborador es requerido")
        Long idColaborador,

        @NotBlank(message = "El nombre del colaborador es requerido")
        String nombreColaborador,

        @NotBlank(message = "La descripción de la ayuda es requerida")
        String descripcion,

        Double valor,

        Integer cantidad,

        @NotNull(message = "La fecha de registro es requerida")
        @PastOrPresent(message = "La fecha de registro no puede ser futura")
        LocalDate fechaRegistro
) {
}