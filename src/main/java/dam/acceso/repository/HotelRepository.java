package dam.acceso.repository;

import dam.acceso.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByLocalidad(String localidad);
    List<Hotel> findByCategoria(String categoria);
}

