Algoritmo OperadoresLogicos
	
	// precio <- 40
	Escribir "Introduce un precio: "
	Leer precio
	// Conjunción: Y
	// obligatoriamente los dos deben ser verdaderos para obtener verdadero
	// Verdadero Y Verdadero = Verdadero
	// Falso Y Verdadero = Falso
	// Verdadero Y Falso = Falso
	// Falso y Falso = Falso
	esPrecioMedio <- precio >= 30 Y precio <= 70 // Verdadero o Falso
	Escribir esPrecioMedio
	
	esMayor30 <- precio >= 30
	esMenor70 <- precio <= 70
	esPrecioMedio <- esMayor30 Y esMenor70
	Escribir esPrecioMedio
	
FinAlgoritmo
