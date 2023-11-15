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

Java|Spring|Spring Boot
|:---:|:---:|:---:
Lenguaje de Programacion|Framework|Productividad

