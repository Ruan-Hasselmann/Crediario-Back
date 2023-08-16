package tfg.crediario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tfg.crediario.entity.Cliente;
import tfg.crediario.repository.ClienteRepository;
import tfg.crediario.service.ClienteService;
import tfg.crediario.service.EnderecoService;
import tfg.crediario.service.PagamentoService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private PagamentoService pagamentoService;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAllByStatus();
    }

    public Optional<Cliente> getClienteById(Integer id) {
        return clienteRepository.findById(id);
    }

    public Cliente createCliente(Cliente cliente) {
        cliente.setStatus(true);
        cliente.setDataCadastro(getDateTime());
        enderecoService.createEndereco(cliente.getEndereco());
        pagamentoService.createPagamento(cliente.getPagamento());
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Integer id, Cliente cliente) {
        return clienteRepository.updateCliente(cliente.getNome(), cliente.getCpf(), cliente.getRg(), cliente.getTelefone(), id);
    }

    public boolean updateStatusCliente(Integer id, Boolean status) {
        return clienteRepository.updateStatus(status, id);
    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
