/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author duroi
 */
public class PrecioDeLaAccion {
    private int precio;

    public PrecioDeLaAccion(int precio) {
        this.precio = precio;
    }
    
    public synchronized int getPrecio() {
        return precio;
    }
    
    //SUBIR PRECIO
    
    public synchronized void subirPrecio(int cantidad) {
        precio = precio + cantidad;
    }
    
    //BAJAR PRECIO
    
    public synchronized void bajarPrecio(int cantidad) {
        if(precio < 0) {
            precio = 0;
        } else {
            precio = precio - cantidad;
        }
    }
}