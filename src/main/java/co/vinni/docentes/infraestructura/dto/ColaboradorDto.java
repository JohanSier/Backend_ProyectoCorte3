package co.vinni.docentes.infraestructura.dto;

import co.vinni.docentes.dominio.modelo.TiposDocumentos;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record ColaboradorDto(
        
        @NotNull(message = "El tipo de documento es requerido")
        TiposDocumentos tipoDocumento,
        @NotBlank(message = "El número de documento es requerido")
        String numeroDocumento,
        @NotBlank(message = "El nombre es requerido")
        String nombres,
        @NotBlank(message = "El apellido es requerido")
        String apellidos,
        @Email(message = "El formato del correo es incorrecto")
        @NotBlank(message = "El email es requerido")
        String email,
        @NotBlank(message = "El teléfono es requerido")
        String telefono,
        @NotBlank(message = "La dirección es requerida")
        String direccion,
        @NotBlank(message = "La ciudad es requerida")
        String ciudad,
        @NotNull @PastOrPresent (message = "La fecha de ingreso es requerida")
        LocalDate fechaIngreso,
        @NotNull @Past (message = "La fecha de nacimiento es requerida")
        LocalDate fechaNacimiento,
        @NotBlank(message = "El género es requerido")
        String genero

) {
}
