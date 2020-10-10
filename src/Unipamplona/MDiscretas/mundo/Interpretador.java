/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unipamplona.MDiscretas.mundo;

import java.util.Stack;

/**
 *
 * @author WILMER
 */
public class Interpretador {

    private static final String UNION = "UNI";
    private static final String INTERSECCION = "INTS";
    private static final String COMPLEMENTO = "COMPL";
    private static final String DIFERENCIA = "DIF";
    private static final String DIFERENCIA_SIMETRICA = "SIM";

    private static final String SYMBOL_UNION = "+";
    private static final String SYMBOL_INTERSECCION = "*";
    private static final String SYMBOL_COMPLEMENTO = "#";
    private static final String SYMBOL_DIFERENCIA = "-";
    private static final String SYMBOL_DIFERENCIA_SIMETRICA = "^";
    private static final String SYMBOL_PARENTESIS_ABIERTO = "(";
    private static final String SYMBOL_PARENTESIS_CERRADO = ")";

    private String transpilacion;

    private String analizarCadena(String entrada) {
        String[] arrayTemp = entrada.toUpperCase().split("");

        transpilacion = "";
        for (int i = 0; i < arrayTemp.length; i++) {
//            System.out.print(arrayTemp[i]  + "" );
            switch (arrayTemp[i]) {
                case " ": // Espacio vacio
                    break;
                case "U": // Posible union - UNI
                    i = agregarToken(arrayTemp, i, (i + 2), UNION, SYMBOL_UNION);
                    break;
                case "I": // Posible interseccion - INTS
                    i = agregarToken(arrayTemp, i, (i + 3), INTERSECCION, SYMBOL_INTERSECCION);
                    break;
                case "C": // Posible complemento - COMPL
                    i = agregarToken(arrayTemp, i, (i + 4), COMPLEMENTO, SYMBOL_COMPLEMENTO);
                    break;
                case "D": // Posible diferencia - DIF
                    i = agregarToken(arrayTemp, i, (i + 2), DIFERENCIA, SYMBOL_DIFERENCIA);
                    break;
                case "S": // Posible diferencia simetrica - DIF_SIM
                    i = agregarToken(arrayTemp, i, (i + 2), DIFERENCIA_SIMETRICA, SYMBOL_DIFERENCIA_SIMETRICA);
                    break;
                default:
                    transpilacion += arrayTemp[i];
            }
        }
        return transpilacion;
    }

    
    private int agregarToken(String[] arrayTemp, int inicial, int fin, String operacion, String simbolo) {
        String temp = "";
        for (int i = inicial; i < fin + 1; i++) {
            try {
                temp += arrayTemp[i];
            } catch (Exception e) {
                transpilacion += arrayTemp[inicial];
                return inicial;
            }
        }
        int i = inicial;
        if (temp.equals(operacion)) {
            transpilacion += simbolo;
            i = i + temp.length() - 1;
        } else {
            transpilacion += arrayTemp[inicial];
            return inicial;
        }
        return i;
    }

    public String descomponerOperacion(String entrada) {
        String primera = analizarCadena(entrada);
        String resultadoStr = "";

        Stack pilaResultado = new Stack();
        Stack pilaEntrada = new Stack();
        Stack pilaOperadores = new Stack();

        //LLenar la pila de entrada
        for (int i = primera.length() - 1; i >= 0; i--) {
            pilaEntrada.push(primera.charAt(i));
        }

        try {
            while (!pilaEntrada.isEmpty()) {
                switch (pilaEntrada.peek().toString()) {
                    case SYMBOL_PARENTESIS_ABIERTO:
                        pilaOperadores.push(pilaEntrada.pop());
                        break;
                    case SYMBOL_PARENTESIS_CERRADO:
                        while (!(pilaOperadores.peek().equals('('))) {
                            pilaResultado.push(pilaOperadores.pop());
                        }
                        pilaEntrada.pop();
                        pilaOperadores.pop();
                        try {
                            if (pilaOperadores.peek().equals('#')) {
                                pilaResultado.push(pilaOperadores.pop());
                            }
                        } catch (Exception e) {
                        }
                        break;
                    case SYMBOL_UNION: // +
                        try {
                            while (pilaOperadores.peek().equals('*')) {
                                pilaResultado.push(pilaOperadores.pop());
                            }
                        } catch (Exception e) {
                        }
                        pilaOperadores.push(pilaEntrada.pop());
                        break;
                    case SYMBOL_INTERSECCION:
                        pilaOperadores.push(pilaEntrada.pop());
                        break;
                    case SYMBOL_COMPLEMENTO:
                        pilaOperadores.push(pilaEntrada.pop());
                        if (!pilaEntrada.peek().equals('(')) {
                            throw new Exception("");
                        }
                        break;
                    case SYMBOL_DIFERENCIA:
                        pilaOperadores.push(pilaEntrada.pop());
                        break;
                    case SYMBOL_DIFERENCIA_SIMETRICA:
                        pilaOperadores.push(pilaEntrada.pop());
                        break;
                    default:
                        pilaResultado.push(pilaEntrada.pop());
                }
            }
            while (!pilaOperadores.isEmpty()) {
                pilaResultado.push(pilaOperadores.pop());
            }

        } catch (Exception e) {
            return "ERROR";
        }
        // COnvierte pila en string
        for (int i = 0; i < pilaResultado.size(); i++) {
            resultadoStr += pilaResultado.get(i).toString();
        }
        
        return resultadoStr;
    }

    private int[] contarConjuntos(String cadena) {
        int[] numeroDe = new int[2];
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if ((c == '+') || c == '*' || c == '#' || c == '-' || c == '^') {
                numeroDe[1]++;    // Numero de operaciones
            } else {
                if (!(c == '(' || c == ')')) {
                    numeroDe[0]++;// Numero de conjuntos
                }
            }
        }
        return numeroDe;
    }

    private String voltearLetras(String cadena) {
        String[] vector = cadena.split("");
        String respuesta = "";

        for (int i = vector.length - 1; i >= 0; i--) {
            respuesta += vector[i];
        }
        return respuesta;
    }

    private String cadenaInterpretada(String cadena) {
        String primera = analizarCadena(cadena);
        String resultadoStr = "";

        Stack pilaEntrada = new Stack();
        Stack pilaConjuntos = new Stack();

        //LLenar la pila de entrada
        for (int i = primera.length() - 1; i >= 0; i--) {
            pilaEntrada.push(primera.charAt(i));
        }

        try {
            while (!pilaEntrada.isEmpty()) {
                switch (pilaEntrada.peek().toString()) {
                    case SYMBOL_UNION: // +
                        pilaConjuntos.push(")" + pilaConjuntos.pop() + SYMBOL_UNION + pilaConjuntos.pop() + "(");
                        pilaEntrada.pop();
                        break;
                    case SYMBOL_INTERSECCION:
                        pilaConjuntos.push(")" + pilaConjuntos.pop() + SYMBOL_INTERSECCION + pilaConjuntos.pop() + "(");
                        pilaEntrada.pop();
                        break;
                    case SYMBOL_COMPLEMENTO:
                        pilaConjuntos.push(")" + SYMBOL_COMPLEMENTO + ")" + pilaConjuntos.pop() + "((");
                        pilaEntrada.pop();
                        break;
                    case SYMBOL_DIFERENCIA:
                        pilaConjuntos.push(")" + pilaConjuntos.pop() + SYMBOL_DIFERENCIA + pilaConjuntos.pop() + "(");
                        pilaEntrada.pop();
                        break;
                    case SYMBOL_DIFERENCIA_SIMETRICA:
                        pilaConjuntos.push(")" + pilaConjuntos.pop() + SYMBOL_DIFERENCIA_SIMETRICA + pilaConjuntos.pop() + "(");
                        pilaEntrada.pop();
                        break;
                    default:
                        pilaConjuntos.push(pilaEntrada.pop());
                }
            }
        } catch (Exception e) {
            return "ERROR";
        }
        
        while (!pilaConjuntos.isEmpty()) {
            resultadoStr += pilaConjuntos.pop();
        }
        resultadoStr = voltearLetras(resultadoStr);

        return resultadoStr;
    }
}
