/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaTour.Equipos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlo_000
 */
public class Equipo {
    private List<Ciclista> ciclistas;
    private String nombre;
    private String nombreDirector;

    public Equipo(){
        ciclistas = new ArrayList<>();
    }
    public Equipo(String nombre, String nombreDirector) {
        this.nombre = nombre;
        this.nombreDirector = nombreDirector;
    }

    
    public List<Ciclista> getCiclistas() {
        return ciclistas;
    }

    public void setCiclistas(List<Ciclista> ciclistas) {
        this.ciclistas = ciclistas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre= nombre;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }
    
    
    
}
