/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaTour.Equipos;

import java.util.List;

/**
 *
 * @author carlo_000
 */
public class Equipo {
    private List<Ciclista> ciclistas;
    private String nombreEquipo;
    private String nombreDirector;

    public Equipo(String nombreEquipo, String nombreDirector) {
        this.nombreEquipo = nombreEquipo;
        this.nombreDirector = nombreDirector;
    }

    
    public List<Ciclista> getCiclistas() {
        return ciclistas;
    }

    public void setCiclistas(List<Ciclista> ciclistas) {
        this.ciclistas = ciclistas;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }
    
    
    
}
