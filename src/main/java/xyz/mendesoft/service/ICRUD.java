package xyz.mendesoft.service;

import java.util.List;

public interface ICRUD <T, ID>{

    List<T> listar() ;
    T listarPorId(ID id);

    T registrar(T t) ;

    T modificar(T t, ID id) throws Exception;

    void eliminarPorId(ID id);

}
