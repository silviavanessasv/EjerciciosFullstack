from input_utils import read_int, read_float, read_bool

precios = [29.99, 44.32, 64.48]

print('''
Elige una opción:
1 - Ver todos los precios
2 - Ver un precio por posición: introduce de 1 en adelante, le restamos 1 para que empiece en 0
3 - Crear un nuevo precio
4 - Actualizar un precio existente
5 - Borrar un precio existente
6 - Vaciar la lista de precios
7 - Eliminar los precios superiores a un número introducido por el usuario
8 - Salir
          ''')

def ver_precios(precios):
    print('Ha elegido ver todos los precios')
    print(precios)

def ver_precio(precios):
    print('Ha elegido ver un precio en concreto')
    posicion = read_int('Introduce la posición del precio que desea consultar: ')
    if 1 <= posicion <= len(precios):
        print(precios[posicion - 1]) # - 1 para adaptar al rango de 0 a len(precios)
    else:
        print('posición incorrecta')

def crear_precio(precios):
    print('Ha elegido introducir un nuevo precio: ')
    nuevo_precio = read_float('Introduce nuevo precio: ')
    precios.append(nuevo_precio)

def actualizar_precio(precios):
    print('Ha elegido actualizar un precio existente')
    print(precios)
    posicion = read_int('Introduce la posición del precio que desea modificar: ')
    if 1 <= posicion <= len(precios):
        precio_modificado = read_float('Introduce precio modificado: ')
        precios[posicion - 1] = precio_modificado
    else:
        print('posición incorrecta')

def borrar_precio(precios):
    print('Ha elegido borrar un precio existente')
    posicion = read_int('Introduce la posición del precio que desea borrar: ')
    if 1 <= posicion <= len(precios):
        precio_borrado = precios.pop(posicion - 1) # saca el elemento por posición
        print(f'Precio borrado exitosamente: {precio_borrado}')
    else:
        print('posición incorrecta')
    # Opción 2:
    # del precios[posicion - 1]
    
    # Opción 3:
    # precio_a_borrar = precios[posicion - 1]
    # precios.remove(precio_a_borrar)

def borrar_precios(precios):
    print('Ha decidido eliminar todos los precios')
    confirmacion = read_bool('¿Está seguro/a de borrar? (si/no): ')
    if confirmacion:
        precios.clear()
            # precios = []
        print(f'Lista de precios vaciada {precios}')
    else:
        print('No se eliminarán los precios.')

def borrar_con_umbral(precios):
    max = read_float('Introduce el precio maximo: ')
        # IMPORTANTE: BORRAR MIENTRAS SE ITERA ES PROBLEMÁTICO, GENERA INCONSISTENCIAS, PROBAR A DEPURAR
        # for precio in precios:
        #    if precio > max:
        #        precios.remove(precio)
        
        # Opción 1:
        # elementos_a_borrar = []
        # for precio in precios:
        #    if precio > max:
        #        elementos_a_borrar.append(precio)
        #        
        # for precio in elementos_a_borrar:
        #    precios.remove(precio)
            
        # Opción 2:
    precios = [precio for precio in precios if precio <= max]

while True:
    opcion = read_int('Introduce la opción (1 a 7): ')
    if opcion == 1:
        ver_precios(precios)
    elif opcion == 2:
        ver_precio(precios)
    elif opcion == 3:
        crear_precio(precios)
    elif opcion == 4:
        actualizar_precio(precios)
    elif opcion == 5:
        borrar_precio(precios)
    elif opcion == 6:
        borrar_precios(precios)
    elif opcion == 7:
        borrar_con_umbral(precios)
    elif opcion == 8:
        print('Saliendo de la app, nos vemos.')
        break
    else:
        print('Opción incorrecta. Introduce un valor en el rango de 1 a 7.')
    
            
        