package co.vinni.docentes.dominio.repositorio;

import co.vinni.docentes.dominio.modelo.Colaborador;


import java.util.List;

public interface ColaboradorRepositorio {
    void crear(Colaborador colaborador);
    List<Colaborador> obtenerTodos();

}
