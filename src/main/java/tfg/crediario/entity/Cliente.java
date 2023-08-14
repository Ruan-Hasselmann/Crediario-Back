package tfg.crediario.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"Cliente\"")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idCliente\"", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"idCliente\"", nullable = false)
    private Endereco endereco;

    @Column(name = "cpf", nullable = false, length = Integer.MAX_VALUE)
    private String cpf;

    @Column(name = "\"dataCadastro\"", length = Integer.MAX_VALUE)
    private String dataCadastro;

    @Column(name = "nome", length = Integer.MAX_VALUE)
    private String nome;

    @Column(name = "rg", length = Integer.MAX_VALUE)
    private String rg;

    @Column(name = "status", nullable = false)
    private Boolean status = false;

    @Column(name = "telefone", length = Integer.MAX_VALUE)
    private String telefone;

    @OneToOne(optional = false)
    private Vendedor vendedor;

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @OneToOne(optional = false)
    private Pagamento pagamento;

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}