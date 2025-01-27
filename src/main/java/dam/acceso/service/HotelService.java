package dam.acceso.service;

import dam.acceso.model.Hotel;
import dam.acceso.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return hotelRepository.save(hotel);
    }

}

