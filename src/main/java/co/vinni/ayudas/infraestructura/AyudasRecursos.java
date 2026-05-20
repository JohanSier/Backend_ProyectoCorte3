package co.vinni.ayudas.infraestructura;

import co.vinni.ayudas.aplicacion.AyudaServicio;
import co.vinni.ayudas.dominio.modelo.Ayuda;
import co.vinni.ayudas.dominio.modelo.EstadoAyuda;
import co.vinni.ayudas.infraestructura.dto.AyudaDto;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/ayudas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AyudasRecursos {

    @Inject
    AyudaServicio ayudaServicio;

    @POST
    @Operation(
        summary = "Registrar una nueva ayuda",
        description = "Registra una ayuda o donación recibida indicando su tipo, colaborador y detalle"
    )
    @APIResponse(
        responseCode = "201",
        description = "Ayuda registrada exitosamente"
    )
    @APIResponse(
        responseCode = "400",
        description = "Datos de entrada inválidos"
    )
    public Response registrar(@Valid AyudaDto ayudaDto) {

        // Validación condicional según tipo
        if (ayudaDto.tipo() != null) {
            switch (ayudaDto.tipo()) {
                case DINERO -> {
                    if (ayudaDto.valor() == null || ayudaDto.valor() <= 0) {
                        return Response.status(Response.Status.BAD_REQUEST)
                                .entity("El valor debe ser mayor a 0 para ayudas en dinero")
                                .build();
                    }
                }
                case EN_ESPECIE -> {
                    if (ayudaDto.cantidad() == null || ayudaDto.cantidad() <= 0) {
                        return Response.status(Response.Status.BAD_REQUEST)
                                .entity("La cantidad debe ser mayor a 0 para ayudas en especie")
                                .build();
                    }
                }
            }
        }

        Ayuda ayuda = Ayuda
                .builder()
                .idColaborador(ayudaDto.idColaborador())
                .nombreColaborador(ayudaDto.nombreColaborador())
                .tipo(ayudaDto.tipo())
                .descripcion(ayudaDto.descripcion())
                .valor(ayudaDto.valor())
                .cantidad(ayudaDto.cantidad())
                .fechaRegistro(ayudaDto.fechaRegistro())
                .estado(EstadoAyuda.REGISTRADA)
                .build();

        ayudaServicio.registrar(ayuda);

        return Response.status(Response.Status.CREATED)
                .entity("Ayuda registrada exitosamente")
                .build();
    }
}