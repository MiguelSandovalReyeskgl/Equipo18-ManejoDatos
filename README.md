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
