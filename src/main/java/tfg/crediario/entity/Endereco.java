package tfg.crediario.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

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

    @OneToMany(mappedBy = "idEndereco")
    private Set<Cliente> clientes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "endereco")
    private Set<Vendedor> vendedors = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id) && Objects.equals(logradouro, endereco.logradouro) && Objects.equals(numero, endereco.numero) && Objects.equals(complemento, endereco.complemento) && Objects.equals(bairro, endereco.bairro) && Objects.equals(cidade, endereco.cidade) && Objects.equals(estado, endereco.estado) && Objects.equals(cep, endereco.cep) && Objects.equals(clientes, endereco.clientes) && Objects.equals(vendedors, endereco.vendedors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, logradouro, numero, complemento, bairro, cidade, estado, cep, clientes, vendedors);
    }
}