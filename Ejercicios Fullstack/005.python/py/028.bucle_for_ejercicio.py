
# Lista de estudiantes con sus respectivas notas
# numero_aprobados
# numero_suspensos
# porcentaje de aprobado


calificaciones = [
    'Alan 5', 
    'Carolina 9', 
    'Antonio 6', 
    'Mike 3', 
    'Patricia 4', 
    'Bob 4',
    'Leyla 8'
]
num_aprobados = 0
num_suspensos = 0

for calificacion in calificaciones:
    # calificacion_partes = calificacion.split()
    # print(calificacion_partes[0]) # Nombre del alumno
    # print(calificacion_partes[1]) # Nota, pero en texto
    # nota = int(calificacion_partes[1])
    # equivalente
    nota = int(calificacion.split()[1])
    
    if nota >= 5:
        num_aprobados += 1
    else:  
        num_suspensos += 1

# imprimir numero_aprobados y numero_suspensos y porcentaje de aprobados redondeado a 2 decimales usando f string
num_total = len(calificaciones)
# num_total = num_aprobados + num_suspensos
porcentaje_aprobados =  round((num_aprobados / num_total) * 100, 2)

print(f'Número aprobados: {num_aprobados}')
print(f'Número suspensos: {num_suspensos}')
print(f'% de aprobados: {porcentaje_aprobados} %')
