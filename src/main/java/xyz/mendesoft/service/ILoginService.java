package xyz.mendesoft.service;

import xyz.mendesoft.model.Usuario;

public interface ILoginService {
    Usuario verificarUsername(String username);
    void cambiarPassword(String password, String username);
}
