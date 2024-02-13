package main.java.com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DwarfApplication {
    public static void main(String[] args) {
        SpringApplication.run(DwarfApplication.class, args);
    }

    //producer
    @Bean
    public RestTemplate restTemplate(@Value("${weapon.url}") String url) {
        return new RestTemplateBuilder().rootUri(url).build();
    }
}
