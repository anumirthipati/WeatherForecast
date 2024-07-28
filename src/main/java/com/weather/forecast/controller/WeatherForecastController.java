package com.weather.forecast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.forecast.model.WeatherForecast;
import com.weather.forecast.service.WeatherForecastService;

@RestController
public class WeatherForecastController {
	

    @Autowired
    private WeatherForecastService weatherService;

    @GetMapping("/today")
    public List<WeatherForecast> getTodayWeather() {
        return weatherService.getTodayForecast();
    }
}
