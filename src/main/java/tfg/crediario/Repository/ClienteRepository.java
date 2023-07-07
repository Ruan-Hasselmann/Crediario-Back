package tfg.crediario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tfg.crediario.Entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}