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
    public void addCiclistaEquipo(String nombre, String nombreEquipo) {
        tour.addCiclistaEquipo(nombre, nombreEquipo);
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
    public List<Equipo> getEquipos() {
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

    @Override

    public boolean existeCiclista(String nombre) {
        return tour.existeCiclista(nombre);
    }

    @Override

    public boolean existeEtapa(int numeroEtapa) {
        return tour.existeEtapa(numeroEtapa);
    }

    @Override

    public boolean existeEquipo(String nombreEquipo) {
        return tour.existeEquipo(nombreEquipo);
    }

    @Override
    public void rmCiclista(String nombre) {
        tour.rmCiclista(nombre);
    }

    @Override
    public void modCiclistaEquipo(String nombre, String nombreEquipo) {
        tour.modCiclistaEquipo(nombre, nombreEquipo);
    }

    @Override
    public void rmEquipo(String nombre) {
        tour.rmEquipo(nombre);
    }

    @Override
    public void modDirecEquipo(String nombre, String nombreDirec) {
        tour.modDirecEquipo(nombre, nombreDirec);
    }

    @Override
    public Etapa getEtapa(int numeroEtapa) {
        return tour.getEtapa(numeroEtapa);
    }

    @Override
    public List<Puerto> getPuertosEtapa(int numeroEtapa) {
        return tour.getPuertosEtapa(numeroEtapa);
    }

    @Override
    public List<Ciclista> getListaCiclistas() {
        return tour.getListaCiclistas();
    }

    @Override
    public void setGanadorEtapa(int numeroEtapa, Ciclista ganadorEtapa) {
        tour.setGanadorEtapa(numeroEtapa, ganadorEtapa);
    }
}
