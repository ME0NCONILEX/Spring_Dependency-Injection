package se.me0nly.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan(basePackages = "se.me0nly")
public class AppConfig {

    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }
}
