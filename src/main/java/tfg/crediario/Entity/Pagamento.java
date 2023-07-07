package tfg.crediario.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "\"Pagamento\"")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IdCliente\"", nullable = false)
    private Integer id;

    @Column(name = "\"DataVenda\"", nullable = false)
    private LocalDate dataVenda;

    @Column(name = "\"DataProx\"", nullable = false)
    private LocalDate dataProx;

    @Column(name = "\"Entrada\"")
    private Double entrada;

    @Column(name = "\"Total Pago\"", nullable = false)
    private Double totalPago;

    @Column(name = "\"Restante\"", nullable = false)
    private Double restante;

    @Column(name = "\"Total\"", nullable = false)
    private Double total;

    @Column(name = "\"FormaPagamento\"", nullable = false, length = Integer.MAX_VALUE)
    private String formaPagamento;

    @Column(name = "\"TipoPagamento\"", nullable = false, length = Integer.MAX_VALUE)
    private String tipoPagamento;

}