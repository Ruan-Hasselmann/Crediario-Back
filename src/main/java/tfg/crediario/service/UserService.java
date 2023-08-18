package tfg.crediario.service;

import tfg.crediario.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();

    Optional<User> getUserById(Integer id);

    User createUser(User user);

    int updateUser(Integer id, User user);

    int deleteUser(Integer id);

    Optional<User> getUserByName(String nome);

    boolean login(User user);
}
