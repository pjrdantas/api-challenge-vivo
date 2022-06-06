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
@JsonPropertyOrder({ "country", "sunrise", "sunset" })
public class Sys {

	@JsonProperty("country")
	public String country;
	
	@JsonProperty("sunrise")
	public int sunrise;
	
	@JsonProperty("sunset")
	public int sunset;

	public Sys() {

	}

}