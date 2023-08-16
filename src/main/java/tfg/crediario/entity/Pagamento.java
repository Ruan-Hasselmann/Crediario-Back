package tfg.crediario.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"Pagamento\"")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idPagamento\"", nullable = false)
    private Integer id;

    @Column(name = "\"dataProximo\"", length = Integer.MAX_VALUE)
    private String dataProximo;

    @Column(name = "\"dataVenda\"", nullable = false, length = Integer.MAX_VALUE)
    private String dataVenda;

    @Column(name = "entrada", length = Integer.MAX_VALUE)
    private Double entrada;

    @Column(name = "\"formaPagamento\"", nullable = false, length = Integer.MAX_VALUE)
    private String formaPagamento;

    @Column(name = "restante", length = Integer.MAX_VALUE)
    private Double restante;

    @Column(name = "\"tipoPagamento\"", nullable = false, length = Integer.MAX_VALUE)
    private String tipoPagamento;

    @Column(name = "total", nullable = false, length = Integer.MAX_VALUE)
    private Double total;

    @Column(name = "\"totalPago\"", nullable = false, length = Integer.MAX_VALUE)
    private Double totalPago;

    public Pagamento(Integer id, String dataProximo, String dataVenda, Double entrada, String formaPagamento, Double restante, String tipoPagamento, Double total, Double totalPago) {
        this.id = id;
        this.dataProximo = dataProximo;
        this.dataVenda = dataVenda;
        this.entrada = entrada;
        this.formaPagamento = formaPagamento;
        this.restante = restante;
        this.tipoPagamento = tipoPagamento;
        this.total = total;
        this.totalPago = totalPago;
    }

    public Pagamento() {

    }
}