package co.vinni.docentes.infraestructura.persistencia;

import co.vinni.docentes.dominio.modelo.Colaborador;
import co.vinni.docentes.dominio.modelo.ColaboradorEntity;
import co.vinni.docentes.dominio.repositorio.ColaboradorRepositorio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ColaboradorPanache implements ColaboradorRepositorio, PanacheRepository<ColaboradorEntity>{

    @Override
    @Transactional
    public void crear(Colaborador colaborador) {
        ColaboradorEntity colaboradorEntity = ColaboradorEntity
                .builder()
                .nombres(colaborador.nombres)
                .apellidos(colaborador.apellidos)
                .email(colaborador.email)
                .build();
        persist(colaboradorEntity);
    }

    @Override
    public List<Colaborador> obtenerTodos() {
        return listAll().stream().map(
                entidad ->{
                    Colaborador colaborador = Colaborador
                            .builder()
                            .nombres(entidad.nombres)
                            .apellidos(entidad.apellidos)
                            .email(entidad.email)
                            .build();
                    return colaborador;
                }
        ).toList();
    }
}
