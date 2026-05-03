package co.vinni.docentes.infraestructura.dto;

import co.vinni.docentes.dominio.modelo.TiposDocumentos;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Path("/enums")
@Produces(MediaType.APPLICATION_JSON)
public class EnumRecursos {

    @GET
    @Path("/tipos-documento")
    public Response listarTiposDocumento() {
        List<Map<String, String>> tipos = Arrays.stream(TiposDocumentos.values())
                .map(tipo -> Map.of(
                    "valor", tipo.name(),
                    "descripcion", obtenerDescripcion(tipo)
                ))
                .collect(Collectors.toList());
        return Response.ok(tipos).build();
    }

    private String obtenerDescripcion(TiposDocumentos tipo) {
        switch (tipo) {
            case CC: return "Cédula de Ciudadanía";
            case TI: return "Tarjeta de Identidad";
            case RC: return "Registro Civil";
            case CE: return "Cédula de Extranjería";
            case PPT: return "Permiso Protección Temporal";
            case PEP: return "Permiso Especial de Permanencia";
            case PAS: return "Pasaporte";
            case NIT: return "NIT";
            default: return tipo.name();
        }
    }
}