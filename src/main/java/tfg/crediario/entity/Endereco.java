package tfg.crediario.entity;

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
    @Column(name = "\"idEndereco\"", nullable = false)
    private Integer id;

    @Column(name = "bairro", nullable = false, length = Integer.MAX_VALUE)
    private String bairro;

    @Column(name = "cep", nullable = false, length = Integer.MAX_VALUE)
    private String cep;

    @Column(name = "cidade", nullable = false, length = Integer.MAX_VALUE)
    private String cidade;

    @Column(name = "complemento", length = Integer.MAX_VALUE)
    private String complemento;

    @Column(name = "estado", nullable = false, length = Integer.MAX_VALUE)
    private String estado;

    @Column(name = "logradouro", nullable = false, length = Integer.MAX_VALUE)
    private String logradouro;

    @Column(name = "numero", nullable = false, length = Integer.MAX_VALUE)
    private String numero;

}