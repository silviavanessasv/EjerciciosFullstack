package com.certidevs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring001HolamundoApplication {


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Spring001HolamundoApplication.class, args);
		// CON SPRING:
		// Pedirle a Spring un objeto de la clase UserRegistration
		 UserRegistration registroUsuario = context.getBean(UserRegistration.class);
		 registroUsuario.holaMundo();


		// SIN SPRING

		NotificationService service = new NotificationService();
		UserRegistration ur = new UserRegistration(service);
		ur.holaMundo();

		// NotificationService
	}

}
