package tfg.crediario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tfg.crediario.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}