package edu.eci.arsw.openweather.cache;

import edu.eci.arsw.openweather.model.*;
import edu.eci.arsw.openweather.services.OpenWeatherException;
import org.springframework.stereotype.Service;

/**
 * ---------------------------------------------------------------------------------------------------------------------------
 * ---------------------------------------------------------------------------------------------------------------------------
 * 													CLASE: OpenWeatherCache
 * ---------------------------------------------------------------------------------------------------------------------------
 *
 * ---------------------------------------------------------------------------------------------------------------------------
 * @author Santiago Buitrago
 * @version 1.0
 * ---------------------------------------------------------------------------------------------------------------------------
 */

@Service
public interface OpenWeatherCache {

    /**
     * Consulta la infomacion del clima de un lugar
     * @param ciudad El nombre de la ciudad a consultar
     * @return Información del clima en dicha ciudad que se encuentra guardad en el cache
     * @throws OpenWeatherException - Si no existe la informacion del clima en el cache de la ciudad consultada
     */
    Weather getClimaCiudadCache(String ciudad) throws OpenWeatherException;

    /**
     * Verifica si en el cache se tiene el clima de la ciudad que se esta consultando
     * @param ciudad El nombre de la ciudad a consultar
     * @return Boleeano que indica si existe o no el clima de dicha ciudad
     * @throws OpenWeatherException - Si hubo un error al verificar la existencia de la informacion de clima de la ciudad en el cache
     */
    boolean verificarClimaCiudadCache(String ciudad) throws OpenWeatherException;

    /**
     * Guarda en el cache la informacion del clima de la ciudad que fue consultada
     * @param ciudad El nombre de la ciudad a consultar
     * @param clima Clima de la ciudad la cual se consulto
     * @throws OpenWeatherException - Si ya existe la informacion del clima de la respectiva ciudad en el cache
     */
    void guardarClimaCache(String ciudad, Weather clima) throws OpenWeatherException;

    /**
     * Limpia el cache eliminando la informacion del clima de la ciudad la cual ya fue consultada hace 5 minutos
     * @param ciudad El nombre de la ciudad a consultar
     * @throws OpenWeatherException - Si no existe informacion del clima de la ciudad en el cache
     */
    void limpiarCacheCiudad(String ciudad) throws OpenWeatherException;
}
