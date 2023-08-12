package tfg.crediario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tfg.crediario.entity.Cliente;
import tfg.crediario.entity.Endereco;
import tfg.crediario.repository.EnderecoRepository;
import tfg.crediario.service.impl.ClienteServiceImpl;

import java.util.Random;

@RestController
@RequestMapping("/popular")
public class PopularController {
    @Autowired
    private ClienteServiceImpl clienteServiceImpl;
    @Autowired
    private EnderecoRepository enderecoRepository;

    Random random = new Random();

    Cliente cliente = new Cliente();
    Endereco endereco = new Endereco();

    @GetMapping
    String popula() {

        cliente.setId(random.nextInt());
        cliente.setStatus(true);
        cliente.setCpf("000.000.000-00");
        cliente.setDataCadastro("01/01/2000");
        cliente.setNome("André");
        cliente.setRg("0000000000");
        cliente.setTelefone("+55 55 55555-5555");
        endereco.setId(random.nextInt());
        endereco.setBairro("Centro");
        endereco.setCep("00000-000");
        endereco.setCidade("Santa Maria");
        endereco.setComplemento("");
        endereco.setEstado("RS");
        endereco.setLogradouro("");
        endereco.setNumero(random.nextInt());

        clienteServiceImpl.createCliente(cliente);
//        enderecoRepository.save(endereco);

        return "Populado com sucesso";
    }
}
