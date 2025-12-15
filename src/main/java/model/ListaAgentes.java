/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duroi
 */
public class ListaAgentes {
    
    private static ArrayList<Agente> agentes = new ArrayList<>();

    public static ArrayList<Agente> getAgentes() {
        return agentes;
    }

    public static void setAgentes(ArrayList<Agente> agentes) {
        ListaAgentes.agentes = agentes;
    }

    public static void anhadirAgente(Agente agente) {
        agentes.add(agente);
    }
    
    public static boolean existeNombre(String nombre) {
        for(Agente agente : agentes) {
            if(agente.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
}