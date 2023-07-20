package tfg.crediario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tfg.crediario.entity.Cliente;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Transactional
    @Modifying
    @Query("update Cliente c set c.status = ?1 where c.id = ?2 and c.status = false")
    void updateTrue(Boolean status, Long id);
    @Transactional
    @Modifying
    @Query("update Cliente c set c.status = ?1 where c.id = ?2 and c.status = true")
    void updateFalse(Boolean status, Long id);
    @Query("select c from Cliente c where c.status = false")
    List<Cliente> findInactive();
    @Query("select c from Cliente c where c.status = true order by c.id, c.nome, c.cpf, c.rg, c.telefone, c.status, c.dataCadastro")
    List<Cliente> findByStatus();
}