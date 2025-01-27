package dam.acceso.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String categoria;
    private boolean piscina;
    private String localidad;

    @JsonManagedReference
    @OneToMany(mappedBy = "hotel")
    private List<Habitacion> habitaciones;
}


