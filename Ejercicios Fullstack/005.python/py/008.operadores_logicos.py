
# and (AND) Y
# Restrictivo porque se tienen que cumplir todas
# las condiciones para que sea True

email_correcto = 'admin@gmail.com'
password_correcta = '1234'

email = input('Introduce tu email: ')
password = input('Introduce password: ')

if email == email_correcto and password == password_correcta:
    print('Credenciales correctas')
else: 
    print('Credenciales incorrectas')


# or O
# Flexible porque es True si al menos se cumple
# una condición

es_estudiante = input('¿Es estudiante? si o no: ') == 'si' # True o False
precio = float(input('Introduce el precio de tu compra: '))

if es_estudiante or precio >= 100:
    print(f"Descuento del 20%, precio final: {precio * 0.80}")
else:
    print(f"Precio final: {precio}")


# not: invierte una condición o bool existente
# En java es !
edad = int(input('Introduce tu edad: '))
if not edad >= 18:
    print('No tiene acceso.')
    
# Ejemplo not: todos los campos son obligatorios
# si email o password están vacías entonces se cumple if
email = input('Introduce email: ')
password = input('Introduce contraseña: ')

if not email or not password:
    print('Todos los campos son obligatorios.')
else:
    print('Registro completo.')
    
    
