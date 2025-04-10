/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreriass;

import java.util.*;

public class Registro {
    private Map<String, String> campo = new HashMap<>();

    public Registro(String... datos) {
        for (int i = 0; i < datos.length; i++) {
            campo.put("campo" + (i + 1), datos[i]);
        }
    }

    public Registro(Map<String, String> mapa) {
        campo.putAll(mapa);
    }

    public Map<String, String> getCampos() {
        return campo;
    }

    @Override
    public String toString() {
        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, String> entrada : campo.entrySet()) {
            json.append("\"").append(entrada.getKey()).append("\":\"").append(entrada.getValue()).append("\", ");
        }
        if (json.length() > 1) json.setLength(json.length() - 2);
        json.append("}");
        return json.toString();
    }
}