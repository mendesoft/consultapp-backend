package xyz.mendesoft.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Menu {

    @Id
    @EqualsAndHashCode.Include
    private Integer idMenu;

    private String icono;

    private String nombre;

    private String url;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "menu_rol",
            joinColumns=@JoinColumn(name = "id_menu",referencedColumnName = "idMenu"),
            inverseJoinColumns =  @JoinColumn(name = "id_rol", referencedColumnName = "idRol")
            )
    private List<Rol> roles;


}
