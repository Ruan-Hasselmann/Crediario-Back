package tfg.crediario.service;

import tfg.crediario.entity.Pagamento;

import java.util.List;
import java.util.Optional;

public interface PagamentoService {
    List<Pagamento> getAllPagamentos();

    Optional<Pagamento> getPagamentoById(Integer id);

    Pagamento createPagamento(Pagamento pagamento);

    Integer updatePagamento(Integer id, Pagamento pagamento);

    Integer deletePagamento(Integer id);

    int registrarPagamento(Integer id, String dataProximo, Double valor);
}
