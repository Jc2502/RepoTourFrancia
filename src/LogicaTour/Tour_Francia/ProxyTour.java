/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaTour.Tour_Francia;

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
    public void addPuertoEtapa(int numeroEtapa, String nombre, String alturaMaxima, String categoria) {
        tour.addPuertoEtapa(numeroEtapa, nombre, alturaMaxima, categoria);
    }
    
}
