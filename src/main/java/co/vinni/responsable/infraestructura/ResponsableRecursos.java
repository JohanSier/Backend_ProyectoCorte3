package co.vinni.responsable.infraestructura;

import co.vinni.responsable.aplicacion.ResponsableServicio;
import co.vinni.responsable.dominio.modelo.Responsable;
import co.vinni.responsable.infraestructura.dto.ResponsableDto;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.List;

@Path("/responsable")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ResponsableRecursos {

    @Inject
    ResponsableServicio responsableServicio;

    @POST
    @Operation(
        summary = "Crear un nuevo docente",
        description = "Registra el docente con sus datos nombre, apellido y correo"
    )
    @APIResponse(
        responseCode = "201",
        description = "Docente creado"
    )
    @APIResponse(
        responseCode = "400",
        description = "Datos de entrada invalidos"
    )
    public Response crear(@Valid ResponsableDto responsableDto) {
        Responsable responsable = Responsable
                .builder()
                .nombre(responsableDto.nombre())
                .apellido(responsableDto.apellido())
                .email(responsableDto.email())
                .build();
        responsableServicio.crear(responsable);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Operation(summary = "Lista todos los responsables")
    public Response obtenerTodos() {
        List<ResponsableDto> responsableDtos = responsableServicio.listar().stream()
                .map(responsable -> new ResponsableDto(responsable.nombre,  responsable.apellido, responsable.email) )
                .toList();
        return Response.status(Response.Status.OK).entity(responsableDtos).build();
    }
}
