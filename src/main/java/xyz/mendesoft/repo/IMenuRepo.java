package xyz.mendesoft.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xyz.mendesoft.model.Menu;
import xyz.mendesoft.model.Menu;

import java.util.List;

public interface IMenuRepo extends IGenericRepo<Menu,Integer> {

    @Query(value = """
            select m.* from menu_rol mr
            inner join usuario_rol ur on ur.id_rol = mr.id_rol
            inner join menu m on m.id_menu = mr.id_menu
            inner join usuario u on u.id_usuario = ur.id_usuario
            where u.username = :username
        """, nativeQuery = true)
    List<Menu> getMenusByUsername(@Param("username") String username);


}
