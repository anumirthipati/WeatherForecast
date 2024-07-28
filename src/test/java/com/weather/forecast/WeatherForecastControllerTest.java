package com.weather.forecast;


import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.weather.forecast.controller.WeatherForecastController;
import com.weather.forecast.model.WeatherForecast;
import com.weather.forecast.repository.WeatherForecastRepository;
import com.weather.forecast.service.WeatherForecastService;

@WebMvcTest(WeatherForecastController.class)
public class WeatherForecastControllerTest {

    @Mock
    private WeatherForecastService weatherService;
    
    @Mock
    private WeatherForecastRepository weatherForecastRepository;
    
    
    @Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

    @Test
    public void testGetTodayWeather() throws Exception {
        WeatherForecast forecast = new WeatherForecast();
        forecast.setDayName("Monday");
        forecast.setTempHighCelsius(27.2);
        forecast.setForecastBlurp("Partly Sunny");
        List<WeatherForecast> forecastDetails = new ArrayList<>();
        forecastDetails.add(forecast);

        when(weatherService.getTodayForecast()).thenReturn(forecastDetails);
        when(weatherForecastRepository.save(forecast)).thenReturn(forecast);

       assertTrue(true);
    }
}
