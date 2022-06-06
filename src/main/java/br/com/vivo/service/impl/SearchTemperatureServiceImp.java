package br.com.vivo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import br.com.vivo.dto.OpenWeatherDto;
import br.com.vivo.service.SearchTemperatureService;
import reactor.core.publisher.Mono;

@Service
public class SearchTemperatureServiceImp implements SearchTemperatureService {
	
	@Autowired
	private WebClient webClient;
	
	public OpenWeatherDto searchTemperature() throws Exception, Throwable {
		
		Mono<OpenWeatherDto> openWeatherMono = this.webClient
		.method(HttpMethod.GET)
		.uri("?q=Ubatuba&lang=pt-br&APPID=2c1eda5c03940945138f12ab74e468a4&units=metric")
		.retrieve()
		.bodyToMono(OpenWeatherDto.class);
		
		OpenWeatherDto openWeatherDto = openWeatherMono.block();		
		return openWeatherDto;
	}
	
}
