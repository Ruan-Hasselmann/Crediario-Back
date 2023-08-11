package tfg.crediario.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tfg.crediario.entity.Cliente;
import tfg.crediario.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Integer id) {
        return clienteRepository.getOne(id);
    }

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Integer id, @NotNull Cliente cliente) {
        return clienteRepository.updateCliente(cliente.getNome(), cliente.getCpf(), cliente.getRg(), cliente.getTelefone(), true, id);
    }

    public boolean updateStatusCliente(Integer id, Boolean status) {
        return clienteRepository.updateStatus(status, id);
    }
}
