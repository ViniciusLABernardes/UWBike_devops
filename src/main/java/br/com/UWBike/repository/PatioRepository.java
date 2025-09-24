package br.com.UWBike.repository;


import br.com.UWBike.model.Moto;
import br.com.UWBike.model.Patio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatioRepository extends JpaRepository<Patio,Long> {
    @Query("SELECT DISTINCT mp.moto FROM MotoPatio mp WHERE mp.patio.idPatio = :idPatio")
    List<Moto> findMotosByPatio(@Param("idPatio") Long idPatio);
}
