package edu.eci.arsw.openweather.services;

/**
 * ---------------------------------------------------------------------------------------------------------------------------
 * ---------------------------------------------------------------------------------------------------------------------------
 * 													CLASE: OpenWeatherException
 * ---------------------------------------------------------------------------------------------------------------------------
 *
 * ---------------------------------------------------------------------------------------------------------------------------
 * @author Santiago Buitrago
 * @version 1.0
 * ---------------------------------------------------------------------------------------------------------------------------
 */


public class OpenWeatherException extends Exception {

    /**
     * Constructor de la clase OpenWeatherException
     * @param msg Mensaje de la Excepción
     */
    public OpenWeatherException(String msg) {
        super(msg);
    }

    /**
     * Constructor de la clase OpenWeatherException
     *
     * @param msg   Mensaje de la Excepción
     * @param cause Causa de la Excepción
     */
    public OpenWeatherException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
