/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Unipamplona.MDiscretas.interfaz.pnCentralesRelaciones;

import main.java.Unipamplona.MDiscretas.interfaz.Boton;
import static main.java.Unipamplona.MDiscretas.interfaz.InterfazMain.alto;
import static main.java.Unipamplona.MDiscretas.interfaz.InterfazMain.ancho;
import main.java.Unipamplona.MDiscretas.interfaz.PatronDisenho;
import main.java.Unipamplona.MDiscretas.interfaz.pnCentralesConjuntos.PnConjunto;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author WILMER
 */
public class PnEntradaRelaciones extends JPanel {

    private final String RELACION_SIMETRICA = "Relación simétrica";
    private final String RELACION_REFLEXIVA = "Relación reflexiva";
    private final String RELACION_ANTRISIMETRICA = "Relación antisimétrica";
    private final String RELACION_TRANSITIVA = "Relación transitiva";

    private final String TITULO_CLASES = "   Seleccionar el tipo de  operaciones";
    private final String TITULO_OPERACIONES = "   Operaciones";
    private final String TITULO_CONJUNTOS = "   Conjuntos";
    private final String TITULO_RELACIONES = "   Relaciones";
    private final String RELACIONES = "RELACIONES";
    private final String TIPO_RELACIONES = "TIPO_RELACIONES";

    private final String TITULO_SALIDA = "   Salida";
    private final String TITULO_TIPO_SALIDA = "   Tipo de relación";
    private final String SALIDA_DEFECTO = "     T = { ( 1, 2 ), ( 2, 3 ), ( 3, 4 ) }";
    private final String TIPO_DEFECTO = "     " + RELACION_SIMETRICA;

    private JPanel pnSuperior;
    private JPanel pnCentral;
    private JPanel pnInferior;

    private JPanel pnSeleccionarClase;
    private JPanel pnSeleccionarBtn;
    private JLabel lbTituloClases;

    private Boton btnRelaciones;
    private Boton btnTipoRelacion;

    private JPanel pnOperaciones;
    private JPanel pnOperacionesBtn;
    private JPanel pnBtnRelaciones;
    private JPanel pnBtnTipoRelaciones;
    private JLabel lbTituloOperaciones;

    private Boton btnMultiplicacion;
    private Boton btnInversaR;
    private Boton btnInversaS;
    private Boton btnComposicion;

    private JPanel pnBtnRFondo;
    private JPanel pnBtnSFondo;
    private JPanel pnBtnR;
    private JPanel pnBtnS;
    private JLabel lbR;
    private JLabel lbS;

    private Boton btnReflexivaR;
    private Boton btnSimetricaR;
    private Boton btnAnriSimetricaR;
    private Boton btnTransitivaR;

    private Boton btnReflexivaS;
    private Boton btnSimetricaS;
    private Boton btnAnriSimetricaS;
    private Boton btnTransitivaS;

    private JPanel pnConjuntos;
    private JPanel pnConjuntosIndi;
    private JLabel lbTituloConjuntos;

    private PnConjunto pnConjuntoA;
    private PnConjunto pnConjuntoB;
    private PnConjunto pnConjuntoC;

    private JPanel pnRelaciones;
    private JPanel pnRelacionesIndi;
    private JLabel lbTituloRelaciones;

    private JPanel pnSalida;
    private JScrollPane spSalida;
    private JLabel lbTituloSalida;
    private JLabel lbSalida;

    private JPanel pnTipoRelacion;
    private JScrollPane spTipoRelacion;
    private JLabel lbTituloTipoRelacion;
    private JLabel lbTipoRelacion;

    private PnConjunto pnRelacionR;
    private PnConjunto pnRelacionS;

    private int tamanho = (int) (ancho * 0.003);

    public PnEntradaRelaciones() {
        super();
        crearPanel();
    }

    private void crearPanel() {
        this.setBackground(PatronDisenho.GRIS_FONDO);
        this.setLayout(new java.awt.BorderLayout(5, 5));

        pnSuperior = new JPanel();
        pnSuperior.setBackground(PatronDisenho.GRIS_FONDO);
        pnSuperior.setLayout(new java.awt.GridLayout(0, 1, 5, 5));

        pnCentral = new JPanel();
        pnCentral.setBackground(PatronDisenho.GRIS_FONDO);
        pnCentral.setLayout(new java.awt.GridLayout(2, 1, 5, 5));

        pnSeleccionarClase = new JPanel();
        pnSeleccionarClase.setBackground(PatronDisenho.BLANCO);
        pnSeleccionarClase.setLayout(new java.awt.BorderLayout(5, 5));

        lbTituloClases = new JLabel(TITULO_CLASES);
        lbTituloClases.setOpaque(true);
        lbTituloClases.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbTituloClases.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbTituloClases.setFont(PatronDisenho.SEGOE_16);
        }
        lbTituloClases.setBackground(PatronDisenho.BLANCO);

        pnSeleccionarBtn = new JPanel();
        pnSeleccionarBtn.setBackground(PatronDisenho.GRIS_FONDO);
        pnSeleccionarBtn.setLayout(new java.awt.GridLayout(1, 0, 0, 0));

        btnRelaciones = new Boton("Relaciones", null, new Dimension((int) (ancho * 0.115), (int) (alto * 0.0467)),
                tamanho, Boton.SUR, Boton.TEXTO, PatronDisenho.MORADO_CABECERA, PatronDisenho.MORADO_CLARO,
                PatronDisenho.MORADO_CABECERA_HOVER, PatronDisenho.MORADO_CABECERA_CLICK, PatronDisenho.BLANCO, 0);

        btnTipoRelacion = new Boton("Tipo de relaciones", null, new Dimension(0, 0),
                tamanho, Boton.SUR, Boton.TEXTO, PatronDisenho.MORADO_CABECERA, PatronDisenho.MORADO_CLARO,
                PatronDisenho.MORADO_CABECERA_HOVER, PatronDisenho.MORADO_CABECERA_CLICK, PatronDisenho.BLANCO, 0);

        pnSeleccionarBtn.add(btnRelaciones);
        pnSeleccionarBtn.add(btnTipoRelacion);

        pnSeleccionarClase.add(lbTituloClases, java.awt.BorderLayout.NORTH);
        pnSeleccionarClase.add(pnSeleccionarBtn, java.awt.BorderLayout.CENTER);

        pnOperaciones = new JPanel();
        pnOperaciones.setBackground(PatronDisenho.GRIS_FONDO);
        pnOperaciones.setLayout(new java.awt.BorderLayout(0, 0));

        pnBtnRelaciones = new JPanel();
        pnBtnRelaciones.setBackground(PatronDisenho.GRIS_FONDO);
        pnBtnRelaciones.setLayout(new java.awt.GridLayout(1, 0));

        pnBtnTipoRelaciones = new JPanel();
        pnBtnTipoRelaciones.setBackground(PatronDisenho.GRIS_FONDO);
        pnBtnTipoRelaciones.setLayout(new java.awt.GridLayout(0, 1, 2, 2));

        lbTituloOperaciones = new JLabel(TITULO_OPERACIONES);
        lbTituloOperaciones.setOpaque(true);
        lbTituloOperaciones.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbTituloOperaciones.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbTituloOperaciones.setFont(PatronDisenho.SEGOE_16);
        }
        lbTituloOperaciones.setBackground(PatronDisenho.BLANCO);

        pnBtnRFondo = new JPanel();
        pnBtnRFondo.setBackground(PatronDisenho.GRIS_FONDO);
        pnBtnRFondo.setLayout(new java.awt.BorderLayout(0, 0));

        lbR = new JLabel("   R   ");
        lbR.setOpaque(true);
        lbR.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbR.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbR.setFont(PatronDisenho.SEGOE_16);
        }
        lbR.setBackground(PatronDisenho.BLANCO);

        pnBtnR = new JPanel();
        pnBtnR.setBackground(PatronDisenho.GRIS_FONDO);
        pnBtnR.setLayout(new java.awt.GridLayout(1, 0));

        btnReflexivaR = new Boton("Reflexiva", null, new Dimension(0,0),
                tamanho, Boton.SUR, Boton.TEXTO, PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, 0);
        btnSimetricaR = new Boton("Simétrica", null, new Dimension(0,0),
                tamanho, Boton.SUR, Boton.TEXTO, PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, 0);
        btnAnriSimetricaR = new Boton("Antisimétrica", null, new Dimension(0,0),
                tamanho, Boton.SUR, Boton.TEXTO, PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, 0);
        btnTransitivaR = new Boton("Transitiva", null, new Dimension(0,0),
                tamanho, Boton.SUR, Boton.TEXTO, PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, 0);

        pnBtnR.add(btnReflexivaR);
        pnBtnR.add(btnSimetricaR);
        pnBtnR.add(btnAnriSimetricaR);
        pnBtnR.add(btnTransitivaR);

        pnBtnRFondo.add(lbR, java.awt.BorderLayout.WEST);
        pnBtnRFondo.add(pnBtnR, java.awt.BorderLayout.CENTER);

        pnBtnSFondo = new JPanel();
        pnBtnSFondo.setBackground(PatronDisenho.GRIS_FONDO);
        pnBtnSFondo.setLayout(new java.awt.BorderLayout(0, 0));

        lbS = new JLabel("   S   ");
        lbS.setOpaque(true);
        lbS.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbS.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbS.setFont(PatronDisenho.SEGOE_16);
        }
        lbS.setBackground(PatronDisenho.BLANCO);

        pnBtnS = new JPanel();
        pnBtnS.setBackground(PatronDisenho.GRIS_FONDO);
        pnBtnS.setLayout(new java.awt.GridLayout(1, 0));

        btnReflexivaS = new Boton("Reflexiva", null, new Dimension(0,0),
                tamanho, Boton.SUR, Boton.TEXTO, PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, 0);
        btnSimetricaS = new Boton("Simétrica", null, new Dimension(0,0),
                tamanho, Boton.SUR, Boton.TEXTO, PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, 0);
        btnAnriSimetricaS = new Boton("Antisimétrica", null, new Dimension(0,0),
                tamanho, Boton.SUR, Boton.TEXTO, PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, 0);
        btnTransitivaS = new Boton("Transitiva", null, new Dimension(0,0),
                tamanho, Boton.SUR, Boton.TEXTO, PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, 0);

        pnBtnS.add(btnReflexivaS);
        pnBtnS.add(btnSimetricaS);
        pnBtnS.add(btnAnriSimetricaS);
        pnBtnS.add(btnTransitivaS);

        pnBtnSFondo.add(lbS, java.awt.BorderLayout.WEST);
        pnBtnSFondo.add(pnBtnS, java.awt.BorderLayout.CENTER);

        pnBtnTipoRelaciones.add(pnBtnRFondo);
        pnBtnTipoRelaciones.add(pnBtnSFondo);

        btnMultiplicacion = new Boton("AxB", null, new Dimension(0,0),
                tamanho, Boton.SUR, Boton.TEXTO, PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, 0);

        btnInversaR = new Boton("R-1", null, new Dimension(0,0),
                tamanho, Boton.SUR, Boton.TEXTO, PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, 0);

        btnInversaS = new Boton("S-1", null, new Dimension(0,0),
                tamanho, Boton.SUR, Boton.TEXTO, PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, 0);

        btnComposicion = new Boton("R°S", null, new Dimension(0,0),
                tamanho, Boton.SUR, Boton.TEXTO, PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, 0);

        pnBtnRelaciones.add(btnMultiplicacion);
        pnBtnRelaciones.add(btnInversaR);
        pnBtnRelaciones.add(btnInversaS);
        pnBtnRelaciones.add(btnComposicion);

        pnOperacionesBtn = new JPanel();
        pnOperacionesBtn.setBackground(PatronDisenho.GRIS_FONDO);
        pnOperacionesBtn.setLayout(new java.awt.BorderLayout(0, 0));

        pnOperacionesBtn.removeAll();

        pnOperacionesBtn.add(pnBtnRelaciones, java.awt.BorderLayout.CENTER);

        pnOperaciones.add(lbTituloOperaciones, java.awt.BorderLayout.NORTH);
        pnOperaciones.add(pnOperacionesBtn, java.awt.BorderLayout.CENTER);

        pnConjuntos = new JPanel();
        pnConjuntos.setBackground(PatronDisenho.GRIS_FONDO);
        pnConjuntos.setLayout(new java.awt.BorderLayout(0, 0));

        lbTituloConjuntos = new JLabel(TITULO_CONJUNTOS);
        lbTituloConjuntos.setOpaque(true);
        lbTituloConjuntos.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbTituloConjuntos.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbTituloConjuntos.setFont(PatronDisenho.SEGOE_16);
        }
        lbTituloConjuntos.setBackground(PatronDisenho.BLANCO);

        pnConjuntosIndi = new JPanel();
        pnConjuntosIndi.setBackground(PatronDisenho.GRIS_FONDO);
        pnConjuntosIndi.setLayout(new java.awt.GridLayout(0, 1, 2, 2));

        pnConjuntoA = new PnConjunto(PatronDisenho.getColorAleatorio(), new Dimension((int) (ancho * 0.0416), 50), "A = { 1, 2 }", false, 0);
        pnConjuntoB = new PnConjunto(PatronDisenho.getColorAleatorio(), new Dimension((int) (ancho * 0.0416), 50), "B = { a, b }", false, 1);
        pnConjuntoC = new PnConjunto(PatronDisenho.getColorAleatorio(), new Dimension((int) (ancho * 0.0416), 50), "C = { x, y }", false, 2);

        pnConjuntosIndi.add(pnConjuntoA);
        pnConjuntosIndi.add(pnConjuntoB);
        pnConjuntosIndi.add(pnConjuntoC);

        pnConjuntos.add(lbTituloConjuntos, java.awt.BorderLayout.NORTH);
        pnConjuntos.add(pnConjuntosIndi, java.awt.BorderLayout.CENTER);

        pnRelaciones = new JPanel();
        pnRelaciones.setBackground(PatronDisenho.GRIS_FONDO);
        pnRelaciones.setLayout(new java.awt.BorderLayout(0, 0));

        lbTituloRelaciones = new JLabel(TITULO_RELACIONES);
        lbTituloRelaciones.setOpaque(true);
        lbTituloRelaciones.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbTituloRelaciones.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbTituloRelaciones.setFont(PatronDisenho.SEGOE_16);
        }
        lbTituloRelaciones.setBackground(PatronDisenho.BLANCO);

        pnRelacionesIndi = new JPanel();
        pnRelacionesIndi.setBackground(PatronDisenho.GRIS_FONDO);
        pnRelacionesIndi.setLayout(new java.awt.GridLayout(0, 1, 2, 2));

        pnRelacionR = new PnConjunto(PatronDisenho.getColorAleatorio(), new Dimension((int) (ancho * 0.0416), 50), "R = { ( 1, 2 ), ( 2, 3 ) }", true, 0);
        pnRelacionS = new PnConjunto(PatronDisenho.getColorAleatorio(), new Dimension((int) (ancho * 0.0416), 50), "S = { ( a, b ), ( c, e ) }", true, 1);

        pnRelacionesIndi.add(pnRelacionR);
        pnRelacionesIndi.add(pnRelacionS);

        pnRelaciones.add(lbTituloRelaciones, java.awt.BorderLayout.NORTH);
        pnRelaciones.add(pnRelacionesIndi, java.awt.BorderLayout.CENTER);

        pnSuperior.add(pnSeleccionarClase);
        pnSuperior.add(pnOperaciones);

        pnCentral.add(pnConjuntos);
        pnCentral.add(pnRelaciones);

        pnInferior = new JPanel();
        pnInferior.setBackground(PatronDisenho.GRIS_FONDO);
        pnInferior.setLayout(new java.awt.GridLayout(2, 1, 5, 5));
        pnInferior.setPreferredSize(new java.awt.Dimension(3, (int) (alto * 0.16)));

        pnSalida = new JPanel();
        pnSalida.setBackground(PatronDisenho.BLANCO);
        pnSalida.setLayout(new java.awt.BorderLayout(0, 0));

        lbTituloSalida = new JLabel(TITULO_SALIDA);
        lbTituloSalida.setOpaque(true);
        lbTituloSalida.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbTituloSalida.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbTituloSalida.setFont(PatronDisenho.SEGOE_16);
        }
        lbTituloSalida.setBackground(PatronDisenho.BLANCO);

        lbSalida = new JLabel(SALIDA_DEFECTO);
        lbSalida.setOpaque(true);
        lbSalida.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbSalida.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbSalida.setFont(PatronDisenho.SEGOE_16);
        }
        lbSalida.setBackground(PatronDisenho.BLANCO);

        spSalida = new JScrollPane(lbSalida,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        spSalida.setBorder(null);
        spSalida.setViewportView(lbSalida);

        pnSalida.add(lbTituloSalida, java.awt.BorderLayout.NORTH);
        pnSalida.add(spSalida, java.awt.BorderLayout.CENTER);

        pnTipoRelacion = new JPanel();
        pnTipoRelacion.setBackground(PatronDisenho.BLANCO);
        pnTipoRelacion.setLayout(new java.awt.BorderLayout(0, 0));

        lbTituloTipoRelacion = new JLabel(TITULO_TIPO_SALIDA);
        lbTituloTipoRelacion.setOpaque(true);
        lbTituloTipoRelacion.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbTituloTipoRelacion.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbTituloTipoRelacion.setFont(PatronDisenho.SEGOE_16);
        }
        lbTituloTipoRelacion.setBackground(PatronDisenho.BLANCO);

        lbTipoRelacion = new JLabel(TIPO_DEFECTO);
        lbTipoRelacion.setOpaque(true);
        lbTipoRelacion.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbTipoRelacion.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbTipoRelacion.setFont(PatronDisenho.SEGOE_16);
        }
        lbTipoRelacion.setBackground(PatronDisenho.BLANCO);

        spTipoRelacion = new JScrollPane(lbTipoRelacion,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        spTipoRelacion.setBorder(null);
        spTipoRelacion.setViewportView(lbTipoRelacion);

        pnTipoRelacion.add(lbTituloTipoRelacion, java.awt.BorderLayout.NORTH);
        pnTipoRelacion.add(spTipoRelacion, java.awt.BorderLayout.CENTER);

        pnInferior.add(pnSalida);
        pnInferior.add(pnTipoRelacion);

        agregarEventoBtnActivos();

        this.add(pnSuperior, java.awt.BorderLayout.NORTH);
        this.add(pnCentral, java.awt.BorderLayout.CENTER);
        this.add(pnInferior, java.awt.BorderLayout.SOUTH);
    }

    private void agregarEventoBtnActivos() {
        btnRelaciones.setActivoSiempre(true);
        btnRelaciones.requestFocus();
        cambiarAColorGris(btnTipoRelacion);
        btnRelaciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                getBtnTipoRelacion().setActivoSiempre(false);
                getBtnTipoRelacion().requestFocus(false);
                getBtnRelaciones().setActivoSiempre(true);
                getBtnRelaciones().requestFocus(true);

                cambiarAColorGris(getBtnTipoRelacion());
                cambiarAColorMorado(getBtnRelaciones());

                cambiarBotones(RELACIONES);

            }
        });

        btnTipoRelacion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                getBtnRelaciones().setActivoSiempre(false);
                getBtnRelaciones().requestFocus(false);
                getBtnTipoRelacion().setActivoSiempre(true);
                getBtnTipoRelacion().requestFocus(true);

                cambiarAColorGris(getBtnRelaciones());
                cambiarAColorMorado(getBtnTipoRelacion());

                cambiarBotones(TIPO_RELACIONES);
            }
        });

    }

    private void cambiarAColorGris(Boton boton) {
        boton.setPRIMARIO(PatronDisenho.GRIS_FONDO_2);
        boton.setFOCO(PatronDisenho.GRIS_RESALTADOR);
        boton.setHOVER(PatronDisenho.GRIS_HOVER);
        boton.setCLICK(PatronDisenho.GRIS_CLICK);
        boton.setCOLOR_FUENTE(PatronDisenho.GRIS_RESALTADOR);

        boton.getPnFondo().setBackground(PatronDisenho.GRIS_FONDO_2);
        boton.getPnDerecha().setBackground(PatronDisenho.GRIS_FONDO_2);
        boton.getPnOrilla().setBackground(PatronDisenho.GRIS_RESALTADOR);
        boton.getLbTexto().setForeground(PatronDisenho.GRIS_RESALTADOR);

        boton.setBorder(null);
        boton.setBorderPainted(false);
        boton.update(boton.getGraphics());
    }

    private void cambiarAColorMorado(Boton boton) {
        boton.setPRIMARIO(PatronDisenho.MORADO_CABECERA);
        boton.setFOCO(PatronDisenho.MORADO_CLARO);
        boton.setHOVER(PatronDisenho.MORADO_HOVER);
        boton.setCLICK(PatronDisenho.MORADO_CLICK);
        boton.setCOLOR_FUENTE(PatronDisenho.BLANCO);

        boton.getPnFondo().setBackground(PatronDisenho.MORADO_CABECERA);
        boton.getPnDerecha().setBackground(PatronDisenho.MORADO_CABECERA);
        boton.getPnOrilla().setBackground(PatronDisenho.MORADO_CLARO);
        boton.getLbTexto().setForeground(PatronDisenho.BLANCO);

        boton.setBorder(null);
        boton.setBorderPainted(false);
        boton.update(boton.getGraphics());
    }

    private void cambiarBotones(String botones) {
        switch (botones) {
            case RELACIONES:
                pnOperacionesBtn.removeAll();
                pnOperacionesBtn.setLayout(new java.awt.BorderLayout(0, 0));
                pnOperacionesBtn.add(pnBtnRelaciones, java.awt.BorderLayout.CENTER);
                break;
            case TIPO_RELACIONES:
                pnOperacionesBtn.removeAll();
                pnOperacionesBtn.setLayout(new java.awt.BorderLayout(0, 0));
                pnOperacionesBtn.add(pnBtnTipoRelaciones, java.awt.BorderLayout.CENTER);
                break;
        }
        pnOperacionesBtn.update(pnOperacionesBtn.getGraphics());
    }

    public PnConjunto getPnConjuntoA() {
        return pnConjuntoA;
    }

    public PnConjunto getPnConjuntoB() {
        return pnConjuntoB;
    }

    public PnConjunto getPnConjuntoC() {
        return pnConjuntoC;
    }

    public PnConjunto getPnRelacionR() {
        return pnRelacionR;
    }

    public PnConjunto getPnRelacionS() {
        return pnRelacionS;
    }

    public Boton getBtnRelaciones() {
        return btnRelaciones;
    }

    public Boton getBtnTipoRelacion() {
        return btnTipoRelacion;
    }

    public Boton getBtnMultiplicacion() {
        return btnMultiplicacion;
    }

    public Boton getBtnInversaR() {
        return btnInversaR;
    }

    public Boton getBtnInversaS() {
        return btnInversaS;
    }

    public Boton getBtnComposicion() {
        return btnComposicion;
    }

    public Boton getBtnReflexivaR() {
        return btnReflexivaR;
    }

    public Boton getBtnSimetricaR() {
        return btnSimetricaR;
    }

    public Boton getBtnAntiSimetricaR() {
        return btnAnriSimetricaR;
    }

    public Boton getBtnTransitivaR() {
        return btnTransitivaR;
    }

    public Boton getBtnReflexivaS() {
        return btnReflexivaS;
    }

    public Boton getBtnSimetricaS() {
        return btnSimetricaS;
    }

    public Boton getBtnAntiSimetricaS() {
        return btnAnriSimetricaS;
    }

    public Boton getBtnTransitivaS() {
        return btnTransitivaS;
    }

    public JLabel getLbSalida() {
        return lbSalida;
    }

    public JLabel getLbTituloTipoRelacion() {
        return lbTituloTipoRelacion;
    }

    public JLabel getLbTipoRelacion() {
        return lbTipoRelacion;
    }

    public void setLbTipoRelacion(JLabel lbTipoRelacion) {
        this.lbTipoRelacion = lbTipoRelacion;
    }

}
