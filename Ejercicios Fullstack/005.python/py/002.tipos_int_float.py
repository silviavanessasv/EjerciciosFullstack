
# Utilizando directamente los números
edad = 30 # número entero
peso = 80.34 # número con decimales
print(edad + 2)
print(peso - 5)

# utilizando constructor
edad2 = int(40)
peso2 = float(90.55)
print(edad2 + 2)
print(peso2 - 5)

# convertir de texto a número
edad3 = "70"
peso3 = "100.21"
# TypeError: can only concatenate str (not "int") to str
# print(edad3 + 2)
# print(peso3 - 5)

edad3_num = int(edad3) # convierte el texto "70" a número 70
print(edad3_num + 2)

peso3_num = float(peso3) # convierte el texto "100.21" a número 100.21
print(peso3_num - 5)


# convertir de número a texto
codigo_postal = str(28003) # convierte de int a str
print(codigo_postal)