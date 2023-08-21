package tfg.crediario.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"Users\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_user\"", nullable = false)
    private Integer id;

    @Column(name = "usuario", nullable = false, length = Integer.MAX_VALUE)
    private String usuario;

    @Column(name = "senha", nullable = false, length = Integer.MAX_VALUE)
    private String senha;

}