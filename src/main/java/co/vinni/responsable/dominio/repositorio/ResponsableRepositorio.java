package co.vinni.responsable.dominio.repositorio;

import co.vinni.responsable.dominio.modelo.Responsable;

import java.util.List;

public interface ResponsableRepositorio {
    void crear(Responsable responsable);
    List<Responsable> obtenerTodos();

}
