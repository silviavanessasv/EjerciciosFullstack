Algoritmo EstructuraControlWhile
	
	// Menu de opciones
	// Leer opción 
	
	// CRUD: Create Retrieve Update Delete 
	option <- 0
	Mientras option <> 4 Hacer
		// Imprimir un menú de opciones y pedir al usuario que
		// introduzca una 
		Escribir "Elige una opción: "
		Escribir "1 - Imprimir productos"
		Escribir "2 - Imprimir un producto"
		Escribir "3 - Crear un nuevo producto"
		Escribir "4 - Salir"
		Leer option
		Escribir "Has elegido la opcion: ", option
	Fin Mientras
	Escribir "Fin del programa"

	
FinAlgoritmo
