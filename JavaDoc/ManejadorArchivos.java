/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreriass;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class ManejadorArchivos {
    
    public static String leerArchivoTexto(String rutaArchivo) throws IOException {
        Path path = Paths.get(rutaArchivo);
        if (!Files.exists(path)) {
            Files.createFile(path); 
        }
        return Files.readString(path, StandardCharsets.UTF_8);
    }
    
    public static void escribirArchivoTexto(String rutaArchivo, String contenido) throws IOException {
        Files.write(Paths.get(rutaArchivo), contenido.getBytes(StandardCharsets.UTF_8));
    }
    
    public static void agregarTextoArchivo(String rutaArchivo, String contenido) throws IOException {
        Files.write(Paths.get(rutaArchivo), contenido.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
    }
    
    public static List<String[]> leerArchivoCSV(String rutaArchivo) throws IOException {
        List<String[]> resultado = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                resultado.add(linea.split(","));
            }
        }
        return resultado;
    }
    
    public static void escribirArchivoCSV(String rutaArchivo, List<String[]> datos) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (String[] fila : datos) {
                bw.write(String.join(",", fila));
                bw.newLine();
            }
        }
    }
    
    public static Map<String, Object> leerArchivoJSON(String rutaArchivo) throws IOException {
        String contenido = leerArchivoTexto(rutaArchivo);
        return parsearJSON(contenido);
    }
    
    public static void escribirArchivoJSON(String rutaArchivo, Map<String, Object> datos) throws IOException {
        escribirArchivoTexto(rutaArchivo, convertirJSON(datos));
    }
    
    public static List<Map<String, String>> leerArchivoCSVConCabeceras(String rutaArchivo) throws IOException {
        List<Map<String, String>> resultado = new ArrayList<>();
        List<String[]> datos = leerArchivoCSV(rutaArchivo);
        if (datos.isEmpty()) return resultado;
        
        String[] cabeceras = datos.get(0);
        for (int i = 1; i < datos.size(); i++) {
            Map<String, String> filaMap = new HashMap<>();
            String[] fila = datos.get(i);
            for (int j = 0; j < Math.min(cabeceras.length, fila.length); j++) {
                filaMap.put(cabeceras[j], fila[j]);
            }
            resultado.add(filaMap);
        }
        return resultado;
    }
    
    public static Map<String, Object> parsearJSON(String json) {
        Map<String, Object> resultado = new HashMap<>();
        json = json.trim();

        if (json.startsWith("{") && json.endsWith("}")) {
            json = json.substring(1, json.length() - 1).trim();

            if (json.startsWith("\"datos\":[")) {
                List<Map<String, String>> lista = new ArrayList<>();
                String contenidoLista = json.substring(json.indexOf('[') + 1, json.lastIndexOf(']'));
                String[] objetos = contenidoLista.split("\\},\\s*\\{");

                for (String obj : objetos) {
                    obj = obj.replaceAll("[{}]", "");
                    Map<String, String> fila = new HashMap<>();
                    for (String par : obj.split(",")) {
                        String[] kv = par.split(":", 2);
                        if (kv.length == 2) {
                            String key = kv[0].replaceAll("\"", "").trim();
                            String value = kv[1].replaceAll("\"", "").trim();
                            fila.put(key, value);
                        }
                    }
                    lista.add(fila);
                }
                resultado.put("datos", lista);
            }
        }
        return resultado;
    }
    
    public static String convertirJSON(Map<String, Object> datos) {
        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, Object> entrada : datos.entrySet()) {
            json.append("\"").append(entrada.getKey()).append("\":");

            Object valor = entrada.getValue();
            if (valor instanceof String) {
                json.append("\"").append(valor).append("\"");
            } else if (valor instanceof Map) {
                json.append(convertirJSON((Map<String, Object>) valor));
            } else if (valor instanceof List) {
                json.append("[");
                List<?> lista = (List<?>) valor;
                for (int i = 0; i < lista.size(); i++) {
                    Object item = lista.get(i);
                    if (item instanceof Map) {
                        json.append(convertirJSON((Map<String, Object>) item));
                    } else {
                        json.append("\"").append(item).append("\"");
                    }
                    if (i < lista.size() - 1) json.append(",");
                }
                json.append("]");
            } else {
                json.append(valor);
            }
            json.append(", ");
        }
        if (json.length() > 1) json.setLength(json.length() - 2);
        json.append("}");
        return json.toString();
    }
    
    public static void convertirCSVaJSON(String archivoCSV, String archivoJSON) throws IOException {
        if (!Files.exists(Paths.get(archivoCSV))) {
            Files.createFile(Paths.get(archivoCSV));
            return; 
        }

        List<String[]> datos = leerArchivoCSV(archivoCSV);
        if (datos.isEmpty()) return;

        String[] cabeceras = datos.get(0); 
        List<Map<String, String>> registros = new ArrayList<>();

        for (int i = 1; i < datos.size(); i++) {
            String[] fila = datos.get(i);
            Map<String, String> registro = new LinkedHashMap<>();
            for (int j = 0; j < Math.min(cabeceras.length, fila.length); j++) {
                registro.put(cabeceras[j].trim(), fila[j].trim());
            }
            registros.add(registro);
        }

        StringBuilder json = new StringBuilder("{\n  \"datos\": [\n");

        for (int i = 0; i < registros.size(); i++) {
            Map<String, String> fila = registros.get(i);
            json.append("    {");
            int count = 0;
            for (Map.Entry<String, String> entry : fila.entrySet()) {
                json.append("\"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\"");
                count++;
                if (count < fila.size()) json.append(", ");
            }
            json.append("}");
            if (i < registros.size() - 1) json.append(",");
            json.append("\n");
        }

        json.append("  ]\n}");

        escribirArchivoTexto(archivoJSON, json.toString());
    }

    
    public static void convertirJSONaCSV(String archivoEntrada, String archivoSalida) throws IOException {
        Map<String, Object> datosJSON = leerArchivoJSON(archivoEntrada);
        List<String[]> datosCSV = new ArrayList<>();
        Object datos = datosJSON.get("datos");
        if (datos instanceof List) {
            List<Map<String, String>> lista = (List<Map<String, String>>) datos;
            if (!lista.isEmpty()) {
                String[] cabeceras = lista.get(0).keySet().toArray(new String[0]);
                datosCSV.add(cabeceras);
                for (Map<String, String> fila : lista) {
                    String[] valoresFila = new String[cabeceras.length];
                    for (int i = 0; i < cabeceras.length; i++) {
                        valoresFila[i] = fila.getOrDefault(cabeceras[i], "");
                    }
                    datosCSV.add(valoresFila);
                }
            }
        }
        escribirArchivoCSV(archivoSalida, datosCSV);
    }
    
    public static void convertirTextoACSV(String archivoTexto, String archivoCSV) throws IOException {
        Path pathTexto = Paths.get(archivoTexto);
        if (!Files.exists(pathTexto)) {
            Files.createFile(pathTexto);
        }
        List<String[]> lineasCSV = new ArrayList<>();
        List<String> lineas = Files.readAllLines(pathTexto, StandardCharsets.UTF_8);
        for (String linea : lineas) {
            lineasCSV.add(new String[]{linea});
        }
        escribirArchivoCSV(archivoCSV, lineasCSV);
    }
    public static void convertirCSVaTXT(String archivoCSV, String archivoTXT) throws IOException {
        List<String[]> datos = leerArchivoCSV(archivoCSV); 

        StringBuilder contenido = new StringBuilder();

        for (String[] fila : datos) {
            contenido.append(String.join(" ", fila));  
            contenido.append("\n"); 
        }

        escribirArchivoTexto(archivoTXT, contenido.toString());
    }
}

