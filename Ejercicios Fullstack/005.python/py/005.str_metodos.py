

texto = "Hola curso Java"

# len() calcular la longitud de un texto y de una estructura de datos
print(len(texto))

# upper() convierte a mayúsculas
print(texto.upper())

# lower() convierte a minúsculas
print(texto.lower())

# capitalize() convierte solo la primera letra de todo el string a mayúscula
print(texto.capitalize())

# split() divide el texto en función de un separador, devuelve una lista

palabras = texto.split() # si no ponemos nada dentro de split() entonces separa por espacios
print(palabras) # ['Hola', 'curso', 'Java']
print(palabras[0]) # Hola
print(palabras[1]) # curso
print(palabras[2]) # Java
# print(palabras[3]) # IndexError: list index out of range

texto_capitalized = palabras[0].capitalize() + " " + palabras[1].capitalize() + " " + palabras[2].capitalize()
print(texto_capitalized)
print(palabras[0].capitalize(), palabras[1].capitalize(), palabras[2].capitalize())


# format {} {} con dos huecos
mensaje = "Hola curso {} la nota mínima es de {} puntos."
print(mensaje.format("Java", 5))
print(mensaje.format("Python", 5))
print(mensaje.format("Spring", 7))

# format {} {} {} con tres huecos
plantilla = "{} {} {}" # String con 3 huecos separados por espacios
texto_capitalized = plantilla.format(
    palabras[0].capitalize(), 
    palabras[1].capitalize(), 
    palabras[2].capitalize()
    )
print(texto_capitalized)

# f strings: Cadenas con formato, permiten incrustar expresiones dentro de cadenas literales
producto = "Laptop ASUS"
precio = 499.99
print(f"El producto seleccionado es {producto} con precio {precio} euros.")

# replace(x, y) reemplaza las ocurrencias del primer valor por el segundo valor
print(texto.replace("Java", "Python"))
print("alan sastre prueba".replace(" ", "")) # Reemplaza todos los espacios por nada, es decir, los elimina