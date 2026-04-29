package co.vinni.responsables.dominio.repositorio;

import co.vinni.responsables.dominio.modelo.Responsable;
import java.util.List;

public interface ResponsableRepositorio {
    void crear(Responsable responsable);
    List<Responsable> obtenerTodos();
}