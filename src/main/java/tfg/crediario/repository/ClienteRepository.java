package tfg.crediario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tfg.crediario.entity.Cliente;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query("select c from Cliente c where c.status = true order by c.id")
    List<Cliente> findAllByStatus();

    @Transactional
    @Modifying
    @Query("update Cliente c set c.status = ?1 where c.id = ?2")
    Integer updateStatus(Boolean status, Integer id);

    @Transactional
    @Modifying
    @Query("update Cliente c set c.nome = ?1, c.cpf = ?2, c.rg = ?3, c.telefone = ?4 where c.id = ?5")
    Integer updateCliente(String nome, String cpf, String rg, String telefone, Integer id);

    @Query("select c from Cliente c where c.pagamento.dataProximo = ?1 order by c.id")
    List<Cliente> findByData(String dataProximo);

    @Query("select (count(c) > 0) from Cliente c where c.cpf = ?1")
    boolean existCliente(String cpf);

    @Query("select c from Cliente c where c.cpf = ?1 order by c.id")
    List<Cliente> findByCpf(String cpf);

}