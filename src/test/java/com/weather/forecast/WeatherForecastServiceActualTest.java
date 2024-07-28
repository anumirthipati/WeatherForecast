package com.weather.forecast;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.weather.forecast.WeatherForecastApplication;
import com.weather.forecast.model.WeatherForecast;
import com.weather.forecast.service.WeatherForecastService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeatherForecastApplication.class)
public class WeatherForecastServiceActualTest {

	@Autowired
	private WeatherForecastService weatherService;


	@Test
	public void testGetTodayForecast() {

		List<WeatherForecast> forecastDetails = weatherService.getTodayForecast();

		WeatherForecast forecast = forecastDetails.get(0);

		assertTrue(forecastDetails.size() > 0);
		assertTrue(forecast != null);
	}
}
