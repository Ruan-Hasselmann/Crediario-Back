package tfg.crediario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tfg.crediario.entity.Cliente;
import tfg.crediario.service.ClienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    /**
     * Retorna uma lista de todos os clientes cadastrados.
     */
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    /**
     * Retorna um cliente específico pelo seu ID.
     *
     * @param id ID do cliente a ser retornado.
     * @return ResponseEntity com o cliente encontrado ou not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> getClienteById(@PathVariable Integer id) {
        Optional<Cliente> cliente = clienteService.getClienteById(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Cria um novo cliente.
     *
     * @param cliente Cliente a ser criado.
     * @return ResponseEntity com o cliente criado e status CREATED.
     */
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente createdCliente = clienteService.createCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCliente);
    }

    /**
     * Atualiza um cliente existente.
     *
     * @param id      ID do cliente a ser atualizado.
     * @param cliente Cliente com as informações atualizadas.
     * @return ResponseEntity com a mensagem de sucesso ou not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        Cliente updatedCliente = clienteService.updateCliente(id, cliente);
        if (updatedCliente != null) {
            return ResponseEntity.ok("Cliente atualizado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Desativa um cliente existente.
     *
     * @param id ID do cliente a ser desativado.
     * @return ResponseEntity com a mensagem de sucesso ou not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> desactiveCliente(@PathVariable Integer id) {
        boolean status = clienteService.updateStatusCliente(id, false);
        if (status) {
            return ResponseEntity.ok("Cliente desativado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Ativa um cliente existente.
     *
     * @param id ID do cliente a ser ativado.
     * @return ResponseEntity com a mensagem de sucesso ou not found.
     */
    @PostMapping("/{id}/ativar")
    public ResponseEntity<String> activeCliente(@PathVariable Integer id) {
        boolean status = clienteService.updateStatusCliente(id, true);
        if (status) {
            return ResponseEntity.ok("Cliente ativado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}