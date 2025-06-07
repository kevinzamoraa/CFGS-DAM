# ✅ **EJERCICIO 3** – Consulta SQL de moneda, símbolo y país

### 🎯 Objetivo:

Mostrar solo 3 columnas:

* Nombre de la moneda
* Símbolo de la moneda
* Nombre del país

---

## 🔧 Paso 1: Comprueba que las tablas estén correctamente relacionadas

Asumiendo que estás trabajando con una base de datos similar a Odoo o ERP genérico, normalmente las tablas involucradas serían:

* `res_currency` → contiene monedas (`name`, `symbol`)
* `res_country` → contiene países (`name`, `currency_id` que apunta a `res_currency.id`)

---

## 🧠 Consulta SQL:

```sql
SELECT
    c.name AS "Nombre moneda",
    c.symbol AS "Símbolo de la moneda",
    co.name AS "Nombre del país"
FROM
    res_country co
JOIN
    res_currency c ON co.currency_id = c.id;
```

---

## 💡 ¿Cómo ejecutarlo en pgAdmin4?

1. Abre pgAdmin4.
2. Conéctate a la base de datos.
3. Clic derecho en la base de datos → `Query Tool`.
4. Pega y ejecuta la consulta anterior.
5. Haz una captura de pantalla del resultado (solo con esas 3 columnas).

---

# ✅ **EJERCICIO 4** – Exportar archivo CSV desde pgAdmin4

### 🎯 Objetivo:

Exportar los siguientes datos en este orden:

* Nombre
* Inicio de sesión
* Activo
* Ciudad
* Idioma
* Correo electrónico

---

## 🔧 Paso 1: Consulta para obtener los datos

En una instalación de Odoo, esta info puede encontrarse así:

```sql
SELECT
    ru.name AS "Nombre",
    ru.login AS "Inicio de sesión",
    ru.active AS "Activo",
    rp.city AS "Ciudad",
    ru.lang AS "Idioma",
    ru.email AS "Correo electrónico"
FROM
    res_users ru
JOIN
    res_partner rp ON ru.partner_id = rp.id;
```

---

## 📤 Paso 2: Exportar a CSV desde pgAdmin4

1. Ejecuta la consulta en la `Query Tool`.
2. En la barra de resultados, haz clic derecho > **"Save As CSV"**.
3. Elige ubicación, nombre del archivo (`usuarios.csv`), codificación `UTF-8` y guarda.

---

## 📸 Paso 3: Captura de pantalla

Haz **capturas de**:

* La consulta ejecutada en pgAdmin.
* La ventana donde guardas el CSV.
* El CSV abierto (en Excel, LibreOffice o bloc de notas).

---

# ✅ **EJERCICIO 5** – Procedimiento almacenado para obtener login, nombre y teléfono de la compañía

---

## 🧠 Suponiendo estas tablas:

* `res_users` (usuario, login, partner\_id)
* `res_partner` (nombre del usuario, teléfono, compañía)

---

## 🛠 Paso 1: Crear el procedimiento almacenado

```sql
CREATE OR REPLACE FUNCTION obtener_info_usuario()
RETURNS TABLE (
    login TEXT,
    nombre TEXT,
    telefono TEXT
) AS $$
BEGIN
    RETURN QUERY
    SELECT
        ru.login,
        rp.name,
        rp.phone
    FROM
        res_users ru
    JOIN
        res_partner rp ON ru.partner_id = rp.id;
END;
$$ LANGUAGE plpgsql;
```

---

## 🧪 Paso 2: Ejecutar el procedimiento

```sql
SELECT * FROM obtener_info_usuario();
```

---

## 📸 Paso 3: Captura de pantalla

* Captura del código del procedimiento.
* Captura del resultado tras ejecutar el `SELECT`.

---

# Ejercicio 6: Creación e Instalación de un módulo personalizado

---

Perfecto, he generado el módulo de Odoo 17 llamado **`user_management`** con todas las carpetas y archivos necesarios. Puedes descargarlo desde el siguiente enlace:

---

### ✅ ¿Qué contiene el módulo?

* **Modelo:** `custom.user` con campos: nombre, email, idioma, y zona horaria.
* **Vistas:**

  * Formulario de usuario.
  * Vista en árbol (lista).
  * Menú principal “Gestión Usuarios”.
  * Submenú “Usuarios” que enlaza al listado y permite crear nuevos registros.
* **Archivos:**

  * `__manifest__.py`
  * `__init__.py`
  * `models/__init__.py`
  * `models/user.py`
  * `views/user_views.xml`

---

### 🧩 Próximo paso: ¿Cómo instalar este módulo en Odoo?

Puedo guiarte paso a paso en la instalación del módulo en tu instancia de Odoo. ¿Deseas continuar ahora con la instalación? También podemos continuar resolviendo el **Ejercicio 3** como mencionaste antes.

¿En qué orden prefieres seguir?

1. **Instalación del módulo en Odoo**
2. **Consulta SQL del Ejercicio 3**
3. **Exportación CSV del Ejercicio 4**
4. **Procedimiento almacenado del Ejercicio 5**

