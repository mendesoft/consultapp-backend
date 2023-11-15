package xyz.mendesoft.service.impl;

import xyz.mendesoft.exception.ModelNotFoundException;
import xyz.mendesoft.repo.IGenericRepo;
import xyz.mendesoft.service.ICRUD;

import java.lang.reflect.Method;
import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {


    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public List<T> listar()  {
        return getRepo().findAll();
    }

    @Override
    public T listarPorId(ID id){
        return getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID no encontrado: " + id));
    }

    @Override
    public T registrar(T t)  {
        return getRepo().save(t);
    }

    @Override
    public T modificar(T t, ID id) throws Exception {
        Class<?> clase = t.getClass();
        String nombreClase = t.getClass().getSimpleName();
        String methodName = "setId" + nombreClase;  //genera el setIdPaciente, etc
        Method setIdMethod = clase.getMethod(methodName, id.getClass());
        setIdMethod.invoke(t, id);

        getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND: " + id));

        return getRepo().save(t);
    }

    @Override
    public void eliminarPorId(ID id) {
        getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID no encontrado: " + id));
        getRepo().deleteById(id);
    }
}
