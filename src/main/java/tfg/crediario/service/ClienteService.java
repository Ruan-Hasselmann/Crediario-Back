package tfg.crediario.service;

import tfg.crediario.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> getAllClientes();

    Optional<Cliente> getClienteById(Integer id);

    Cliente createCliente(Cliente cliente);

    Cliente updateCliente(Integer id, Cliente cliente);

    boolean updateStatusCliente(Integer id, Boolean status);
}
