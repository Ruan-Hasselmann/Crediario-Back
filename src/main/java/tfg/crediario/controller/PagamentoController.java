package tfg.crediario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tfg.crediario.entity.Pagamento;
import tfg.crediario.repository.PagamentoRepository;
import tfg.crediario.service.PagamentoService;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private final PagamentoService pagamentoService;

    @GetMapping
    public List<Pagamento> getAllPagamentos() {
        return pagamentoService.findAll();
    }

    @PostMapping
    public Pagamento createPagamento(@RequestBody Pagamento pagamento) {
        return pagamentoService.save(pagamento);
    }

    @PutMapping("/{id}")
    public Pagamento updatePagamento(@PathVariable Integer id, @RequestBody Pagamento pagamento) {
        pagamento.setId(id);
        return pagamentoService.save(pagamento);
    }

    @DeleteMapping("/{id}")
    public void deletePagamento(@PathVariable Integer id) {
        pagamentoService.deleteById(id);
    }
}