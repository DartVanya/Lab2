package Lab2.Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfig {
    	
	// Создаем бины элементов

	@Bean(name = "Lamp")
	@Scope("prototype")
	public Lamp Lamp() {
		return new Lamp();
	}

	@Bean(name = "Button")
	@Scope("prototype")
	public Button Button() {
		return new Button();
	}
   
}
