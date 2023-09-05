package tfg.crediario.service.impl;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tfg.crediario.entity.Pagamento;
import tfg.crediario.repository.PagamentoRepository;
import tfg.crediario.service.PagamentoService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PagamentoServiceImpl implements PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Override
    public List<Pagamento> getAllPagamentos() {
        return pagamentoRepository.findAllPagamentos();
    }

    @Override
    public Optional<Pagamento> getPagamentoById(Integer id) {
        return pagamentoRepository.findById(id);
    }

    @Override
    public Pagamento createPagamento(Pagamento pagamento) {
        pagamento.setDataProximo(formatDate(pagamento.getDataProximo()));
        pagamento.setDataVenda(getDateTime());
        pagamento.setRestante(pagamento.getTotal() - pagamento.getEntrada());
        pagamento.setTotalPago(pagamento.getEntrada());
        return pagamentoRepository.save(pagamento);
    }

    @Override
    public Integer updatePagamento(Integer id, @NotNull Pagamento pagamento) {
        return pagamentoRepository.updatePagamento(pagamento.getDataProximo(), pagamento.getEntrada(), pagamento.getFormaPagamento(), pagamento.getRestante(), pagamento.getTipoPagamento(), pagamento.getTotal(), pagamento.getTotalPago(), id);
    }

    @Override
    public Integer deletePagamento(Integer id) {
        return pagamentoRepository.deletePagamentoById(id);
    }

    @Override
    public int registrarPagamento(Integer id, String dataProximo, Double valor) {
        Optional<Pagamento> pagamentoAtual = getPagamentoById(id);
        if (pagamentoAtual.isPresent()) {
            pagamentoAtual.get().setDataProximo(formatDate(dataProximo));
            pagamentoAtual.get().setRestante(pagamentoAtual.get().getRestante() - valor);
            pagamentoAtual.get().setTotalPago(pagamentoAtual.get().getTotalPago() + valor);
            return updatePagamento(id, pagamentoAtual);
        }
        return 0;
    }

    private int updatePagamento(Integer id, Optional<Pagamento> pagamento) {
        return pagamento.map(value -> pagamentoRepository.updatePagamento(value.getDataProximo(), value.getEntrada(), value.getFormaPagamento(), value.getRestante(), value.getTipoPagamento(), value.getTotal(), value.getTotalPago(), id)).orElse(0);
    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private String formatDate(String data){
        String[] dataSeparada = data.split("-");
        data = dataSeparada[2] + "-" + dataSeparada[1] + "-" +dataSeparada[0];
        return data;
    }

}
