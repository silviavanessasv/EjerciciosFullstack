Algoritmo Funciones_String_SubCadenas
	
	// R <- SubCadena(S, I, J)
	// 0 o 1 empieza en la misma posición
	palabra <- SubCadena("Hola buenas",1,6)
	Escribir palabra // Hola
	
	// En lenguajes normales si se superan los 
	// limites habria una Excepcion
	// Aqui en PSeInt es capaz de cargar bien la cadena
	palabra <- SubCadena("Hola buenas",-3,50)
	Escribir palabra 
	
	// Texto dinámico
	Escribir "escribe una frase: "
	Leer phrase
	phraseLength <- Longitud(phrase)
	subPhrase <- SubCadena(phrase, 5, phraseLength)
	Escribir subPhrase
	
	
	
FinAlgoritmo
