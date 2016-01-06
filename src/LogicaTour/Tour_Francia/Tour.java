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
            s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rs = s.executeQuery("SELECT * FROM Equipo");
            while (rs.next()) {
                String director = rs.getString("director").trim();
                String nombre_equipo = rs.getString("nombre_equipo").trim();

                Equipo equipo = new Equipo();
                equipo.setNombre(nombre_equipo);
                equipo.setNombreDirector(director);
                equipos.put(nombre_equipo, equipo);
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
    public void addCiclistaEquipo(String nombre, String nombreEquipo) {
        if (!existeEquipo(nombreEquipo)) {
            System.out.println("NO HAY EQUIPO");//Throwear algo
        } else if (existeCiclista(nombre)) {
            System.out.println("YA EXISTE");//Throwear algo
        } else {

            System.out.println("INSERTANDO");
            Ciclista ciclista = new Ciclista(nombre, siguienteDorsal(), nombreEquipo);
            ciclistas.put(nombre, ciclista);
            equipos.get(nombreEquipo).getCiclistas().add(ciclista);
            try {
                s.executeUpdate("INSERT INTO Ciclista VALUES('" + ciclista.getNombre() + "','" + ciclista.getDorsal() + "','" + ciclista.getNombreEquipo() + "')");
            } catch (SQLException ex) {
                Logger.getLogger(Tour.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void addEquipo(String nombreEquipo, String nombreDirector) {
        if (existeEquipo(nombreEquipo)) {
            System.out.println("YA EXISTE");//Throwear algo
        } else {
            try {
                equipos.put(nombreEquipo, new Equipo(nombreEquipo, nombreDirector));

                s.executeUpdate("INSERT INTO Equipo VALUES('" + nombreDirector + "','" + nombreEquipo + "')");
            } catch (SQLException ex) {
                Logger.getLogger(Tour.class.getName()).log(Level.SEVERE, null, ex);
            }

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

    @Override
    public boolean existeCiclista(String nombre) {
        return ciclistas.containsKey(nombre);
    }

    @Override
    public boolean existeEtapa(int numeroEtapa) {
        return etapas.containsKey(numeroEtapa);
    }

    @Override
    public boolean existeEquipo(String nombreEquipo) {
        return equipos.containsKey(nombreEquipo);
    }

    private int siguienteDorsal() {
        int ret = 1;

        for (Map.Entry<String, Ciclista> entry : ciclistas.entrySet()) {
            String key = entry.getKey();
            Ciclista value = entry.getValue();
            if (value.getDorsal() > ret) {
                ret = value.getDorsal();
            }
        }
        return ret + 1;

    }

    @Override
    public Equipo getEquipo(String nombreEquipo) {
        return equipos.get(nombreEquipo);
    }

    @Override
    public Ciclista getCiclista(String nombreCiclista) {
        for (Map.Entry<String, Ciclista> entry : ciclistas.entrySet()) {
            String key = entry.getKey();
            Ciclista value = entry.getValue();

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
    public List<Equipo> getEquipos() {
        ArrayList ret = new ArrayList();
        for (Map.Entry<String, Equipo> entry : equipos.entrySet()) {
            ret.add(entry.getValue());
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

    @Override
    public void rmCiclista(String nombre) {
        try {
            ciclistas.remove(nombre);
            s.executeUpdate("DELETE FROM Ganador_Etapa WHERE numero_dorsal in (SELECT numero_dorsal from Ciclista WHERE nombre = '" + nombre + "')");
            s.executeUpdate("DELETE FROM Ganador_Puerto WHERE numero_dorsal in (SELECT numero_dorsal from Ciclista WHERE nombre = '" + nombre + "')");
            s.executeUpdate("DELETE FROM Portador_Maillot WHERE numero_dorsal in (SELECT numero_dorsal from Ciclista WHERE nombre = '" + nombre + "')");
            s.executeUpdate("DELETE FROM Ciclista WHERE nombre = '" + nombre + "'");
        } catch (SQLException ex) {
            Logger.getLogger(Tour.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modCiclistaEquipo(String nombre, String nombreEquipo) {
        try {
            rs = s.executeQuery("UPDATE Ciclista SET nombre_equipo = '" + nombreEquipo + "' WHERE nombre = '" + nombre + "'");
        } catch (SQLException ex) {
            Logger.getLogger(Tour.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void rmEquipo(String nombre) {
        try {
            equipos.remove(nombre);
            s.executeUpdate("DELETE FROM Ganador_Etapa WHERE numero_dorsal in (SELECT numero_dorsal from Ciclista WHERE nombre_equipo = '" + nombre + "')");
            s.executeUpdate("DELETE FROM Ganador_Puerto WHERE numero_dorsal in (SELECT numero_dorsal from Ciclista WHERE nombre_equipo = '" + nombre + "')");
            s.executeUpdate("DELETE FROM Portador_Maillot WHERE numero_dorsal in (SELECT numero_dorsal from Ciclista WHERE nombre_equipo = '" + nombre + "')");
            s.executeUpdate("DELETE FROM Ciclista WHERE nombre_equipo = '" + nombre + "'");
            s.executeUpdate("DELETE FROM Equipo WHERE nombre_equipo = '" + nombre + "'");
        } catch (SQLException ex) {
            Logger.getLogger(Tour.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modDirecEquipo(String nombre, String nombreDirec) {
        try {
            s.executeQuery("UPDATE Equipo SET director = '" + nombreDirec + "' WHERE nombre_equipo = '" + nombre + "'");
        } catch (SQLException ex) {
            Logger.getLogger(Tour.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Etapa getEtapa(int numeroEtapa) {
        return etapas.get(numeroEtapa);
    }

    @Override
    public List<Puerto> getPuertosEtapa(int numeroEtapa) {
        ArrayList<Puerto> puertos = new ArrayList<>();
        for (Map.Entry<String, InterfazTerreno> entry : etapas.get(numeroEtapa).getListaDesniveles().entrySet()) {
            String key = entry.getKey();
            Puerto value = (Puerto) entry.getValue();
            puertos.add(value);
        }
        return puertos;
                
    }

    @Override
    public List<Ciclista> getListaCiclistas() {
          ArrayList<Ciclista> ciclistasLista = new ArrayList<>();
        for (Map.Entry<String, Ciclista> entry : ciclistas.entrySet()) {
            String key = entry.getKey();
            Ciclista value = entry.getValue();
            ciclistasLista.add(value);
        }
        return ciclistasLista;
    }

    @Override
    public void setGanadorEtapa(int numeroEtapa, Ciclista ganadorEtapa) {
        etapas.get(numeroEtapa).setGanador_etapa(ganadorEtapa);
         try {
           if(!(s.executeQuery("UPDATE Ganador_Etapa SET numero_dorsal = '" + ganadorEtapa.getDorsal() + "' WHERE numero_etapa = '" + numeroEtapa + "'")).rowUpdated());
                s.executeQuery("INSERT INTO Ganador_Etapa VALUES('" + ganadorEtapa.getDorsal() + "', numero_etapa = '" + numeroEtapa + "')");
         } catch (SQLException ex) {
            Logger.getLogger(Tour.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
