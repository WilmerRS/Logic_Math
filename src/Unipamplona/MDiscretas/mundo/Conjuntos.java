package Unipamplona.MDiscretas.mundo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Conjuntos {

    private final String CONJUNTOS = "CONJUNTOS";
    private final String HISTORIAL = "HISTORIAL";

    private ArrayList<Conjunto> conjuntos;

    public Conjuntos(String TIPO) {
        conjuntos = new ArrayList<>();
        crearConjuntosIciales(TIPO);
    }

    /**
     * *
     * Permite inicializar los conjutnos por defecto qu etraerá el programa al
     * inicial
     *
     * @param TIPO: Tipo de conjuntos a crear, Conjutnos o Historial
     */
    private void crearConjuntosIciales(String TIPO) {
        switch (TIPO) {
            case CONJUNTOS:
                ArrayList a = new ArrayList();
                a.add("1");
                a.add("2");
                a.add("3");

                ArrayList b = new ArrayList();
                b.add("x");
                b.add("y");
                b.add("z");

                ArrayList c = new ArrayList();
                c.add("a");
                c.add("b");
                c.add("c");

                conjuntos.add(new Conjunto("A", a, getColorRecomendado()));
                conjuntos.add(new Conjunto("B", b, getColorRecomendado()));
                conjuntos.add(new Conjunto("C", c, getColorRecomendado()));
                break;
            case HISTORIAL:
                ArrayList h = new ArrayList();
                h.add("1");
                h.add("2");
                h.add("3");
                h.add("x");
                h.add("y");
                h.add("z");
                conjuntos.add(new Conjunto("( A Uni B ) Ints ( Compl ( C ) )", h, getColorRecomendado()));
                break;
        }

    }

    public ArrayList<Conjunto> getConjuntos() {
        return conjuntos;
    }

    public int buscarConjunto(String nombre) {
        int i = 0;
        for (Conjunto conjunto : conjuntos) {
            if (conjunto.getNombre().equals(nombre)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public String getNombreRecomendado() {
        char c = 65;
        for (Conjunto conjunto : conjuntos) {
            if (buscarConjunto(Character.toString(c)) == -1) {
                return Character.toString(c);
            }
            c++;
        }
        return Character.toString(c);
    }

    public Color getColorRecomendado() {
        Random random = new Random(); 
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return new Color(red, green, blue);
    }

    public void addConjunto(Conjunto conjunto) {
        conjuntos.add(conjunto);
    }

    public void reemplazarConjunto(Conjunto conjunto, int i) {
        conjuntos.set(i, conjunto);
    }

    public void eliminarConjunto(Conjunto conjunto) {
        conjuntos.remove(conjunto);
    }

    public void eliminarTodo() {
        while (!conjuntos.isEmpty()) {
            conjuntos.remove(conjuntos.size() - 1);
        }
    }
}
