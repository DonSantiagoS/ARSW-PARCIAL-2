package edu.eci.arsw.openweather.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * ---------------------------------------------------------------------------------------------------------------------------
 * ---------------------------------------------------------------------------------------------------------------------------
 * 													CLASE: Weather
 * ---------------------------------------------------------------------------------------------------------------------------
 *
 * ---------------------------------------------------------------------------------------------------------------------------
 * @author Santiago Buitrago
 * @version 1.0
 * ---------------------------------------------------------------------------------------------------------------------------
 */

public class Weather {
    private String ciudad;
    private String country;
    private String image;
    private double temperature;
    private double thermalSensation;
    private double windSpeed;
    private double longitude;
    private double latitude;
    private int pressure;
    private int humidity;

    @JsonIgnore
    private LocalDateTime time;

    /**
     * Constructor por defecto de la clase WeatherByCity
     */
    public Weather() {
    }

    /**
     * Constructor extenso de la clase WeatherByCity
     *
     * @param ciudad - Nombre de la ciudad
     * @param country - Pais en el cual se encuentra la ciudad
     * @param temperature - Temperatura de la ciudad
     * @param thermalSensation - Sensacion termica de la ciudad
     * @param windSpeed - Velocidad del viento de la ciudad
     * @param pressure - Presion atmosferica de la ciudad
     * @param humidity - Humedad de la ciudad
     */
    public Weather(String ciudad, String country, double temperature, double thermalSensation, double windSpeed, int pressure, int humidity) {
        this.ciudad = ciudad;
        this.country = country;
        this.temperature = temperature;
        this.thermalSensation = thermalSensation;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getThermalSensation() {
        return thermalSensation;
    }

    public void setThermalSensation(double thermalSensation) {
        this.thermalSensation = thermalSensation;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "WeatherByCity{" +
                "ciudad='" + ciudad + '\'' +
                ", country='" + country + '\'' +
                ", image='" + image + '\'' +
                ", temperature=" + temperature +
                ", thermalSensation=" + thermalSensation +
                ", windSpeed=" + windSpeed +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()){
            return false;
        }
        Weather clima = (Weather) object;
        return Double.compare(clima.temperature, temperature) == 0 &&
                Double.compare(clima.thermalSensation, thermalSensation) == 0 &&
                Double.compare(clima.windSpeed, windSpeed) == 0 &&
                Double.compare(clima.longitude, longitude) == 0 &&
                Double.compare(clima.latitude, latitude) == 0 &&
                pressure == clima.pressure &&
                humidity == clima.humidity &&
                Objects.equals(ciudad, clima.ciudad) &&
                Objects.equals(country, clima.country) &&
                Objects.equals(image, clima.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ciudad, country, image, temperature, thermalSensation, windSpeed, longitude, latitude, pressure, humidity);
    }
}
