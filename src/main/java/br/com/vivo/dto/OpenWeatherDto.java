package br.com.vivo.dto;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Validated
@EqualsAndHashCode
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "coord", "weather", "base", "main", "visibility", "wind", "clouds", "dt", "sys", "timezone", "id",
		"name", "cod" })
public class OpenWeatherDto {

	@JsonProperty("coord")
	public Coord coord;

	@JsonProperty("weather")
	public List<Weather> weather = null;

	@JsonProperty("base")
	public String base;

	@JsonProperty("main")
	public Main main;

	@JsonProperty("visibility")
	public int visibility;

	@JsonProperty("wind")
	public Wind wind;

	@JsonProperty("clouds")
	public Clouds clouds;

	@JsonProperty("dt")
	public int dt;

	@JsonProperty("sys")
	public Sys sys;

	@JsonProperty("timezone")
	public int timezone;

	@JsonProperty("id")
	public int id;

	@JsonProperty("name")
	public String name;

	@JsonProperty("cod")
	public int cod;

	public OpenWeatherDto() {

	}

}