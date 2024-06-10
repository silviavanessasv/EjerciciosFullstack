
# Borrar elementos de una lista existente

phones = ['666555444', '654654654', '698874123' , '721223554']

# remove() borra un elemento que pasemos por parámetro
phones.remove('654654654')
print(phones)

# pop() elimina y devuelve el último elemento de la lista o por su índice
# SI NO SE ESPECIFICA UN ÍNDICE EN pop() POR DEFECTO TOMA EL ÚLTIMO
pendientes_calificacion = ['Aitor', 'Ángel Sanz', 'Ángel Sigueros', 'Carlos']
alumno_a_calificar = pendientes_calificacion.pop()
print(f"alumno_a_calificar {alumno_a_calificar}")

alumno_a_calificar = pendientes_calificacion.pop()
print(f"alumno_a_calificar {alumno_a_calificar}")

fila_pescaderia = ['persona1', 'persona2', 'persona3', 'persona4', 'Alan']
persona_a_atender = fila_pescaderia.pop(0)
print(f"persona_a_atender {persona_a_atender}") # persona1

persona_a_atender = fila_pescaderia.pop(0)
print(f"persona_a_atender {persona_a_atender}") # persona2

# del permite borrar un elemento concreto sin devolverlo, por posición
# Ejemplo: productos de un ecommerce, en el checkout antes de finalizar compra eliminamos uno
precios = [5.99, 12.32, 10.00, 48.57]
del precios[2]
# precios[2] = None
print(precios)

