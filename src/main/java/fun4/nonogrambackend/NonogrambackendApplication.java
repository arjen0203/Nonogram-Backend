package fun4.nonogrambackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class NonogrambackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NonogrambackendApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCRyptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
