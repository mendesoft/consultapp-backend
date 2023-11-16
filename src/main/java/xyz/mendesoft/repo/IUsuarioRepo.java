package xyz.mendesoft.repo;

import xyz.mendesoft.model.Usuario;

public interface IUsuarioRepo extends IGenericRepo<Usuario,Integer> {

    Usuario findOneByUsername(String username);

}
