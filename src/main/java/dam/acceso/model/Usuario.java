package dam.acceso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    private String username;
    private String password;
    private String role;
}

