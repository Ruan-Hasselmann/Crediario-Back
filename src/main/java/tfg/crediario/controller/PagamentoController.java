package tfg.crediario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tfg.crediario.entity.Endereco;
import tfg.crediario.entity.Pagamento;
import tfg.crediario.service.PagamentoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private final PagamentoService pagamentoService;

    @Autowired
    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @GetMapping
    public ResponseEntity<List<Pagamento>> getAllPagamentos() {
        List<Pagamento> pagamentos = pagamentoService.getAllPagamentos();
        return ResponseEntity.ok(pagamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pagamento>> getPagamentoById(@PathVariable Integer id) {
        Optional<Pagamento> pagamento = pagamentoService.getPagamentoById(id);
        if (pagamento != null) {
            return ResponseEntity.ok(pagamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Pagamento> createPagamento(@RequestBody Pagamento pagamento) {
        Pagamento createdPagamento = pagamentoService.createPagamento(pagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePagamento(@PathVariable Integer id, @RequestBody Pagamento pagamento) {
        Integer updatedPagamento = pagamentoService.updatePagamento(id, pagamento);
        if (updatedPagamento == 1) {
            return ResponseEntity.ok("Pagamento atualizado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePagamento(@PathVariable Integer id) {
        Integer deleted = pagamentoService.deletePagamento(id);
        if (deleted == 1) {
            return ResponseEntity.ok("Pagamento deletado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/pagamento")
    public ResponseEntity<String> registrarPagamento(@RequestParam Integer id, @RequestParam String dataProximo, @RequestParam Double valor) {
        int pagamento = pagamentoService.registrarPagamento(id, dataProximo, valor);
        if (pagamento == 1) {
            return ResponseEntity.ok("Pagamento registro com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}