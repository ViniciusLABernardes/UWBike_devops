package br.com.UWBike.repository;


import br.com.UWBike.model.Ancora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AncoraRepository extends JpaRepository<Ancora,Long> {
}
