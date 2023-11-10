package xyz.mendesoft.service.impl;

import xyz.mendesoft.repo.IGenericRepo;
import xyz.mendesoft.service.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {


    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public List<T> listar() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T listarPorId(ID id) throws Exception {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public T registrar(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T modificar(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public void eliminarPorId(ID id) {
        getRepo().deleteById(id);
    }
}
