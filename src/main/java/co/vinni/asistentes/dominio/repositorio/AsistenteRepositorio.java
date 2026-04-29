package co.vinni.asistentes.dominio.repositorio;

import co.vinni.asistentes.dominio.modelo.Asistente;

import java.util.List;
import java.util.Optional;

public interface AsistenteRepositorio {

    void crear(Asistente asistente);

    List<Asistente> obtenerTodos();

    Optional<Asistente> buscarPorIdentificacion(String identificacion);
}