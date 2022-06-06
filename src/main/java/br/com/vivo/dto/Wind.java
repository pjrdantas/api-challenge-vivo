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
@JsonPropertyOrder({ "speed", "deg", "gust" })
public class Wind {

	@JsonProperty("speed")
	public double speed;
	
	@JsonProperty("deg")
	public int deg;
	
	@JsonProperty("gust")
	public double gust;

	public Wind() {
		
	}
}