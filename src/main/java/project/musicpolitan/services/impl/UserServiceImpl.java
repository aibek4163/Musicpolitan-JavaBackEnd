package project.musicpolitan.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.musicpolitan.entities.Roles;
import project.musicpolitan.entities.Users;
import project.musicpolitan.repositories.RoleRepository;
import project.musicpolitan.repositories.UserRepository;
import project.musicpolitan.services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(s);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("USER NOT FOUND");
        }
    }

    @Override
    public Users getUserById(Long id) {
        Optional<Users> users = userRepository.findById(id);
        return users.orElse(null);
    }

    @Override
    public Users addUser(Users user) {
        Users u = userRepository.findByEmail(user.getEmail());
        if (u == null) {
            Roles role = roleRepository.findByRole("ROLE_USER");
            if (role != null) {
                ArrayList<Roles> roles = new ArrayList<>();
                roles.add(role);
                user.setRoles(roles);
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                return userRepository.save(user);
            }
        }
        return null;
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users changePassword(Users user, String old, String newPass, String reNew) {
        if (passwordEncoder.matches(old, user.getPassword()) && newPass.equals(reNew)) {
            user.setPassword(passwordEncoder.encode(reNew));
            return userRepository.save(user);
        }
//        else if(!passwordEncoder.matches(old,user.getPassword()) || !newPass.equals(reNew)){
//            return
//        }
        return null;
    }

    @Override
    public Users getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Users updateUser(Users user) {
        return userRepository.save(user);
    }
}
