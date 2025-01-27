package dam.acceso.controller;

import dam.acceso.model.Habitacion;
import dam.acceso.service.HabitacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/habitaciones")
@Tag(name = "Habitaciones", description = "API para gestionar habitaciones")
public class HabitacionController {

    @Autowired
    private HabitacionService habitacionService;

    @GetMapping("/buscar")
    @Operation(summary = "Buscar habitaciones por tamaño y precio", description = "Proporciona una lista de habitaciones según el tamaño y el rango de precio")
    public List<Habitacion> buscarPorTamañoYPrecio(@RequestParam int tamaño, @RequestParam double precioMin, @RequestParam double precioMax) {
        return habitacionService.buscarPorTamañoYPrecio(tamaño, precioMin, precioMax);
    }

    @PostMapping
    @Operation(summary = "Agregar una nueva habitación", description = "Agrega una nueva habitación a la base de datos")
    public Habitacion agregarHabitacion(@RequestBody Habitacion habitacion) {
        return habitacionService.agregarHabitacion(habitacion);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una habitación", description = "Elimina una habitación de la base de datos por ID")
    public void eliminarHabitacion(@PathVariable Long id) {
        habitacionService.eliminarHabitacion(id);
    }

    @PutMapping("/{id}/estado")
    @Operation(summary = "Modificar estado de ocupación de una habitación", description = "Modifica el estado de ocupación de una habitación por ID")
    public Habitacion modificarEstadoOcupacion(@PathVariable Long id, @RequestBody Map<String, Boolean> estado) {
        boolean ocupada = estado.get("ocupada");
        return habitacionService.modificarEstadoOcupacion(id, ocupada);
    }

}



