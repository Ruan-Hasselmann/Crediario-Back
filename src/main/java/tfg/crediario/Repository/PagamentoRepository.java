package tfg.crediario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tfg.crediario.Entity.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}