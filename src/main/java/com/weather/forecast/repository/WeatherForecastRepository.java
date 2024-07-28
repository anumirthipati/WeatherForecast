package com.weather.forecast.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.weather.forecast.model.WeatherForecast;

@Repository
public interface WeatherForecastRepository extends CrudRepository<WeatherForecast, Long>{

	
}
