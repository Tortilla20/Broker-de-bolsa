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
import model.ListaAgentes;
import view.AgentsView;

/**
 *
 * @author dam2_alu06@inf.ald
 */
public class AgentsController {
    private AgentsView view;
    public static long contador = 1;

    public AgentsController(AgentsView view) {
        this.view = view;
        this.view.addCreateAgentButton(this.createAgentListener());
    }
    
    private ActionListener createAgentListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = view.getNombre();
                double saldo = view.getSaldo();
                
                if(nombre == null ||nombre.isBlank()) {
                    JOptionPane.showMessageDialog(view, "El nombre no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if(ListaAgentes.existeNombre(nombre)) {
                    JOptionPane.showMessageDialog(view, "Ya existe un agente con ese nombre", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if(saldo < 0) {
                    JOptionPane.showMessageDialog(view, "El saldo no puede ser negativo", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                //CREAR AGENTE
                Agente agente = new Agente(contador++, nombre, saldo);
                ListaAgentes.anhadirAgente(agente);
                
                //ACTUALIZAR VISTA
                //view.updateList(ListaAgentes.getAgentes());
                view.updateList(new ArrayList<>(ListaAgentes.getAgentes()));
            }
        };
        return al;
    }
}