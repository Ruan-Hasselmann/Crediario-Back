package tfg.crediario.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"Endereco\"")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IdEndereco\"", nullable = false)
    private Integer id;

    @Column(name = "\"Logradouro\"", nullable = false, length = Integer.MAX_VALUE)
    private String logradouro;

    @Column(name = "\"Numero\"", nullable = false)
    private Integer numero;

    @Column(name = "\"Complemento\"", length = Integer.MAX_VALUE)
    private String complemento;

    @Column(name = "\"Bairro\"", nullable = false, length = Integer.MAX_VALUE)
    private String bairro;

    @Column(name = "\"Cidade\"", nullable = false, length = Integer.MAX_VALUE)
    private String cidade;

    @Column(name = "\"Estado\"", nullable = false, length = Integer.MAX_VALUE)
    private String estado;

    @Column(name = "\"Cep\"", nullable = false, length = Integer.MAX_VALUE)
    private String cep;

}