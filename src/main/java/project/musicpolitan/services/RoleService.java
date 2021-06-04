package project.musicpolitan.services;

import project.musicpolitan.entities.Roles;

import java.util.List;

public interface RoleService {
    List<Roles> getAllRoless();

    Roles addRoles(Roles roles);

    Roles getRolesById(Long id);

    void deleteRoles(Roles roles);

    void deleteRolesById(Long id);

    Roles updateRoles(Roles roles);

}
