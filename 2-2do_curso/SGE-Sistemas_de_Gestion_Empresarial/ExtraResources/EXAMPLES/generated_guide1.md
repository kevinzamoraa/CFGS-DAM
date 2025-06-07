---

## ✅ Paso 1: Localizar el archivo de configuración de PostgreSQL

El archivo que necesitas modificar es `pg_hba.conf`, que controla los métodos de autenticación para cada conexión.

### 📍 Comando para encontrar `pg_hba.conf` y otros archivos de configuración

Desde terminal (Linux/Mac) o PowerShell (Windows), ejecuta:

```bash
sudo -u postgres psql -c "SHOW hba_file;"
```

Esto te mostrará algo como:

```
             hba_file
-------------------------------------
 /etc/postgresql/15/main/pg_hba.conf
(1 row)
```

También puedes encontrar la ruta del archivo principal de configuración (`postgresql.conf`) con:

```bash
sudo -u postgres psql -c "SHOW config_file;"
```

---

## ✅ Paso 2: Editar `pg_hba.conf` para deshabilitar la autenticación por contraseña

Una vez que conozcas la ruta, edita el archivo:

```bash
sudo nano /etc/postgresql/15/main/pg_hba.conf
```

Busca líneas similares a estas (al final del archivo normalmente):

```text
# IPv4 local connections:
host    all             all             127.0.0.1/32            scram-sha-256
```

### 🔄 Modifícalas así para permitir acceso sin contraseña temporalmente (NO recomendado en producción):

```text
host    all             all             127.0.0.1/32            trust
```

También puedes usar `md5` si prefieres usar contraseña pero tener acceso desde herramientas externas:

```text
host    all             all             127.0.0.1/32            md5
```

Guarda y sal de `nano` con `Ctrl + O`, luego `Enter`, y `Ctrl + X`.

---

## ✅ Paso 3: Reiniciar el servicio de PostgreSQL

Para aplicar los cambios:

```bash
sudo systemctl restart postgresql
```

---

## ✅ Paso 4: Asignar una contraseña al usuario `postgres` desde `psql`

Entra al shell de PostgreSQL:

```bash
sudo -u postgres psql
```

Dentro de `psql`, escribe:

```sql
\password postgres
```

Introduce la nueva contraseña (por ejemplo, `odoo123` — pero elige una segura).

Si prefieres hacerlo directamente con un comando SQL:

```sql
ALTER USER postgres WITH PASSWORD 'odoo123';
```

Luego sal de `psql`:

```sql
\q
```

---

## ✅ Paso 5: Probar acceso desde pgAdmin4

1. Abre pgAdmin4.
2. Click derecho en “Servers” > “Create” > “Server…”
3. **Name:** OdooDB (o lo que quieras).
4. **Connection:**

   * **Host name/address:** 127.0.0.1
   * **Port:** 5432
   * **Username:** postgres
   * **Password:** (pon la que definiste, ej. `odoo123`)
   * Marca la casilla “Save Password”

Haz clic en "Save" y deberías conectarte sin problemas.

---

## ✅ Extras

### Para listar las bases de datos disponibles:

```bash
sudo -u postgres psql -c "\l"
```

### Para conectarte a una base de datos específica:

```bash
sudo -u postgres psql -d nombredb
```

