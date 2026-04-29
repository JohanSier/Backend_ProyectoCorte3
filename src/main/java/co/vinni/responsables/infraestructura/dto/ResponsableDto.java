package co.vinni.responsables.infraestructura.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public record ResponsableDto(

        @NotBlank(message = "La identificacion no puede estar vacia")
        String identificacion,

        @NotBlank(message = "El nombre completo no puede estar vacio")
        String nombreCompleto,

        boolean tieneVariosNinos,

        @NotEmpty(message = "Debe registrar al menos un nino")
        List<@NotBlank(message = "El nombre del nino no puede estar vacio") String> nombresNinos

) {}