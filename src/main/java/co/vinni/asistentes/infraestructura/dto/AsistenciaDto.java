package co.vinni.asistentes.infraestructura.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AsistenciaDto(

        @NotBlank(message = "El identificador es requerido")
        String id_asistencia,

        @NotBlank(message = "La identificación es requerida")
        String asistente_id,

        @NotNull(message = "La fecha de registro es requerida")
        LocalDate fecha,

        @NotBlank(message = "El tipo de servicio es requerido")
        String tipo_servicio,

        @NotBlank(message = "La observacion es requerida")
        String observaciones,

        @NotNull(message = "La fecha de creacion es requerida")
        LocalDate fecha_creacion

) {
}