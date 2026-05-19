package co.vinni.docentes.servicio;

import co.vinni.asistentes.aplicacion.AsistenteServicio;
import co.vinni.asistentes.dominio.modelo.Asistencia;
import co.vinni.asistentes.dominio.repositorio.AsistenteRepositorio;
import co.vinni.docentes.dominio.modelo.Docente;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.*;


@QuarkusTest
public class AsistenteServicioTest {
    @Inject
    AsistenteServicio asistenteServicio;

    @InjectMock
    AsistenteRepositorio asistenteRepositorio;
    private Asistencia asistenciaPrueba;
    @BeforeEach
    public void setup(){
        asistenciaPrueba = Asistencia
                .builder()
                .asistenteId("1010235696")
                .fecha(LocalDate.parse("07/07/2026"))
                .tipo_servicio("correo@correo.com")
                .observaciones("Patero")
                .fecha_creacion(LocalDate.parse("07/07/2026"))
                .build();

    }
}
