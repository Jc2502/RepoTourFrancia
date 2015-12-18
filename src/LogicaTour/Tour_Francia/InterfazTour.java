/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaTour.Tour_Francia;

import LogicaTour.Etapas.Etapa;
import java.util.List;

/**
 *
 * @author carlo_000
 */
public interface InterfazTour {
    public void addEquipo(String nombreEquipo, String nombreDirector);
    public void addCiclistaEquipo(String nombre, String apellidos, String DNI, String nombreEquipo);
    public void addEtapa(int numeroEtapa, int numeroKilometros, String ciudadOrigen, String ciudadDestino);
    public void addPuertoEtapa(int numeroEtapa, String nombre, String alturaMaxima, String categoria); 
    
}
