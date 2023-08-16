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
    @Query("select c from Cliente c where c.status = true order by c.id")
    List<Cliente> findAllByStatus();

    @Transactional
    @Modifying
    @Query("update Cliente c set c.status = ?1 where c.id = ?2")
    boolean updateStatus(Boolean status, Integer id);

    @Transactional
    @Modifying
    @Query("update Cliente c set c.nome = ?1, c.cpf = ?2, c.rg = ?3, c.telefone = ?4 where c.id = ?5")
    Cliente updateCliente(String nome, String cpf, Integer rg, String telefone, Integer id);

}