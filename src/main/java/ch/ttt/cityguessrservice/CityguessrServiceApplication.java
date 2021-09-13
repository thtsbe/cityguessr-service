package ch.ttt.cityguessrservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Webflux Endpoint :8080
 * RSocket Endpoint :9898
 */
@SpringBootApplication
public class CityguessrServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityguessrServiceApplication.class, args);
    }

}
