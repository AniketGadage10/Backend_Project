package com.app;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IacsdAddmissionApplication {

	public static void main(String[] args) {
		SpringApplication.run(IacsdAddmissionApplication.class, args);
	}
	@Bean
	public ModelMapper modelmapper(){
		ModelMapper mp = new ModelMapper();
		mp.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mp;
	}
}
