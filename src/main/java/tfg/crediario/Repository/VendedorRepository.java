package tfg.crediario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tfg.crediario.Entity.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
}