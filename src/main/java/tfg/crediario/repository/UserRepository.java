package tfg.crediario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import tfg.crediario.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.usuario = ?1")
    Optional<User> findByName(String usuario);

    @Query("select (count(u) > 0) from User u where u.usuario = ?1 and u.senha = ?2")
    boolean login(String usuario, String senha);

    @Transactional
    @Modifying
    @Query("delete from User u where u.id = ?1")
    int deletebyId(Integer id);

    @Transactional
    @Modifying
    @Query("update User u set u.usuario = ?1, u.senha = ?2 where u.id = ?3")
    int updateUser(String usuario, String senha, Integer id);

    @Override
    Optional<User> findById(Integer integer);

    User save(User user);
}
