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
import java.sql.*;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo_000
 */
public class Tour implements InterfazTour {

    private Map<String, Equipo> equipos;
    private Map<String, Ciclista> ciclistas;
    private Map<Integer, Etapa> etapas;
    private Connection c;
    private Statement s;
    private ResultSet rs;
    private ResultSetMetaData rsmd;

    public Tour() {
        try {
            Class.forName(("sun.jdbc.odbc.JdbcOdbcDriver"));

            c = DriverManager.getConnection("jdbc:odbc:OrigenDatos", "", "");
            s = c.createStatement();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tour.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Tour.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addCiclistaEquipo(String nombre, String apellidos, String dni, String nombreEquipo) {
        if (!existeEquipo(nombreEquipo)) {
            System.out.println("NO HAY EQUIPO");//Throwear algo
        } else if (existeCiclista(dni)) {
            System.out.println("YA EXISTE");//Throwear algo
        } else {
            Ciclista ciclista = new Ciclista(nombre, apellidos, siguienteDorsal(), nombreEquipo, dni);
            ciclistas.put(dni, ciclista);
            equipos.get(nombreEquipo).getCiclistas().add(ciclista);
        }

    }

    @Override
    public void addEquipo(String nombreEquipo, String nombreDirector) {
        if (existeEquipo(nombreEquipo)) {
            System.out.println("YA EXISTE");//Throwear algo
        } else {
            equipos.put(nombreEquipo, new Equipo(nombreEquipo, nombreDirector));
        }

    }

    @Override
    public void addEtapa(int numeroEtapa, int numeroKilometros, String ciudadOrigen, String ciudadDestino) {
        if (!etapas.containsKey(numeroEtapa)) {
            etapas.put(numeroEtapa, new Etapa(numeroEtapa, numeroKilometros, ciudadOrigen, ciudadDestino));
        } else {
            System.out.println("YA EXISTE");//Throwear algo
        }
    }

    @Override
    public void addPuertoEtapa(int numeroEtapa, String nombre, String alturaMaxima, String categoria) {
        if (existeEtapa(numeroEtapa)) {
            if (!etapas.get(numeroEtapa).getListaDesniveles().containsKey(nombre)) {
                etapas.get(numeroEtapa).getListaDesniveles().put(nombre, new Puerto(nombre, alturaMaxima, categoria));
            } else {
                System.out.println("YA EXISTE EL PUERTO");//Throwear algo
            }
        } else {
            System.out.println("NO EXISTE LA ETAPA");//Throwear algo
        }

    }

    private boolean existeCiclista(String DNI) {
        return ciclistas.containsKey(DNI);
    }

    private boolean existeEtapa(int numeroEtapa) {
        return etapas.containsKey(numeroEtapa);
    }

    private boolean existeEquipo(String nombreEquipo) {
        return equipos.containsKey(nombreEquipo);
    }

    private int siguienteDorsal() {
        int ret = 1;
        try {
            rs = s.executeQuery("SELECT max(dorsal)+1 FROM Ciclistas");
            ret = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Tour.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return ret;
        }

    }

}
