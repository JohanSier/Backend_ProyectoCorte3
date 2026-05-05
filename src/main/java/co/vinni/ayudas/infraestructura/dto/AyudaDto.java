package co.vinni.ayudas.infraestructura.dto;

import co.vinni.ayudas.dominio.modelo.TipoAyuda;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public record AyudaDto(

        @NotNull(message = "El tipo de ayuda es requerido")
        @Schema(example = "DINERO")
        TipoAyuda tipo,

        @NotNull(message = "El id del colaborador es requerido")
        @Schema(example = "1")
        Long idColaborador,

        @NotBlank(message = "El nombre del colaborador es requerido")
        @Schema(example = "Giovanni Sierra")
        String nombreColaborador,

        @NotBlank(message = "La descripción de la ayuda es requerida")
        @Schema(example = "Donación de alimentos para el comedor")
        String descripcion,

        @Schema(example = "2000000.0")
        Double valor,

        @Schema(example = "0")
        Integer cantidad,

        @NotNull(message = "La fecha de registro es requerida")
        @PastOrPresent(message = "La fecha de registro no puede ser futura")
        @Schema(example = "2026-05-04")
        LocalDate fechaRegistro
) {}

