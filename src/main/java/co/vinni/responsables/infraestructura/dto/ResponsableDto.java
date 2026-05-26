package co.vinni.responsables.infraestructura.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public record ResponsableDto(

        @NotBlank(message = "La identificación no puede estar vacía")
        String identificacion,

        @NotBlank(message = "El nombre completo no puede estar vacío")
        String nombreCompleto,

        boolean tieneVariosNinos,

        @NotEmpty(message = "Debe registrar al menos un niño")
        List<@NotBlank(message = "El nombre del niño no puede estar vacío") String> nombresNinos

) {}