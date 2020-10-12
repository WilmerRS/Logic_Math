package Unipamplona.MDiscretas.mundo;

import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class TablaVerdad {

    private static final String SYMBOL_UNION = "+";
    private static final String SYMBOL_INTERSECCION = "*";
    private static final String SYMBOL_COMPLEMENTO = "#";
    private static final String SYMBOL_DIFERENCIA = "-";
    private static final String SYMBOL_DIFERENCIA_SIMETRICA = "^";

    private String operacionSalida;
    private int columnas;
    private int filas;
    private String[][] matrizResultado;
    private String operacionResuelta;

    public TablaVerdad() {
    }

    private int contarConjuntos(String cadena) {
        List<String> lista = new ArrayList<>();
        char n[] = cadena.toCharArray();
        for (int i = 0; i < n.length; i++) {
            char temp = n[i];
            if ((temp != '+') && (temp != '*') && (temp != '#') && (temp != '-')
                    && (temp != '^')) {
                lista.add(Character.toString(temp));
            }
        }
        //pasamos la lista a un stream ya que nos ofrece el metodo distinct el cual elimina los duplicados y retorna un stream
        //luego agrupamos el stream y lo volcamos en una lista nuevamente.
        lista = lista.stream().distinct().collect(Collectors.toList());
        return lista.size();
    }

    private List indicadorConjunto(String cadena) {
        String[] lista = cadena.split("");
        List<String> listaResultado = new ArrayList();
        for (int i = 0; i < lista.length; i++) {
            String temp = lista[i];
            if (!((temp.equals("+")) || (temp.equals("*")) || (temp.equals("#")) || (temp.equals("-"))
                    || (temp.equals("^")))) {
                listaResultado.add(temp);
            }
        }
        //pasamos la lista a un stream ya que nos ofrece el metodo distinct el cual elimina los duplicados y retorna un stream
        //luego agrupamos el stream y lo volcamos en una lista nuevamente.
        listaResultado = listaResultado.stream().distinct().collect(Collectors.toList());
        return listaResultado;
    }

    private int contarOperaciones(String cadena) {
        char n[] = cadena.toCharArray();
        int numOperaciones = 0;
        for (int i = 0; i < n.length; i++) {
            char temp = n[i];
            if ((temp == '+') || (temp == '*') || (temp == '#')) {
                numOperaciones++;
            }
            if (temp == '-') {
                numOperaciones += 2;
            }
            if (temp == '^') {
                numOperaciones += 4;
            }
        }
        return numOperaciones;
    }

    private String transConjuntos(String cadena) {
        List<String> lista = new ArrayList<>();
        char n[] = cadena.toCharArray();
        for (int i = 0; i < n.length; i++) {
            char temp = n[i];
            if ((temp != '+') && (temp != '*') && (temp != '#') && (temp != '-')
                    && (temp != '^')) {
                lista.add(Character.toString(temp));
            }
        }
        lista = lista.stream().distinct().collect(Collectors.toList());
        int c = 79;
        for (int i = 0; i < lista.size(); i++) {
            c++;
            for (int j = 0; j < n.length; j++) {
                char temp = n[j];
                String cad = Character.toString(temp);
                if (cad.equals(lista.get(i))) {
                    n[j] = (char) c;
                }
            }
        }
        return String.valueOf(n);
    }

    public void matrizSolucion(String cadena) {
        String tempCadena = cadena;
        cadena = transConjuntos(cadena);
        //declaracion de la matriz
        int n_conjuntos = contarConjuntos(cadena);
        int nTemp = n_conjuntos;
        int n_ope = contarOperaciones(cadena);
        filas = (int) pow(2, n_conjuntos) + 1;
        columnas = n_conjuntos + n_ope;
        matrizResultado = new String[filas][columnas];
        //inicalizacion de la matriz con p,q,r......
        char c;
        int temp = 79;
        for (int i = 0; i < n_conjuntos; i++) {
            temp++;
            c = (char) temp;
            String ascii = Character.toString(c);
            matrizResultado[0][i] = ascii;
        }

        int x = (int) pow(2, n_conjuntos);
        for (int j = 0; j < n_conjuntos; j++) {
            x /= 2;
            int aux = 0;
            for (int i = 1; i < filas; i++) {

                if (aux <= x) {
                    matrizResultado[i][j] = "V";
                }
                if (aux >= x) {
                    matrizResultado[i][j] = "F";
                }
                aux++;
                if (aux == x * 2) {
                    aux = 0;
                }
            }
        }
        String primera = cadena;
        String resultado = "";
        Stack pilaEntrada = new Stack();
        Stack pilaSalida = new Stack();
        for (int i = primera.length() - 1; i >= 0; i--) {
            pilaEntrada.push(primera.charAt(i));
        }

        Object temp1;
        Object temp2;
        Object temp3;
        Object temp4;
        Object temp5;

        String var1;
        String var2;
        String var3;
        String var4;
        String var5;
        int aux = 0, f = 0, k = 0, l = 0, a = 0;
        try {
            while (!pilaEntrada.isEmpty()) {
//                if(pilaEntrada.peek().toString().equals("-")){
                switch (pilaEntrada.peek().toString()) {
                    case SYMBOL_UNION:
                        temp1 = pilaSalida.pop();
                        temp2 = pilaSalida.pop();
                        pilaSalida.add("( " + temp2 + " v " + temp1 + " ) ");
                        matrizResultado[0][n_conjuntos] = (String) pilaSalida.peek();
                        var1 = temp1.toString();
                        var2 = temp2.toString();
                        for (int h = 0; h < n_conjuntos; h++) {

                            if (matrizResultado[0][h].equals(var1)) {
                                f = h;
                            }
                            if (matrizResultado[0][h].equals(var2)) {
                                k = h;
                            }
                        }
                        for (int j = 1; j < filas; j++) {
                            boolean p = true;
                            boolean q = true;
                            if (matrizResultado[j][f].equals("F")) {
                                p = false;
                            }
                            if (matrizResultado[j][k].equals("F")) {
                                q = false;
                            }
                            if (p || q) {
                                matrizResultado[j][n_conjuntos] = "V";
                            } else {
                                matrizResultado[j][n_conjuntos] = "F";
                            }
                        }
                        n_conjuntos++;
                        pilaEntrada.pop();
                        break;
                    case SYMBOL_INTERSECCION:
                        temp1 = pilaSalida.pop();
                        temp2 = pilaSalida.pop();
                        pilaSalida.add("( " + temp2 + " ^ " + temp1 + " ) ");
                        matrizResultado[0][n_conjuntos] = (String) pilaSalida.peek();

                        var1 = temp1.toString();
                        var2 = temp2.toString();
                        for (int h = 0; h < n_conjuntos; h++) {

                            if (matrizResultado[0][h].equals(var1)) {
                                f = h;
                            }
                            if (matrizResultado[0][h].equals(var2)) {
                                k = h;
                            }
                        }
                        for (int j = 1; j < filas; j++) {
                            boolean p = true;
                            boolean q = true;
                            if (matrizResultado[j][f].equals("F")) {
                                p = false;
                            }
                            if (matrizResultado[j][k].equals("F")) {
                                q = false;
                            }
                            if (p && q) {
                                matrizResultado[j][n_conjuntos] = "V";
                            } else {
                                matrizResultado[j][n_conjuntos] = "F";
                            }
                        }
                        n_conjuntos++;
                        pilaEntrada.pop();
                        break;
                    case SYMBOL_COMPLEMENTO:
                        temp1 = pilaSalida.pop();
                        pilaSalida.add("( " + "¬ " + temp1 + " )");
                        matrizResultado[0][n_conjuntos] = (String) pilaSalida.peek();
                        var1 = temp1.toString();
                        for (int h = 0; h < n_conjuntos; h++) {

                            if (matrizResultado[0][h].equals(var1)) {
                                f = h;
                            }
                        }
                        for (int j = 1; j < filas; j++) {
                            boolean p = true;
                            if (matrizResultado[j][f].equals("F")) {
                                p = false;
                            }
                            if (!p) {
                                matrizResultado[j][n_conjuntos] = "V";
                            } else {
                                matrizResultado[j][n_conjuntos] = "F";
                            }
                        }
                        n_conjuntos++;
                        pilaEntrada.pop();
                        break;
                    case SYMBOL_DIFERENCIA:
                        temp1 = pilaSalida.pop();
                        temp3 = pilaSalida.pop();
                        temp2 = ("( " + "¬ " + temp1 + " )");
                        matrizResultado[0][n_conjuntos] = (String) temp2;
                        n_conjuntos++;
                        pilaSalida.add("( " + temp3 + " ^ " + temp2 + " ) ");
                        matrizResultado[0][n_conjuntos] = (String) pilaSalida.peek();
                        var1 = temp1.toString();
                        var2 = temp2.toString();
                        var3 = temp3.toString();

                        for (int h = 0; h < n_conjuntos; h++) {
                            if (matrizResultado[0][h].equals(var2)) {
                                aux = h;
                            }
                            if (matrizResultado[0][h].equals(var3)) {
                                f = h;
                            }
                            if (matrizResultado[0][h].equals(var1)) {
                                k = h;
                            }
                        }

                        for (int j = 1; j < filas; j++) {

                            boolean p = true;
                            boolean q = true;
                            if (matrizResultado[j][k].equals("F")) {
                                matrizResultado[j][aux] = "V";
                            } else {
                                matrizResultado[j][aux] = "F";
                            }
                            if (matrizResultado[j][k].equals("F")) {
                                q = false;
                            }
                            if (matrizResultado[j][f].equals("F")) {
                                p = false;
                            }
                            if (p && !q) {
                                matrizResultado[j][n_conjuntos] = "V";
                            } else {
                                matrizResultado[j][n_conjuntos] = "F";
                            }
                        }
                        n_conjuntos++;
                        pilaEntrada.pop();
                        break;
                    case SYMBOL_DIFERENCIA_SIMETRICA:
                        temp1 = pilaSalida.pop();
                        temp2 = pilaSalida.pop();
                        temp3 = ("( " + temp2 + " v " + temp1 + " ) ");
                        temp4 = ("( " + temp2 + " ^ " + temp1 + " ) ");
                        temp5 = ("¬ " + "( " + temp2 + " ^ " + temp1 + " ) ");
                        matrizResultado[0][n_conjuntos] = (String) temp3;
                        n_conjuntos++;
                        matrizResultado[0][n_conjuntos] = (String) temp4;
                        n_conjuntos++;
                        matrizResultado[0][n_conjuntos] = (String) temp5;
                        n_conjuntos++;
                        pilaSalida.add("( " + temp2 + " v " + temp1 + " ) " + "^ ¬" + " ( " + temp2 + " ^ " + temp1 + " )");
                        matrizResultado[0][n_conjuntos] = (String) pilaSalida.peek();
                        var1 = temp1.toString();
                        var2 = temp2.toString();
                        var3 = temp3.toString();
                        var4 = temp4.toString();
                        var5 = temp5.toString();
                        for (int h = 0; h < n_conjuntos; h++) {
                            if (matrizResultado[0][h].equals(var1)) {
                                f = h;
                            }
                            if (matrizResultado[0][h].equals(var2)) {
                                k = h;
                            }
                            if (matrizResultado[0][h].equals(var3)) {
                                l = h;
                            }
                            if (matrizResultado[0][h].equals(var4)) {
                                a = h;
                            }
                            if (matrizResultado[0][h].equals(var5)) {
                                aux = h;
                            }

                        }
                        for (int j = 1; j < filas; j++) {
                            boolean p = true;
                            boolean q = true;

                            if (matrizResultado[j][f].equals("F")) {
                                p = false;
                            }
                            if (matrizResultado[j][k].equals("F")) {
                                q = false;
                            }
                            //union
                            if (p || q) {
                                matrizResultado[j][l] = "V";
                            } else {
                                matrizResultado[j][l] = "F";
                            }
                            //interseccion
                            if (p && q) {
                                matrizResultado[j][a] = "V";
                            } else {
                                matrizResultado[j][a] = "F";
                            }
                            //negacion
                            if (matrizResultado[j][a].equals("V")) {
                                matrizResultado[j][aux] = "F";
                            } else {
                                matrizResultado[j][aux] = "V";
                            }
                            //simetrica
                            if (matrizResultado[j][l].equals("V")) {
                                p = true;
                            } else {
                                p = false;
                            }
                            if (matrizResultado[j][aux].equals("V")) {
                                q = true;
                            } else {
                                q = false;
                            }
                            if (p && q) {
                                matrizResultado[j][n_conjuntos] = "V";
                            } else {
                                matrizResultado[j][n_conjuntos] = "F";
                            }
                        }
                        n_conjuntos++;
                        pilaEntrada.pop();
                        break;
                    default:
                        pilaSalida.add(pilaEntrada.pop());
                }
            }
        } catch (Exception e) {
            resultado = "ERROR";
        }
        List<String> lista = indicadorConjunto(tempCadena);
        temp = 79;
        for (int i = 0; i < nTemp; i++) {
            temp++;
            c = (char) temp;
            String ascii = Character.toString(c);
            matrizResultado[0][i] = ascii + " ( " + lista.get(i) + " )";
        }
//        operacionResuelta = voltearLetras(matrizResultado[0][columnas - 1]);
        operacionResuelta = matrizResultado[0][columnas - 1];

    }

    private String voltearLetras(String cadena) {
        String[] vector = cadena.split("");
        String respuesta = "";
        for (int i = vector.length - 1; i >= 0; i--) {
//            if (vector[i].equals("(")) {
//                vector[i] = ")";
//            } else if (vector[i].equals(")")) {
//                vector[i] = "(";
//            } else if (vector[i].equals("¬")) {
//                respuesta += vector[i + 2];
//                respuesta += vector[i + 4];
//                respuesta += vector[i + 3];
//                respuesta += vector[i + 2];
//                respuesta += vector[i + 1];
//                respuesta += vector[i];
//                i -= 4;
//                System.out.println("2");
//                if (!flag) {
//                    String c = vector[i];
//                    System.out.println(c);
//
//                    vector[i] = vector[i + 2];
//                    System.out.println(vector[i]);
//
//                    vector[i + 2] = c;
//                    System.out.println(vector[i + 2]);
//                    flag = true;
//                }
//            }
            respuesta += vector[i];
        }
        return respuesta;
    }

    public String getOperacionResuelta() {
        return operacionResuelta;
    }

    public int getColumnas() {
        return columnas;
    }

    public int getFilas() {
        return filas;
    }

    public String[][] getMatrizResultado() {
        return matrizResultado;
    }
}
