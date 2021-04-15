package edu.eci.arsw.openweather.connection;

import edu.eci.arsw.openweather.connection.impl.OpenWeatherConnectionException;
import edu.eci.arsw.openweather.model.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * ---------------------------------------------------------------------------------------------------------------------------
 * ---------------------------------------------------------------------------------------------------------------------------
 * 													CLASE: HttpConnection
 * ---------------------------------------------------------------------------------------------------------------------------
 *
 * ---------------------------------------------------------------------------------------------------------------------------
 * @author Santiago Buitrago
 * @version 1.0
 * ---------------------------------------------------------------------------------------------------------------------------
 */

@Service
public interface HttpConnection {

    double DELTA_FROM_KELVIN_TO_CENTIGRADE = 273.15;

    Weather getClimaCiudad (String ciudad) throws OpenWeatherConnectionException;

    default String getUrl(String cadena) throws OpenWeatherConnectionException {
        String encodedQuery;
        try{
            encodedQuery = URLEncoder.encode(cadena, StandardCharsets.UTF_8.toString());
        }catch (UnsupportedEncodingException ex) {
            throw new OpenWeatherConnectionException("Error al leer" + cadena, ex.getCause());
        }
        return encodedQuery.replace("+", "%20");
    }

    default double getDoubleOfJsonObject(JSONObject jsonObject, String value, double delta) {
        double returnedValue = jsonObject.getDouble(value) - delta;
        return Math.round(returnedValue * 10d) / 10d;
    }

    default String getStringFromJsonArrayElementInJsonObject(int index, String arrayValue, JSONObject jsonObject, String stringValue) {
        JSONObject object = jsonObject.getJSONArray(arrayValue).getJSONObject(index);
        return getStringOfJsonObject(object, stringValue);
    }

    default String getStringOfJsonObject(JSONObject jsonObject, String value) {
        return jsonObject.getString(value);
    }

    default Weather getClimaCiudad(JSONObject obj) throws JSONException {
        JSONObject main = obj.getJSONObject("main");
        JSONObject coordenadas = obj.getJSONObject("coord");
        String ciudad = getStringOfJsonObject(obj, "name");
        String pais = getStringOfJsonObject(obj.getJSONObject("sys"), "country");
        String imagen = getStringFromJsonArrayElementInJsonObject(0, "weather", obj, "icon");
        double temperatura = getDoubleOfJsonObject(main, "temp", DELTA_FROM_KELVIN_TO_CENTIGRADE);
        double sensacionTermica = getDoubleOfJsonObject(main, "feels_like", DELTA_FROM_KELVIN_TO_CENTIGRADE);
        double velocidadViento = getDoubleOfJsonObject(obj.getJSONObject("wind"), "speed", 0);
        double longitud = getDoubleOfJsonObject(coordenadas, "lon", 0);
        double latitud = getDoubleOfJsonObject(coordenadas, "lat", 0);
        int presion = main.getInt("pressure");
        int humedad = main.getInt("humidity");
        Weather clima = new Weather(ciudad, pais, temperatura, sensacionTermica, velocidadViento, presion, humedad);
        clima.setImage(imagen);
        clima.setLatitude(latitud);
        clima.setLongitude(longitud);
        return clima;
    }
}
