package tfg.crediario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tfg.crediario.entity.User;
import tfg.crediario.service.UserService;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Integer id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/name/{nome}")
    public HttpStatus getUserByName(@PathVariable String nome) {
        Optional<User> usuario = userService.getUserByName(nome);
        if (usuario.isPresent()) {
            return HttpStatus.FOUND;
        }
        return HttpStatus.NOT_FOUND;
    }

    @PostMapping("/login")
    public HttpStatus login(@RequestBody User user) {
        user.setSenha(Base64.getEncoder().encodeToString(user.getSenha().getBytes()));
        boolean usuario = userService.login(user);
        if (usuario) {
            return HttpStatus.FOUND;
        }
        return HttpStatus.NOT_FOUND;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user.setSenha(Base64.getEncoder().encodeToString(user.getSenha().getBytes()));
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody User user) {
        user.setSenha(Base64.getEncoder().encodeToString(user.getSenha().getBytes()));
        Integer updatedUser = userService.updateUser(id, user);
        if (updatedUser == 1) {
            return ResponseEntity.ok("Usuario atualizado com sucesso");
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        Integer deleted = userService.deleteUser(id);
        if (deleted == 1) {
            return ResponseEntity.ok("Usuario deletado com sucesso");
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}