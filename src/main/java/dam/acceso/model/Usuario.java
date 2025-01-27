package dam.acceso.model;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Data
public class Usuario {
    @Id
    private String username;
    private String password;
    private String role;
}

