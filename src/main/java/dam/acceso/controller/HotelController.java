package dam.acceso.controller;

import dam.acceso.model.Hotel;
import dam.acceso.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoteles")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/localidad/{localidad}")
    public List<Hotel> buscarPorLocalidad(@PathVariable String localidad) {
        return hotelService.buscarPorLocalidad(localidad);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Hotel> buscarPorCategoria(@PathVariable String categoria) {
        return hotelService.buscarPorCategoria(categoria);
    }

    @PostMapping
    public Hotel agregarHotel(@RequestBody Hotel hotel) {
        return hotelService.agregarHotel(hotel);
    }

}
