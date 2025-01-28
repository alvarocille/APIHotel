package dam.acceso.service;

import dam.acceso.model.Habitacion;
import dam.acceso.repository.HabitacionRepository;
import dam.acceso.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private HotelRepository hotelRepository;

    public List<Habitacion> buscarPorTamañoYPrecio(int tamaño, double precioMin, double precioMax) {
        return habitacionRepository.findByTamanioAndPrecioPorNocheBetweenAndOcupadaFalse(tamaño, precioMin, precioMax);
    }

    public Habitacion agregarHabitacion(Habitacion habitacion) {
        if (habitacion.getHotel() == null || !hotelRepository.existsById(habitacion.getHotel().getId())) {
            System.out.println("El hotel no existe");
            return null;
        } else {
            return habitacionRepository.save(habitacion);
        }
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





