package co.vinni.asistentes.infraestructura;

import co.vinni.asistentes.aplicacion.AsistenteServicio;
import co.vinni.asistentes.dominio.modelo.Asistente;
import co.vinni.asistentes.infraestructura.dto.AsistenteDto;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.List;
import java.util.Map;

@Path("/asistentes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AsistentesRecursos {

    @Inject
    AsistenteServicio asistenteServicio;

    @POST
    @Operation(
            summary = "Crear un nuevo asistente",
            description = "Registra un asistente asociado a un responsable"
    )
    @APIResponse(
            responseCode = "201",
            description = "Asistente creado"
    )
    @APIResponse(
            responseCode = "400",
            description = "Datos de entrada inválidos"
    )
    public Response crear(@Valid AsistenteDto asistenteDto) {
        try {
            Asistente asistente = Asistente
                    .builder()
                    .identificacion(asistenteDto.identificacion())
                    .nombreCompleto(asistenteDto.nombreCompleto())
                    .fechaNacimiento(asistenteDto.fechaNacimiento())
                    .edad(asistenteDto.edad())
                    .genero(asistenteDto.genero())
                    .barrio(asistenteDto.barrio())
                    .identificacionResponsable(asistenteDto.identificacionResponsable())
                    .estadoAsistente(asistenteDto.estadoAsistente())
                    .fechaIngreso(asistenteDto.fechaIngreso())
                    .build();

            asistenteServicio.crear(asistente);

            return Response.status(Response.Status.CREATED).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Map.of("mensaje", e.getMessage()))
                    .build();
        }
    }

    @GET
    @Operation(summary = "Lista todos los asistentes")
    public Response obtenerTodos() {
        List<AsistenteDto> asistenteDtos = asistenteServicio.listar().stream()
                .map(asistente -> new AsistenteDto(
                        asistente.identificacion,
                        asistente.nombreCompleto,
                        asistente.fechaNacimiento,
                        asistente.edad,
                        asistente.genero,
                        asistente.barrio,
                        asistente.identificacionResponsable,
                        asistente.estadoAsistente,
                        asistente.fechaIngreso
                ))
                .toList();

        return Response.status(Response.Status.OK).entity(asistenteDtos).build();
    }
}