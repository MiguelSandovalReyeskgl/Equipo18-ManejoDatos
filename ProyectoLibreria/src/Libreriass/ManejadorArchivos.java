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
        return new String(Files.readAllBytes(Paths.get(rutaArchivo)), StandardCharsets.UTF_8);
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
        json = json.trim().replaceAll("[{}]", "");
        for (String entrada : json.split(",")) {
            String[] partes = entrada.split(":", 2);
            if (partes.length == 2) {
                resultado.put(partes[0].trim(), partes[1].trim());
            }
        }
        return resultado;
    }
    
    public static String convertirJSON(Map<String, Object> datos) {
        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, Object> entrada : datos.entrySet()) {
            json.append("\"").append(entrada.getKey()).append("\":\"")
                .append(entrada.getValue()).append("\", ");
        }
        if (json.length() > 1) json.setLength(json.length() - 2);
        json.append("}");
        return json.toString();
    }
    
    public static void convertirCSVaJSON(String archivoEntrada, String archivoSalida) throws IOException {
        List<String[]> datosCSV = leerArchivoCSV(archivoEntrada);
        Map<String, Object> datosJSON = new HashMap<>();
        datosJSON.put("datos", leerArchivoCSVConCabeceras(archivoEntrada));
        escribirArchivoJSON(archivoSalida, datosJSON);
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
        List<String[]> lineasCSV = new ArrayList<>();
        List<String> lineas = Files.readAllLines(Paths.get(archivoTexto), StandardCharsets.UTF_8);
        for (String linea : lineas) {
            lineasCSV.add(new String[]{linea});
        }
        escribirArchivoCSV(archivoCSV, lineasCSV);
    }
}