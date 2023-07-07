package tfg.crediario.Entity;

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
    @Column(name = "\"IdCliente\"", nullable = false)
    private Integer id;

    @Column(name = "\"Nome\"", nullable = false, length = Integer.MAX_VALUE)
    private String nome;

    @Column(name = "\"Cpf\"", nullable = false, length = Integer.MAX_VALUE)
    private String cpf;

    @Column(name = "\"Rg\"", length = Integer.MAX_VALUE)
    private String rg;

    @Column(name = "\"Telefone\"", nullable = false, length = Integer.MAX_VALUE)
    private String telefone;

    @Column(name = "\"Status\"")
    private Boolean status;

}