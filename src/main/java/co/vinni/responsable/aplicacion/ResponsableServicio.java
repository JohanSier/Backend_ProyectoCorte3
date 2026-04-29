package co.vinni.responsable.aplicacion;

import co.vinni.responsable.dominio.modelo.Responsable;
import co.vinni.responsable.dominio.repositorio.ResponsableRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ResponsableServicio {
    @Inject
    ResponsableRepositorio repositorio;

    public void crear(Responsable responsable) {
        repositorio.crear(responsable);
    }

    public List<Responsable> listar(){return repositorio.obtenerTodos();}

}
