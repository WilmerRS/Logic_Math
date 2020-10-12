/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unipamplona.MDiscretas.interfaz.pnCentralesConjuntos;

import static Unipamplona.MDiscretas.interfaz.InterfazMain.alto;
import static Unipamplona.MDiscretas.interfaz.InterfazMain.ancho;
import Unipamplona.MDiscretas.interfaz.PatronDisenho;
import Unipamplona.MDiscretas.mundo.TablaVerdad;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolTip;

public class PnTablaVerdad extends JPanel {

    private String titulo;
    private String operacionResuelta;
    private String operacionInfija;
    private String[][] matrizSolucion;

    private JLabel lbTitulo;
    private JLabel lbOperacion;

    private JPanel pnSuperior;
    private JPanel pnInferior;
    private JPanel pnTabla;
    private JScrollPane spTabla;

    private TablaVerdad tablaVerdad;

    public PnTablaVerdad(String operacionInfija, String operacionResuelta) {
        super();
        this.operacionResuelta = operacionResuelta;
        this.operacionInfija = operacionInfija;
        tablaVerdad = new TablaVerdad();
        crearPanel();
    }

    private void crearPanel() {
        this.setBackground(PatronDisenho.GRIS_FONDO);
        this.setMinimumSize(new Dimension(10, (int) (alto * 0.07 * 2)));
        this.setPreferredSize(new Dimension(10, (int) (alto * 0.07 * 2)));
        this.setLayout(new java.awt.BorderLayout(5, 5));

        lbTitulo = new JLabel("     Tabla de verdad:");
        lbTitulo.setBackground(PatronDisenho.MORADO_CLICK);
        lbTitulo.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbTitulo.setFont(PatronDisenho.SEGOE_14);
        } else {
            lbTitulo.setFont(PatronDisenho.SEGOE_18);
        }

        lbOperacion = new JLabel("         Operacion resuelta:  " + operacionResuelta);
        lbOperacion.setBackground(PatronDisenho.MORADO_CLICK);
        lbOperacion.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbOperacion.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbOperacion.setFont(PatronDisenho.SEGOE_16);
        }

        pnSuperior = new JPanel();
        pnSuperior.setBackground(PatronDisenho.BLANCO);
        pnSuperior.setLayout(new java.awt.BorderLayout(5, 0));
        pnSuperior.setPreferredSize(new Dimension(10, (int) (alto * 0.055)));

        pnSuperior.add(lbTitulo, java.awt.BorderLayout.NORTH);
        pnSuperior.add(lbOperacion, java.awt.BorderLayout.CENTER);

        pnInferior = new JPanel();
        pnInferior.setBackground(PatronDisenho.MORADO_CLARO);
        pnInferior.setLayout(new java.awt.BorderLayout(5, 0));

        pnTabla = new JPanel();
        pnTabla.setBackground(PatronDisenho.GRIS_FONDO_2);

        actualizarTabla();

        spTabla = new JScrollPane(pnTabla,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        spTabla.setBorder(null);
        spTabla.setBackground(PatronDisenho.BLANCO);

        spTabla.setViewportView(pnTabla);

        this.add(pnSuperior, java.awt.BorderLayout.NORTH);
        this.add(spTabla, java.awt.BorderLayout.CENTER);
    }

    private void llenarMatrizSolucion() {
        tablaVerdad.matrizSolucion(operacionInfija);
        operacionResuelta = tablaVerdad.getOperacionResuelta();
        matrizSolucion = tablaVerdad.getMatrizResultado();
    }

    public void actualizarTabla() {
        llenarMatrizSolucion();
        pnTabla.removeAll();
        pnTabla.setLayout(new java.awt.GridLayout(matrizSolucion.length, matrizSolucion[0].length, 4, 4));
        for (int i = 0; i < matrizSolucion.length; i++) {
            for (int j = 0; j < matrizSolucion[0].length; j++) {
                if (i == 0) {
                    pnTabla.add(crearLabel(matrizSolucion[i][j], PatronDisenho.MORADO_HOVER, PatronDisenho.BLANCO));
                } else {
                    pnTabla.add(crearLabel(matrizSolucion[i][j], PatronDisenho.BLANCO, PatronDisenho.MORADO_OSCURO));
                }
            }
        }
        operacionResuelta = tablaVerdad.getOperacionResuelta();
        lbOperacion.setText("         Operacion resuelta:  " + operacionResuelta);
//        pnTabla.update(pnTabla.getGraphics());
    }

    private JScrollPane crearLabel(String texto, Color fondo, Color letra) {

        JPanel pnTemp = new JPanel() {
            @Override
            public JToolTip createToolTip() {
                JToolTip toolTip = super.createToolTip();
                toolTip.setBackground(PatronDisenho.BLANCO);
                toolTip.setForeground(PatronDisenho.MORADO_OSCURO);
                toolTip.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, PatronDisenho.MORADO_CABECERA));
                if (ancho < 1500) {
                    toolTip.setFont(PatronDisenho.SEGOE_12);
                } else {
                    toolTip.setFont(PatronDisenho.SEGOE_16);
                }
                return toolTip;
            }
        };

        pnTemp.setBackground(fondo);
        pnTemp.setLayout(new java.awt.BorderLayout());
        pnTemp.setPreferredSize(new Dimension(100, 30));
        pnTemp.setToolTipText("  " + texto + "  ");

        JLabel temp = new JLabel(" " + texto + " ");
        temp.setForeground(letra);
        temp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        if (ancho < 1500) {
            temp.setFont(PatronDisenho.SEGOE_12);
        } else {
            temp.setFont(PatronDisenho.SEGOE_16);
        }
        pnTemp.add(temp, java.awt.BorderLayout.CENTER);

        JScrollPane sp = new JScrollPane(pnTemp,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setBorder(null);
        sp.setViewportView(pnTemp);
        return sp;
    }

    public String getOperacionInfija() {
        return operacionInfija;
    }

    public void setOperacionInfija(String operacionInfija) {
        this.operacionInfija = operacionInfija;
    }

    public String getOperacionResuelta() {
        return operacionResuelta;
    }

    public void setOperacionResuelta(String operacionResuelta) {
        this.operacionResuelta = operacionResuelta;
    }
}
