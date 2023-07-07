package tfg.crediario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tfg.crediario.entity.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
}