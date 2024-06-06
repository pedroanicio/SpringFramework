package dio.spring_data_jpa_repository.app;

import dio.spring_data_jpa_repository.app.model.Usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class SistemaUsuario implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Usuario pedro = criarUsuarioPedro();
        Usuario admin = criarUsuarioAdmin();

        Iterable<Usuario> usuarios = null;
        usuarios.forEach(u -> System.out.println(u.getNomeCompleto() + " - " + u.getLogin()));

    }

    private Usuario criarUsuarioPedro() {
        Usuario usuario = new Usuario();
        usuario.setEmail("pedro@dio.com.br");
        usuario.setLogin("pedro");
        usuario.setNomeCompleto("PEDRO ARTHUR");
        usuario.setSenha("diospringjpa");
        return usuario;
    }

    private Usuario criarUsuarioAdmin() {
        Usuario usuario = new Usuario();
        usuario.setEmail("admin@dio.com.br");
        usuario.setLogin("admin");
        usuario.setNomeCompleto("ADMINISTRADOR");
        usuario.setSenha("masterpass");
        return usuario;
    }
}
