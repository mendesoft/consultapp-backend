package xyz.mendesoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import xyz.mendesoft.model.Usuario;
import xyz.mendesoft.repo.ILoginRepo;
import xyz.mendesoft.service.ILoginService;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements ILoginService {

    private final ILoginRepo repo;

    private final PasswordEncoder bycript;

    @Override
    public Usuario verificarUsername(String username) {
        return repo.verificarUsername(username);
    }

    @Override
    public void cambiarPassword(String password, String username) {
        repo.cambiarPassword(bycript.encode(password), username);
    }
}
