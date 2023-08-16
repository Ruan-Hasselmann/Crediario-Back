package tfg.crediario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tfg.crediario.entity.Endereco;
import tfg.crediario.service.EnderecoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private final EnderecoService enderecoService;

    @Autowired
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    /**
     * Retorna um endereco específico pelo seu ID.
     *
     * @param id ID do endereco a ser retornado.
     * @return ResponseEntity com o endereco encontrado ou not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Endereco>> getEnderecoById(@PathVariable Integer id) {
        Optional<Endereco> endereco = enderecoService.getEnderecoById(id);
        if (endereco.isPresent()) {
            return ResponseEntity.ok(endereco);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Retorna uma lista de todos os endereços cadastrados.
     */
    @GetMapping
    public ResponseEntity<List<Endereco>> getAllEnderecos() {
        List<Endereco> enderecos = enderecoService.getAllEnderecos();
        return ResponseEntity.ok(enderecos);
    }

    /**
     * Cria um novo endereco.
     *
     * @param endereco endereco a ser criado.
     * @return ResponseEntity com o endereco criado e status CREATED.
     */
    @PostMapping
    public ResponseEntity<Endereco> createEndereco(@RequestBody Endereco endereco) {
        Endereco createdEndereco = enderecoService.createEndereco(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEndereco);
    }

    /**
     * Atualiza um endereco existente.
     *
     * @param id       ID do endereco a ser atualizado.
     * @param endereco endereco com as informações atualizadas.
     * @return ResponseEntity com a mensagem de sucesso ou not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEndereco(@PathVariable Integer id, @RequestBody Endereco endereco) {
        Integer updatedEndereco = enderecoService.updateEndereco(id, endereco);
        if (updatedEndereco == 1) {
            return ResponseEntity.ok("Endereco atualizado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deleta um endereco existente.
     *
     * @param id ID do endereco a ser deleta.
     * @return ResponseEntity com a mensagem de sucesso ou not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEndereco(@PathVariable Integer id) {
        Integer deleted = enderecoService.deleteEndereco(id);
        if (deleted == 1) {
            return ResponseEntity.ok("Endereço deletado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}