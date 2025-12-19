/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dam2_alu06@inf.ald
 */
public class Operacion implements Runnable {
    private String tipo;
    private double limite;
    private double cantidad;
    private Thread hiloEjecutor;
    private Agente agente;
    private Broker broker;

    //usar metodos geters y seters en el constructor
    public Operacion(String tipo, double limite, double cantidad, Agente agente, Broker broker) {
        setTipo(tipo);
        this.limite = limite;
        this.cantidad = cantidad;
        this.agente = agente;
        this.broker = broker;
        //OPERACION SE EJECUTA EN SU HIJO
        hiloEjecutor = new Thread(this);
        hiloEjecutor.start();
    }

    @Override
    public void run() {
        //BUCLE
            //comprobar el precio de broker en bucle
            //SI    PEDIR EL LOCK SUMAR O RESTAR LIBERAR EL LOCK
            //NO    ME DUERMO
        boolean comprobar = false;
        //CONSULTAR PRECIO
        while(!comprobar) {
            //MIRAR EL PRECIO ACTUAL
            int precioActual = broker.getPrecioActual();
            if(tipo.equalsIgnoreCase("compra") && precioActual <= limite || tipo.equalsIgnoreCase("venta") && precioActual >= limite) {
                broker.ejecutarLaOperacion(this);
                comprobar = true;
            } else {
                try {
                    Thread.sleep(500);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo.equalsIgnoreCase("compra") || tipo.equalsIgnoreCase("venta")) {
            this.tipo = tipo;
        }
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Thread getHiloEjecutor() {
        return hiloEjecutor;
    }

    public void setHiloEjecutor(Thread hiloEjecutor) {
        this.hiloEjecutor = hiloEjecutor;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public Broker getBroker() {
        return broker;
    }

    public void setBroker(Broker broker) {
        this.broker = broker;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + " - Cantidad: " + cantidad + " - Limite: " + limite;
    }
}