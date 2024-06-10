
# Estructuras de control condicional
precio = float(input('Introduce un precio: '))

if precio >= 100: 
    print('El producto es caro')
elif precio >= 50: 
    print('El producto está chévere.')
else: 
    print('El producto está muy barato.')
    
    
# RUTINA DIARIA 24 HORAS

hora = int(input('Introduce la hora del día: '))

# 0 - 8 está durmiendo
# 8 a 15 está en clase de Angular
# 15 a 16 está comiendo
# 16 a 21 está en clase de Java
# 21 a 24 está cenando
# Si es más de 24 entonces imprimir hora incorrecta

# if hora >= 0 and hora < 8:

if 0 <= hora < 8:
    print('Está durmiendo 😴💤')
elif 8 <= hora < 15:
    print('En clases de Frontend 💻')
elif 15 <= hora < 16:
    print('Comiendo manguito maracatón 🥭')
elif 16 <= hora < 21:
    print('Clase de backend con el míster ❤️')
elif 21 <= hora < 24:
    print('Cenando sano en plan fitness 🐟💪')
else:
    print('Introduce una hora correcta')