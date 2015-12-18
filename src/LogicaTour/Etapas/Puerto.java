/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaTour.Etapas;

/**
 *
 * @author carlo_000
 */
public class Puerto implements InterfazTerreno {
    private String nombre;
    private String alturaMaxima;
    private String categoria;
    private int dorsalGanador;

    public Puerto(String nombre, String alturaMaxima, String categoria) {
        this.nombre = nombre;
        this.alturaMaxima = alturaMaxima;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlturaMaxima() {
        return alturaMaxima;
    }

    public void setAlturaMaxima(String alturaMaxima) {
        this.alturaMaxima = alturaMaxima;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getDorsalGanador() {
        return dorsalGanador;
    }

    public void setDorsalGanador(int dorsalGanador) {
        this.dorsalGanador = dorsalGanador;
    }
    
   
}
