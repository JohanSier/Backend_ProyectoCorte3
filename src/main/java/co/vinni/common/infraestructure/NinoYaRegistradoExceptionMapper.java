package co.vinni.common.infraestructure;

import co.vinni.common.exception.NinoYaRegistradoException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.util.Map;

@Provider
public class NinoYaRegistradoExceptionMapper
        implements ExceptionMapper<NinoYaRegistradoException> {

    @Override
    public Response toResponse(NinoYaRegistradoException ex) {
        return Response.status(Response.Status.CONFLICT)
                .entity(Map.of(
                        "error", "Niño ya registrado",
                        "mensaje", ex.getMessage()
                ))
                .build();
    }
}