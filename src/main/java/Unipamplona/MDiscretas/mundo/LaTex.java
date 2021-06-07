/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Unipamplona.MDiscretas.mundo;

import java.util.Stack;
import org.scilab.forge.jlatexmath.ParseException;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

public class LaTex {

    private static final String SYMBOL_UNION = "+";
    private static final String SYMBOL_INTERSECCION = "*";
    private static final String SYMBOL_COMPLEMENTO = "#";
    private static final String SYMBOL_DIFERENCIA = "-";
    private static final String SYMBOL_DIFERENCIA_SIMETRICA = "^";

    // Representa una fórmula matemática lógica que se mostrará en un TexIcon
    TeXFormula formula;
    // Una implementación de Icon que pintará la formula que la creó.
    TeXIcon icon;
    String math;

//    public LaTex() {
//        // ...
//    }

    public LaTex(String math) {
        this.math = math;
    }

    public TeXIcon getIconLaTex() {
        try {
            formula = new TeXFormula(this.math);
            this.icon = this.formula.createTeXIcon(TeXConstants.ALIGN_CENTER, 40);
            return this.icon;
        } catch (ParseException e) {
            System.err.println("Error: " + e.getMessage());
            return this.icon = null;
        }
    }

    public TeXIcon actualizarIconLaTex(String math, int valor) {
        try {
            this.math = ecuacion(math);
            this.formula = new TeXFormula(this.math);
            this.icon = this.formula.new TeXIconBuilder().setStyle(TeXConstants.STYLE_DISPLAY)
                    .setSize(valor)
                    .setWidth(TeXConstants.UNIT_PIXEL, 256f, TeXConstants.ALIGN_LEFT)
                    .setIsMaxWidth(true)
                    .setInterLineSpacing(TeXConstants.UNIT_PIXEL, 20f).build();
            return this.icon;

        } catch (ParseException e) {
            System.err.println("Error: " + e.getMessage());
            return this.icon = null;
        }

    }

    public String ecuacion(String cadena) {
        String primera = cadena;
        String resultado = "";
        Stack pilaEntrada = new Stack();
        Stack pilaSalida = new Stack();
        Object temp1 = null;
        Object temp2 = null;
        for (int i = primera.length() - 1; i >= 0; i--) {
            pilaEntrada.push(primera.charAt(i));
        }
        try {
            while (!pilaEntrada.isEmpty()) {
                switch (pilaEntrada.peek().toString()) {
                    case SYMBOL_UNION:
                        temp1 = pilaSalida.pop();
                        temp2 = pilaSalida.pop();
                        pilaSalida.push(")" + temp1 + " puc\\ " + temp2 + "(");
                        pilaEntrada.pop();
                        break;
                    case SYMBOL_INTERSECCION:
                        temp1 = pilaSalida.pop();
                        temp2 = pilaSalida.pop();
                        pilaSalida.push(")" + temp1 + " pac\\ " + temp2 + "(");
                        pilaEntrada.pop();
                        break;
                    case SYMBOL_COMPLEMENTO:
                        temp1 = pilaSalida.pop();
                        pilaSalida.push("}" + temp1 + "{" + "enilrevo\\");
                        pilaEntrada.pop();
                        break;
                    case SYMBOL_DIFERENCIA:
                        temp1 = pilaSalida.pop();
                        temp2 = pilaSalida.pop();
                        pilaSalida.push(")" + temp1 + " - " + temp2 + "(");
                        pilaEntrada.pop();
                        break;
                    case SYMBOL_DIFERENCIA_SIMETRICA:
                        temp1 = pilaSalida.pop();
                        temp2 = pilaSalida.pop();
                        pilaSalida.push(")" + temp1 + " elgnairtrav\\ " + temp2 + "(");
                        pilaEntrada.pop();
                        break;
                    default:
                        pilaSalida.push(pilaEntrada.pop());
                }
            }
        } catch (Exception e) {
            resultado = "ERROR";
        }
        return voltearLetras((String) pilaSalida.pop());
    }

    public String voltearLetras(String cadena) {
        String[] vector = cadena.split("");
        String respuesta = "";

        for (int i = vector.length - 1; i >= 0; i--) {
            respuesta += vector[i];
        }
        return respuesta;
    }

}
