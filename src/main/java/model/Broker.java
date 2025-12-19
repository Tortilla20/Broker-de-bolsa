/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author duroi
 */
public class Broker {
    private PrecioDeLaAccion precioDeLaAccion;

    public Broker(PrecioDeLaAccion precioDeLaAccion) {
        this.precioDeLaAccion = precioDeLaAccion;
    }
    
    //MODIFICAR EL SALDO DEL AGENTE
    //MODIFICAR PRECIO DE LA ACCION
    public synchronized void ejecutarLaOperacion(Operacion operacion) {
        Agente agente = operacion.getAgente();
        double total = operacion.getCantidad()* operacion.getLimite();
        
        //MIRAR SALDO ANTES DE COMPRAR
        if(operacion.getTipo().equalsIgnoreCase("compra")) {
            if(agente.getSaldo() >= total) {
                agente.setSaldo(agente.getSaldo() - total);
                precioDeLaAccion.subirPrecio((int) operacion.getCantidad());
            }
        } else if(operacion.getTipo().equalsIgnoreCase("venta")) {
            agente.setSaldo(agente.getSaldo() + total);
            precioDeLaAccion.bajarPrecio((int) operacion.getCantidad());
        }
    }
    
    public int getPrecioActual() {
        return precioDeLaAccion.getPrecio();
    }
}
