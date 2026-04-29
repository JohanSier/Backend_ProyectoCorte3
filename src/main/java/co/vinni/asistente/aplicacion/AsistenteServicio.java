package co.vinni.asistente.aplicacion;

import co.vinni.asistente.dominio.modelo.Asistente;
import co.vinni.asistente.dominio.repositorio.AsistenteRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class AsistenteServicio {
    @Inject
    AsistenteRepositorio repositorio;

    public void crear(Asistente asistente) {
        repositorio.crear(asistente);
    }

    public List<Asistente> listar(){return repositorio.obtenerTodos();}

}
