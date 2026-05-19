package co.vinni.colaborador.aplicacion;

import co.vinni.colaborador.dominio.modelo.Colaborador;
import co.vinni.colaborador.dominio.repositorio.ColaboradorRepositorio;
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
