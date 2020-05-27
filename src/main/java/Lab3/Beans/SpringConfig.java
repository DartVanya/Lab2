package Lab3.Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import Lab3.ControlPanel;

@Configuration
@ComponentScan("Lab2.Beans")
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
