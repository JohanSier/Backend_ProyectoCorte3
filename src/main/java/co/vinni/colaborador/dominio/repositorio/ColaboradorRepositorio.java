package co.vinni.colaborador.dominio.repositorio;

import co.vinni.colaborador.dominio.modelo.Colaborador;


import java.util.List;

public interface ColaboradorRepositorio {
    void crear(Colaborador colaborador);
    List<Colaborador> obtenerTodos();

}
