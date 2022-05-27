package com.eva.weatherservice.component;

import com.eva.weatherservice.entity.WeatherData;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherRequest {
    private final RestTemplate restTemplate;

    public WeatherRequest() {
        restTemplate = new RestTemplate();
    }

    // Get current weather in city.
    public WeatherData getWeatherByCity(String city) {
        try {
            return restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q={city}&appid={API key}"
                    .replace("{city}", city)
                    .replace("{API key}", "8e13dbfdb4d289209b9e3fab3b32c8e1"), WeatherData.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Get current weather by city's id.
    public WeatherData getWeatherById(Integer id) {
        try {
            return restTemplate
                    .getForObject("https://api.openweathermap.org/data/2.5/weather?id={city id}&appid={API key}"
                            .replace("{city id}", id.toString())
                            .replace("{API key}", "8e13dbfdb4d289209b9e3fab3b32c8e1"), WeatherData.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
