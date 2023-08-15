package tfg.crediario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import tfg.crediario.entity.Vendedor;

import java.util.List;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
    @Transactional
    @Modifying
    @Query("update Vendedor v set v.telefone = ?1, v.cpf = ?2, v.nome = ?3, v.rg = ?4 where v.id = ?5")
    int updateVendedor(String telefone, String cpf, String nome, String rg, Integer id);

    @Query("select v from Vendedor v order by v.id")
    List<Vendedor> getAllVendedores();

    @Transactional
    @Modifying
    @Query("delete from Vendedor v where v.id = ?1")
    int deleteVendedorById(Integer id);
}