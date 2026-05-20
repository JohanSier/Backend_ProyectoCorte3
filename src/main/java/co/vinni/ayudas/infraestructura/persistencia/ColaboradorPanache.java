package co.vinni.ayudas.infraestructura.persistencia;

import co.vinni.ayudas.dominio.repositorio.ColaboradorRepositorio;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ColaboradorPanache implements ColaboradorRepositorio {

    @Override
    public boolean existePorId(Long id) {
        // TODO: implementar cuando el módulo de colaboradores esté disponible
        return true;
    }
}