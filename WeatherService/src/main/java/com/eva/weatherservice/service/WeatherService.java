package com.eva.weatherservice.service;

import com.eva.weatherservice.entity.WeatherData;

public interface WeatherService {
    WeatherData getCurrentWeatherByCity(String city);

    WeatherData getCurrentWeatherById(Integer id);
}
