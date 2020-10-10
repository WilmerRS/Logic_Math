
package Unipamplona.MDiscretas.mundo;

import java.awt.Color;
import java.util.ArrayList;


public class Conjunto {
    private String nombre;
    private ArrayList<String> elementos;
    private Color color;

    public Conjunto(String nombre, ArrayList elementos, Color color) {
        this.nombre = nombre;
        this.elementos = elementos;
        this.color = color;
    }

    public ArrayList getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList elementos) {
        this.elementos = elementos;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
