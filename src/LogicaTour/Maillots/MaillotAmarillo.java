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
public class MaillotAmarillo implements InterfazMaillot{
    private final String codigo = "AM";
    private final String descripcion = "Amarillo";
    private final String tipo = "General";
    private static InterfazMaillot maillot;

    @Override
    public InterfazMaillot getMaillot(){
        if(maillot==null)
            maillot =  new MaillotAmarillo();
        return maillot;
    }
}
