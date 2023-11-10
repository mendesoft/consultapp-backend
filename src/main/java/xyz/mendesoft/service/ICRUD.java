package xyz.mendesoft.service;

import java.util.List;

public interface ICRUD <T, ID>{

    List<T> listar() throws Exception;
    T listarPorId(ID id) throws Exception;

    T registrar(T t) throws Exception;

    T modificar(T t) throws Exception;

    void eliminarPorId(ID id);

}
