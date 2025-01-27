package dam.acceso.controller;

import dam.acceso.model.Hotel;
import dam.acceso.service.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoteles")
@Tag(name = "Hoteles", description = "API para gestionar hoteles")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/localidad/{localidad}")
    @Operation(summary = "Buscar hoteles por localidad", description = "Proporciona una lista de hoteles en una localidad específica")
    public List<Hotel> buscarPorLocalidad(@PathVariable String localidad) {
        return hotelService.buscarPorLocalidad(localidad);
    }

    @GetMapping("/categoria/{categoria}")
    @Operation(summary = "Buscar hoteles por categoría", description = "Proporciona una lista de hoteles en una categoría específica")
    public List<Hotel> buscarPorCategoria(@PathVariable String categoria) {
        return hotelService.buscarPorCategoria(categoria);
    }

    @PostMapping
    @Operation(summary = "Agregar un nuevo hotel", description = "Agrega un nuevo hotel a la base de datos")
    public Hotel agregarHotel(@RequestBody Hotel hotel) {
        return hotelService.agregarHotel(hotel);
    }

}