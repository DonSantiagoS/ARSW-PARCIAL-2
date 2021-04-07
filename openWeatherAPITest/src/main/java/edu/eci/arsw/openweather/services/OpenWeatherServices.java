package edu.eci.arsw.openweather.services;

import edu.eci.arsw.openweather.model.*;
import org.springframework.stereotype.Service;

/**
 * ---------------------------------------------------------------------------------------------------------------------------
 * ---------------------------------------------------------------------------------------------------------------------------
 * 													CLASE: OpenWeatherServices
 * ---------------------------------------------------------------------------------------------------------------------------
 *
 * ---------------------------------------------------------------------------------------------------------------------------
 * @author Santiago Buitrago
 * @version 1.0
 * ---------------------------------------------------------------------------------------------------------------------------
 */

@Service
public interface OpenWeatherServices {
    /**
     * Obtiene los datos del clima de un lugar específico
     *
     * @param Ciudad Nombre de la ciudad a consultar el clima
     * @return Información del clima en dicha ciudad
     * @throws OpenWeatherException Cuando la ciudad no existe
     */
    Weather getClimaCiudad(String ciudad) throws OpenWeatherException;
}
