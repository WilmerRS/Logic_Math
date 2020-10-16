/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unipamplona.MDiscretas.interfaz.pnCentralesRelaciones;

import Unipamplona.MDiscretas.interfaz.Boton;
import static Unipamplona.MDiscretas.interfaz.InterfazMain.ancho;
import Unipamplona.MDiscretas.interfaz.PatronDisenho;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author WILMER
 */
public class PnMatrizSalida extends JPanel {

    private final String TIPO_RELACION = "RELACION";
    private final String TIPO_COMPOSICION = "COMPOSICION";

    private JPanel pnFondo;
    private JLabel lbTitulo;

    private JScrollPane spMatriz;
    private JScrollPane spSagital;

    private JPanel pnMatrizFondo;
    private JPanel pnSagitalFondo;

    private JPanel pnMatriz;
    private JPanel pnSagital;

    private JLabel lbTituloMatriz;
    private JLabel lbTituloSagital;

    private String[][] matrizSalida;

    private int tamanho = (int) (ancho * 0.003);

    private ArrayList<String> conjuntoA;
    private ArrayList<String> conjuntoB;
    private ArrayList<String> conjuntoC;

    private ArrayList<String[]> relacion1;
    private ArrayList<String[]> relacion2;

    public PnMatrizSalida() {
        super();
        crearPaneles();
    }

    private void crearPaneles() {
        this.setBackground(PatronDisenho.GRIS_FONDO);
        this.setLayout(new java.awt.BorderLayout(5, 5));

        lbTitulo = new JLabel("   Solución de las operaciones");
        lbTitulo.setOpaque(true);
        lbTitulo.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbTitulo.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbTitulo.setFont(PatronDisenho.SEGOE_16);
        }
        lbTitulo.setBackground(PatronDisenho.BLANCO);

        pnFondo = new JPanel();
        pnFondo.setBackground(PatronDisenho.GRIS_FONDO);
        pnFondo.setLayout(new java.awt.GridLayout(1, 2, 5, 5));

        pnMatrizFondo = new JPanel();
        pnMatrizFondo.setBackground(PatronDisenho.GRIS_FONDO);
        pnMatrizFondo.setLayout(new java.awt.BorderLayout(0, 0));

        lbTituloMatriz = new JLabel("   Solución matricial");
        lbTituloMatriz.setOpaque(true);
        lbTituloMatriz.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbTituloMatriz.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbTituloMatriz.setFont(PatronDisenho.SEGOE_16);
        }
        lbTituloMatriz.setBackground(PatronDisenho.BLANCO);

        pnMatriz = new JPanel();
        pnMatriz.setBackground(PatronDisenho.GRIS_FONDO);
        pnMatriz.setLayout(new java.awt.BorderLayout(0, 0));

        spMatriz = new JScrollPane(pnMatriz,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        spMatriz.setBorder(null);
        spMatriz.setViewportView(pnMatriz);

        pnMatrizFondo.add(lbTituloMatriz, java.awt.BorderLayout.NORTH);
        pnMatrizFondo.add(spMatriz, java.awt.BorderLayout.CENTER);

        pnSagitalFondo = new JPanel();
        pnSagitalFondo.setBackground(PatronDisenho.GRIS_FONDO);
        pnSagitalFondo.setLayout(new java.awt.BorderLayout(0, 0));

        lbTituloSagital = new JLabel("   Diagrama sagital");
        lbTituloSagital.setOpaque(true);
        lbTituloSagital.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbTituloSagital.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbTituloSagital.setFont(PatronDisenho.SEGOE_16);
        }
        lbTituloSagital.setBackground(PatronDisenho.BLANCO);

        pnSagital = new JPanel();
        pnSagital.setBackground(PatronDisenho.BLANCO);
        pnSagital.setLayout(new java.awt.BorderLayout(0, 0));

        spSagital = new JScrollPane(pnSagital,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        spSagital.setBorder(null);
        spSagital.setViewportView(pnSagital);

        pnSagitalFondo.add(lbTituloSagital, java.awt.BorderLayout.NORTH);
        pnSagitalFondo.add(spSagital, java.awt.BorderLayout.CENTER);

        pnFondo.add(pnMatrizFondo);
        pnFondo.add(pnSagitalFondo);

        crearMatrizInicial();
        actualizarMatriz();

        elementosDefecto();
        crearDiagramaSagital(TIPO_RELACION);

        this.add(lbTitulo, java.awt.BorderLayout.NORTH);
        this.add(pnFondo, java.awt.BorderLayout.CENTER);

    }

    private void elementosDefecto() {
        conjuntoA = new ArrayList<>();
        conjuntoB = new ArrayList<>();
        conjuntoC = new ArrayList<>();

        relacion1 = new ArrayList<>();
        relacion2 = new ArrayList<>();

        conjuntoA.add("a");
        conjuntoA.add("b");
        conjuntoA.add("c");
        conjuntoA.add("d");

        conjuntoB.add("x");
        conjuntoB.add("y");
        conjuntoB.add("z");

        conjuntoC.add("1");
        conjuntoC.add("2");
        conjuntoC.add("3");
        conjuntoC.add("4");

        String[] temp4 = {"a", "x"};
        relacion1.add(temp4);
        String[] temp5 = {"b", "y"};
        relacion1.add(temp5);
        String[] temp6 = {"c", "z"};
        relacion1.add(temp6);
        String[] temp7 = {"d", "z"};
        relacion1.add(temp7);

        String[] temp1 = {"x", "1"};
        relacion2.add(temp1);
        String[] temp2 = {"y", "1"};
        relacion2.add(temp2);
        String[] temp3 = {"y", "4"};
        relacion2.add(temp3);
        String[] temp0 = {"z", "3"};
        relacion2.add(temp0);
    }

    private String[][] crearMatrizInicial() {
        String[][] temp
                = {{" ", "x", "y", "z"},
                {"a", "1", "0", "0"},
                {"b", "0", "1", "0"},
                {"c", "0", "0", "1"},
                {"d", "0", "0", "1"}};

        matrizSalida = temp;
        return matrizSalida;
    }

    public void actualizarMatriz() {
        pnMatriz.removeAll();
        pnMatriz.setLayout(new java.awt.GridLayout(matrizSalida.length, matrizSalida[0].length, 3, 3));
        int contador = 0;
        for (int i = 0; i < matrizSalida.length; i++) {
            for (int j = 0; j < matrizSalida[0].length; j++) {
                boolean p = i == 0;
                boolean q = j == 0;
                Boton temp = null;
                if (p || q) {
                    temp = new Boton(matrizSalida[i][j], null, new Dimension(20, 20), tamanho, Boton.SUR, Boton.TEXTO,
                            PatronDisenho.MORADO_CABECERA, PatronDisenho.MORADO_CLARO,
                            PatronDisenho.MORADO_CABECERA_HOVER, PatronDisenho.MORADO_CABECERA_CLICK, PatronDisenho.BLANCO, 0);
                    temp.setEnabled(false);
                } else {
                    switch (matrizSalida[i][j]) {
                        case "0":
                            temp = new Boton("0", null, new Dimension(20, 20), tamanho, Boton.SUR, Boton.TEXTO,
                                    PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                                    PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, contador);
                            break;
                        case "1":
                            temp = new Boton("1", null, new Dimension(20, 20), tamanho, Boton.SUR, Boton.TEXTO,
                                    PatronDisenho.VERDE_CLARO, PatronDisenho.VERDE_RESALTADOR, PatronDisenho.VERDE_HOVER,
                                    PatronDisenho.VERDE_CLICK, PatronDisenho.VERDE_OSCURO, contador);
                            break;
                        case "-1":
                            temp = new Boton("1", null, new Dimension(20, 20), tamanho, Boton.SUR, Boton.TEXTO,
                                    PatronDisenho.ROJO_CLARO, PatronDisenho.ROJO_CLICK, PatronDisenho.ROJO_CLARO_HOVER,
                                    PatronDisenho.ROJO_CLARO_CLICK, PatronDisenho.ROJO_OSCURO, contador);
                            break;
                    }
                }
                contador++;
                pnMatriz.add(temp);
            }
        }
        pnMatriz.update(pnMatriz.getGraphics());
        spMatriz.setViewportView(pnMatriz);
    }

    public boolean matrizVacia(String[][] matriz) {
        int cont = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                try {
                    if (matriz[i][j].equals("1")) {
                        cont++;
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return cont == 0;
    }

    public void restablecerMatriz(){
        matrizSalida = crearMatrizInicial();
        actualizarMatriz();
    }
    
    public String[][] getMatrizSalida() {
        return matrizSalida;
    }

    public void setMatrizSalida(String[][] matrizSalida) {
        this.matrizSalida = matrizSalida;
    }

    public void crearDiagramaSagital(String tipo) {
        pnSagital.removeAll();
        PnDiagramaSagital dmSagital = null;
        switch (tipo) {
            case TIPO_RELACION:
                dmSagital = new PnDiagramaSagital(conjuntoA, conjuntoB, relacion1, "A", "B", TIPO_RELACION);
                break;
            case TIPO_COMPOSICION:
                dmSagital = new PnDiagramaSagital(conjuntoA, conjuntoB, conjuntoC, relacion1, relacion2, "A", "B", "C", TIPO_COMPOSICION);
                break;
        }
//        PnDiagramaSagital dmSagital = new PnDiagramaSagital(conjuntoA, conjuntoB, conjuntoC, relacion1, relacion2, "A", "B", "C", TIPO_COMPOSICION);
        pnSagital.add(dmSagital);
        pnSagital.updateUI();
    }

    public JPanel getPnMatriz() {
        return pnMatriz;
    }

    public JPanel getPnSagital() {
        return pnSagital;
    }

    public ArrayList<String> getConjuntoA() {
        return conjuntoA;
    }

    public void setConjuntoA(ArrayList<String> conjuntoA) {
        this.conjuntoA = conjuntoA;
    }

    public ArrayList<String> getConjuntoB() {
        return conjuntoB;
    }

    public void setConjuntoB(ArrayList<String> conjuntoB) {
        this.conjuntoB = conjuntoB;
    }

    public ArrayList<String> getConjuntoC() {
        return conjuntoC;
    }

    public void setConjuntoC(ArrayList<String> conjuntoC) {
        this.conjuntoC = conjuntoC;
    }

    public ArrayList<String[]> getRelacion1() {
        return relacion1;
    }

    public void setRelacion1(ArrayList<String[]> relacion1) {
        this.relacion1 = relacion1;
    }

    public ArrayList<String[]> getRelacion2() {
        return relacion2;
    }

    public void setRelacion2(ArrayList<String[]> relacion2) {
        this.relacion2 = relacion2;
    }

}
