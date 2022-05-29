package com.eva.weatherservice.controller;

import com.eva.weatherservice.entity.WeatherData;
import com.eva.weatherservice.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/weather")
public class WeatherControllerImpl implements WeatherController {

    private final WeatherService weatherService;

    public WeatherControllerImpl(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getWeatherInCity(@PathVariable String city) {
        return Optional.ofNullable(weatherService.getCurrentWeatherByCity(city))
                .map(weather -> ResponseEntity.ok().body(weather))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public List<WeatherData> getWeatherInSomeCities(@RequestParam MultiValueMap<String, String> params) {
        List<WeatherData> data = new ArrayList<>();
        Set<String> keys = params.keySet();

        for (String key : keys) {
            List<String> values = params.get(key);
            for (String i : values) {
                if (Objects.equals(key, "id")) {
                    data.add(weatherService.getCurrentWeatherById(Integer.parseInt(i)));
                }
            }
        }

        return data.stream().filter(Objects::nonNull).toList();
    }

}
