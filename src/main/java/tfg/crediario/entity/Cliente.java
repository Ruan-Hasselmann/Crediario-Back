package tfg.crediario.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"Clientes\"")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_cliente\"", nullable = false)
    private Integer id;

    @Column(name = "cpf", nullable = false, length = Integer.MAX_VALUE)
    private String cpf;

    @Column(name = "\"data_cadastro\"", nullable = false, length = Integer.MAX_VALUE)
    private String dataCadastro;

    @Column(name = "nome", nullable = false, length = Integer.MAX_VALUE)
    private String nome;

    @Column(name = "rg", length = Integer.MAX_VALUE)
    private String rg;

    @Column(name = "status", nullable = false)
    private Boolean status = false;

    @Column(name = "telefone", nullable = false, length = Integer.MAX_VALUE)
    private String telefone;

    @Column(name = "vendedor", nullable = false, length = Integer.MAX_VALUE)
    private String vendedor;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "\"endereco\"", nullable = false)
    private Endereco endereco;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "\"pagamento\"", nullable = false)
    private Pagamento pagamento;

}