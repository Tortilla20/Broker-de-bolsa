/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package model;

import controller.FrontController;
import java.util.ArrayList;
import view.MainView;
import view.OperationsView;

/**
 *
 * @author dam2_alu06@inf.ald
 */
public class Main {

    public static void main(String[] args) {
        //hacer en casa
        //persistencia 
        //interfaz grafica
        
        //(GUARDAR DATOS POR SI SE CIERRA EL PROGRAMA) -> PERSISTENCIA DE USUARIOS/AGENTES Y OPERACIONES
        //TENEMOS QUE RECUPERAR EL PRECIO Y LOS VALORES ANTERIORES
        
        //MOSTRAR(PINTAR) PRECIO / TIEMPO -----> INTERFAZ GRÁFICA
        
        //CREAR AGENTES QUE TIENEN OPERACIONES DE ENTRADA Y SALIDA
            //LECTURA DE PRECIO Y COMPRAN O VENDEN - > 2 TIPOS DE HILOS (COMPRAR Y VENDER)
            
        //LÓGICA DE COMPRAVENTA EN BROKER --> HILO
        
        //AGENTES CON UN CAPITAL QUE PUEDAN LANZAR LAS OPERACIONES DE COMPRAVENTA
        
        //METER EN INTERFAZ GRÁFICA NUEVOS AGENTES Y CREAR OPERACIONES  
        
        //--------------------------------- LÓGICA ---------------------------------
        
        MainView view = new MainView();
        //OperationsView operations = new OperationsView();
        //operations.setAgents(new ArrayList<>(ListaAgentes.getAgentes()));
        //operations.setVisible(true);
        PrecioDeLaAccion precio = new PrecioDeLaAccion(100);
        Broker broker = new Broker(precio);
        FrontController controller = new FrontController(view, broker);
        view.setVisible(true);
    }
}