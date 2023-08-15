package tfg.crediario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tfg.crediario.entity.Vendedor;
import tfg.crediario.service.VendedorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

    @Autowired
    private final VendedorService vendedorService;

    @Autowired
    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @GetMapping
    public ResponseEntity<List<Vendedor>> obterTodosVendedores() {
        List<Vendedor> vendedores = vendedorService.getVendedores();
        return ResponseEntity.ok(vendedores);
    }

    @PostMapping
    public ResponseEntity<Vendedor> criarVendedor(@RequestBody Vendedor vendedor) {
        Vendedor createdVendedor = vendedorService.createVendedor(vendedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVendedor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vendedor>> obterVendedor(@PathVariable Integer id) {
        Optional<Vendedor> vendedor = vendedorService.getVendedorById(id);
        if (vendedor != null) {
            return ResponseEntity.ok(vendedor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarVendedor(@PathVariable Integer id, @RequestBody Vendedor vendedor) {
        Integer updateVendedor = vendedorService.updateVendedor(id, vendedor);
        if (updateVendedor == 1){
            return ResponseEntity.ok("Vendedor atualizado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirVendedor(@PathVariable Integer id) {
        Integer deleted = vendedorService.deleteVendedorById(id);
        if (deleted == 1) {
            return ResponseEntity.ok("Vendedor deletado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}