package tfg.crediario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tfg.crediario.entity.Cliente;
import tfg.crediario.entity.Endereco;
import tfg.crediario.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listarAtivos() {
        return clienteRepository.findByStatus();
    }

    @GetMapping("/inativo")
    List<Cliente> listarInativos() {
        return clienteRepository.findInactive();
    }

    @GetMapping("/todos")
    List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @DeleteMapping
    public String delete(@RequestParam Long id) {
        try {
            clienteRepository.updateFalse(false, id);
            return "Cliente desativado";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PatchMapping
    public String ativar(@RequestParam Long id) {
        try {
            clienteRepository.updateTrue(true, id);
            return "Cliente ativado";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("/ClienteEndereco/{id}")
    public Optional<Endereco> endereco(@RequestParam Integer id) {
        return clienteRepository.findWithEndereco(id);
    }

    ;
}
