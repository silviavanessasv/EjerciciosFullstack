
# CREAR UNA LISTA

students = ['Aitor', 'Ángel Sanz', 'Ángel Sigueros', 'Carlos']

# ACCEDER A ELEMENTOS DE UNA LISTA DESDE EL PRINCIPIO
print(students[0])
print(students[1])
print(students[2])
print(students[3])
# print(students[4]) # IndexError: list index out of range

# ACCEDER A ELEMENTOS DE UNA LISTA DESDE EL FINAL
print(students[-1]) # el último de la lista
print(students[-2])
print(students[-3])
print(students[-4])
# print(students[-5]) IndexError: list index out of range

precios = [5.99, 12.32, 10.00, 48.57]

print(precios[0])
print(precios[1])
print(precios[2])
print(precios[3])

# Modificar un elemento de la lista:
# precios[2] = precios[2] * 0.80
precios[2] *= 0.80

print(precios[2])

# Calcular longitud listas con el método len()

print(len(students))
print(len(precios))

# En Java
# arrays .length
# ArrayList .size()