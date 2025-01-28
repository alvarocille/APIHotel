package dam.acceso.util;

import dam.acceso.model.Usuario;
import dam.acceso.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (!usuarioRepository.existsById("juan")) {
                Usuario usuario = new Usuario();
                usuario.setUsername("juan");
                usuario.setPassword(passwordEncoder.encode("juan"));
                usuario.setRole("ROLE_USER");
                usuarioRepository.save(usuario);
            }
        };
    }
}
