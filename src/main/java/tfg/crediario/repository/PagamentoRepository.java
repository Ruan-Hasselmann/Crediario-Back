package tfg.crediario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import tfg.crediario.entity.Pagamento;

import java.util.List;
import java.util.Optional;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
    @Transactional
    @Modifying
    @Query("delete from Pagamento p where p.id = ?1")
    int deletePagamentoById(Integer id);

    @Transactional
    @Modifying
    @Query("""
            update Pagamento p set p.dataProximo = ?1, p.entrada = ?2, p.formaPagamento = ?3, p.restante = ?4, p.tipoPagamento = ?5, p.total = ?6, p.totalPago = ?7
            where p.id = ?8""")
    int updatePagamento(String dataProximo, String entrada, String formaPagamento, String restante, String tipoPagamento, String total, String totalPago, Integer id);

    Optional<Pagamento> findById(Integer id);

    Pagamento save(Pagamento pagamento);

    @Query("select p from Pagamento p order by p.id")
    List<Pagamento> findAllPagamentos();

}