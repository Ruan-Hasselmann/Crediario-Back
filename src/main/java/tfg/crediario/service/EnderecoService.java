package tfg.crediario.service;

import tfg.crediario.entity.Endereco;

import java.util.List;
import java.util.Optional;

public interface EnderecoService {
    Optional<Endereco> getEnderecoById(Integer id);

    List<Endereco> getAllEnderecos();

    Endereco createEndereco(Endereco endereco);

    int updateEndereco(Integer id, Endereco endereco);

    int deleteEndereco(Integer id);
}
