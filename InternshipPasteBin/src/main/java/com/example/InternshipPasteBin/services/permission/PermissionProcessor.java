package com.example.InternshipPasteBin.services.permission;

import com.example.InternshipPasteBin.models.Permission;
import com.example.InternshipPasteBin.repositories.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PermissionProcessor {
    @Autowired
    private PermissionRepository repository;
    public List<Permission> findAll(){
        return repository.findAll();
    }
    public Permission findById(Long id){
        return repository.getById(id);
    }
    public Permission create(Permission permission){
        return repository.saveAndFlush(permission);
    }
    public Permission put(Long id, Permission newPermission){
        Permission permission=repository.getById(id);
        permission.setPermissionName(newPermission.getPermissionName());
        return repository.saveAndFlush(permission);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
}
