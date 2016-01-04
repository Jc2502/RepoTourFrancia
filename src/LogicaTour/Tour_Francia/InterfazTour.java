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
public interface InterfazTour {
    public void addEquipo(String nombreEquipo, String nombreDirector);
    public void addCiclistaEquipo(String nombre, String apellidos, String DNI, String nombreEquipo);
    public void addEtapa(int numeroEtapa, int numeroKilometros, String ciudadOrigen, String ciudadDestino);
    public void addPuertoEtapa(int numeroEtapa, String nombre, int alturaMaxima, String categoria); 
    public Equipo getEquipo(String nombreEquipo);
    public Ciclista getCiclista(String nombreCiclista);
    public List<String> getCiclistas();
    public List<Equipo> getEquipos();
    public List<Puerto> getPuertos();
    public List<Puerto> getPuertos(String categoria);
    public List<Etapa> getEtapas();
}
