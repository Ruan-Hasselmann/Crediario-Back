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

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> getClienteById(@PathVariable Integer id) {
        Optional<Cliente> cliente = clienteService.getClienteById(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente createdCliente = clienteService.createCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        Integer updatedCliente = clienteService.updateCliente(id, cliente);
        if (updatedCliente != null) {
            return ResponseEntity.ok("Cliente atualizado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> desactiveCliente(@PathVariable Integer id) {
        Integer status = clienteService.updateStatusCliente(id, false);
        if (status == 1) {
            return ResponseEntity.ok("Cliente deletado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/ativar")
    public ResponseEntity<String> activeCliente(@PathVariable Integer id) {
        Integer status = clienteService.updateStatusCliente(id, true);
        if (status == 1) {
            return ResponseEntity.ok("Cliente ativado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}