
numero = -10
numero_absoluto = None

# if else normal

if numero <= 0:
    numero_absoluto = -numero
else: 
    numero_absoluto = numero
    
print(numero_absoluto)


# Operador ternario: if else en una línea
numero_absoluto = -numero if numero <= 0 else numero

# RECOMENDACIÓN: usarlo solo en casos sencillos para evitar que la 
# sentencia se vuelva muy compleja

## Otras opciones: Opción 1 - nativa abs(), Opción 2 - buscar en numpy