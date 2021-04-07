package edu.eci.arsw.openweather.cache.impl;

import edu.eci.arsw.openweather.cache.OpenWeatherCache;
import edu.eci.arsw.openweather.model.*;
import edu.eci.arsw.openweather.services.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ---------------------------------------------------------------------------------------------------------------------------
 * ---------------------------------------------------------------------------------------------------------------------------
 * 													CLASE: OpenWeatherCacheImpl
 * ---------------------------------------------------------------------------------------------------------------------------
 *
 * ---------------------------------------------------------------------------------------------------------------------------
 * @author Santiago Buitrago
 * @version 1.0
 * ---------------------------------------------------------------------------------------------------------------------------
 */

@Service
public class OpenWeatherCacheImpl implements OpenWeatherCache {

    private static final long MINUTES_IN_CACHE = 5;
    private final ConcurrentHashMap<String, Weather> cache = new ConcurrentHashMap<>();

    /**
     * Consulta la infomacion del clima de un lugar
     * @param ciudad El nombre de la ciudad a consultar
     * @return Información del clima en dicha ciudad que se encuentra guardad en el cache
     * @throws OpenWeatherException - Si no existe la informacion del clima en el cache de la ciudad consultada
     */
    @Override
    public Weather getClimaCiudadCache(String ciudad) throws OpenWeatherException {
        Weather clima = cache.get(ciudad);
        if (ciudad == null) {
            throw new OpenWeatherException("No existe informacion del clima de la ciudad Solicitada");
        }
        return clima;
    }

    /**
     * Verifica si en el cache se tiene el clima de la ciudad que se esta consultando
     * @param ciudad El nombre de la ciudad a consultar
     * @return Boleeano que indica si existe o no el clima de dicha ciudad
     * @throws OpenWeatherException - Si hubo un error al verificar la existencia de la informacion de clima de la ciudad en el cache
     */
    @Override
    public boolean verificarClimaCiudadCache(String ciudad) throws OpenWeatherException {
        Weather climaCiudad = cache.get(ciudad);
        boolean estaEnCache = true;
        if (climaCiudad == null) {
            estaEnCache = false;
        } else if (LocalDateTime.now().isAfter(climaCiudad.getTime().plusMinutes(MINUTES_IN_CACHE))) {
            limpiarCacheCiudad(ciudad);
            estaEnCache = false;
        }
        return estaEnCache;
    }

    /**
     * Guarda en el cache la informacion del clima de la ciudad que fue consultada
     * @param ciudad El nombre de la ciudad a consultar
     * @param clima Clima de la ciudad la cual se consulto
     * @throws OpenWeatherException - Si ya existe la informacion del clima de la respectiva ciudad en el cache
     */
    @Override
    public void guardarClimaCache(String ciudad, Weather clima) throws OpenWeatherException {
        if (verificarClimaCiudadCache(ciudad)==true) {
            throw new OpenWeatherException("Ya existe el clima de"+ciudad+"en cache");
        }
        else{
            cache.put(ciudad, clima);
        }
    }

    /**
     * Limpia el cache eliminando la informacion del clima de la ciudad la cual ya fue consultada hace 5 minutos
     * @param ciudad El nombre de la ciudad a consultar
     * @throws OpenWeatherException - Si no existe informacion del clima de la ciudad en el cache
     */
    @Override
    public void limpiarCacheCiudad(String ciudad) throws OpenWeatherException {
        cache.remove(ciudad);
    }
}
