/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unipamplona.MDiscretas.mundo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author WILMER
 */
public class OperacionesConjuntos {

    private final String SYMBOL_UNION = "+";
    private final String SYMBOL_INTERSECCION = "*";
    private final String SYMBOL_COMPLEMENTO = "#";
    private final String SYMBOL_DIFERENCIA = "-";
    private final String SYMBOL_DIFERENCIA_SIMETRICA = "^";

    private ArrayList<String> universo;
    private Conjuntos conjuntos;

    public OperacionesConjuntos(Conjuntos conjuntos) {
        this.universo = crearUniverso();
        this.conjuntos = conjuntos;
    }

    ArrayList<String> crearUniverso() {
        ArrayList<String> temp = new ArrayList();
        for (int j = 0; j <= 9; j++) {
            temp.add(j + "");
        }
        for (int i = 97; i < 123; i++) {
            char caracter = (char) i;
            temp.add(caracter + "");
        }

        return temp;
    }

    ArrayList<String> interseccion(ArrayList conjunto_a, ArrayList conjunto_b) {
        ArrayList<String> resultado = new ArrayList();
        boolean p, q;
        for (int i = 0; i < universo.size(); i++) {
            p = conjunto_a.contains(universo.get(i));
            q = conjunto_b.contains(universo.get(i));
            if (p && q) {
                resultado.add((String) universo.get(i));
            }
        }
        return resultado;
    }

    ArrayList<String> union(ArrayList conjunto_a, ArrayList conjunto_b) {
        ArrayList<String> resultado = new ArrayList();
        boolean p, q;
        for (int i = 0; i < universo.size(); i++) {
            p = conjunto_a.contains(universo.get(i));
            q = conjunto_b.contains(universo.get(i));
            if (p || q) {
                resultado.add((String) universo.get(i));
            }
        }
        return resultado;
    }

    ArrayList<String> diferencia(ArrayList conjunto_a, ArrayList conjunto_b) {
        ArrayList<String> resultado = new ArrayList();
        boolean p, q;
        for (int i = 0; i < universo.size(); i++) {
            p = conjunto_a.contains(universo.get(i));
            q = conjunto_b.contains(universo.get(i));
            if (p && !q) {
                resultado.add((String) universo.get(i));
            }
        }

        return resultado;
    }

    ArrayList<String> diferenciaSimetrica(ArrayList conjunto_a, ArrayList conjunto_b) {
        ArrayList<String> resultado = new ArrayList();
        boolean p, q;
        for (int i = 0; i < universo.size(); i++) {
            p = conjunto_a.contains(universo.get(i));
            q = conjunto_b.contains(universo.get(i));
            if ((p || q) && !(p && q)) {
                resultado.add((String) universo.get(i));
            }
        }
        return resultado;
    }

    ArrayList<String> complemento(ArrayList conjunto_a) {
        ArrayList<String> resultado = new ArrayList();
        boolean p;
        for (int i = 0; i < universo.size(); i++) {
            p = conjunto_a.contains(universo.get(i));
            if (!p) {
                resultado.add((String) universo.get(i));
            }
        }
        return resultado;
    }

    public Conjunto resultadoConjunto(String cadena) {
        String primera = cadena;
        Stack pilaEntrada = new Stack();
        Stack pilaSalida = new Stack();
        ArrayList conjuntoRespuesta = null;
        for (int i = primera.length() - 1; i >= 0; i--) {
            pilaEntrada.push(primera.charAt(i));
        }
        try {
            while (!pilaEntrada.isEmpty()) {
                switch (pilaEntrada.peek().toString()) {
                    case SYMBOL_UNION:
                        pilaSalida.push(union((ArrayList) pilaSalida.pop(), (ArrayList) pilaSalida.pop()));
                        pilaEntrada.pop();
                        break;
                    case SYMBOL_INTERSECCION:
                        pilaSalida.push(interseccion((ArrayList) pilaSalida.pop(), (ArrayList) pilaSalida.pop()));
                        pilaEntrada.pop();
                        break;
                    case SYMBOL_COMPLEMENTO:
                        pilaSalida.push(complemento((ArrayList) pilaSalida.pop()));
                        pilaEntrada.pop();
                        break;

                    case SYMBOL_DIFERENCIA:
                        pilaSalida.push(diferencia((ArrayList) pilaSalida.pop(), (ArrayList) pilaSalida.pop()));
                        pilaEntrada.pop();
                        break;
                    case SYMBOL_DIFERENCIA_SIMETRICA:
                        pilaSalida.push(diferenciaSimetrica((ArrayList) pilaSalida.pop(), (ArrayList) pilaSalida.pop()));
                        pilaEntrada.pop();
                        break;
                    default:
                        Conjunto aux = buscarConjunto(pilaEntrada.pop() + "");
                        ArrayList h = aux.getElementos();
                        pilaSalida.push(h);
                }
            }

            if (pilaSalida.size() == 1) {
                conjuntoRespuesta = (ArrayList) pilaSalida.peek();
            }else{
                return  null;
            }
        } catch (Exception e) {
            return  null;
        }
        return new Conjunto(conjuntos.getNombreRecomendado(), conjuntoRespuesta, conjuntos.getColorRecomendado());
    }

    private Conjunto buscarConjunto(String nombre) {
        int posConjunto = conjuntos.buscarConjunto(nombre);
        Conjunto A = new Conjunto(nombre, new ArrayList<>(), conjuntos.getColorRecomendado());
        if (posConjunto != -1) {
            A = conjuntos.getConjuntos().get(posConjunto);
        } else {
            conjuntos.addConjunto(A);
        }
        return A;
    }
}
