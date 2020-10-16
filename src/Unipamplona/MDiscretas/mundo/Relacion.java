/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unipamplona.MDiscretas.mundo;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author WILMER
 */
public class Relacion {
    private String nombre;
    private ArrayList<String[]> pares;
    private Color color;

    public Relacion(String nombre, ArrayList pares, Color color) {
        this.nombre = nombre;
        this.pares = pares;
        this.color = color;
    }

    public String getCadenaElementos(){
        String texto = getNombre()+ " = { ";
        for (int i = 0; i < pares.size(); i++) {
            if (i != 0) {
                texto += ", ";
            }
            texto += "( "+pares.get(i)[0]+", "+pares.get(i)[1]+" )";
        }
        texto += " }";
        return texto;
    }
    
    public boolean existePar(String[] par){
        for (int i = 0; i < pares.size(); i++) {
            if(pares.get(i)[0].equals(par[0]) && pares.get(i)[1].equals(par[1])){
                return true;
            }
        }
        return false;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList getPares() {
        return pares;
    }

    public void setPares(ArrayList pares) {
        this.pares = pares;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    
}
