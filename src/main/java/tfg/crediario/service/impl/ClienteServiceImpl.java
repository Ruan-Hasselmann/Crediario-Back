package tfg.crediario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tfg.crediario.entity.Cliente;
import tfg.crediario.repository.ClienteRepository;
import tfg.crediario.service.ClienteService;
import tfg.crediario.service.EnderecoService;
import tfg.crediario.service.PagamentoService;

import java.text.DateFormat;
import java.text.ParseException;
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
        if(clienteRepository.existCliente(cliente.getCpf())) {
            return new Cliente();
        }
        cliente.setStatus(true);
        cliente.setDataCadastro(getDateTime());
        enderecoService.createEndereco(cliente.getEndereco());
        pagamentoService.createPagamento(cliente.getPagamento());
        return clienteRepository.save(cliente);
    }

    public Integer updateCliente(Integer id, Cliente cliente) {
        return clienteRepository.updateCliente(cliente.getNome(), cliente.getCpf(), cliente.getRg(), cliente.getTelefone(), id);
    }

    public Integer updateStatusCliente(Integer id, Boolean status) {
        return clienteRepository.updateStatus(status, id);
    }

    public List<Cliente> findByData(String dataProximo) {
        return clienteRepository.findByData(formatDate(dataProximo));
    }

    public List<Cliente> findByCpf(String cpf){
        return clienteRepository.findByCpf(cpf);
    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private String formatDate(String data){
        String[] dataSeparada = data.split("-");
        data = dataSeparada[2] + "-" + dataSeparada[1] + "-" +dataSeparada[0];
        return data;
    }
}
