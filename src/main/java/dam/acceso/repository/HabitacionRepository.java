package dam.acceso.repository;

import dam.acceso.model.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
    List<Habitacion> findByTamañoAndPrecioPorNocheBetweenAndOcupadaFalse(int tamaño, double precioPorNoche, double precioPorNoche2);
}




