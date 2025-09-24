package br.com.UWBike.repository;

import br.com.UWBike.model.Funcionario;
import br.com.UWBike.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
    Optional<Funcionario> findByLogin_Login(String login);

}
