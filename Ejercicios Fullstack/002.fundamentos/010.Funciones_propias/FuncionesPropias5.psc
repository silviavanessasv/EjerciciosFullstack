Funcion capitulo1
	Escribir "En un lugar de la mancha...."
Fin Funcion

Funcion capitulo2
	Escribir "Don Quijote sale hacia el Toboso...."
Fin Funcion

Funcion capitulo3
	Escribir "Don Quijote apaleado...."
Fin Funcion

Algoritmo FuncionesPropias5
	
	Escribir "Bienvenido a la App de libros. Introduce un capitulo"
	
	Repetir 
		Escribir "Introduce un numero capitulo" 
		Leer numeroCapitulo
		Segun numeroCapitulo Hacer
			1:
				capitulo1()
			2:
				capitulo2()
			3:
				capitulo3()
			De Otro Modo:
				Escribir "No hay resultados."
		Fin Segun
		Escribir "Introduce si desea seguir leyendo Verdadero o Falso"
		Leer deseaSeguirLeyendo
	Hasta Que NO deseaSeguirLeyendo
		

	
FinAlgoritmo
