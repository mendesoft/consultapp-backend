# ConsultAPP
![texto alt](https://www.brainandlife.org/siteassets/online-exclusives/covid-19/telehealth-computer-main.jpg) 
### Temas desarrollados
1. ***Spring Security***
2. Spring Hateos
3. Spring Data JpaRepository
4. Hibernate
5. Manejo de Excepciones
6. JWT
7. PostgreSQL
8. Lombok
9. ModelMapper
10. Reflexión en Java
11. Generar reportes con JasperReport

[Documentación](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Usuario {

    @Id
    @EqualsAndHashCode.Include
    private Integer idUsuario;

    @Column(nullable = false, length = 60, unique = true)
    private String username;

    @Column(nullable = false, length = 60)
    private String password; //123 | Bcrypt

    @Column(nullable = false)
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol",
            joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol")
    )
    private List<Rol> roles;
}
```

> El código perfecto no existe


### Script de SQL
```sql
--ROL
INSERT INTO Rol (id_rol, nombre, descripcion) VALUES (1, 'ADMIN', 'Administrador');
INSERT INTO Rol (id_rol, nombre, descripcion) VALUES (2, 'USER', 'Usuario');
INSERT INTO Rol (id_rol, nombre, descripcion) VALUES (3, 'DBA', 'Admin de bd');

--USUARIOS
INSERT INTO usuario(id_usuario, username, password, enabled) values (1, 'admin@gmail.com', '$2a$10$ju20i95JTDkRa7Sua63JWOChSBc0MNFtG/6Sps2ahFFqN.HCCUMW.', '1');
INSERT INTO usuario(id_usuario, username, password, enabled) values (2, 'usuario@gmail.com', '$2a$10$ju20i95JTDkRa7Sua63JWOChSBc0MNFtG/6Sps2ahFFqN.HCCUMW.', '1');

--USUARIO_ROL
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (1, 1);
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (1, 3);
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (2, 2);

--MENU
INSERT INTO menu(id_menu, nombre,icono, url) VALUES (1, 'Dashboard', 'home', '/pages/dashboard');
INSERT INTO menu(id_menu, nombre, icono, url) VALUES (5, 'Especialidades', 'star_rate', '/pages/especialidad');
INSERT INTO menu(id_menu, nombre, icono, url) VALUES (7, 'Examenes', 'assignment', '/pages/examen');
INSERT INTO menu(id_menu, nombre, icono, url) VALUES (8, 'Pacientes', 'accessibility', '/pages/paciente');
INSERT INTO menu(id_menu, name, icon, url) VALUES (6, 'Medicos', 'healing', '/pages/medico');

--MENU_ROL
INSERT INTO menu_rol (id_menu, id_rol) VALUES (1, 1);
INSERT INTO menu_rol (id_menu, id_rol) VALUES (8, 1);
INSERT INTO menu_rol (id_menu, id_rol) VALUES (5, 1);
INSERT INTO menu_rol (id_menu, id_rol) VALUES (7, 1);
INSERT INTO menu_rol (id_menu, id_rol) VALUES (1, 2);
INSERT INTO menu_rol (id_menu, id_rol) VALUES (5, 2);
INSERT INTO menu_role (id_menu, id_role) VALUES (6, 1);
INSERT INTO menu_role (id_menu, id_role) VALUES (6, 2);

--PARA SACAR MENUS POR USERNAME
            select m.* from menu_rol mr
            inner join usuario_rol ur on ur.id_rol = mr.id_rol
            inner join menu m on m.id_menu = mr.id_menu
            inner join usuario u on u.id_usuario = ur.id_usuario
            where u.username = :username


```
```sql
--PROCEDIMIENTO ALMACENADO

CREATE OR REPLACE FUNCTION fn_list ()
RETURNS TABLE (
cantidad INT,
fecha TEXT
)
AS $$
DECLARE
var_r record;
BEGIN
FOR var_r IN(
select (count(*)::int) as cantidad, to_char(c.fecha, 'dd/MM/yyyy') as fecha from consulta c
group by to_char(c.fecha, 'dd/MM/yyyy') order by to_char(c.fecha, 'dd/MM/yyyy') asc
)  
LOOP
cantidad := var_r.cantidad;
fecha := var_r.fecha;
RETURN NEXT;
END LOOP;
END; $$
LANGUAGE 'plpgsql';
```