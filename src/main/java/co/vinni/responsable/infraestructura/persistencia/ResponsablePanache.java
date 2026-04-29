package co.vinni.responsable.infraestructura.persistencia;

import co.vinni.responsable.dominio.modelo.Responsable;
import co.vinni.responsable.dominio.modelo.ResponsableEntity;
import co.vinni.responsable.dominio.repositorio.ResponsableRepositorio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ResponsablePanache implements ResponsableRepositorio, PanacheRepository<ResponsableEntity>{

    @Override
    @Transactional
    public void crear(Responsable responsable) {
        ResponsableEntity responsableEntity = ResponsableEntity
                .builder()
                .nombre(responsable.nombre)
                .apellido(responsable.apellido)
                .email(responsable.email)
                .build();
        persist(responsableEntity);

    }

    @Override
    public List<Responsable> obtenerTodos() {
        return listAll().stream().map(
                entidad ->{
                    Responsable responsable = Responsable
                            .builder()
                            .nombre(entidad.nombre)
                            .apellido(entidad.apellido)
                            .email(entidad.email)
                            .build();
                    return responsable;
                }
        ).toList();
    }
}
