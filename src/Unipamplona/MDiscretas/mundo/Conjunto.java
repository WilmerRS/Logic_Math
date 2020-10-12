
package Unipamplona.MDiscretas.mundo;

import java.awt.Color;
import java.util.ArrayList;


public class Conjunto {
    private String nombre;
    private ArrayList<String> elementos;
    private Color color;
    private String elementosActuales;

    public Conjunto(String nombre, ArrayList elementos, Color color) {
        this.nombre = nombre;
        this.elementos = elementos;
        this.color = color;
    }

    public ArrayList getElementos() {
        return elementos;
    }

    public String getCadenaElementos(){
        String texto = getNombre()+ " = { ";
        for (int i = 0; i < elementos.size(); i++) {
            if (i != 0) {
                texto += ", ";
            }
            texto += elementos.get(i);
        }
        texto += " }";
        return texto;
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

    public String getElementosActuales() {
        return elementosActuales;
    }

    public void setElementosActuales(String elementosActuales) {
        this.elementosActuales = elementosActuales;
    }
    
}
