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
    private String nombre, apellidos;
    private int dorsal;
    private String nombreEquipo;
    private String dni;
    
    public Ciclista(){
        
    }
    public Ciclista(String nombre, String apellidos, int dorsal, String nombreEquipo, String dni){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dorsal = dorsal;
        this.nombreEquipo = nombreEquipo;
        this.dni = dni;
    }    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
}
