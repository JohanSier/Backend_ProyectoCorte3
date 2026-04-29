package co.vinni.asistentes.aplicacion;

import co.vinni.asistentes.dominio.modelo.Asistente;
import co.vinni.asistentes.dominio.repositorio.AsistenteRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class AsistenteServicio {

    @Inject
    AsistenteRepositorio repositorio;

    private static final Set<String> RESPONSABLES_TEMPORALES = Set.of(
            "98765",
            "123456",
            "55555"
    );

    public void crear(Asistente asistente) {
        validarCamposObligatorios(asistente);
        validarFechaNacimiento(asistente);
        validarEdadMenorDe16(asistente);
        validarEdadCoherente(asistente);
        validarIdentificacionNoRepetida(asistente.identificacion);
        validarResponsableExiste(asistente.identificacionResponsable);

        repositorio.crear(asistente);
    }

    public List<Asistente> listar() {
        return repositorio.obtenerTodos();
    }

    private void validarCamposObligatorios(Asistente asistente) {
        if (asistente.identificacion == null || asistente.identificacion.isBlank()) {
            throw new IllegalArgumentException("La identificación del asistente es obligatoria.");
        }

        if (asistente.nombreCompleto == null || asistente.nombreCompleto.isBlank()) {
            throw new IllegalArgumentException("El nombre completo del asistente es obligatorio.");
        }

        if (asistente.fechaNacimiento == null) {
            throw new IllegalArgumentException("La fecha de nacimiento del asistente es obligatoria.");
        }

        if (asistente.edad == null) {
            throw new IllegalArgumentException("La edad del asistente es obligatoria.");
        }

        if (asistente.genero == null || asistente.genero.isBlank()) {
            throw new IllegalArgumentException("El género del asistente es obligatorio.");
        }

        if (asistente.barrio == null || asistente.barrio.isBlank()) {
            throw new IllegalArgumentException("El barrio del asistente es obligatorio.");
        }

        if (asistente.identificacionResponsable == null || asistente.identificacionResponsable.isBlank()) {
            throw new IllegalArgumentException("La identificación del responsable es obligatoria.");
        }

        if (asistente.estadoAsistente == null || asistente.estadoAsistente.isBlank()) {
            throw new IllegalArgumentException("El estado del asistente es obligatorio.");
        }

        if (asistente.fechaIngreso == null) {
            throw new IllegalArgumentException("La fecha de ingreso del asistente es obligatoria.");
        }
    }

    private void validarFechaNacimiento(Asistente asistente) {
        if (asistente.fechaNacimiento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser futura.");
        }
    }

    private void validarEdadMenorDe16(Asistente asistente) {
        int edadCalculada = Period.between(asistente.fechaNacimiento, LocalDate.now()).getYears();

        if (edadCalculada >= 16) {
            throw new IllegalArgumentException("El asistente debe ser menor de 16 años.");
        }
    }

    private void validarEdadCoherente(Asistente asistente) {
        int edadCalculada = Period.between(asistente.fechaNacimiento, LocalDate.now()).getYears();

        if (!asistente.edad.equals(edadCalculada)) {
            throw new IllegalArgumentException("La edad no coincide con la fecha de nacimiento.");
        }
    }

    private void validarIdentificacionNoRepetida(String identificacion) {
        repositorio.buscarPorIdentificacion(identificacion)
                .ifPresent(asistente -> {
                    throw new IllegalArgumentException("Ya existe un asistente con esa identificación.");
                });
    }

    private void validarResponsableExiste(String identificacionResponsable) {
        if (!RESPONSABLES_TEMPORALES.contains(identificacionResponsable)) {
            throw new IllegalArgumentException("La identificación del responsable no existe en el sistema.");
        }
    }
}