package br.com.UWBike.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Entity

@Table(name = "tb_patio")
@SequenceGenerator(sequenceName = "tb_patio_seq",name = "patio_seq",allocationSize = 1)
public class Patio {

    public Patio(){

    }
    public Patio(String logradouro, int numero, String complemento, String cep, String cidade, String uf, String pais, int lotacao) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.pais = pais;
        this.lotacao = lotacao;
    }

    @Id
    @Column(name = "id_patio")
    @GeneratedValue(generator = "patio_seq",strategy = GenerationType.SEQUENCE)
    private long idPatio;

    @Column(name = "logradouro",nullable = false,length = 450)
    private String logradouro;

    @Column(name ="numero",nullable = false)
    private int numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "cep",nullable = false)
    private String cep;

    @Column(name = "cidade",nullable = false,length = 100)
    private String cidade;

    @Column(name = "uf",nullable = false,length = 6)
    private String uf;

    @Column(name = "pais",nullable = false,length = 100)
    private String pais;

    @Column(name = "lotacao_max",nullable = false)
    private int lotacao;

    @OneToMany(mappedBy = "patio", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("patioRef")
    private List<MotoPatio> entradas = new ArrayList<>();;

    @OneToMany(mappedBy = "patio", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("ancoraRef")
    private List<Ancora> ancoras = new ArrayList<>();;

    @ManyToMany(mappedBy = "patios")
    @JsonManagedReference("funcioRef")
    private List<Funcionario> funcionarios = new ArrayList<>();;

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Ancora> getAncoras() {
        return ancoras;
    }

    public void setAncoras(List<Ancora> ancoras) {
        this.ancoras = ancoras;
    }

    public List<MotoPatio> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<MotoPatio> entradas) {
        this.entradas = entradas;
    }

    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    public long getIdPatio() {
        return idPatio;
    }

    public void setIdPatio(long idPatio) {
        this.idPatio = idPatio;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Patio outro = (Patio) obj;
        return idPatio == outro.idPatio;
    }
}
