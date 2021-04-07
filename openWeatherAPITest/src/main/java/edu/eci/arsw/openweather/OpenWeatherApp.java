package edu.eci.arsw.openweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * ---------------------------------------------------------------------------------------------------------------------------
 * ---------------------------------------------------------------------------------------------------------------------------
 * 													CLASE: OpenWeatherApp
 * ---------------------------------------------------------------------------------------------------------------------------
 *
 * ---------------------------------------------------------------------------------------------------------------------------
 * @author Santiago Buitrago
 * @version 1.0
 * ---------------------------------------------------------------------------------------------------------------------------
 */

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.openweather"})
public class OpenWeatherApp {

    /**
     * Metodo principal que inicia la aplicacion
     * @param args Argumentos para iniciar la aplicación
     */
    public static void main(String[] args) {
        SpringApplication.run(OpenWeatherApp.class, args);
    }
}
