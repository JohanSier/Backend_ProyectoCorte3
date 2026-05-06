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
                .tipoDocumento(colaborador.tipoDocumento)
                .numeroDocumento(colaborador.numeroDocumento)
                .nombres(colaborador.nombres)
                .apellidos(colaborador.apellidos)
                .email(colaborador.email)
                .telefono(colaborador.telefono)
                .direccion(colaborador.direccion)
                .ciudad(colaborador.ciudad)
                .fechaIngreso(colaborador.fechaIngreso)
                .fechaNacimiento(colaborador.fechaNacimiento)
                .genero(colaborador.genero)
                .build();
        persist(colaboradorEntity);
    }

    @Override
    public List<Colaborador> obtenerTodos() {
        return listAll().stream().map(
                entidad ->{
                    Colaborador colaborador = Colaborador
                            .builder()
                            .tipoDocumento(entidad.tipoDocumento)
                            .numeroDocumento(entidad.numeroDocumento)
                            .nombres(entidad.nombres)
                            .apellidos(entidad.apellidos)
                            .email(entidad.email)
                            .telefono(entidad.telefono)
                            .direccion(entidad.direccion)
                            .ciudad(entidad.ciudad)
                            .fechaIngreso(entidad.fechaIngreso)
                            .fechaNacimiento(entidad.fechaNacimiento)
                            .genero(entidad.genero)
                            .build();
                    return colaborador;
                }
        ).toList();
    }
}
