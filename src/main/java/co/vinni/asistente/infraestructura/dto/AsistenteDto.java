package co.vinni.asistente.infraestructura.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AsistenteDto(
        @NotBlank(message = "El nombre es requerido")
        String nombre,
        @NotBlank(message = "El apellido es requerido")
        String apellido,
        @Email(message = "El formato del correo es incorrecto")
        @NotBlank(message = "El email es requerido")
        String email

) {
}
