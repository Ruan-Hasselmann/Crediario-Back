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
    private String entrada;

    @Column(name = "\"formaPagamento\"", nullable = false, length = Integer.MAX_VALUE)
    private String formaPagamento;

    @Column(name = "restante", length = Integer.MAX_VALUE)
    private String restante;

    @Column(name = "\"tipoPagamento\"", nullable = false, length = Integer.MAX_VALUE)
    private String tipoPagamento;

    @Column(name = "total", nullable = false, length = Integer.MAX_VALUE)
    private String total;

    @Column(name = "\"totalPago\"", nullable = false, length = Integer.MAX_VALUE)
    private String totalPago;

}