Algoritmo EstructuraControl_Repetir_Menu
	
	// Crear el menú de la app productos
	// utilizando Repetir en lugar de Mientras 
	// No hace falta que tenga el switch/segun dentro
	Repetir
		Escribir "Elige una opcion: "
		Escribir "1 - Imprimir productos"
		Escribir "2 - Imprimir un producto"
		Escribir "3 - Crear un nuevo producto"
		Escribir "4 - Actualizar un producto existente"
		Escribir "5 - Borrar un producto producto"
		Escribir "6 - Salir"
		Leer option
		Escribir "Has elegido la opcion: ", option
	Hasta Que option = 6
	// Verdadero rompe el bucle
	// Falso continua en el bucle
	
FinAlgoritmo
