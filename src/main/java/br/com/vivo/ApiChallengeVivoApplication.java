package br.com.vivo;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.function.client.WebClient;

import com.google.common.net.HttpHeaders;




@SpringBootApplication
@EnableScheduling
public class ApiChallengeVivoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ApiChallengeVivoApplication.class);
	
	
	
	@Bean
	public WebClient webClient(WebClient.Builder builder)  {		
		return builder
		.baseUrl("http://api.openweathermap.org/data/2.5/weather")
		.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PROBLEM_JSON_VALUE)
		.build();		
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiChallengeVivoApplication.class, args);
		
		log.info(">>>Serviço Iniciado<<<");	
		
		
	}
}
