
# Devuelve el número de vocales
def contar_vocales(texto):
    num_vocales = 0
    for caracter in texto:
        # if caracter == 'a' or caracter == 'e' or caracter == '':
        if caracter in 'aeiouAEIOUáéíóúÁÉÍÓÚ':
            num_vocales += 1
         
    return num_vocales   


    
resultado1 = contar_vocales('Alan')
print(f'resultado1 {resultado1}') # 2

resultado2 = contar_vocales('Hola mundo')
print(f'resultado2 {resultado2}') # 4