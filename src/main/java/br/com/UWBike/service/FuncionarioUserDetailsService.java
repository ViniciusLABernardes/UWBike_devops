package br.com.UWBike.service;


import br.com.UWBike.model.Funcionario;
import br.com.UWBike.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FuncionarioUserDetailsService implements UserDetailsService {

    private final FuncionarioRepository funcionarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Funcionario funcionario = funcionarioRepository.findByLogin_Login(login)
                .orElseThrow(() -> new UsernameNotFoundException("Login não encontrado: " + login));



        return User.builder()
                .username(funcionario.getLogin().getLogin())
                .password(funcionario.getLogin().getSenha())
                .roles(funcionario.getCargo().toUpperCase())
                .build();

    }
}
