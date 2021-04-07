package edu.eci.arsw.openweather.services.impl;

import edu.eci.arsw.openweather.cache.*;
import edu.eci.arsw.openweather.cache.impl.*;
import edu.eci.arsw.openweather.connection.*;
import edu.eci.arsw.openweather.connection.impl.*;
import edu.eci.arsw.openweather.model.*;
import edu.eci.arsw.openweather.services.OpenWeatherException;
import edu.eci.arsw.openweather.services.OpenWeatherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

/**
 * ---------------------------------------------------------------------------------------------------------------------------
 * ---------------------------------------------------------------------------------------------------------------------------
 * 													CLASE: OpenWeatherServicesImpl
 * ---------------------------------------------------------------------------------------------------------------------------
 *
 * ---------------------------------------------------------------------------------------------------------------------------
 * @author Santiago Buitrago
 * @version 1.0
 * ---------------------------------------------------------------------------------------------------------------------------
 */

@Service
public class OpenWeatherServicesImpl implements OpenWeatherServices {

    public Weather getClimaCiudad(String ciudad) throws OpenWeatherException {
        Weather clima;
        try {
            if (openWeatherCache.verificarClimaCiudadCache(ciudad)) {
                clima = openWeatherCache.getClimaCiudadCache(ciudad);
            } else {
                clima = httpConnection.getClimaCiudad(ciudad);
                clima.setTime(LocalDateTime.now());
                openWeatherCache.guardarClimaCache(ciudad, clima);
            }
        } catch (OpenWeatherConnectionException e) {
            throw new OpenWeatherException(e.getMessage(), e);
        }
        return clima;
    }
}