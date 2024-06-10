

vehiculos = ['Mercedes', 'Lambo', 'Tractor John Deere', 'Bici Orbea', 'Patinete'] # 5

# iterar sobre elementos
for vehiculo in vehiculos:
    print(vehiculo)


# iterar sobre indices utilizando la función range()
for index in range(0, 5, 1):
    print(vehiculos[index])
    
# Si solo se indica un número entones es el número final, 
# por tanto empieza en 0 hasta este número (excluido)
for index in range(5):
    print(vehiculos[index])
    
    
for index in range(len(vehiculos)):
    print(vehiculos[index])
    
coches = ['BMW','Mercedes','Seat','KIA','Honda']
for index in range(len(coches)):
    print(index, coches[index])
