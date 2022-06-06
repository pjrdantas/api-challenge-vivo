package br.com.vivo.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "temp", "feels_like", "temp_min", "temp_max", "pressure", "humidity", "sea_level", "grnd_level" })
public class Main {

	@JsonProperty("temp")
	public Double temp;
	
	@JsonProperty("feels_like")
	public double feelsLike;
	
	@JsonProperty("temp_min")
	public double tempMin;
	
	@JsonProperty("temp_max")
	public double tempMax;
	
	@JsonProperty("pressure")
	public int pressure;
	
	@JsonProperty("humidity")
	public int humidity;
	
	@JsonProperty("sea_level")
	public int seaLevel;
	
	@JsonProperty("grnd_level")
	public int grndLevel;

	public Main() {
		
	}
}