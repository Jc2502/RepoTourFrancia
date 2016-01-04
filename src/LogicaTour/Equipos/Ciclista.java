/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaTour.Equipos;

/**
 *
 * @author carlo_000
 */
public class Ciclista {
    private String nombre;
    private int dorsal;
    private String nombreEquipo;
    
    public Ciclista(){
        
    }
    public Ciclista(String nombre, int dorsal, String nombreEquipo){
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.nombreEquipo = nombreEquipo;
  
    }    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }    
}
