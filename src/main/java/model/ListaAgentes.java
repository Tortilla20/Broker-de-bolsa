/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duroi
 */
public class ListaAgentes {
    
    //BORRAR LINEAS EN PROPIEDADES - RUN - VM OPTIONS
    
    //private static ArrayList<Agente> agentes = new ArrayList<>();
    //private static List<Agente> agentes = Persistence.cargarAgentes();
    private static List<Agente> agentes = new ArrayList<>();
    public static List<Agente> getAgentes() {
        return agentes;
    }

    public static void setAgentes(ArrayList<Agente> agentes) {
        ListaAgentes.agentes = agentes;
    }

    public static void anhadirAgente(Agente agente) {
        agentes.add(agente);
        Persistence.guardarAgentes(agentes);
    }
    
    public static boolean existeNombre(String nombre) {
        for(Agente agente : agentes) {
            if(agente.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
    
    // GUARDAR AGENTE EN ARCHIVO
    public static void actualizar() {
        Persistence.guardarAgentes(agentes);
    }
}