
# lista de precios
# filtrar precios por rango
"""
CREAR UNA FUNCIÓN QUE RECIBA UNA LISTA DE PRECIOS, UN PRECIO MIN, UN PRECIO MAX
LA FUNCIÓN DEBE COMPROBAR UNO A UNO LOS PRECIOS Y COMPROBAR SI ESTÁN
COMPRENDIDOS ENTRE PRECIO MIN Y PRECIO MAX, SI LO ESTÁN ENTONCES SE GUARDAN
EN UNA LISTA DE RESULTADOS Y FINALMENTE SE DEVUELVE LA LISTA DE RESULTADOS
"""
def filtrar_precios(precios, precio_min, precio_max):
    resultados = [] # lista para almacenar los resultados, precios filtrados
    for precio in precios:
        if precio_min <= precio <= precio_max:
            resultados.append(precio) # agregar este precio a la lista de resultados
            
    return resultados # devuelve la lista de resultados

precios = [20.99, 42.33, 55.50, 90.77, 36.77, 47.89]
# parametros: lista precios, precio minimo, precio maximo
# precios_filtrados es una lista de resultados, de precios filtrados
precios_filtrados = filtrar_precios(precios, 100, 500)
print(precios_filtrados)
print(len(precios_filtrados))