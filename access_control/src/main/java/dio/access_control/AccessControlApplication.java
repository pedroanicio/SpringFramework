package dio.access_control;

import dio.access_control.model.User;
import dio.access_control.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class AccessControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessControlApplication.class, args);
	}

	@Component
	public class StartApplication implements CommandLineRunner {
		@Autowired
		private UserService service;
		@Override
		public void run(String... args) throws Exception {
			for(int x=1; x<=5;x++){
				service.insert(new User("user"+x));
			}
			User user2 = service.searchByUsername("user2");
			user2.setName("MASTER");
			service.modify(user2);

			for(User user: service.list()){
				System.out.println(user);
			}
		}
	}
}

/**
 *
 *O Spring usa um conjunto de anotações @ para identificar as classes que terão a instância dos objetos gerenciados pelo container.
 *
 * @Component: Tudo no Spring são componentes, logo quando iniciamos a aplicação será criado um objeto baseado na classe StartApplication.java.
 *
 * @Autowired: Esta anotação determina que o objeto baseado na classe UserService.java será atribuído a variável service conforme linha 8.
 *
 * Estamos simulando a inclusão de 05 usuários com username: user1, user2 e etc, conforme linhas 11 a 13.
 *
 * Na linha 14 estamos simulando buscar um usuário pelo seu username, no caso o User com username = user2.
 *
 * Após localizar o User mudamos o seu name para MASTER conforme linha 15
 *
 * Na linha 16 simulamos a alteração de User no nosso "banco de dados".
 *
 * E por último, imprimimos todos os usuários para avaliar sua estrutura conforme linhas 18 até 20.

 * */
