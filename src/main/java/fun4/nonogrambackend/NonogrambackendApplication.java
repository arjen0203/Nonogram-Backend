package fun4.nonogrambackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
        "fun4.nonogrambackend.Repositories"})
public class NonogrambackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NonogrambackendApplication.class, args);
    }
    //yes
}
