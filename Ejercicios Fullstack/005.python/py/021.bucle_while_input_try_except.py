

# Leer una edad hasta que el usuario escriba una edad correcta 18 a 100

while True:
    
    # capturar ValueError: invalid literal for int() with base 10: 'hola'
    try:
        edad = int(input('Introduce tu edad (18 - 100): '))
        
        if 18 <= edad <= 100:
            print('Edad correcta.')
            break
    
    except ValueError:
        print('Formato de datos incorrecto')


# Leer un booleano hasta que esté bien escrito