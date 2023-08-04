package tfg.crediario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tfg.crediario.entity.Endereco;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    @Override
    List<Endereco> findAll();

    @Override
    void deleteById(Integer integer);
}