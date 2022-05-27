package com.eva.weatherservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {
    private Weather[] weather;
    private Main main;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Weather getWeather() {
        return weather[0];
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }
}
