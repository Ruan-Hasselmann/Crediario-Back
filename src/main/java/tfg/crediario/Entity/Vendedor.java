package tfg.crediario.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"Vendedor\"")
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IdVendedor\"", nullable = false)
    private Integer id;

    @Column(name = "\"Nome\"", nullable = false, length = Integer.MAX_VALUE)
    private String nome;

    @Column(name = "\"Cpf\"", nullable = false, length = Integer.MAX_VALUE)
    private String cpf;

    @Column(name = "\"Rg\"", nullable = false, length = Integer.MAX_VALUE)
    private String rg;

    @Column(name = "\"Contato\"", nullable = false, length = Integer.MAX_VALUE)
    private String contato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"Endereco\"")
    private Endereco endereco;

}