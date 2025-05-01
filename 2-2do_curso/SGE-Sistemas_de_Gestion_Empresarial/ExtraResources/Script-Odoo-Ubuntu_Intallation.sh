#!/bin/bash
# instalar_odoo.sh

# 1. Actualizar e instalar paquetes esenciales
sudo apt update
sudo apt install -y git python3 python3-pip python3-venv python3-dev gcc g++ \
libxml2-dev libxslt1-dev libldap2-dev libsasl2-dev libssl-dev libpq-dev \
libjpeg-dev libpng-dev postgresql postgresql-client

# 2. Iniciar y habilitar PostgreSQL
sudo systemctl start postgresql
sudo systemctl enable postgresql

# 3. Crear usuario de PostgreSQL
read -p "Introduce tu nombre de usuario de Ubuntu para PostgreSQL: " usuario
sudo -u postgres createuser -d -R -S $usuario
createdb $usuario

# 4. Clonar Odoo
git clone https://github.com/odoo/odoo --depth 1 --branch 17.0 odoo
cd odoo

# 5. Instalar dependencias Python
pip3 install setuptools wheel
pip3 install -r requirements.txt

# 6. Dar permisos de ejecución
chmod +x odoo-bin

# 7. Final
echo "Instalación completada. Ejecuta Odoo con: ./odoo-bin"
