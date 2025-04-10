# Equipo18-ManejoDatos
# Proyecto: Conversor de Archivos (.txt, .csv, .json)

**Equipo 18**  
**Integrantes:**
- Sandoval Reyes Miguel  
- García Pérez César Miguel

---

##  Descripción del Proyecto

Este proyecto consiste en una aplicación en Java con interfaz gráfica (JFrame) que permite **exportar y convertir archivos** entre los formatos `.txt`, `.csv` y `.json`. La herramienta está pensada como una utilidad sencilla para gestionar y transformar datos en distintos formatos populares, sin necesidad de librerías externas.

---
### Descripción general

La clase ManejadorArchivos implementa métodos estáticos para:

- Leer y escribir archivos de texto plano.
- Leer y escribir archivos CSV y JSON.
- Convertir entre formatos CSV, JSON y TXT.
- Parsear estructuras JSON simples sin bibliotecas externas.
- Validaciones: La aplicación valida rutas vacías, extensiones repetidas, errores de lectura/escritura, y más.
#### Lectura y escritura de texto

```java
public static String leerArchivoTexto(String ruta)
Lee el contenido completo de un archivo .txt.


public static void escribirArchivoTexto(String ruta, String contenido)
Sobrescribe el contenido de un archivo .txt.


public static void agregarTextoArchivo(String ruta, String contenido)
Agrega contenido al final de un archivo de texto.

Manejo de CSV

public static List<String[]> leerArchivoCSV(String ruta)
Lee un archivo .csv línea por línea, devolviendo una lista de arreglos de cadenas.


public static void escribirArchivoCSV(String ruta, List<String[]> datos)
Escribe una lista de datos en un archivo .csv.


public static List<Map<String, String>> leerArchivoCSVConCabeceras(String ruta)
Lee un .csv con cabeceras, devolviendo una lista de mapas (clave = cabecera, valor = celda).

Manejo de JSON

public static Map<String, Object> leerArchivoJSON(String ruta)
Lee un archivo .json y lo transforma en un Map.


public static void escribirArchivoJSON(String ruta, Map<String, Object> datos)
Escribe un Map como archivo .json.


public static Map<String, Object> parsearJSON(String json)
Parsea manualmente una cadena JSON en un Map.


public static String convertirJSON(Map<String, Object> datos)
Convierte un Map en una cadena JSON.

Conversión entre formatos

public static void convertirCSVaJSON(String archivoCSV, String archivoJSON)
Transforma un archivo CSV a JSON, respetando cabeceras.

public static void convertirJSONaCSV(String archivoJSON, String archivoCSV)
Convierte un archivo JSON a CSV (si contiene una lista bajo la clave "datos").

public static void convertirTextoACSV(String archivoTexto, String archivoCSV)
Transforma un archivo .txt en un .csv con una columna por línea.

public static void convertirCSVaTXT(String archivoCSV, String archivoTXT)
Convierte un archivo .csv en .txt, uniendo los valores de cada línea con espacios.
##  Funcionalidades principales

- **Exportación:** Guarda el contenido escrito en un `JTextArea` en formato `.txt`, `.csv` o `.json`.
- **Conversión:** Convierte archivos entre los formatos `.txt`, `.csv` y `.json`.
- **Validaciones:** La app valida rutas vacías, extensiones repetidas, errores de lectura/escritura, y más.

---

## Estructura del proyecto

El proyecto se compone de dos clases principales:

- ManejadorArchivos: Funcionalidad para manipular archivos y convertir formatos.
- Registro: Representación de un registro de datos genérico utilizado para almacenamiento o visualización.
---
##  Clases y métodos

### ManejadorArchivos.java
Clase estática con funciones para manejo de archivos.

#### Lectura/Escritura

- leerArchivoTexto(String ruta)
- escribirArchivoTexto(String ruta, String contenido)
- agregarTextoArchivo(String ruta, String contenido)

#### CSV

- leerArchivoCSV(String ruta)
- leerArchivoCSVConCabeceras(String ruta)
- escribirArchivoCSV(String ruta, List<String[]> datos)

#### JSON

- leerArchivoJSON(String ruta)
- escribirArchivoJSON(String ruta, Map<String, Object> datos)
- parsearJSON(String json)
- convertirJSON(Map<String, Object> datos)

#### Conversiones

- convertirCSVaJSON(String archivoCSV, String archivoJSON)
- convertirJSONaCSV(String archivoJSON, String archivoCSV)
- convertirTextoACSV(String archivoTexto, String archivoCSV)
- convertirCSVaTXT(String archivoCSV, String archivoTXT)

---
Clase Registro
Descripción general
La clase Registro representa un registro genérico con campos dinámicos, útil para almacenar estructuras provenientes de formularios o archivos.

Atributos
Atributo	Tipo	Descripción
campo	Map<String, String>


Constructores

public Registro(String... datos)
Genera campos dinámicamente como campo1, campo2, etc.

public Registro(Map<String, String> mapa)
Permite crear un registro directamente desde un Map.

Métodos

public Map<String, String> getCampos()
Devuelve el mapa con los campos.

public String toString()
Devuelve el contenido del registro como una cadena estilo JSON.

JFrame de ejemplo
Dependencias

import Libreriass.ManejadorArchivos;
import Libreriass.Registro;

Ejemplo básico de uso

// Leer archivo CSV
List<String[]> datos = ManejadorArchivos.leerArchivoCSV("usuarios.csv");

// Convertir a JSON
ManejadorArchivos.convertirCSVaJSON("usuarios.csv", "usuarios.json");

// Leer JSON como mapa
Map<String, Object> mapa = ManejadorArchivos.leerArchivoJSON("usuarios.json");

// Crear registros
Registro registro = new Registro("Juan", "Pérez", "juan@correo.com");
System.out.println(registro.toString());


###  Validaciones implementadas:

- Verificación de que la ruta no esté vacía.
- Comprobación de que el archivo exista antes de convertir.
- Evita que se convierta un archivo al mismo formato.
- Captura y notificación de errores de entrada/salida con `JOptionPane`.

---

##  Cómo importar el archivo `.jar` en otro proyecto

1. Abre tu proyecto en **NetBeans**, **Eclipse** o cualquier IDE de Java.
2. Da clic derecho en el proyecto → **Properties** (Propiedades).

3. Ve a **Libraries** o **Build Path**.
4. Haz clic en **Add JAR/Folder** o **Add External JARs**.
5. Selecciona el archivo `ManejoDatos.jar`.
6. Da clic en **Aceptar** y ¡listo! Puedes comenzar a utilizar la funcionalidad si estás usando esa versión antigua del proyecto.






## Enlace al video de demostración

   -https://youtu.be/fMSa7-YgOi4

---

##  Requisitos mínimos

- Java 8 o superior.
- IDE como NetBeans, IntelliJ o Eclipse.
- No se requiere conexión a internet ni librerías externas.

---

## Créditos:

Este proyecto fue desarrollado como parte de un ejercicio académico para la materia de programación, por el equipo 18, integrado por:

- Sandoval Reyes Miguel  
- García Pérez César Miguel
