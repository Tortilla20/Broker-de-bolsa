/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author dam2_alu06@inf.ald
 */
public class Agente {
    private long id;
    private String nombre;
    private double saldo;
    //private Operacion Operacion_Compra;
    //private Operacion Operacion_Venta;

    //Operacion Operacion_Compra, Operacion Operacion_Venta
    public Agente(long id, String nombre, double saldo) {
        this.id = id;
        this.nombre = nombre;
        this.saldo = saldo;
        //this.Operacion_Compra = Operacion_Compra;
        //this.Operacion_Venta = Operacion_Venta;
    }
    //(Agente this) -> es la referencia
    /*public boolean nuevaOperacion(String tipo, double limite, double cantidad) {
        switch (tipo) {
                case "compra":
                    //crear una operacion y asignarla a compra
                    if(Operacion_Compra.equals(null)) {
                        Operacion_Compra = new Operacion(tipo, limite, cantidad);
                    } else {
                        System.out.println("Ya existe una operacion de compra para el agente " + getNombre());
                        return false;
                    }  
                break;
                
                case "venta":
                    //crear una operacion y asignarla a venta
                break;
                
                default: return false;
        }
        return true;
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /*public Operacion getOperacion_Compra() {
        return Operacion_Compra;
    }

    public void setOperacion_Compra(Operacion Operacion_Compra) {
        this.Operacion_Compra = Operacion_Compra;
    }

    public Operacion getOperacion_Venta() {
        return Operacion_Venta;
    }

    public void setOperacion_Venta(Operacion Operacion_Venta) {
        this.Operacion_Venta = Operacion_Venta;
    }*/

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Agente other = (Agente) obj;
        return this.id == other.id;
    }
    
    @Override
    public String toString() {
        return nombre + " - " + saldo;
    }
}