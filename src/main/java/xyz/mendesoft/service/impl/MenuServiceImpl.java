package xyz.mendesoft.service.impl;

import org.springframework.stereotype.Service;
import xyz.mendesoft.model.Menu;
import xyz.mendesoft.repo.IGenericRepo;
import xyz.mendesoft.repo.IMenuRepo;
import xyz.mendesoft.service.IMenuService;

import java.util.List;

@Service
public class MenuServiceImpl extends CRUDImpl<Menu,Integer> implements IMenuService  {


    private final IMenuRepo repo;

    public MenuServiceImpl(IMenuRepo repo) {
        this.repo = repo;
    }

    @Override
    protected IGenericRepo<Menu, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Menu> getMenusByUsername(String username) {
        return repo.getMenusByUsername(username);
    }
}
