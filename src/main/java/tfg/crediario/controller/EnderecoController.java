package tfg.crediario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tfg.crediario.entity.Endereco;
import tfg.crediario.repository.EnderecoRepository;

import java.util.List;
import java.util.Optional;

public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Endereco> listarById(@RequestParam Integer id) {
        return enderecoRepository.findById(id);
    }

    @PostMapping
    public Endereco adicionar(@RequestBody Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @DeleteMapping
    public String delete(@RequestParam Integer id) {
        try {
            enderecoRepository.deleteById(id);
            return "Endereco deletado";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
