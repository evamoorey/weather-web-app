package com.eva.weatherservice.controller;

import com.eva.weatherservice.entity.WeatherData;
import org.springframework.http.ResponseEntity;

public interface WeatherController {
    ResponseEntity<?> getWeatherInCity(String id);
}
