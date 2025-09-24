package br.com.UWBike.repository;


import br.com.UWBike.model.Moto;
import br.com.UWBike.model.MotoPatio;
import br.com.UWBike.model.Patio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotoRepository extends JpaRepository<Moto,Long> {

}
