package br.com.vivo.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name = "tb_device")
public class TbDevice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "tb_device_local_temperature")
	private Double tbDeviceLocalTemperature;

	@Column(name = "tb_device_message")
	private String tbDeviceMessage;

	@Column(name = "tb_device_power_off_active")
	private Boolean tbDevicePowerOffActive;

	@Column(name = "tb_device_power_on_active")
	private Boolean tbDevicePowerOnActive;

	@Column(name = "tb_device_power_on_off")
	private Boolean tbDevicePowerOnOff;

	@Column(name = "tb_device_scheduler_power_off")
	private String tbDeviceSchedulerPowerOff;

	@Column(name = "tb_device_scheduler_power_on")
	private String tbDeviceSchedulerPowerOn;

	@Column(name = "tb_device_temperature")
	private Double tbDeviceTemperature;

	public TbDevice() {
	}

}