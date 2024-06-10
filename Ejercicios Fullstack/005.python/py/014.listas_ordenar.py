
coches = ['Mercedes', 'BMW', 'Skoda', 'Alfa Romeo', 'Maserati']

# sort() ordena de forma ASCENDENTE, de menos a más A - Z
coches.sort()
print(coches)

# sort(reverse=True) ordena de forma DESCENDENTE, de más a menos Z - A
coches.sort(reverse=True)
print(coches)

# Invirtiendo el orden de los elementos en torno al centro
# reverse() equivalente a .sort(reverse=True)
coches2 = ['Mercedes', 'BMW', 'Skoda', 'Alfa Romeo', 'Maserati']
coches2.reverse()
print(coches2) # ['Maserati', 'Alfa Romeo', 'Skoda', 'BMW', 'Mercedes']

# sorted() la diferencia es que este no modifica la original
# devuelve una nueva lista con los elementos ordenados
precios = [1.11, 2.22, 3.33, 7.77, 4.44, 6.66]
precios_asc = sorted(precios)
print(precios)
print(precios_asc)

# sorted(reverse=True)
calificaciones = [1.11, 2.22, 3.33, 7.77, 4.44, 6.66] # 6
calificaciones_desc = sorted(calificaciones, reverse=True)
print(calificaciones_desc)

calificacion_maxima = calificaciones_desc[0] # El primero
calificacion_minima = calificaciones_desc[-1] # El último
# otra opción para obtener el último:
last_index = len(calificaciones_desc) - 1 
calificacion_minima = calificaciones_desc[last_index]
