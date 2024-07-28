package com.weather.forecast;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.weather.forecast.model.WeatherForecast;
import com.weather.forecast.repository.WeatherForecastRepository;
import com.weather.forecast.service.WeatherForecastService;
import com.weather.forecast.service.util.Period;
import com.weather.forecast.service.util.Properties;
import com.weather.forecast.service.util.WeatherApiResponse;

@SpringBootTest
public class WeatherForecastServiceTest {

	@Mock
	private RestTemplate restTemplate;

	@Mock
	private WeatherForecastRepository repository;

	@InjectMocks
	private WeatherForecastService weatherService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetTodayForecast() {
		WeatherApiResponse response = new WeatherApiResponse();
		Properties properties = new Properties();
		Period period = new Period();
		period.setName("Monday");
		period.setTemperature(80);
		period.setShortForecast("Partly Sunny");
		List<Period> periods = new ArrayList<Period>();
		periods.add(period);
		properties.setPeriods(periods);
		response.setProperties(properties);

		when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(WeatherApiResponse.class))).thenReturn(response);

		List<WeatherForecast> forecastDetails = weatherService.getTodayForecast();

		WeatherForecast forecast = forecastDetails.get(0);

		assertTrue(forecastDetails.size() > 0);
		assertTrue(forecast != null);
	}
}
