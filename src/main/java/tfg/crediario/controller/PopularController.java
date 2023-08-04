package tfg.crediario.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tfg.crediario.entity.Cliente;
import tfg.crediario.entity.Endereco;
import tfg.crediario.repository.ClienteRepository;
import tfg.crediario.repository.EnderecoRepository;

import java.util.Random;

@RestController
@RequestMapping("/popular")
public class PopularController {
    ClienteRepository clienteRepository;
    EnderecoRepository enderecoRepository;
    Cliente cliente;
    Endereco endereco;

    Random random = new Random();

    @GetMapping
    String popula() {
        cliente.setCpf("000.000.000-00");
        cliente.setDataCadastro("01/01/2000");
        cliente.setNome("André");
        cliente.setRg("0000000000");
        cliente.setTelefone("+55 55 55555-5555");
        endereco.setBairro("Centro");
        endereco.setCep("00000-000");
        endereco.setCidade("Santa Maria");
        endereco.setComplemento("");
        endereco.setEstado("RS");
        endereco.setLogradouro("");
        endereco.setNumero(random.nextInt());

        return "Populado com sucesso";
    }
}
