package br.com.UWBike.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Builder;

@Entity

@Table(name = "TB_ANCORA")
@SequenceGenerator(name = "ancora_seq",allocationSize = 1,sequenceName = "tb_ancora_seq")
public class Ancora {

    public Ancora(){

    }
    public Ancora(double x, double y) {
        this.x = x;
        this.y = y;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ancora_seq")
    private Long id;
    @Column(name = "posicao_x")
    private double x;
    @Column(name = "posicao_y")
    private double y;

    @ManyToOne
    @JoinColumn(name = "id_patio")
    @JsonBackReference("ancoraRef")
    private Patio patio;

    public Patio getPatio() {
        return patio;
    }

    public void setPatio(Patio patio) {
        this.patio = patio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
