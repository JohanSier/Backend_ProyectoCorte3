package co.vinni.docentes.infraestructura;

import co.vinni.docentes.aplicacion.ColaboradorServicio;
import co.vinni.docentes.dominio.modelo.Colaborador;
import co.vinni.docentes.infraestructura.dto.ColaboradorDto;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.List;

@Path("/colaboradores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ColaboradorRecursos {

    @Inject
    ColaboradorServicio colaboradorServicio;

    @POST
    @Operation(
        summary = "Crear un nuevo colaborador",
        description = "Registra el colaborador con sus datos necesarios"
    )
    @APIResponse(
        responseCode = "201",
        description = "Colaborador creado"
    )
    @APIResponse(
        responseCode = "400",
        description = "Datos de entrada invalidos"
    )
    public Response crear(@Valid ColaboradorDto colaboradorDto) {
        Colaborador colaborador = Colaborador
                .builder()
                .tipoDocumento(colaboradorDto.tipoDocumento())
                .numeroDocumento(colaboradorDto.numeroDocumento())
                .nombres(colaboradorDto.nombres())
                .apellidos(colaboradorDto.apellidos())
                .email(colaboradorDto.email())
                .telefono(colaboradorDto.telefono())
                .direccion(colaboradorDto.direccion())
                .ciudad(colaboradorDto.ciudad())
                .fechaIngreso(colaboradorDto.fechaIngreso())
                .fechaNacimiento(colaboradorDto.fechaNacimiento())
                .genero(colaboradorDto.genero())
                .build();
        colaboradorServicio.crear(colaborador);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Operation(summary = "Lista todos los colaboradores")
    public Response obtenerTodos() {
        List<ColaboradorDto> colaboradorDtos = colaboradorServicio.listar().stream()
            .map(colaborador -> new ColaboradorDto(colaborador.tipoDocumento, colaborador.numeroDocumento, colaborador.nombres, colaborador.apellidos, colaborador.email, colaborador.telefono, colaborador.direccion, colaborador.ciudad, colaborador.fechaIngreso, colaborador.fechaNacimiento, colaborador.genero))
            .toList();
        return Response.status(Response.Status.OK).entity(colaboradorDtos).build();
    }
}
