package com.certidevs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
Para evitar la excepción:
org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.certidevs.UserRegistration' available

Se debe registrar esta clase en Spring

 @Component
 @Service
 @Repository
 @RestController
 @Controller
 @Configuration
 */
@Component
public class UserRegistration {

    private NotificationService notificador;

    public UserRegistration(NotificationService notificador) {
        this.notificador = notificador;
    }

    public void holaMundo() {
        notificador.holaMundo();
    }
}
