package xyz.mendesoft.repo;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xyz.mendesoft.model.Paciente;
import xyz.mendesoft.model.Usuario;

public interface ILoginRepo extends IGenericRepo<Paciente,Integer> {

    @Query("FROM Usuario us where us.username =:username")
    Usuario verificarUsername(@Param("username") String username);

    @Transactional
    @Modifying
    @Query("UPDATE Usuario us SET us.password =:password WHERE us.username =:username")
    void cambiarPassword(@Param("password") String password, @Param("username") String username);

}
