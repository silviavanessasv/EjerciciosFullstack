Algoritmo EstructurasControl_Si
	
	peso <- 130
	altura <- 155
	perfil <- ""
	
	
	// bloque 1
	Si altura <= 160 Y peso >= 120 Entonces
		perfil <- "Sobrepreso"
	Fin Si
	
	// bloque 2
	Si altura >= 210 Y peso <= 60 Entonces
		perfil <- "Delgado"
	Fin Si
	
	// perfil muy delgado
	
	alturaMedia <- altura > 160 Y altura < 210
	pesoMedio <- peso > 60 Y peso < 120
	Si alturaMedia Y pesoMedio
		Escribir "Peso intermedio"
	FinSi
	// perfil normal 

	
	Escribir "Tipo de perfil: ", perfil
	
FinAlgoritmo
