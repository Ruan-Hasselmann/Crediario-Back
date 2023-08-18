package tfg.crediario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tfg.crediario.entity.User;
import tfg.crediario.repository.UserRepository;
import tfg.crediario.service.UserService;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public int updateUser(Integer id, User user) {
        return userRepository.updateUser(user.getUsuario(), user.getSenha(), id);
    }

    @Override
    public int deleteUser(Integer id) {
        return userRepository.deletebyId(id);
    }

    @Override
    public Optional<User> getUserByName(String nome) {
        return userRepository.findByName(nome);
    }

    @Override
    public boolean login(User user) {
        return userRepository.login(user.getUsuario(), user.getSenha());
    }
}
