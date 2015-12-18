/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaTour.Maillots;

/**
 *
 * @author carlo_000
 */
public class MaillotPuntosRojos implements InterfazMaillot{
    private final String codigo = "PR";
    private final String descripcion = "Puntos Rojos";
    private final String tipo = "Montaña";
    private static InterfazMaillot maillot;

    @Override
    public InterfazMaillot getMaillot(){
        if(maillot==null)
            maillot =  new MaillotPuntosRojos();
        return maillot;
    }
}
