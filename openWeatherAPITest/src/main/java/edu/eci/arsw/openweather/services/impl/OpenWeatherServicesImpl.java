package edu.eci.arsw.openweather.services.impl;

import edu.eci.arsw.openweather.cache.OpenWeatherCache;
import edu.eci.arsw.openweather.connection.HttpConnection;
import edu.eci.arsw.openweather.connection.impl.OpenWeatherConnectionException;
import edu.eci.arsw.openweather.model.Weather;
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

    @Autowired
    private HttpConnection httpConnection;

    @Autowired
    private OpenWeatherCache openWeatherCache;

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