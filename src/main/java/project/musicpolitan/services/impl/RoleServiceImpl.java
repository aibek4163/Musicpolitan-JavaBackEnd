package project.musicpolitan.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.musicpolitan.entities.Roles;
import project.musicpolitan.repositories.RoleRepository;
import project.musicpolitan.services.RoleService;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Roles> getAllRoless() {
        return roleRepository.findAll();
    }

    @Override
    public Roles addRoles(Roles roles) {
        return roleRepository.save(roles);
    }

    @Override
    public Roles getRolesById(Long id) {
        Optional<Roles> roles = roleRepository.findById(id);
        return roles.orElse(null);
    }

    @Override
    public void deleteRoles(Roles roles) {
        roleRepository.delete(roles);
    }

    @Override
    public void deleteRolesById(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Roles updateRoles(Roles roles) {
        return roleRepository.save(roles);
    }
}
