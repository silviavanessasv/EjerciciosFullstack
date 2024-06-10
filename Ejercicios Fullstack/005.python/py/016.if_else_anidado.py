
# Una estructura if dentro de otra estructura if

nivel = 4
puntos = 75

if nivel < 1:
    print('Nivel incorrecto')
    
elif nivel == 1:
    
    if puntos < 20:
        print('Mal comienzo')
    else:
        print('¡Buen comienzo!')    
        
elif nivel == 2:
    
    if puntos < 30 :
        print('Podría hacerse mejor para un nivel 2')
    else:
        print('Gran avance de nivel')
        
elif nivel == 3:

    if puntos < 40 :
        print('Mejorable')
    else:
        print('Está perfecto')
        
else:
    print('Máquina')