package edu.eci.arsw.openweather.connection.impl;

import edu.eci.arsw.openweather.connection.HttpConnection;
import edu.eci.arsw.openweather.model.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * ---------------------------------------------------------------------------------------------------------------------------
 * ---------------------------------------------------------------------------------------------------------------------------
 * 													CLASE: OpenWeatherConnectionServiceImpl
 * ---------------------------------------------------------------------------------------------------------------------------
 *
 * ---------------------------------------------------------------------------------------------------------------------------
 * @author Santiago Buitrago
 * @version 1.0
 * ---------------------------------------------------------------------------------------------------------------------------
 */

@Service
public class OpenWeatherConnectionServiceImpl implements HttpConnection {

    private final String url;
    private final String appiKey;

    public OpenWeatherConnectionServiceImpl(){
        url = "http://api.openweathermap.org/data/2.5/weather?q=";
        appiKey = "2d12224e7296ec060040b6d87b709c44";
    }

    @Override
    public Weather getClimaCiudad(String ciudad) throws OpenWeatherConnectionException {
        HttpResponse<JsonNode> response;
        try{
            response = Unirest.get(url+getUrl(ciudad)+"&appid="+appiKey).asJson();
        }catch (UnirestException e) {
            throw new OpenWeatherConnectionException("Error en la conexion con OpenWeather", e);
        }
        if (response == null) throw new OpenWeatherConnectionException("Error en la conexion con OpenWeather");
        JSONObject obj = response.getBody().getObject();
        Weather clima;
        try {
            clima=getClimaCiudad(obj);
        } catch (JSONException e) {
            throw new OpenWeatherConnectionException("No se encuentra informacion del clima de la ciudad solicitada", e);
        }
        return clima;
    }
}
