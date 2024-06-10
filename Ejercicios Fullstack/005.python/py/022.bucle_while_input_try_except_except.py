
vehiculos = ['Mercedes', 'Lambo', 'Tractor John Deere', 'Bici Orbea', 'Patinete'] # 5

while True:
    
    try:
        indice = int(input(f'Introduzca qué vehículo desea hoy (0 a {len(vehiculos) - 1}): '))
        vehiculo = vehiculos[indice]
        print(f'Excelente decisión, ha elegido el vehículo {indice}: {vehiculo}')
        break

    # IndexError: list index out of range
    # ValueError: invalid literal for int() with base 10: 'hola'
    except IndexError as e:
        print(f"Se ha producido un error de acceso por índice incorrecto: {e}")
    except ValueError as e:
        print(f"Se ha producido un error de formato de dato incorrecto: {e}")
        

# Exception