
vehiculos = ['Mercedes', 'Lambo', 'Tractor John Deere', 'Bici Orbea', 'Patinete'] # 5

while True:
    
    try:
        indice = int(input(f'Introduzca qué vehículo desea hoy (0 a {len(vehiculos) - 1}): '))
        vehiculo = vehiculos[indice]
        print(f'Excelente decisión, ha elegido el vehículo {indice}: {vehiculo}')
        break

    
    except Exception: # Captura cualquier error que se produzca
        print("Se ha producido un error. Inténtalo de nuevo")

        
