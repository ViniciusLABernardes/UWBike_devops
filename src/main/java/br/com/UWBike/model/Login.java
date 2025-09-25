package br.com.UWBike.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_LOGIN")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login implements Serializable {

    @Id
    @Column(name = "id_funcionario")
    private Long idFuncionario;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario")
    private Funcionario funcionario;

    @Column(name = "login", length = 50, nullable = false, unique = true)
    private String login;

    @Column(name = "senha", length = 180, nullable = false)
    private String senha;
}