/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Unipamplona.MDiscretas.mundo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class OperacionesRelaciones {

    public String evaluarTodosLosTipos(String m[][]) {
        String resultado = "   ";
        Object[] reflexiva = reflexiva(m);
        Object[] simetrica = simetrica(m);
        Object[] antisimetrica = antisimetrica(m);
        Object[] transitiva = transitiva(m);

        if((boolean)reflexiva[0]){
            resultado+="Reflexiva, ";
        }
        if((boolean)simetrica[0]){
            resultado+="Simetrica, ";
        }
        if((boolean)antisimetrica[0]){
            resultado+="Antisimetrica, ";
        }
        if((boolean)transitiva[0]){
            resultado+="Transitiva, ";
        }
        if(resultado.equals("   ")){
            resultado="   La matriz ingresada no es de ningún tipo de relación.";
        }
        return resultado;
    }

    //verifica el tipo de relcion
    public Object[] reflexiva(String m[][]) {
        boolean p, q;
        Object sn[] = new Object[2];
        sn[0] = true;
        String sap[][] = new String[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                p = (j == i);
                q = (m[i][j].equals("1"));
                if (p && !q) {
                    sn[0] = false;
                    sap[i][j] = "-1";
                } else {
                    sap[i][j] = m[i][j];
                }

            }
        }
        sap[0][0] = " ";
        sn[1] = sap;
        return sn;
    }

    //verifica el tipo de relcion
    public Object[] simetrica(String m[][]) {
        Object sn[] = new Object[2];
        sn[0] = true;
        String sap[][] = new String[m.length][m[0].length];
        for (int n = 0; n < m.length; n++) {
            sap[0][n] = m[0][n];
            sap[n][0] = m[0][n];
        }
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                if (m[i][j] != m[j][i]) {
                    sn[0] = false;
                    if (m[i][j] != "1") {
                        sap[i][j] = "-1";
                    } else {
                        sap[i][j] = "1";
                    }
                } else {
                    sap[i][j] = m[i][j];
                }
            }
        }
        sn[1] = sap;
        return sn;
    }

    //verifica el tipo de relcion
    public Object[] antisimetrica(String m[][]) {
        Object sn[] = new Object[2];
        sn[0] = true;
        String sap[][] = new String[m.length][m[0].length];
        for (int n = 0; n < m.length; n++) {
            sap[0][n] = m[0][n];
            sap[n][0] = m[0][n];
        }

        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                if ((i != j) && (m[i][j].equals(m[j][i])) && !m[i][j].equals("0")) {
                    sn[0] = false;
                    sap[i][j] = "-1";
                } else {
                    sap[i][j] = m[i][j];
                }
            }
        }
        sn[1] = sap;
        return sn;
    }

    //verifica el tipo de relcion
    public Object[] transitiva(String m[][]) {
        Object sn[] = new Object[2];
        sn[0] = true;
        String sap[][] = new String[m.length][m[0].length];
        boolean b = true;
        for (int n = 0; n < m.length; n++) {
            sap[0][n] = m[0][n];
            sap[n][0] = m[0][n];
        }
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                if ((i != j) && (m[i][j].equals("1"))) {
                    for (int k = 0; k < m.length; k++) {
                        if ((j != k) && (m[j][k].equals("1")) && (m[i][k] != "1")) {
                            sn[0] = false;
                            sap[i][k] = "-1";
                        } else {
                            sap[i][j] = m[i][j];
                        }
                    }
                } else {
                    sap[i][j] = m[i][j];
                }
            }
        }
        sn[1] = sap;
        return sn;
    }
// A*B-------------------------------------------------------------------------------------------------------
//recibe dos conjuntos diferentes y hace la relacion(prodcuto carteciano)

    public ArrayList<String[]> composicionParejas(ArrayList a, ArrayList b) {
        ArrayList<String[]> union = new ArrayList();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                String[] parejas = new String[2];
                parejas[0] = (String) a.get(i);
                parejas[1] = (String) b.get(j);
                union.add(parejas);
            }
        }
        return union;
    }

    public int[] posiciones(String m[][], String x, String y) {
        int[] par = new int[2];
        par[0] = -1;
        par[1] = -1;
        //filas
        for (int i = 1; i < m.length; i++) {
            if (m[i][0].equals(y)) {
                par[0] = i;
            }
        }
        //columnas
        for (int j = 1; j < m[0].length; j++) {
            if (m[0][j].equals(x)) {
                par[1] = j;
            }
        }
        return par;
    }
//devulve la matriz de la relacion entre dos conjuntos AB

    public String[][] matrizAB(ArrayList a, ArrayList b) {
        Collections.sort(a);
        Collections.sort(b);
        int columnas = a.size() + 1;
        int filas = b.size() + 1;
        ArrayList<String[]> relaciones = composicionParejas(a, b);
        String[][] matriz = new String[filas][columnas];
        for (int i = 1; i < columnas; i++) {
            matriz[0][i] = (String) a.get(i - 1);
        }
        for (int j = 1; j < filas; j++) {
            matriz[j][0] = (String) b.get(j - 1);
        }

        for (int k = 0; k < relaciones.size(); k++) {
            String[] aux = (String[]) relaciones.get(k);
            int[] p = posiciones(matriz, aux[0], aux[1]);
            matriz[p[0]][p[1]] = "1";
            matriz[0][0] = " ";
        }
        return matriz;
    }

    //------------------------------------------------------------------------------
//devuelve la matriz de la relacion recibida como parametro y el conjunto
    public String[][] matrizA(ArrayList<String[]> relaciones, ArrayList conjunto) {
        Collections.sort(conjunto);
        String[][] matriz = new String[conjunto.size() + 1][conjunto.size() + 1];
        for (int i = 1; i < conjunto.size() + 1; i++) {
            matriz[0][i] = (String) conjunto.get(i - 1);
            matriz[i][0] = (String) conjunto.get(i - 1);
        }
        for (int k = 0; k < relaciones.size(); k++) {
            String[] aux = (String[]) relaciones.get(k);
            int[] p = posiciones(matriz, aux[0], aux[1]);
            if (p[0] == -1 || p[1] == -1) {
                return null;
            }
            matriz[p[0]][p[1]] = "1";

        }

        for (int i = 1; i < matriz.length; i++) {
            for (int j = 1; j < matriz[0].length; j++) {
                if (matriz[i][j] != "1") {
                    matriz[i][j] = "0";
                }

            }
        }
        matriz[0][0] = " ";
        return matriz;
    }

//traspuesta de una matriz
    public String[][] matrizTras(String m[][]) {
        String[][] matriz = new String[m[0].length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                matriz[j][i] = m[i][j];
            }
        }
        return matriz;
    }

    public String getCadenaElementos(ArrayList<String[]> pares){
        String texto ="  T = { ";
        for (int i = 0; i < pares.size(); i++) {
            if (i != 0) {
                texto += ", ";
            }
            texto += "( "+pares.get(i)[0]+", "+pares.get(i)[1]+" )";
        }
        texto += " }";
        return texto;
    }
    
    public ArrayList<String[]> composicionParejas(String m[][]) {
        ArrayList<String[]> relaciones = new ArrayList();
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                if (m[i][j].equals("1")) {
                    String[] par = new String[2];
                    par[0] = m[i][0];
                    par[1] = m[0][j];
                    relaciones.add(par);
                }
            }
        }
        return relaciones;
    }

    public String[][] matrizx(ArrayList<String[]> r) {
        ArrayList<String> filas = new ArrayList();
        ArrayList<String> columnas = new ArrayList();
        for (int i = 0; i < r.size(); i++) {
            filas.add(r.get(i)[0]);
            columnas.add(r.get(i)[1]);
        }
        Set<String> hashSet = new HashSet<String>(filas);
        filas.clear();
        filas.addAll(hashSet);

        hashSet = new HashSet<String>(columnas);
        columnas.clear();
        columnas.addAll(hashSet);
        return matrizComposiciones(filas, columnas, r);
    }

    public String[][] matrizComposiciones(ArrayList a, ArrayList b, ArrayList<String[]> r) {
        Collections.sort(a);
        Collections.sort(b);
        int filas = a.size() + 1;
        int columnas = b.size() + 1;
        String[][] matriz = new String[filas][columnas];
        for (int i = 1; i < filas; i++) {
            matriz[i][0] = (String) a.get(i - 1);
        }
        for (int j = 1; j < columnas; j++) {
            matriz[0][j] = (String) b.get(j - 1);
        }

        for (int k = 0; k < r.size(); k++) {
            String[] aux = (String[]) r.get(k);
            int[] p = posiciones(matriz, aux[1], aux[0]);
            matriz[p[0]][p[1]] = "1";
            matriz[0][0] = " ";
        }

        for (int i = 1; i < matriz.length; i++) {
            for (int j = 1; j < matriz[0].length; j++) {
                if (matriz[i][j] != "1") {
                    matriz[i][j] = "0";
                }
            }
        }
        return matriz;
    }

    public ArrayList<String[]> composiciones(ArrayList<String[]> x, ArrayList<String[]> y) {
        String r[][] = matrizx(x);
        String s[][] = matrizx(y);

        ArrayList<String[]> resultado = new ArrayList();
        for (int i = 1; i < r.length; i++) {
            for (int j = 1; j < r[0].length; j++) {
                if (r[i][j].equals("1")) {
                    String temp = r[0][j];
                    String temp2 = r[i][0];
                    for (int m = 1; m < s.length; m++) {
                        if (s[m][0].equals(temp)) {
                            for (int n = 1; n < s[0].length; n++) {
                                if (s[m][n].equals("1")) {
                                    String[] par = new String[2];
                                    par[0] = temp2;
                                    par[1] = s[0][n];
                                    if (!(existePar(resultado, par))) {
                                        resultado.add(par);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < s.length; i++) {
            String[] strings = s[i];
        }
        return resultado;
    }

    public boolean existePar(ArrayList<String[]> pares, String[] par) {
        for (int i = 0; i < pares.size(); i++) {
            if (pares.get(i)[0].equals(par[0]) && pares.get(i)[1].equals(par[1])) {
                return true;
            }
        }
        return false;
    }
}
