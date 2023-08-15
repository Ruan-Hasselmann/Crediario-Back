package tfg.crediario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tfg.crediario.entity.Vendedor;
import tfg.crediario.repository.VendedorRepository;
import tfg.crediario.service.VendedorService;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorServiceImpl implements VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;
    @Override
    public Vendedor createVendedor(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    @Override
    public Optional<Vendedor> getVendedorById(Integer id) {
        return vendedorRepository.findById(id);
    }

    public int updateVendedor(Integer id, Vendedor vendedor) {
        return vendedorRepository.updateVendedor(vendedor.getTelefone(), vendedor.getCpf(), vendedor.getNome(), vendedor.getRg(), id);
    }

    @Override
    public int deleteVendedorById(Integer id) {
        return vendedorRepository.deleteVendedorById(id);
    }

    public List<Vendedor> getVendedores() {
        return vendedorRepository.getAllVendedores();
    }
}
