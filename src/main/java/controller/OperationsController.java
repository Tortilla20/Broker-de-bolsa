/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Agente;
import model.Broker;
import model.ListaAgentes;
import model.Operacion;
import view.OperationsView;

/**
 *
 * @author dam2_alu06@inf.ald
 */
public class OperationsController {
    private OperationsView view;
    private Broker broker;

    public OperationsController(OperationsView view, Broker broker) {
        this.view = view;
        this.broker = broker;
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
                    JOptionPane.showMessageDialog(view, "Tienes que seleccionar un agente", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if(precio <= 0 || cantidad <= 0) {
                    JOptionPane.showMessageDialog(view, "El precio y la cantidad deben de ser positivos", "Error", JOptionPane.ERROR_MESSAGE);
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
                                
                if(agenteObject == null) {
                    JOptionPane.showMessageDialog(view, "Agente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                Operacion operacion = new Operacion(tipo, precio, cantidad, agenteObject, broker);
                boolean creacionOperacion = agenteObject.nuevaOperacion(operacion);
                
                if(!creacionOperacion) {
                    JOptionPane.showMessageDialog(view, "El agente ya tiene una operacion", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                //ACTUALIZAR LA INTERFAZ
                view.actualizarLista(agenteObject);
                ListaAgentes.actualizar();
            }
        };
        return al;
    }
}