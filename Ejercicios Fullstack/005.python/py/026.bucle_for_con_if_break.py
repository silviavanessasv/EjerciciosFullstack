vehiculos = ['Mercedes', 'Lambo', 'Tractor John Deere', 'Bici Orbea', 'Patinete'] # 5

# Iterar con bucle for y si el vehiculo contiene "tractor" 
# entonces imprimir y salir del bucle


for vehiculo in vehiculos:
    if 'tractor' in vehiculo.lower():
        print(f'Tractor encontrado: {vehiculo}')
        break