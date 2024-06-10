Algoritmo EstructurasControl_BucleForSumatorio
	
	// pedir al usuario cuantos examenes ha hecho (numero)
	Escribir "Introduce number of exams"
	Leer numberOfExams // es un numero
	notaSumatorio <- 0
	Para i <- 1 Hasta numberOfExams Con Paso 1 Hacer
		
		Escribir "Introduce la nota numero ", i 
		Leer notaExamen
		Escribir "Nota introducida", notaExamen
		
		// sumatorio de notas
		notaSumatorio <- notaSumatorio + notaExamen
	Fin Para
	Escribir "Suma total de notas ", notaSumatorio
	notaMedia <- notaSumatorio / numberOfExams
	Escribir "Nota media", notaMedia
	Escribir "Nota media redondeada ", redon(notaMedia)
	Escribir "Nota media truncada ", trunc(notaMedia)
	

	
FinAlgoritmo
