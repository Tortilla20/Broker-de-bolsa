/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Agente;
import model.ListaAgentes;
import model.Operacion;
import view.OperationsView;

/**
 *
 * @author dam2_alu06@inf.ald
 */
public class OperationsController {
    private OperationsView view;

    public OperationsController(OperationsView view) {
        this.view = view;
        this.view.setAgents(new ArrayList<>(ListaAgentes.getAgentes()));
        //ACTIVAR FUNCIONALIDAD BOTON
        this.view.addCreateOperacionButton(this.createOperationListener());
    }
    
    private ActionListener createOperationListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreAgente = view.getAgenteSeleccionado();
                String tipo = view.getTipoOperacion();
                double precio = view.getPrecio();
                double cantidad = view.getCantidad();
                
                if(nombreAgente == null) {
                    view.errors("Tienes que seleccionar un agente");
                    return;
                }
                
                if(precio <= 0 || cantidad <= 0) {
                    view.errors("El precio y la cantidad deben de ser positivos");
                    return;
                }
                
                //BUSCAR EL OBJETO AGENTE ANTES DE CREAR UNA POSIBLE OPERACION
                Agente agenteObject = null;
                for(Agente agente : ListaAgentes.getAgentes()) {
                    if(agente.getNombre().equals(nombreAgente)) {
                        agenteObject = agente;
                        break;
                    }
                }

                //CREAR OPERACION
                
                Operacion operacion = new Operacion(tipo, precio, cantidad);
                boolean creacionOperacion = agenteObject.nuevaOperacion(operacion);
                
                if(agenteObject == null) {
                    view.errors("Agente no encontrado");
                    return;
                }
                
                if(!creacionOperacion) {
                    view.errors("El agente ya tiene una operacion");
                    return;
                }
                
                //ACTUALIZAR
                view.actualizarLista(agenteObject);
                ListaAgentes.actualizar();
            }
        };
        return al;
    }
}