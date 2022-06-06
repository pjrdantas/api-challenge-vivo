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
@JsonPropertyOrder({ "id", "main", "description", "icon" })
public class Weather {

	@JsonProperty("id")
	public int id;
	
	@JsonProperty("main")
	public String main;
	
	@JsonProperty("description")
	public String description;
	
	@JsonProperty("icon")
	public String icon;

	public Weather() {
		
	}
}