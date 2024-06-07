package dio.spring_security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        UserDetails user = users
                .username("teste")
                .password("123")
                .roles("USER")
                .build();
        UserDetails admin = users
                .username("admin")
                .password("456")
                .roles("ADMIN", "USER")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/admins").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/users/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/users/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/users/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")
                        .requestMatchers("/").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(Customizer.withDefaults()).logout(logout -> logout.logoutUrl("/logout"))
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }



}

/**
 *
 *userDetailsService
 * Esse Bean cria os usuários em memória. Ele recebe como parâmetro um PasswordEncoder
 * (que é o último Bean da classe) e usa esse cara para criptografar as senhas.
 *
 * filterChain
 * Esse Bean é quem cuida das permissões. Os requestMatchers têm todos os métodos
 * disponíveis na minha classe. Basicamente a raiz do meu projeto é acessada somente
 * pela role ADMIN. O formulário de Login é acessado por qualquer pessoa (como se estivesse
 * fora da gestão da segurança).
 *
 * Os últimos 3 itens são interessante:
 *
 * o CSRF  protege os métodos PUT, POST e DELETE. Para segurança do tipo Basic, eu
 * precisei desabilitá-lo, é isso que a linha csrf() faz;
 *
 * o formLogin(), como você já pode imaginar, habilita o formulário de login e o
 * endereço para logout;
 *
 * o httpBasic() habilita a autenticação do tipo Basic, permitindo que minha api seja
 * acessada pelo Postman, por exemplo, e as requisições sejam feitas.
 * Outra coisa que eu acho interessante dizer, esse projeto que eu usei foi o projeto
 * que foi feito na aula anterior, que tinha um Controller User, onde mostrava os
 * dados do usuário.
 *
 *
 *
 * */