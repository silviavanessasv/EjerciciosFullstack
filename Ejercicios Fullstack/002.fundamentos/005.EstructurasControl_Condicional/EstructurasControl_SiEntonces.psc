Algoritmo EstructurasControl_SiEntonces
	price <- 50
	// Si entonces, If Else
	// Escribir "El producto es barato" si vale menos de 30 euros
	// Si vale 30 o más entonces "El producto es caro"
	Si price < 30 Entonces
		Escribir "Barato"
	SiNo
		Escribir "Caro"
	Fin Si
	
	
	// si es mayor de edad o tiene tutor:
	// Escribir puede pasar o no puede pasar 
	Escribir "introduce tu edad: "
	Leer age
	Escribir  "Tiene tutor (Verdadero o Falso)"
	Leer tutor
	Si age >= 18 O tutor Entonces
		Escribir "Puede pasar"
	SiNo
		Escribir "No puede pasar"
	FinSi
	
	
	
FinAlgoritmo
