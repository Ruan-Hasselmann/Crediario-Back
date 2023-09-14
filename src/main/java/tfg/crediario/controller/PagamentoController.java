package tfg.crediario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tfg.crediario.entity.Pagamento;
import tfg.crediario.service.ClienteService;
import tfg.crediario.service.PagamentoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private final PagamentoService pagamentoService;

    @Autowired
    private final ClienteService clienteService;

    @Autowired
    public PagamentoController(PagamentoService pagamentoService, ClienteService clienteService) {
        this.pagamentoService = pagamentoService;
        this.clienteService = clienteService;
    }

    /**
     * Retorna uma lista de todos os pagamentos cadastrados.
     */
    @GetMapping
    public ResponseEntity<List<Pagamento>> getAllPagamentos() {
        List<Pagamento> pagamentos = pagamentoService.getAllPagamentos();
        return ResponseEntity.ok(pagamentos);
    }

    /**
     * Retorna um pagamento específico pelo seu ID.
     *
     * @param id ID do pagamento a ser retornado.
     * @return ResponseEntity com o pagamento encontrado ou not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pagamento>> getPagamentoById(@PathVariable Integer id) {
        Optional<Pagamento> pagamento = pagamentoService.getPagamentoById(id);
        if (pagamento.isPresent()) {
            return ResponseEntity.ok(pagamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Cria um novo pagamento.
     *
     * @param pagamento Pagamento a ser criado.
     * @return ResponseEntity com o pagamento criado e status CREATED.
     */
    @PostMapping
    public ResponseEntity<Pagamento> createPagamento(@RequestBody Pagamento pagamento) {
        Pagamento createdPagamento = pagamentoService.createPagamento(pagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPagamento);
    }

    /**
     * Atualiza um pagamento existente.
     *
     * @param id        ID do pagamento a ser atualizado.
     * @param pagamento Pagamento com as informações atualizadas.
     * @return ResponseEntity com a mensagem de sucesso ou not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePagamento(@PathVariable Integer id, @RequestBody Pagamento pagamento) {
        Integer updatedPagamento = pagamentoService.updatePagamento(id, pagamento);
        if (updatedPagamento == 1) {
            clienteService.updateStatusCliente(id, true);
            return ResponseEntity.ok("Pagamento atualizado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Desativa um endereco existente.
     *
     * @param id ID do endereco a ser excluido.
     * @return ResponseEntity com a mensagem de sucesso ou not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePagamento(@PathVariable Integer id) {
        Integer deleted = pagamentoService.deletePagamento(id);
        if (deleted == 1) {
            return ResponseEntity.ok("Pagamento deletado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Atualiza um pagamento existente.
     *
     * @param id          ID do pagamento a ser atualizado.
     * @param dataProximo data do proximo pagamento com as informações atualizadas.
     * @param valor       valor do pagamento efetuado a ser atualizado
     * @return ResponseEntity com a mensagem de sucesso ou not found.
     */
    @PostMapping("/pagamento")
    public ResponseEntity<String> registrarPagamento(@RequestParam Integer id, @RequestParam String dataProximo, @RequestParam Double valor) {
        int pagamento = pagamentoService.registrarPagamento(id, dataProximo, valor);
        if (pagamento == 1) {
            return ResponseEntity.ok("Pagamento registrado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}