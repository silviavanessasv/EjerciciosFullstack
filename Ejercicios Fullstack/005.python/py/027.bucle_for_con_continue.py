
vehiculos = ['mercedes rojo', 'bmw gris', 'tractor azul', 'tractor rosa', 'patinete azul']

# Hacer un bucle for que itere imprimiendo cada vehiculo y si es de 
# color azul salta a la siguiente iteración
# usar continue

for vehiculo in vehiculos:
    if 'azul' in vehiculo.lower():
        continue
        
    print(vehiculo) # solo imprime si el vehículo no es azul
# A diferencia de break que rompe el bucle, 
# continue se mantiene dentro pero salta a la siguiente iteración