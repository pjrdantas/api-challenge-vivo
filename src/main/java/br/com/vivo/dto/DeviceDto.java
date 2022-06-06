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
@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
@JsonPropertyOrder({ "id", "powerOnOff", "temperature", "devicePowerOnActive", "devicePowerOffActive",
		"schedulerPowerOn", "schedulerPowerOff", "local_temperature", "deviceMessage" })
public class DeviceDto {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("powerOnOff")
	private Boolean powerOnOff;

	@JsonProperty("temperature")
	private Double temperature;

	@JsonProperty("device_power_on_active")
	private Boolean devicePowerOnActive;

	@JsonProperty("device_power_off_active")
	private Boolean devicePowerOffActive;

	@JsonProperty("schedulerPowerOn")
	private String schedulerPowerOn;

	@JsonProperty("schedulerPowerOff")
	private String schedulerPowerOff;

	@JsonProperty("local_temperature")
	private Double localTemperature;

	@JsonProperty("device_message")
	private String deviceMessage;

	public DeviceDto() {

	}
}
