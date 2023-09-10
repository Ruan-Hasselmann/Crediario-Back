package tfg.crediario.service;

import tfg.crediario.entity.Cliente;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> getAllClientes();

    Optional<Cliente> getClienteById(Integer id);

    Cliente createCliente(Cliente cliente);

    Integer updateCliente(Integer id, Cliente cliente);

    Integer updateStatusCliente(Integer id, Boolean status);

    List<Cliente> findByData(String dataProximo) throws ParseException;

    List<Cliente> findByCpf(String cpf);
}
