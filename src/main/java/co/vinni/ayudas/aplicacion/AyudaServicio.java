package co.vinni.ayudas.aplicacion;

import co.vinni.ayudas.dominio.modelo.Ayuda;
import co.vinni.ayudas.dominio.repositorio.AyudaRepositorio;
import co.vinni.ayudas.dominio.repositorio.ColaboradorRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AyudaServicio {

    @Inject
    AyudaRepositorio ayudaRepositorio;

    @Inject
    ColaboradorRepositorio colaboradorRepositorio;

    public void registrar(Ayuda ayuda) {
        // TODO: activar cuando el módulo de colaboradores esté disponible
        // boolean existe = colaboradorRepositorio.existePorId(ayuda.idColaborador);
        // if (!existe) {
        //     throw new IllegalArgumentException("El colaborador no está registrado en el sistema");
        // }
        ayudaRepositorio.registrar(ayuda);
    }
}