package dam.acceso.controller;

import dam.acceso.model.Habitacion;
import dam.acceso.service.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {

    @Autowired
    private HabitacionService habitacionService;

    @GetMapping("/buscar")
    public List<Habitacion> buscarPorTamañoYPrecio(@RequestParam int tamaño, @RequestParam double precioMin, @RequestParam double precioMax) {
        return habitacionService.buscarPorTamañoYPrecio(tamaño, precioMin, precioMax);
    }

    @PostMapping
    public Habitacion agregarHabitacion(@RequestBody Habitacion habitacion) {
        return habitacionService.agregarHabitacion(habitacion);
    }

    @DeleteMapping("/{id}")
    public void eliminarHabitacion(@PathVariable Long id) {
        habitacionService.eliminarHabitacion(id);
    }

    @PutMapping("/{id}/estado")
    public Habitacion modificarEstadoOcupacion(@PathVariable Long id, @RequestBody Map<String, Boolean> estado) {
        boolean ocupada = estado.get("ocupada");
        return habitacionService.modificarEstadoOcupacion(id, ocupada);
    }

}



