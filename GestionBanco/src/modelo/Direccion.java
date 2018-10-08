/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author carde
 */
public class Direccion {
    
    private String calle,ciudad;
    private int cod_post;
    
    public Direccion(String calle,String ciudad,int cod_post){
        this.calle=calle;
        this.ciudad=ciudad;
        this.cod_post=cod_post;
    }
    
}
