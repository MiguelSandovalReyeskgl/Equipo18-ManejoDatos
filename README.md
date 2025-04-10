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

##  Estructura del Código:

###  Componentes principales

- `btnExportarActionPerformed`:  
  Método que gestiona el guardado de archivos desde el área de texto en el formato seleccionado por el usuario.

- `btnConvertirActionPerformed`:  
  Método que permite convertir un archivo existente de un formato a otro (entre `.txt`, `.csv`, `.json`).

###  Variables importantes:

- `txtRuta`: Campo de texto para ingresar o mostrar la ruta del archivo.
- `txtArea`: Área de texto donde se escribe o carga el contenido.
- `OpTxt`, `OpCSV`, `OpJSON`: Radio buttons que permiten al usuario elegir el tipo de archivo.

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
