package edu.eci.arsw.openweather.connection.impl;

/**
 * ---------------------------------------------------------------------------------------------------------------------------
 * ---------------------------------------------------------------------------------------------------------------------------
 * 													CLASE: OpenWeatherConnectionException
 * ---------------------------------------------------------------------------------------------------------------------------
 *
 * ---------------------------------------------------------------------------------------------------------------------------
 * @author Santiago Buitrago
 * @version 1.0
 * ---------------------------------------------------------------------------------------------------------------------------
 */


public class OpenWeatherConnectionException extends Exception{
    /**
     * Constructor de la clase OpenWeatherConnectionException
     * @param msg Mensaje de la Excepción
     */
    public OpenWeatherConnectionException(String msg) {
        super(msg);
    }

    /**
     * Constructor de la clase OpenWeatherConnectionException
     * @param msg   Mensaje de la Excepción
     * @param cause Causa de la Excepción
     */
    public OpenWeatherConnectionException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
