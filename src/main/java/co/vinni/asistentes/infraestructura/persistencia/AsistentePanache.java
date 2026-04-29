package co.vinni.asistentes.infraestructura.persistencia;

import co.vinni.asistentes.dominio.modelo.Asistente;
import co.vinni.asistentes.dominio.modelo.AsistenteEntity;
import co.vinni.asistentes.dominio.repositorio.AsistenteRepositorio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AsistentePanache implements AsistenteRepositorio, PanacheRepository<AsistenteEntity> {

    @Override
    @Transactional
    public void crear(Asistente asistente) {
        AsistenteEntity asistenteEntity = AsistenteEntity
                .builder()
                .identificacion(asistente.identificacion)
                .nombreCompleto(asistente.nombreCompleto)
                .fechaNacimiento(asistente.fechaNacimiento)
                .edad(asistente.edad)
                .genero(asistente.genero)
                .barrio(asistente.barrio)
                .identificacionResponsable(asistente.identificacionResponsable)
                .estadoAsistente(asistente.estadoAsistente)
                .fechaIngreso(asistente.fechaIngreso)
                .build();

        persist(asistenteEntity);
    }

    @Override
    public List<Asistente> obtenerTodos() {
        return listAll().stream().map(
                entidad -> Asistente
                        .builder()
                        .identificacion(entidad.identificacion)
                        .nombreCompleto(entidad.nombreCompleto)
                        .fechaNacimiento(entidad.fechaNacimiento)
                        .edad(entidad.edad)
                        .genero(entidad.genero)
                        .barrio(entidad.barrio)
                        .identificacionResponsable(entidad.identificacionResponsable)
                        .estadoAsistente(entidad.estadoAsistente)
                        .fechaIngreso(entidad.fechaIngreso)
                        .build()
        ).toList();
    }

    @Override
    public Optional<Asistente> buscarPorIdentificacion(String identificacion) {
        AsistenteEntity entidad = find("identificacion", identificacion).firstResult();

        if (entidad == null) {
            return Optional.empty();
        }

        Asistente asistente = Asistente
                .builder()
                .identificacion(entidad.identificacion)
                .nombreCompleto(entidad.nombreCompleto)
                .fechaNacimiento(entidad.fechaNacimiento)
                .edad(entidad.edad)
                .genero(entidad.genero)
                .barrio(entidad.barrio)
                .identificacionResponsable(entidad.identificacionResponsable)
                .estadoAsistente(entidad.estadoAsistente)
                .fechaIngreso(entidad.fechaIngreso)
                .build();

        return Optional.of(asistente);
    }
}