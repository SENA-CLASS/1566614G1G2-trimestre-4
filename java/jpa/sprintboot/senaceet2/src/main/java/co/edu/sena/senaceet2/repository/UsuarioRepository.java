package co.edu.sena.senaceet2.repository;

import co.edu.sena.senaceet2.domain.Cliente;
import co.edu.sena.senaceet2.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByIdCliente(Cliente cliente);
    Usuario findByCorreo(String correo);

}
