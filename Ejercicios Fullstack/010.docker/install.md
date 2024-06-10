## INSTALACIÓN DOCKER

### 1. Habilitar características de windows

https://docs.docker.com/desktop/troubleshoot/topics/#virtualization

* Plataforma de máquina virtual
* Subsistema de windows para linux

### 2. Instalar WSL
https://learn.microsoft.com/en-us/windows/wsl/install

WSL es Windows Subsystem for Linux permite ejecutar Linux en Windows.

Abrir Powershell en Windows:

wsl --install 

wsl --list --online

wsl --install -d Ubuntu-22.04

wsl --list 

wsl.exe --update

### 3. Instalar docker desktop

https://www.docker.com/products/docker-desktop/