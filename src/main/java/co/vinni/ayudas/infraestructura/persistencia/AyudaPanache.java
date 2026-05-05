package co.vinni.ayudas.infraestructura.persistencia;

import co.vinni.ayudas.dominio.modelo.Ayuda;
import co.vinni.ayudas.dominio.modelo.AyudaEntity;
import co.vinni.ayudas.dominio.modelo.EstadoAyuda;
import co.vinni.ayudas.dominio.repositorio.AyudaRepositorio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AyudaPanache implements AyudaRepositorio, PanacheRepository<AyudaEntity> {

    @Override
    @Transactional
    public void registrar(Ayuda ayuda) {
        AyudaEntity entity = AyudaEntity
                .builder()
                .idColaborador(ayuda.idColaborador)
                .nombreColaborador(ayuda.nombreColaborador)
                .tipo(ayuda.tipo)
                .descripcion(ayuda.descripcion)
                .valor(ayuda.valor)
                .cantidad(ayuda.cantidad)
                .fechaRegistro(ayuda.fechaRegistro)
                .estado(EstadoAyuda.REGISTRADA)
                .build();
        persist(entity);
    }
}