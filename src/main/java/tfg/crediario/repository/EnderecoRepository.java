package tfg.crediario.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tfg.crediario.entity.Endereco;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    @Transactional
    @Modifying
    @Query("""
            update Endereco e set e.logradouro = ?1, e.numero = ?2, e.complemento = ?3, e.bairro = ?4, e.cidade = ?5, e.estado = ?6, e.cep = ?7
            where e.id = ?8""")
    int updateEndereco(String logradouro, String numero, String complemento, String bairro, String cidade, String estado, String cep, Integer id);

    @Override
    @NotNull
    Optional<Endereco> findById(@NotNull Integer id);

    @Transactional
    @Modifying
    @Query("delete from Endereco e where e.id = ?1")
    int deleteEnderecoById(Integer id);

    @Override
    @Query("select e from Endereco e order by e.id")
    List<Endereco> findAll();
}