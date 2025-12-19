/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Broker;
import view.AgentsView;
import view.GraphicView;
import view.MainView;
import view.OperationsView;

/**
 *
 * @author dam2_alu06@inf.ald
 */

public class FrontController {
    
    private MainView view;
    private Broker broker;

    public FrontController(MainView view, Broker broker) {
        this.view = view;
        this.broker = broker;
        this.view.QuitMenutItemListener(this.quitMenuItemListener());
        this.view.GraphicsMenuItem(this.graphicListener());
        this.view.AgentsMenuItemActionListener(this.agentsListener());
        this.view.OperationsMenutItem(this.operationsListener());
    }
    
    private ActionListener quitMenuItemListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.dispose();
            }
        };
        return al;
    }
    
    private ActionListener graphicListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GraphicView gv = new GraphicView();
                GraphicController gc = new GraphicController(gv); 
                gv.setVisible(true);
            }
        };
        return al;
    }
    
    private ActionListener agentsListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AgentsView av = new AgentsView();
                AgentsController ac = new AgentsController(av);
                av.setVisible(true);
            }
        };
        return al;
    }
    
    private ActionListener operationsListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                OperationsView ov = new OperationsView();
                OperationsController oc = new OperationsController(ov, broker);
                ov.setVisible(true);
            }
        };
        return al;
    }
}