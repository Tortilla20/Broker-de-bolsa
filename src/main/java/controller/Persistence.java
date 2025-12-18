/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import model.Agente;
/**
 *
 * @author duroi
 */
public class Persistence {
    private static final String name = "agentes.json";
    private static final Gson gson = new Gson();
    
    //GUARDAR LISTA AGENTES
    public static void guardarAgentes(List<Agente> agentes) {
        try(FileWriter wr = new FileWriter(name)) {
            gson.toJson(agentes, wr);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    //CARGAR LISTA AGENTES
    public static List<Agente> cargarAgentes() {
        File fl = new File(name);
        try(FileReader fr = new FileReader(fl)) {
            Type lista = new TypeToken<List<Agente>>(){}.getType();
            return gson.fromJson(fr, lista);
        } catch(IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }
}
