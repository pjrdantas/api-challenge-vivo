package br.com.vivo.schedulingtasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.vivo.dto.DeviceDto;
import br.com.vivo.dto.OpenWeatherDto;
import br.com.vivo.service.DeviceService;
import br.com.vivo.service.SearchTemperatureService;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	@Autowired
	private SearchTemperatureService searchTemperatureService;

	@Autowired
	private DeviceService deviceService;

	OpenWeatherDto openWeatherDto = new OpenWeatherDto();
	DeviceDto deviceDto = new DeviceDto();
	private int cont = 0;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
	String date;

	// * @Scheduled(initialDelay=0, fixedRate=1*60*60*1000) p/ 1 hora =
	// HH*MM*SS*1000

	@Scheduled(initialDelay = 0, fixedRate = 01 * 01 * 10 * 1000)
	public void reportCurrentTime() throws Exception, Throwable {

		openWeatherDto = this.searchTemperatureService.searchTemperature();
		deviceDto.setLocalTemperature(openWeatherDto.getMain().getTemp());
		LocalDateTime timeNow = LocalDateTime.now();
		date = timeNow.format(formatter);
		preparDispositivo();
		verificaTemperaturaExterna();
		verificaAgendamento();

	}

	public void preparDispositivo() {
		if (cont == 0) {
			this.deviceService.deleteTable();
			deviceDto.setId(1L);
			deviceDto.setPowerOnOff(false);
			deviceDto.setSchedulerPowerOn("00:00");
			deviceDto.setSchedulerPowerOff("00:00");
			deviceDto.setDevicePowerOnActive(false);
			deviceDto.setDevicePowerOffActive(false);
			deviceDto.setTemperature(0.0);
			deviceDto.setDeviceMessage("");
			this.deviceService.initializeDeviceInformation(deviceDto);
			log.info("----> Temperatura em LOCAL agora é : {}°C.", openWeatherDto.getMain().getTemp());
			cont = 1;
		}
	}

	public void verificaTemperaturaExterna() {

		if (deviceDto.getLocalTemperature() < 15.0) {
			if (deviceDto.getPowerOnOff().equals(false)) {
				deviceDto.setId(1L);
				deviceDto.setPowerOnOff(false);
				deviceDto.setSchedulerPowerOn("00:00");
				deviceDto.setSchedulerPowerOff("00:00");
				deviceDto.setDevicePowerOnActive(false);
				deviceDto.setDevicePowerOffActive(false);
				deviceDto.setTemperature(00.0);
				deviceDto.setDeviceMessage("");
				this.deviceService.updateDeviceInformation(deviceDto);
			}
		}

			if (deviceDto.getLocalTemperature() > 22.00) {
				if (deviceDto.getPowerOnOff().equals(true)) {
					log.info("O AR CONDICIONADO JÁ ESTA LIGADO.");					
				} else {
					deviceDto.setId(1L);
					deviceDto.setPowerOnOff(true);
					deviceDto.setSchedulerPowerOn("00:00");
					deviceDto.setSchedulerPowerOff("00:00");
					deviceDto.setDevicePowerOnActive(false);
					deviceDto.setDevicePowerOffActive(false);
					deviceDto.setTemperature(15.0);
					deviceDto.setDeviceMessage("O AR CONDICIONADO FOI LIGADO AS :"+ date +"min  - TEMPERATURA LOCAL :"
							+ deviceDto.getLocalTemperature()+"°C");
					this.deviceService.updateDeviceInformation(deviceDto);
					log.info("O AR CONDICIONADO FOI LIGADO - TEMPERATURA LOCAL :{}°C.",
							deviceDto.getLocalTemperature());
				}
			}
		
		log.info("Temperatura LOCAL agora é : {}°C.", deviceDto.getLocalTemperature());
	}
	
	
	
	
	

	public void verificaAgendamento() {

		log.info("----> Horario local: {}min ", date);

		if (deviceDto.getDevicePowerOnActive() == true) {
			log.info("O ARCONDICIONADO IRÁ LIGAR AS   : {} min.", deviceDto.getSchedulerPowerOn());
			if (deviceDto.getSchedulerPowerOn().contains(date)) {
				log.info("LIGANDO AR CONDICIONADO.");
				deviceDto.setPowerOnOff(true);
				deviceDto.setDevicePowerOnActive(false);
				deviceDto.setSchedulerPowerOn("00:00");
				deviceDto.setTemperature(18.0);
				deviceDto.setDeviceMessage("O AR CONDICIONADO FOI LIGADO PELO AGENDAMENTO AS :"+ deviceDto.getLocalTemperature()+"min.");
				this.deviceService.updateDeviceInformation(deviceDto);
			}
		} else {
			log.info("O AGENDAMENTO PARA LIGAR NÃO FOI PROGRAMADO PELO USUARIO. ");
		}

		if (deviceDto.getDevicePowerOffActive() == true) {
			log.info("O ARCONDICIONADO IRÁ DESLIGAR AS: {} min.", deviceDto.getSchedulerPowerOff());
			if (deviceDto.getSchedulerPowerOff().contains(date)) {
				log.info("DESLIGANDO AR CONDICIONADO.");
				deviceDto.setPowerOnOff(false);
				deviceDto.setDevicePowerOffActive(false);
				deviceDto.setSchedulerPowerOff("00:00");
				deviceDto.setTemperature(0.0);
				deviceDto.setDeviceMessage("");
				this.deviceService.updateDeviceInformation(deviceDto);
			}
		} else {
			log.info("O AGENDAMENTO PARA DESLIGAR NÃO FOI PROGRAMADO PELO USUARIO. ");
		}
	}

}
