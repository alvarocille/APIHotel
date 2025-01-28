package dam.acceso.service;

import dam.acceso.model.Habitacion;
import dam.acceso.model.Hotel;
import dam.acceso.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> buscarPorLocalidad(String localidad) {
        return hotelRepository.findByLocalidad(localidad);
    }

    public List<Hotel> buscarPorCategoria(String categoria) {
        return hotelRepository.findByCategoria(categoria);
    }

    public Hotel agregarHotel(Hotel hotel) {
        for (Habitacion habitacion : hotel.getHabitaciones()) {
            habitacion.setHotel(hotel);
        }
        return hotelRepository.save(hotel);
    }

    public Optional<Hotel> buscarPorId(Long id) {
        return hotelRepository.findById(id);
    }
}



