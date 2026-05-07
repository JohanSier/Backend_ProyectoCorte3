package co.vinni.asistentes.infraestructura.persistencia;

import co.vinni.asistentes.dominio.modelo.AsistenciaEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AsistenciaPanache implements PanacheRepository<AsistenciaEntity>{
}