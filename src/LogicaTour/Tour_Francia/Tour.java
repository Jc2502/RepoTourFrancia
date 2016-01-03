/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaTour.Tour_Francia;

import LogicaTour.Equipos.Ciclista;
import LogicaTour.Equipos.Equipo;
import LogicaTour.Etapas.Etapa;
import LogicaTour.Etapas.InterfazTerreno;
import LogicaTour.Etapas.Puerto;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import sun.jdbc.odbc.JdbcOdbcDriver;

/**
 *
 * @author carlo_000
 */
public class Tour implements InterfazTour {

    private HashMap<String, Equipo> equipos;
    private HashMap<String, Ciclista> ciclistas;
    private HashMap<Integer, Etapa> etapas;
    private Connection c;
    private Statement s;
    private ResultSet rs;
    private ResultSetMetaData rsmd;

    public Tour() {
        ciclistas = new HashMap<>();
        equipos = new HashMap<>();
        etapas = new HashMap<>();
        try {
            Class.forName(("sun.jdbc.odbc.JdbcOdbcDriver"));

            c = DriverManager.getConnection("jdbc:odbc:OrigenDatos", "", "");
            s = c.createStatement();

            rs = s.executeQuery("SELECT * FROM Equipo");
            while (rs.next()) {
                String director = rs.getString("director").trim();
                String nombre_equipo = rs.getString("nombre_equipo").trim();

                Equipo equipo = new Equipo();
                equipo.setNombre(nombre_equipo);
                equipo.setNombreDirector(director);
                equipos.put(nombre_equipo, equipo);

                System.out.println(equipo.getNombre());
                System.out.println(equipo.getNombreDirector());
            }

            rs = s.executeQuery("SELECT * FROM Ciclista");
            while (rs.next()) {
                String nombre = rs.getString("nombre").trim();
                int numDorsal = rs.getInt("numero_dorsal");
                String nombre_equipo = rs.getString("nombre_equipo").trim();

                Ciclista ciclista = new Ciclista();
                ciclista.setNombre(nombre);
                ciclista.setDorsal(numDorsal);
                ciclista.setNombreEquipo(nombre_equipo);
                if (equipos.containsKey(nombre_equipo)) {
                    equipos.get(nombre_equipo).getCiclistas().add(ciclista);
                }
                ciclistas.put(nombre, ciclista);
            }

            rs = s.executeQuery("SELECT * FROM Etapa");
            while (rs.next()) {
                int numero_etapa = rs.getInt("numero_etapa");
                int kilometros = rs.getInt("kilometros");
                String ciudad_origen = rs.getString("ciudad_origen").trim();
                String ciudad_destino = rs.getString("ciudad_destino").trim();

                Etapa etapa = new Etapa();
                etapa.setCiudadDestino(ciudad_destino);
                etapa.setCiudadOrigen(ciudad_origen);
                etapa.setNumeroKilometros(kilometros);
                etapa.setNumeroEtapa(numero_etapa);
                etapas.put(numero_etapa, etapa);
            }

            rs = s.executeQuery("SELECT * FROM Ganador_Etapa");
            while (rs.next()) {
                int numero_etapa = rs.getInt("numero_etapa");
                int numero_dorsal = rs.getInt("numero_dorsal");

                for (Map.Entry<String, Ciclista> entry : ciclistas.entrySet()) {
                    String key = entry.getKey();
                    Ciclista value = entry.getValue();
                    if (value.getDorsal() == numero_dorsal) {
                        etapas.get(numero_etapa).setGanador_etapa(value);
                    }
                }
            }
            rs = s.executeQuery("SELECT * FROM Puerto");
            while (rs.next()) {
                int altura = rs.getInt("altura");
                int numero_etapa = rs.getInt("numero_etapa");
                String nombre = rs.getString("nombre").trim();
                String categoria = rs.getString("categoria").trim();
                Puerto p = new Puerto();
                p.setAlturaMaxima(altura);
                p.setCategoria(categoria);
                p.setNombre(nombre);

                etapas.get(numero_etapa).addDesnivel(p);
            }
            rs = s.executeQuery("SELECT * FROM Ganador_Puerto");
            while (rs.next()) {
                String nombre = rs.getString("nombre").trim();
                int numero_dorsal = rs.getInt("numero_dorsal");

                for (Map.Entry<Integer, Etapa> entry : etapas.entrySet()) {
                    int key = entry.getKey();
                    Etapa value = entry.getValue();
                    for (Iterator iterator = value.getListaDesniveles().values().iterator(); iterator.hasNext();) {
                        Puerto next = (Puerto) iterator.next();
                        if (next.getNombre().equals(nombre)) {
                            next.setDorsalGanador(numero_dorsal);
                        }

                    }

                }
            }

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
            Etapa etapa = new Etapa();
            etapa.setCiudadDestino(ciudadDestino);
            etapa.setCiudadOrigen(ciudadOrigen);
            etapa.setNumeroEtapa(numeroEtapa);
            etapa.setNumeroKilometros(numeroKilometros);
            etapas.put(numeroEtapa, etapa);

        } else {
            System.out.println("YA EXISTE");//Throwear algo
        }
    }

    @Override
    public void addPuertoEtapa(int numeroEtapa, String nombre, int alturaMaxima, String categoria) {
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

    @Override
    public Equipo getEquipo(String nombreEquipo) {
        return equipos.get(nombreEquipo);
    }

    public Ciclista getCiclista(String nombreCiclista) {
        for (Map.Entry<String, Ciclista> entry : ciclistas.entrySet()) {
            String key = entry.getKey();
            Ciclista value = entry.getValue();
            System.out.println(key + " " + value.getNombreEquipo());

        }
        return ciclistas.get(nombreCiclista);
    }

    @Override
    public List<String> getCiclistas() {
        ArrayList ret = new ArrayList();
        for (Map.Entry<String, Ciclista> entry : ciclistas.entrySet()) {
            String key = entry.getKey();
            ret.add(key);
        }
        return ret;
    }

    @Override
    public List<String> getEquipos() {
        ArrayList ret = new ArrayList();
        for (Map.Entry<String, Equipo> entry : equipos.entrySet()) {
            String key = entry.getKey();
            ret.add(key);
        }
        return ret;
    }

    @Override
    public List<Puerto> getPuertos() {
        ArrayList ret = new ArrayList();
        for (Map.Entry<Integer, Etapa> entry : etapas.entrySet()) {
            Etapa value = entry.getValue();
            for (Iterator iterator = value.getListaDesniveles().values().iterator(); iterator.hasNext();) {
                Puerto next = (Puerto) iterator.next();
                ret.add(next);
            }
        }
        return ret;
    }

    @Override
    public List<Etapa> getEtapas() {
        ArrayList ret = new ArrayList();
        for (Map.Entry<Integer, Etapa> entry : etapas.entrySet()) {
            Etapa value = entry.getValue();
            ret.add(value);
        }
        return ret;
    }

    @Override
    public List<Puerto> getPuertos(String categoria) {
        ArrayList ret = new ArrayList();
        for (Map.Entry<Integer, Etapa> entry : etapas.entrySet()) {
            Etapa value = entry.getValue();
            for (Iterator iterator = value.getListaDesniveles().values().iterator(); iterator.hasNext();) {
                Puerto next = (Puerto) iterator.next();
                if (next.getCategoria().equals(categoria)) {
                    ret.add(next);
                }

            }
        }
        return ret;
    }
}
