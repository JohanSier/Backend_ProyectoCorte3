package co.vinni.asistente.infraestructura.persistencia;

import co.vinni.asistente.dominio.modelo.Asistente;
import co.vinni.asistente.dominio.modelo.AsistenteEntity;
import co.vinni.asistente.dominio.repositorio.AsistenteRepositorio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class AsistentePanache implements AsistenteRepositorio, PanacheRepository<AsistenteEntity>{

    @Override
    @Transactional
    public void crear(Asistente asistente) {
        AsistenteEntity responsableEntity = AsistenteEntity
                .builder()
                .nombre(asistente.nombre)
                .apellido(asistente.apellido)
                .email(asistente.email)
                .build();
        persist(responsableEntity);

    }

    @Override
    public List<Asistente> obtenerTodos() {
        return listAll().stream().map(
                entidad ->{
                    Asistente asistente = Asistente
                            .builder()
                            .nombre(entidad.nombre)
                            .apellido(entidad.apellido)
                            .email(entidad.email)
                            .build();
                    return asistente;
                }
        ).toList();
    }
}
