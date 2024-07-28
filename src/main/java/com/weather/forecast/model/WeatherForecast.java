package com.weather.forecast.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class WeatherForecast implements Serializable {
	
	private static final long serialVersionUID = -507989352124889587L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String dayName;
	private double tempHighCelsius;
	private String forecastBlurp;

}
