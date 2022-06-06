package br.com.vivo.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.vivo.dto.DeviceDto;
import br.com.vivo.service.DeviceService;
import io.restassured.http.ContentType;

@WebMvcTest
public class DeviceControllerTests {
	
	@Autowired
	private DeviceController  deviceController;
	
	@MockBean
	private DeviceService deviceService;
	
	@BeforeEach
	public void setup() {
		
		standaloneSetup(this.deviceController);
	}
	
	
	@Test
	public void deveRetornarSucesso_getDeviceInformation() {
		
		when(this.deviceService.getDeviceInformation(1L))
		.thenReturn(new DeviceDto(1L, false, 0.0, false, false, "00:00", "00:00", 17.22, "sem mensagem" ));
		
		given()
		.accept(ContentType.JSON)
		.when()
		.get("/service/getStatusInformation/{id}", 1L)
		.then()
		.statusCode(HttpStatus.OK.value());
		
	}
	
	@Test
	public void deveRetornarNaoEncontrado_getDeviceInformation() {
		
		when(this.deviceService.getDeviceInformation(5L))
		.thenReturn(null);
		
		given()
		.accept(ContentType.JSON)
		.when()
		.get("/service/getStatusInformation/{id}", 5L)
		.then()
		.statusCode(HttpStatus.NOT_FOUND.value());
		
	}
	
	@Test
	public void deveRetornarSucesso_updateDeviceInformation() {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         
        DeviceDto deviceDto = new DeviceDto(1L, false, 0.0, false, false, "00:00", "00:00", 17.22, "sem mensagem");
        ResponseEntity<Void> responseEntity = deviceController.updateDeviceInformation(deviceDto);
         
        responseEntity.getStatusCode();
		assertThat(HttpStatus.OK.value());
        responseEntity.getHeaders().getContentType();
        
        responseEntity.getStatusCode();
		assertThat(HttpStatus.CREATED.value());
        responseEntity.getHeaders().getContentType();		
		
	}

}
