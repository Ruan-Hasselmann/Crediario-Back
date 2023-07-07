package tfg.crediario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tfg.crediario.entity.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}