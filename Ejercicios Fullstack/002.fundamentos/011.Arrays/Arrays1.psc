Funcion enviarMensaje(email, mensaje)
	Escribir mensaje, " ", email, " Accede en company.com"
FinFuncion
Algoritmo Arrays1
	// variable de texto
	email <- "persona@gmail.com"
	// Estructura de datos: Array dentro puede tener más de 1 variable
	Dimension emails[3]
	emails[1] = 'user1@gmail.com'
	emails[2] = 'user2@gmail.com'
	emails[3] = 'user3@gmail.com'
	
	Para i <- 1 Hasta 3 Con Paso 1 Hacer
		Escribir emails[i]
	Fin Para
	
	Para i <- 1 Hasta 3 Con Paso 1 Hacer
		enviarMensaje(emails[i], "Bienvenido/a a PseInt")
	Fin Para
	
	
FinAlgoritmo
