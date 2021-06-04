package project.musicpolitan.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import project.musicpolitan.entities.Users;

import java.util.List;

public interface UserService extends UserDetailsService {
    Users addUser(Users users);

    List<Users> getAllUsers();

    Users getUserById(Long id);

    Users changePassword(Users user, String old, String newPass, String reNew);

    Users getUserByEmail(String email);

    Users updateUser(Users user);
}
