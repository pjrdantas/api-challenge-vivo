package br.com.vivo.service;


import br.com.vivo.dto.DeviceDto;

public interface DeviceService {
	

	DeviceDto getDeviceInformation(Long id);
	
	void initializeDeviceInformation(DeviceDto deviceDto);

	void updateDeviceInformation(DeviceDto deviceDto);

	void deleteTable();

	
	
}
