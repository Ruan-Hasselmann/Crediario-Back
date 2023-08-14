package tfg.crediario.entity;

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
    @Column(name = "\"idVendedor\"", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"idVendedor\"", nullable = false)
    private Endereco endereco;

    @Column(name = "contato", nullable = false, length = Integer.MAX_VALUE)
    private String contato;

    @Column(name = "cpf", nullable = false, length = Integer.MAX_VALUE)
    private String cpf;

    @Column(name = "nome", nullable = false, length = Integer.MAX_VALUE)
    private String nome;

    @Column(name = "rg", nullable = false, length = Integer.MAX_VALUE)
    private String rg;

    @OneToOne(mappedBy = "vendedor")
    private Cliente cliente;

}