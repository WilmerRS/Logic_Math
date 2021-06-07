/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Unipamplona.MDiscretas.interfaz.pnCentralesRelaciones;

import main.java.Unipamplona.MDiscretas.interfaz.PatronDisenho;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @author WILMER
 */
public class PnDiagramaSagital extends JPanel {

    private final String TIPO_RELACION = "RELACION";
    private final String TIPO_COMPOSICION = "COMPOSICION";
    private String TIPO;

    private ArrayList<String> conjuntoA;
    private ArrayList<String> conjuntoB;
    private ArrayList<String> conjuntoC;

    private ArrayList<String[]> relacion1;
    private ArrayList<String[]> relacion2;

    private String nombreA;
    private String nombreB;
    private String nombreC;

    private int columna1;
    private int columna2;
    private int columna3;

    private int tamanhoOvalo1;
    private int tamanhoOvalo2;
    private int tamanhoOvalo3;
    private JScrollPane spSagital;

    public PnDiagramaSagital(ArrayList conjuntoA, ArrayList conjuntoB, ArrayList<String[]> relacion1, String nombreA, String nombreB, String TIPO) {
        super();
        this.conjuntoA = conjuntoA;
        this.conjuntoB = conjuntoB;
        this.relacion1 = relacion1;
        this.nombreA = nombreA;
        this.nombreB = nombreB;
        this.TIPO = TIPO;
        iniciarComponentes();
    }

    public PnDiagramaSagital(ArrayList conjuntoA, ArrayList conjuntoB, ArrayList conjuntoC,
                             ArrayList<String[]> relacion1, ArrayList<String[]> relacion2, String nombreA,
                             String nombreB, String nombreC, String TIPO) {
        super();
        this.conjuntoA = conjuntoA;
        this.conjuntoB = conjuntoB;
        this.conjuntoC = conjuntoC;
        this.relacion1 = relacion1;
        this.relacion2 = relacion2;
        this.nombreA = nombreA;
        this.nombreB = nombreB;
        this.nombreC = nombreC;
        this.TIPO = TIPO;
        iniciarComponentes();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setFont(new Font("Segoe UI Semibold", 0, 18));
        g2d.setColor(PatronDisenho.MORADO_CABECERA);
        g2d.setStroke(new BasicStroke(3));

        switch (TIPO) {
            case TIPO_RELACION:
                columna1 = (int) (g.getClipBounds().getWidth() / 4);
                columna2 = (int) ((3 * g.getClipBounds().getWidth()) / 4);

                int yInicial1 = 30;
//                g2d.drawString(nombreA, columna1, yInicial1);
                yInicial1 += 10;
                for (int i = 0; i < conjuntoA.size(); i++) {
                    yInicial1 += 30;
                    g2d.drawString(conjuntoA.get(i), columna1, yInicial1);
                }

                int yInicial2 = 30;
//                g2d.drawString(nombreB, columna2, yInicial2);
                yInicial2 += 10;
                for (int i = 0; i < conjuntoB.size(); i++) {
                    yInicial2 += 30;
                    g2d.drawString(conjuntoB.get(i), columna2, yInicial2);
                }

                g2d.setColor(PatronDisenho.MORADO_OSCURO);
                g2d.drawOval(columna1 - 35, 35, 80, yInicial1 - 5);
                g2d.drawOval(columna2 - 35, 35, 80, yInicial2 - 5);

                g2d.setColor(PatronDisenho.VERDE_CLICK);
                for (int i = 0; i < relacion1.size(); i++) {
                    int tempA = buscarPosicionElemento(relacion1.get(i)[0], conjuntoA);
                    int tempB = buscarPosicionElemento(relacion1.get(i)[1], conjuntoB);
                    if (tempA != -1 && tempB != -1) {
                        g2d.drawLine(columna1 + 15, (70 + (30 * tempA) - 5), columna2 - 5, (70 + (30 * tempB) - 5));
                    }
                }
                g2d.drawString("R", (int) (columna1 + columna2) / 2, 30);
                break;
            case TIPO_COMPOSICION:
                columna1 = (int) (g.getClipBounds().getWidth() / 4) - 50;
                columna2 = (int) (g.getClipBounds().getWidth() / 2);
                columna3 = (int) ((3 * g.getClipBounds().getWidth()) / 4) + 45;

                yInicial1 = 30;
//                g2d.drawString(nombreA, columna1, yInicial1);
                yInicial1 += 10;
                for (int i = 0; i < conjuntoA.size(); i++) {
                    yInicial1 += 30;
                    g2d.drawString(conjuntoA.get(i), columna1, yInicial1);
                }

                yInicial2 = 30;
//                g2d.drawString(nombreB, columna2, yInicial2);
                yInicial2 += 10;
                for (int i = 0; i < conjuntoB.size(); i++) {
                    yInicial2 += 30;
                    g2d.drawString(conjuntoB.get(i), columna2, yInicial2);
                }

                int yInicial3 = 30;
//                g2d.drawString(nombreC, columna3, yInicial3);
                yInicial3 += 10;
                for (int i = 0; i < conjuntoC.size(); i++) {
                    yInicial3 += 30;
                    g2d.drawString(conjuntoC.get(i), columna3, yInicial3);
                }

                g2d.setColor(PatronDisenho.MORADO_OSCURO);
                g2d.drawOval(columna1 - 35, 35, 80, yInicial1 - 5);
                g2d.drawOval(columna2 - 35, 35, 80, yInicial2 - 5);
                g2d.drawOval(columna3 - 35, 35, 80, yInicial3 - 5);

                g2d.setColor(PatronDisenho.VERDE_CLICK);
                for (int i = 0; i < relacion1.size(); i++) {
                    int tempA = buscarPosicionElemento(relacion1.get(i)[0], conjuntoA);
                    int tempB = buscarPosicionElemento(relacion1.get(i)[1], conjuntoB);
                    if (tempA != -1 && tempB != -1) {
                        g2d.drawLine(columna1 + 15, (70 + (30 * tempA) - 5), columna2 - 5, (70 + (30 * tempB) - 5));
                    }
                }

                g2d.drawString("R", (int) (columna1 + columna2) / 2, 30);


                g2d.setColor(PatronDisenho.ROJO_CLARO);
                for (int i = 0; i < relacion2.size(); i++) {
                    int tempB = buscarPosicionElemento(relacion2.get(i)[0], conjuntoB);
                    int tempC = buscarPosicionElemento(relacion2.get(i)[1], conjuntoC);
                    if (tempB != -1 && tempC != -1) {
                        g2d.drawLine(columna2 + 15, (70 + (30 * tempB) - 5), columna3 - 5, (70 + (30 * tempC) - 5));
                    }
                }

                g2d.drawString("S", (int) (columna2 + columna3) / 2, 30);
                break;
        }
    }

    private int buscarPosicionElemento(String elemento, ArrayList<String> array) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    private void iniciarComponentes() {
        this.setBackground(PatronDisenho.BLANCO);
        spSagital = new JScrollPane(this,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        spSagital.setBorder(null);
        spSagital.setViewportView(this);
    }
}
