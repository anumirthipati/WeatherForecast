package com.weather.forecast.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.forecast.model.WeatherForecast;
import com.weather.forecast.repository.WeatherForecastRepository;
import com.weather.forecast.service.util.Period;
import com.weather.forecast.service.util.WeatherApiResponse;

@Service
public class WeatherForecastService {

	@Autowired
	private WeatherForecastRepository repository;

	public List<WeatherForecast> getTodayForecast() {
		String url = "https://api.weather.gov/gridpoints/MLB/33,70/forecast";
		RestTemplate restTemplate = new RestTemplate();
		WeatherApiResponse response = restTemplate.getForObject(url, WeatherApiResponse.class);

		if (response != null && !response.getProperties().getPeriods().isEmpty()) {
			List<WeatherForecast> forecastDetails = new ArrayList<WeatherForecast>();
			List<Period> periods = response.getProperties().getPeriods();
			for (Period period : periods) {
				WeatherForecast forecast = new WeatherForecast();
				forecast.setDayName(period.getName());
				forecast.setTempHighCelsius(fahrenheitToCelsius(period.getTemperature()));
				forecast.setForecastBlurp(period.getShortForecast());

				forecastDetails.add(forecast);
				repository.save(forecast);
			}

			return forecastDetails;
		}

		throw new RuntimeException("No forecast data available");
	}

	private double fahrenheitToCelsius(double fahrenheit) {
		return (fahrenheit - 32) * 5.0 / 9.0;
	}

}
