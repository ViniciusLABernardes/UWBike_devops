package br.com.UWBike.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity

@Table(name = "tb_moto_patio")
//@SequenceGenerator(name = "moto_patio_seq",allocationSize = 1,sequenceName = "tb_moto_patio_seq")
public class MotoPatio {
    public MotoPatio(){

    }
    public MotoPatio( Moto moto, Patio patio, LocalDateTime dataHoraEntrada){
        this.moto = moto;
        this.patio = patio;
        this.dataHoraEntrada = dataHoraEntrada;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "moto_patio_seq")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_moto", nullable = false)
    @JsonBackReference("motoRef")
    private Moto moto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_patio", nullable = false)
    @JsonBackReference("patioRef")
    private Patio patio;

    @Column(name = "data_hora_entrada", nullable = false)
    private LocalDateTime dataHoraEntrada;
    @Column(name = "data_hora_saida")
    private LocalDateTime dataHoraSaida;

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public Patio getPatio() {
        return patio;
    }

    public void setPatio(Patio patio) {
        this.patio = patio;
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public LocalDateTime getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
