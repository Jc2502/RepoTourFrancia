/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaTour.Tour_Francia;

import LogicaTour.Equipos.Ciclista;
import LogicaTour.Equipos.Equipo;
import LogicaTour.Etapas.Etapa;
import LogicaTour.Etapas.Puerto;
import java.util.List;

/**
 *
 * @author carlo_000
 */
public class ProxyTour implements InterfazTour {

    private Tour tour = new Tour();
    
    @Override
    public void addEquipo(String nombreEquipo, String nombreDirector) {
        tour.addEquipo(nombreEquipo, nombreDirector);
    }
    
    @Override
    public void addCiclistaEquipo(String nombre, String apellidos, String DNI, String nombreEquipo) {
        tour.addCiclistaEquipo(nombre, apellidos, DNI, nombreEquipo);
    }
    
    @Override
    public void addEtapa(int numeroEtapa, int numeroKilometros, String ciudadOrigen, String ciudadDestino) {
        tour.addEtapa(numeroEtapa, numeroKilometros, ciudadOrigen, ciudadDestino);
    }
    
    @Override
    public void addPuertoEtapa(int numeroEtapa, String nombre, int alturaMaxima, String categoria) {
        tour.addPuertoEtapa(numeroEtapa, nombre, alturaMaxima, categoria);
    }

    @Override
    public Equipo getEquipo(String nombreEquipo) {
        return tour.getEquipo(nombreEquipo);
    }

    @Override
    public Ciclista getCiclista(String nombreCiclista) {
        return tour.getCiclista(nombreCiclista);
    }

    @Override
    public List<String> getCiclistas() {
        return tour.getCiclistas();
    }

    @Override
    public List<String> getEquipos() {
        return tour.getEquipos();
    }

    @Override
    public List<Puerto> getPuertos() {
        return tour.getPuertos();
    }   
    @Override
    public List<Etapa> getEtapas() {
        return tour.getEtapas();
    }

    @Override
    public List<Puerto> getPuertos(String categoria) {
            return tour.getPuertos(categoria);
    }
    
}
