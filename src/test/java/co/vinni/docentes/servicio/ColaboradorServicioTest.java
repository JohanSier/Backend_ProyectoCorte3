package co.vinni.docentes.servicio;

import co.vinni.docentes.aplicacion.ColaboradorServicio;
import co.vinni.docentes.dominio.modelo.Colaborador;
import co.vinni.docentes.dominio.repositorio.ColaboradorRepositorio;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.time.LocalDate;

import static org.mockito.Mockito.*;


@QuarkusTest
public class ColaboradorServicioTest {
    @Inject
    ColaboradorServicio colaboradorServicio;

    @InjectMock
    ColaboradorRepositorio colaboradorRepositorio;
    private Colaborador colaboradorPrueba;
    @BeforeEach
    public void setup(){
        colaboradorPrueba = Colaborador
                .builder()
                .tipoDocumento(co.vinni.docentes.dominio.modelo.TiposDocumentos.CC)
                .numeroDocumento("123456789")
                .nombres("Elsa")
                .apellidos("Patero")
                .email("correo@correo.com")
                .telefono("1234567890")
                .direccion("Calle 123")
                .ciudad("Bogotá")
                .fechaIngreso(LocalDate.now())
                .fechaNacimiento(LocalDate.of(1990, 1, 1))
                .genero("Femenino")
                .build();

    }
    @Test
    public void testCrearColaborador(){
        colaboradorServicio.crear(colaboradorPrueba);
        verify(colaboradorRepositorio, times(1)).crear(any(Colaborador.class));
    }
    @Test
    public void testListaColaboradores(){
        Mockito.when(colaboradorRepositorio.obtenerTodos()).thenReturn(List.of(colaboradorPrueba));
        var resultado = colaboradorServicio.listar();
        Assertions.assertFalse(resultado.isEmpty());
        Assertions.assertEquals("Elsa", resultado.get(0).nombres);
    }
}
    