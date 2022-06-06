package br.com.vivo.repository;

import br.com.vivo.dto.DeviceDto;



public interface DeviceRepository {
	
	DeviceDto getDeviceInformation(Long id);
	
	void updateDeviceInformation(DeviceDto deviceDto);
	
	void initializeDeviceInformation(DeviceDto deviceDto);
	
	void deleteTable();
	 
	
 
	

}
