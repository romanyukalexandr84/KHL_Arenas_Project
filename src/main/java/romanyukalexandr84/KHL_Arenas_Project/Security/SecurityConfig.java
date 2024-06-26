package romanyukalexandr84.KHL_Arenas_Project.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//класс - конфигурация безопасности
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //в конфигурацию безопасности внедряем зависимость - обработчик аутентификации
    @Autowired
    private AuthHandler authenticationSuccessHandler;

    //настраиваем цепочку фильтров безопасности для разных страниц и разных ролей
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/", "/css/**", "/welcome", "/login").permitAll()
                        .requestMatchers("/user-profile").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/admin-profile/**").hasAnyRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .successHandler(authenticationSuccessHandler)
                        .permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/"))
                .csrf().disable();
        return http.build();
    }

    //создаем кодировщик паролей
    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    //создаем пользователей, задаем им имена, пароли и роли для менеджера пользовательских данных
    @Bean
    UserDetailsManager inMemoryUserDetailsManager() {
        var user1 = User.withUsername("user1").password("{noop}user1pass").roles("USER").build();
        var user2 = User.withUsername("user2").password("{noop}user2pass").roles("USER").build();
        var user3 = User.withUsername("user3").password("{noop}user3pass").roles("USER").build();
        var admin = User.withUsername("admin").password("{noop}adminpass").roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user1, user2, user3, admin);
    }
}