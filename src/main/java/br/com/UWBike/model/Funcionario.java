package br.com.UWBike.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TB_FUNCIONARIO")
@Getter
@Builder
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
//@SequenceGenerator(name = "SQ_FUNCIONARIO", sequenceName = "tb_funcionario_seq", allocationSize = 1)
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_FUNCIONARIO")
    @Column(name = "id_funcionario")
    private Long idFuncionario;

    @Column(name = "nome_func", length = 150, nullable = false)
    private String nomeFunc;

    @Column(name = "CPF", length = 30, nullable = false, unique = true)
    private String cpf;

    @Column(name = "salario", nullable = false)
    private double salario;

    @Column(name = "cargo",nullable = false)
    private String cargo;

    @OneToOne(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Login login;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "TB_PATIO_FUNCIONARIO",
            joinColumns = @JoinColumn(name = "id_funcionario"),
            inverseJoinColumns = @JoinColumn(name = "id_patio")
    )
    @JsonBackReference("funcioRef")
    private List<Patio> patios;
}