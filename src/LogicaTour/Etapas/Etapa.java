/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaTour.Etapas;

import LogicaTour.Equipos.Ciclista;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author carlo_000
 */
public class Etapa{
    private int numeroEtapa;
    private int numeroKilometros;
    private String ciudadOrigen;
    private String ciudadDestino;
    private Map<String, InterfazTerreno> listaDesniveles; 
    private Ciclista ganador_etapa;

    public Etapa() {
        listaDesniveles = new HashMap<>();
    }

    
    public void addDesnivel(InterfazTerreno desnivel){
        listaDesniveles.put(desnivel.getNombre(), desnivel);
    }
    
    public int getNumeroEtapa() {
        return numeroEtapa;
    }

    public void setNumeroEtapa(int numeroEtapa) {
        this.numeroEtapa = numeroEtapa;
    }

    public int getNumeroKilometros() {
        return numeroKilometros;
    }

    public void setNumeroKilometros(int numeroKilometros) {
        this.numeroKilometros = numeroKilometros;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }
    public Map<String,InterfazTerreno> getListaDesniveles() {
        return listaDesniveles;
    }

    public void setListaDesniveles(Map<String, InterfazTerreno> listaDesniveles) {
        this.listaDesniveles = listaDesniveles;
    }

    public Ciclista getGanador_etapa() {
        return ganador_etapa;
    }

    public void setGanador_etapa(Ciclista ganador_etapa) {
        this.ganador_etapa = ganador_etapa;
    }
    
    
}
