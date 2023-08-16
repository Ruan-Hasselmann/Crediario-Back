package tfg.crediario.service.impl;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tfg.crediario.entity.Endereco;
import tfg.crediario.repository.EnderecoRepository;
import tfg.crediario.service.EnderecoService;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public Optional<Endereco> getEnderecoById(Integer id) {
        return enderecoRepository.findById(id);
    }

    @Override
    public List<Endereco> getAllEnderecos() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco createEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public Integer updateEndereco(Integer id, @NotNull Endereco endereco) {
        return enderecoRepository.updateEndereco(endereco.getLogradouro(), endereco.getNumero(), endereco.getComplemento(), endereco.getBairro(), endereco.getCidade(), endereco.getCidade(), endereco.getCep(), id);
    }

    @Override
    public Integer deleteEndereco(Integer id) {
        return enderecoRepository.deleteEnderecoById(id);
    }
}
