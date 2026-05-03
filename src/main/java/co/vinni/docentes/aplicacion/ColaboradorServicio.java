package co.vinni.docentes.aplicacion;

import co.vinni.docentes.dominio.modelo.Colaborador;
import co.vinni.docentes.dominio.repositorio.ColaboradorRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ColaboradorServicio {
    @Inject
    ColaboradorRepositorio repositorio;

    public void crear(Colaborador colaborador) {
        repositorio.crear(colaborador);
    }

    public List<Colaborador> listar(){return repositorio.obtenerTodos();}

}
