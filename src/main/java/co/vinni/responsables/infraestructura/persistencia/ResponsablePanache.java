package co.vinni.responsables.infraestructura.persistencia;

import co.vinni.common.exception.NinoYaRegistradoException;
import co.vinni.responsables.dominio.modelo.NinoEntity;
import co.vinni.responsables.dominio.modelo.Responsable;
import co.vinni.responsables.dominio.modelo.ResponsableEntity;
import co.vinni.responsables.dominio.repositorio.ResponsableRepositorio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ResponsablePanache implements ResponsableRepositorio,
        PanacheRepository<ResponsableEntity> {

    @Override
    @Transactional
    public void crear(Responsable responsable) {
        // Verificar si algún niño ya está registrado con otro responsable
        for (String nombreNino : responsable.nombresNinos) {
            boolean existe = NinoEntity
                    .find("nombreCompleto", nombreNino)
                    .firstResultOptional()
                    .isPresent();
            if (existe) {
                throw new NinoYaRegistradoException(nombreNino);
            }
        }

        ResponsableEntity entity = ResponsableEntity.builder()
                .identificacion(responsable.identificacion)
                .nombreCompleto(responsable.nombreCompleto)
                .build();

        List<NinoEntity> ninos = responsable.nombresNinos.stream()
                .map(nombre -> NinoEntity.builder()
                        .nombreCompleto(nombre)
                        .responsable(entity)
                        .build())
                .collect(Collectors.toList());

        entity.ninos = ninos;
        persist(entity);
    }

    @Override
    public List<Responsable> obtenerTodos() {
        return listAll().stream()
                .map(entity -> Responsable.builder()
                        .identificacion(entity.identificacion)
                        .nombreCompleto(entity.nombreCompleto)
                        .nombresNinos(entity.ninos.stream()
                                .map(n -> n.nombreCompleto)
                                .toList())
                        .build())
                .toList();
    }
}