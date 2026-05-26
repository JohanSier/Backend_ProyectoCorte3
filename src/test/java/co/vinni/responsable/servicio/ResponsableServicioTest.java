package co.vinni.responsables.servicio;

import co.vinni.responsables.aplicacion.ResponsableServicio;
import co.vinni.responsables.dominio.modelo.Responsable;
import co.vinni.responsables.dominio.repositorio.ResponsableRepositorio;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class ResponsableServicioTest {

    @Inject
    ResponsableServicio responsableServicio;

    @InjectMock
    ResponsableRepositorio responsableRepositorio;

    private Responsable responsableUnNino;
    private Responsable responsableVariosNinos;

    @BeforeEach
    public void setup() {
        responsableUnNino = Responsable.builder()
                .identificacion("123456789")
                .nombreCompleto("María García")
                .nombresNinos(List.of("Juan García"))
                .build();

        responsableVariosNinos = Responsable.builder()
                .identificacion("987654321")
                .nombreCompleto("Carlos López")
                .nombresNinos(List.of("Ana López", "Pedro López"))
                .build();
    }

    @Test
    public void testCrearResponsableConUnNino() {
        responsableServicio.crear(responsableUnNino);
        verify(responsableRepositorio, times(1)).crear(any(Responsable.class));
    }

    @Test
    public void testCrearResponsableConVariosNinos() {
        responsableServicio.crear(responsableVariosNinos);
        verify(responsableRepositorio, times(1)).crear(any(Responsable.class));
    }

    @Test
    public void testListarResponsables() {
        Mockito.when(responsableRepositorio.obtenerTodos())
                .thenReturn(List.of(responsableUnNino, responsableVariosNinos));

        List<Responsable> resultado = responsableServicio.listar();

        assertFalse(resultado.isEmpty());
        assertEquals(2, resultado.size());
        assertEquals("María García", resultado.get(0).nombreCompleto);
        assertEquals("Carlos López", resultado.get(1).nombreCompleto);
    }

    @Test
    public void testNinoYaRegistradoConOtroResponsable() {
        doThrow(new IllegalStateException("El niño Juan García ya está registrado con otro responsable"))
                .when(responsableRepositorio).crear(any(Responsable.class));

        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> {
            responsableServicio.crear(responsableUnNino);
        });

        assertTrue(ex.getMessage().contains("ya está registrado con otro responsable"));
        verify(responsableRepositorio, times(1)).crear(any(Responsable.class));
    }

    @Test
    public void testResponsableTieneIdentificacion() {
        assertNotNull(responsableUnNino.identificacion);
        assertFalse(responsableUnNino.identificacion.isBlank());
    }

    @Test
    public void testResponsableTieneNombreCompleto() {
        assertNotNull(responsableUnNino.nombreCompleto);
        assertFalse(responsableUnNino.nombreCompleto.isBlank());
    }

    @Test
    public void testResponsableTieneAlMenosUnNino() {
        assertNotNull(responsableUnNino.nombresNinos);
        assertFalse(responsableUnNino.nombresNinos.isEmpty());
    }

    @Test
    public void testChecklistMarcadoVariosNinos() {
        assertTrue(responsableVariosNinos.nombresNinos.size() > 1);
    }

    @Test
    public void testChecklistNoMarcadoUnSoloNino() {
        assertEquals(1, responsableUnNino.nombresNinos.size());
        assertEquals("Juan García", responsableUnNino.nombresNinos.get(0));
    }

    @Test
    public void testNombresNinosNoVacios() {
        responsableVariosNinos.nombresNinos.forEach(nombre -> {
            assertNotNull(nombre);
            assertFalse(nombre.isBlank());
        });
    }

    @Test
    public void testErrorAlCrearNoGuarda() {
        doThrow(new RuntimeException("Error interno al registrar"))
                .when(responsableRepositorio).crear(any(Responsable.class));

        assertThrows(RuntimeException.class, () -> {
            responsableServicio.crear(responsableUnNino);
        });

        verify(responsableRepositorio, times(1)).crear(any(Responsable.class));
    }
}