/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psphilosbroker;

/**
 *
 * @author dam2_alu06@inf.ald
 */
class Operacion implements Runnable {
    private String tipo;
    private double limite;
    private double cantidad;
    private Thread hiloEjecutor;

    //usar metodos geters y seters en el constructor
    public Operacion(String tipo, double limite, double cantidad) {
        setTipo(tipo);
        this.limite = limite;
        this.cantidad = cantidad;
        hiloEjecutor = new Thread(this);
        hiloEjecutor.start();
    }

    @Override
    public void run() {
        //BUCLE
            //comprobar el precio de broker en bucle
            //SI    PEDIR EL LOCK SUMAR O RESTAR LIBERAR EL LOCK
            //NO    ME DUERMO
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
    
    
}