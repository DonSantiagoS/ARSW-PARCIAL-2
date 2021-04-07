package edu.eci.arsw.openweather.controllers;

import edu.eci.arsw.openweather.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ---------------------------------------------------------------------------------------------------------------------------
 * ---------------------------------------------------------------------------------------------------------------------------
 * 													CLASE: OpenWeatherController
 * ---------------------------------------------------------------------------------------------------------------------------
 *
 * ---------------------------------------------------------------------------------------------------------------------------
 * @author Santiago Buitrago
 * @version 1.0
 * ---------------------------------------------------------------------------------------------------------------------------
 */

@RestController
@RequestMapping(value = "/weather")
public class OpenWeatherController {

    @Autowired
    OpenWeatherServices servicios;

    /**
     * Consulta la informacion del clima de la ciudad indicada
     * @param ciudad Nombre de la ciudad a consultar
     * @return Informacion del clima de la ciudad solicitada o error en caso de no encontrarlo
     */
    @GetMapping(value = "/{ciudad}")
    public ResponseEntity<?> getClimaCiudad(@PathVariable String ciudad) {
        try {
            return new ResponseEntity<>(servicios.getClimaCiudad(ciudad), HttpStatus.ACCEPTED);
        } catch (OpenWeatherException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

