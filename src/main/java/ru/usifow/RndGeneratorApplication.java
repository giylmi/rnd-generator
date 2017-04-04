package ru.usifow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.usifow.repository.InternetSourceBitsRepository;
import ru.usifow.repository.MultipleSourceXorBitsRepository;
import ru.usifow.source.HotBitsSource;

@SpringBootApplication
@Configuration
public class RndGeneratorApplication {

    @Bean("hotbitsRepository")
    public InternetSourceBitsRepository hotbitsRepository(){
        return new InternetSourceBitsRepository("hotbits", new HotBitsSource());
    }

    @Bean("multipleSourceXorBitsRepository")
    public MultipleSourceXorBitsRepository multipleSourceXorBitsRepository() {
        return new MultipleSourceXorBitsRepository(new HotBitsSource());
    }

	public static void main(String[] args) {
		SpringApplication.run(RndGeneratorApplication.class, args);
	}
}
