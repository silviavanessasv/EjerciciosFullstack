
# Operadores de identidad

email = None

email_user = input('Introduce tu email: ')

if email_user.endswith('gmail.com'):
    email = email_user

# is 
if email is None: # habitual para comprobar si existe un valor
    print('No se ha podido completar el registro.')

# is not
if email is not None: # comprueba que el email no sea nulo o vacío
    print('El email es correcto, registro completado.')
    
# if else
if email is None:
    print('No se ha podido completar el registro.')
else: 
    print('El email es correcto, registro completado.')
    
    
if email is not None: # comprueba que el email no sea nulo o vacío
    print('El email es correcto, registro completado.')
else: 
    print('Email incorrecto.')

    
    
    
print(1 == True) # True, compara valores
print(0 == True) # False
print(1 is True) # False, compara la identidad
