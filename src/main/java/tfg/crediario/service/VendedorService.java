package tfg.crediario.service;

import tfg.crediario.entity.Vendedor;

import java.util.List;
import java.util.Optional;

public interface VendedorService {
    Vendedor createVendedor(Vendedor vendedor);

    Optional<Vendedor> getVendedorById(Integer id);

    int updateVendedor(Integer id, Vendedor vendedor);

    int deleteVendedorById(Integer id);

    List<Vendedor> getVendedores();
}
