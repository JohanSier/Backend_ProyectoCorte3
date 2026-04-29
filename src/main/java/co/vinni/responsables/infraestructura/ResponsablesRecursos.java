package co.vinni.responsables.infraestructura;

import co.vinni.responsables.aplicacion.ResponsableServicio;
import co.vinni.responsables.dominio.modelo.Responsable;
import co.vinni.responsables.infraestructura.dto.ResponsableDto;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import java.util.List;
import java.util.Map;

@Path("/responsables")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ResponsablesRecursos {

    @Inject
    ResponsableServicio servicio;

    @POST
    @Operation(
            summary = "Registrar un nuevo responsable",
            description = "Registra el responsable con identificacion, nombre completo y nombres de ninos a cargo"
    )
    @APIResponse(responseCode = "201", description = "Responsable registrado exitosamente")
    @APIResponse(responseCode = "400", description = "Datos de entrada invalidos")
    @APIResponse(responseCode = "409", description = "Nino ya registrado con otro responsable")
    public Response crear(@Valid ResponsableDto dto) {
        Responsable responsable = Responsable.builder()
                .identificacion(dto.identificacion())
                .nombreCompleto(dto.nombreCompleto())
                .nombresNinos(dto.nombresNinos())
                .build();
        servicio.crear(responsable);
        return Response.status(Response.Status.CREATED)
                .entity(Map.of("mensaje", "Responsable registrado exitosamente"))
                .build();
    }

    @GET
    @Operation(summary = "Listar todos los responsables")
    public Response obtenerTodos() {
        List<ResponsableDto> dtos = servicio.listar().stream()
                .map(r -> new ResponsableDto(
                        r.identificacion,
                        r.nombreCompleto,
                        r.nombresNinos.size() > 1,
                        r.nombresNinos
                ))
                .toList();
        return Response.ok(dtos).build();
    }
}