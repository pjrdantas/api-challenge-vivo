package br.com.vivo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vivo.dto.DeviceDto;
import br.com.vivo.entity.TbDevice;
import br.com.vivo.repository.DeviceRepository;
import br.com.vivo.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceRepository deviceRepository;
	
	TbDevice tbDevice = new TbDevice();
	
	@Override
	public DeviceDto getDeviceInformation(Long id) {

		return deviceRepository.getDeviceInformation(id);
	}


	

	@Override
	public void updateDeviceInformation(DeviceDto deviceDto) {		
	 	if (deviceDto.getPowerOnOff().equals(true)) {
	 		if ((deviceDto.getDevicePowerOnActive().equals(true)) && (deviceDto.getDevicePowerOffActive().equals(true))) {
	 			if (deviceDto.getSchedulerPowerOn() == deviceDto.getSchedulerPowerOff() ) {
	 				deviceDto.setDevicePowerOnActive(false);
	 				deviceDto.setDevicePowerOffActive(false);
	 			} 
	 		} 
	 	}	 
		this.deviceRepository.updateDeviceInformation(deviceDto);		
	}

	
	
	@Override
	public void initializeDeviceInformation(DeviceDto deviceDto) {				
		this.deviceRepository.initializeDeviceInformation(deviceDto);		
	}

	
	
	@Override
	public void deleteTable() {
		this.deviceRepository.deleteTable();		
	}



	



	
}
