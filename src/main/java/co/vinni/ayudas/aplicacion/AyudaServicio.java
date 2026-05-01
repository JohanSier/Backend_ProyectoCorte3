package co.vinni.ayudas.aplicacion;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

import co.vinni.ayudas.dominio.modelo.Docente;
import co.vinni.ayudas.dominio.repositorio.DocenteRepositorio;

@ApplicationScoped
public class AyudaServicio {
    @Inject
    DocenteRepositorio repositorio;

    public void crear(Docente docente) {
        repositorio.crear(docente);
    }

    public List<Docente> listar(){return repositorio.obtenerTodos();}

}
