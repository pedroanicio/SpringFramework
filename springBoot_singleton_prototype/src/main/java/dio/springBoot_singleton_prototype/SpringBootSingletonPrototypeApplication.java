package dio.springBoot_singleton_prototype;

import dio.springBoot_singleton_prototype.app.SistemaMensagem;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootSingletonPrototypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSingletonPrototypeApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(SistemaMensagem sitema) throws Exception{
		return args -> {
			sitema.enviarConfirmacaoCadastro();
			sitema.enviarMensagemBoasVindas();
			sitema.enviarConfirmacaoCadastro();
		};
	}
}
