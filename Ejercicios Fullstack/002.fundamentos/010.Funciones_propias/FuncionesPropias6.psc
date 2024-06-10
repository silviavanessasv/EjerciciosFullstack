Funcion capitulo1
	Escribir "En un lugar de la mancha...."
Fin Funcion

Funcion capitulo2
	Escribir "Don Quijote sale hacia el Toboso...."
Fin Funcion

Funcion capitulo3
	Escribir "Don Quijote apaleado...."
Fin Funcion

Algoritmo FuncionesPropias6
	
	deseaLeerCapitulo <- Verdadero
	Mientras deseaLeerCapitulo Hacer
		Escribir "Introduce el num capitulo que desea leer"
		Leer numCapitulo
		Segun numCapitulo Hacer
			1:
				capitulo1()
			2:
				capitulo2()
			3:
				capitulo3()
			De Otro Modo:
				Escribir "no hay resultados"
		Fin Segun
		Escribir "Introduce si desea leer un capitulo Verdadero o Falso"
		Leer deseaLeerCapitulo
	Fin Mientras
FinAlgoritmo
