package br.com.vivo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vivo.dto.DeviceDto;
import br.com.vivo.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Validated
@Api(value = "service")
@RequestMapping("/service")
public class DeviceController {
	
	private static final Logger log = LoggerFactory.getLogger(DeviceController.class);
	
	@Autowired
	private DeviceService deviceService;
	
	

	@ApiOperation(value = "CONSULTAR INFORMAÇÕES DE STATUS")
	@RequestMapping(value = "/getStatusInformation/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<DeviceDto> getDeviceInformation(@PathVariable Long id) {
			
			log.info("CONSULTANDO INFORMAÇÕES DE STATUS !");	
			DeviceDto deviceDto = this.deviceService.getDeviceInformation(id);
			if (deviceDto == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(deviceDto);
			
	}
	
	@ApiOperation(value = "EXECUTAR COMANDO")
	@RequestMapping(value = "/updateDeviceInformation/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Void>  updateDeviceInformation(@RequestBody DeviceDto deviceDto) {		
		
			this.deviceService.updateDeviceInformation(deviceDto);
			
			return new ResponseEntity<>(HttpStatus.OK);			
		
	}

	
	
}
