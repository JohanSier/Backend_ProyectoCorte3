package co.vinni.asistente.dominio.repositorio;

import co.vinni.asistente.dominio.modelo.Asistente;

import java.util.List;

public interface AsistenteRepositorio {
    void crear(Asistente responsable);
    List<Asistente> obtenerTodos();

}
