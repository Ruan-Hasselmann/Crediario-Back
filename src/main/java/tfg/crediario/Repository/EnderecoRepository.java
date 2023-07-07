package tfg.crediario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tfg.crediario.Entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}