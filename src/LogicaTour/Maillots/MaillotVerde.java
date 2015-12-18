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
public class MaillotVerde implements InterfazMaillot{
    private final String codigo = "VE";
    private final String descripcion = "Verde";
    private final String tipo = "Regularidad";
    private static InterfazMaillot maillot;

    @Override
    public InterfazMaillot getMaillot(){
        if(maillot==null)
            maillot =  new MaillotVerde();
        return maillot;
    }
}
