package dam.acceso.service;

import dam.acceso.model.Habitacion;
import dam.acceso.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {

    @Autowired
    private HabitacionRepository habitacionRepository;

    public List<Habitacion> buscarPorTamañoYPrecio(int tamaño, double precioMin, double precioMax) {
        return habitacionRepository.findByTamañoAndPrecioPorNocheBetweenAndOcupadaFalse(tamaño, precioMin, precioMax);
    }

    public Habitacion agregarHabitacion(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    public void eliminarHabitacion(Long id) {
        habitacionRepository.deleteById(id);
    }

    public Habitacion modificarEstadoOcupacion(Long id, boolean ocupada) {
        Optional<Habitacion> optionalHabitacion = habitacionRepository.findById(id);
        if (optionalHabitacion.isPresent()) {
            Habitacion habitacion = optionalHabitacion.get();
            habitacion.setOcupada(ocupada);
            return habitacionRepository.save(habitacion);
        }
        return null;
    }

}




