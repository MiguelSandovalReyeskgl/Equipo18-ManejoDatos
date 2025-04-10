# Equipo18-ManejoDatos
## Proyecto: Conversor de Archivos (.txt, .csv, .json)
---

##  Descripción del Proyecto

ManejadorArchivos es una librería en Java orientada al manejo eficiente de archivos en formato TXT, CSV y JSON. Permite leer, escribir y convertir datos entre estos formatos de manera sencilla, utilizando métodos estáticos sin necesidad de dependencias externas.
La librería está pensada para integrarse en aplicaciones de escritorio basadas en Swing, especialmente en formularios o interfaces que requieren entrada/salida de datos estructurados. También es útil como base para proyectos educativos o administrativos que requieran persistencia de datos en archivos planos.

---
### Descripción general

La clase ManejadorArchivos implementa métodos estáticos para:

- Leer y escribir archivos de texto plano.
- Leer y escribir archivos CSV y JSON.
- Convertir entre formatos CSV, JSON y TXT.
- Parsear estructuras JSON simples sin bibliotecas externas.
- Validaciones: La aplicación valida rutas vacías, extensiones repetidas, errores de lectura/escritura, y más.
---
##  Validaciones implementadas:

- Verificación de que la ruta no esté vacía.
- Comprobación de que el archivo exista antes de convertir.
- Evita que se convierta un archivo al mismo formato.
- Captura y notificación de errores de entrada/salida con `JOptionPane`.

---
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

`leerArchivoTexto(String ruta)`
```bash
public static String leerArchivoTexto(String ruta)
```
-Lee el contenido completo de un archivo .txt.

`escribirArchivoTexto(String ruta, String contenido)`
```bash
public static void escribirArchivoTexto(String ruta, String contenido)
```
-Sobrescribe el contenido de un archivo .txt.

`agregarTextoArchivo(String ruta, String contenido)`
```bash
public static void agregarTextoArchivo(String ruta, String contenido)
```
-Agrega contenido al final de un archivo de texto.

#### CSV

`leerArchivoCSV(String ruta)`
```bash
public static List<String[]> leerArchivoCSV(String ruta)
```
-Lee un archivo .csv línea por línea, devolviendo una lista de arreglos de cadenas.

`leerArchivoCSVConCabeceras(String ruta)`
```bash
public static List<Map<String, String>> leerArchivoCSVConCabeceras(String ruta)
```
-Lee un .csv con cabeceras, devolviendo una lista de mapas (clave = cabecera, valor = celda).

`escribirArchivoCSV(String ruta, List<String[]> datos)`
```bash
public static void escribirArchivoCSV(String ruta, List<String[]> datos)
```
-Escribe una lista de datos en un archivo .csv.

#### JSON

`leerArchivoJSON(String ruta)`
```bash
public static Map<String, Object> leerArchivoJSON(String ruta)
```
-Lee un archivo .json y lo transforma en un Map.

`escribirArchivoJSON(String ruta, Map<String, Object> datos)`
```bash
public static void escribirArchivoJSON(String ruta, Map<String, Object> datos)
```
-Escribe un Map como archivo .json.

`parsearJSON(String json)`
```bash
public static Map<String, Object> parsearJSON(String json)
```
-Parsea manualmente una cadena JSON en un Map.

`convertirJSON(Map<String, Object> datos)`
```bash
public static String convertirJSON(Map<String, Object> datos)
```
-Convierte un Map en una cadena JSON.

#### Conversiones

`convertirCSVaJSON(String archivoCSV, String archivoJSON)`
```bash
public static void convertirCSVaJSON(String archivoCSV, String archivoJSON)
```
-Transforma un archivo CSV a JSON, respetando cabeceras.

`convertirJSONaCSV(String archivoJSON, String archivoCSV)`
```bash
public static void convertirJSONaCSV(String archivoJSON, String archivoCSV)
```
-Convierte un archivo JSON a CSV (si contiene una lista bajo la clave "datos").

`convertirTextoACSV(String archivoTexto, String archivoCSV)`
```bash
public static void convertirTextoACSV(String archivoTexto, String archivoCSV)
```
-Transforma un archivo .txt en un .csv con una columna por línea.

`convertirCSVaTXT(String archivoCSV, String archivoTXT)`
```bash
public static void convertirCSVaTXT(String archivoCSV, String archivoTXT)
```
-Convierte un archivo .csv en .txt, uniendo los valores de cada línea con espacios.

---

### Clase Registro
---
#### Descripción general
La clase Registro representa un registro genérico con campos dinámicos, útil para almacenar estructuras provenientes de formularios o archivos.

#### Atributos
|Atributo	|Tipo	|Descripción|
| :-------- |--|:-------------------------- |
|`campo` |Map<String, String>|Mapa con campos dinámicos del registro|

---
#### Constructores

`public Registro(String... datos)`
Genera campos dinámicamente como campo1, campo2, etc.

`public Registro(Map<String, String> mapa)`
Permite crear un registro directamente desde un Map.

#### Métodos

`public Map<String, String> getCampos()`
Devuelve el mapa con los campos.

`public String toString()`
Devuelve el contenido del registro como una cadena estilo JSON.

---
### JFrame de ejemplo
#### Dependencias
```bash
import Libreriass.ManejadorArchivos;
import Libreriass.Registro;
```
---
#### Ejemplo básico de uso
```bash
// Leer archivo CSV
List<String[]> datos = ManejadorArchivos.leerArchivoCSV("usuarios.csv");
// Convertir a JSON
ManejadorArchivos.convertirCSVaJSON("usuarios.csv", "usuarios.json");

// Leer JSON como mapa
Map<String, Object> mapa = ManejadorArchivos.leerArchivoJSON("usuarios.json");

// Crear registros
Registro registro = new Registro("Juan", "Pérez", "juan@correo.com");
System.out.println(registro.toString());
```
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
