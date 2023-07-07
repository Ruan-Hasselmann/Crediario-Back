package tfg.crediario.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
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

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Cliente cliente = (Cliente) o;
        return getId() != null && Objects.equals(getId(), cliente.getId());
    }

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }
}