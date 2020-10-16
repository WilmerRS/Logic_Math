/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unipamplona.MDiscretas.interfaz;

import static Unipamplona.MDiscretas.interfaz.InterfazMain.alto;
import static Unipamplona.MDiscretas.interfaz.InterfazMain.ancho;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Luis Alfredo
 */
public class VnTutorial extends javax.swing.JDialog {

    private PnCabecera pnCabecera;
    private String titulo;
    private JLabel lbImagenConjuntos;
    private JLabel lbImagenRelaciones;
    private JScrollPane spTutorial;
    private Boton btnConjuntos;
    private Boton btnRelaciones;
    private JPanel pnFondo;
    private JPanel pnBotones;

    private final java.awt.Dimension dimensionBotones = new java.awt.Dimension((int) (ancho * 0.043), (int) (ancho * 0.035));

    private int tamanho = (int) (ancho * 0.003);

    public VnTutorial(java.awt.Frame parent, boolean modal, String titulo) {
        super(parent, modal);
        this.titulo = titulo;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.setPreferredSize(new java.awt.Dimension((int) (ancho * 0.45), (int) (alto * 0.58)));
        this.setLayout(new java.awt.BorderLayout(5, 5));
        this.setBackground(PatronDisenho.GRIS_FONDO);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setLayout(new java.awt.BorderLayout());
        this.setResizable(false);
        this.setIconImage(new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png").getImage());
        this.setTitle(titulo);

        pnCabecera = new PnCabecera("   " + titulo);
        pnCabecera.setPreferredSize(new java.awt.Dimension((int) (ancho * 0.3073), (int) (alto * 0.063)));

        btnConjuntos = new Boton("Conjuntos", null, dimensionBotones, tamanho, Boton.SUR, Boton.TEXTO,
                PatronDisenho.MORADO_OSCURO, PatronDisenho.MORADO_CLARO, PatronDisenho.MORADO_HOVER,
                PatronDisenho.MORADO_CLICK, PatronDisenho.BLANCO, 0);

        btnRelaciones = new Boton("Relaciones", null, dimensionBotones, tamanho, Boton.SUR, Boton.TEXTO,
                PatronDisenho.MORADO_OSCURO, PatronDisenho.MORADO_CLARO, PatronDisenho.MORADO_HOVER,
                PatronDisenho.MORADO_CLICK, PatronDisenho.BLANCO, 0);

        lbImagenRelaciones = new JLabel();
        lbImagenRelaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImagenRelaciones.setOpaque(true);
        lbImagenRelaciones.setBackground(PatronDisenho.BLANCO);
        lbImagenRelaciones.setIcon(new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
        if (ancho < 1500) {
            lbImagenRelaciones.setIcon(new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
        }

        lbImagenConjuntos = new JLabel();
        lbImagenConjuntos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImagenConjuntos.setOpaque(true);
        lbImagenConjuntos.setBackground(PatronDisenho.BLANCO);
        lbImagenConjuntos.setIcon(new ImageIcon("./data/Iconos/1x/tutorial_conjuntos_max.png"));
        if (ancho < 1500) {
            lbImagenConjuntos.setIcon(new ImageIcon("./data/Iconos/1x/Icono-tutorial_conjuntos_min.png"));
        }

        spTutorial = new JScrollPane(lbImagenConjuntos,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        spTutorial.setBorder(null);
        spTutorial.setViewportView(lbImagenConjuntos);
        eventoAgregarImagen();
        pnFondo = new JPanel();
        pnFondo.setLayout(new java.awt.BorderLayout(0, 0));

        pnBotones = new JPanel();
        pnBotones.setLayout(new java.awt.GridLayout(1, 0));
        pnBotones.add(btnConjuntos);
        pnBotones.add(btnRelaciones);

        pnFondo.add(pnBotones, java.awt.BorderLayout.NORTH);
        pnFondo.add(spTutorial, java.awt.BorderLayout.CENTER);

        this.add(this.pnCabecera, java.awt.BorderLayout.NORTH);
        this.add(this.pnFondo, java.awt.BorderLayout.CENTER);
        pack();

    }

    public void eventoAgregarImagen() {
        btnConjuntos.setActivoSiempre(true);
        btnConjuntos.requestFocus();
        cambiarAColorGris(btnRelaciones);

        setTitle(titulo + " - Conjuntos");
        pnCabecera.actualizarTitulo(titulo + " - Conjuntos");

        btnConjuntos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRelaciones.setActivoSiempre(false);
                btnRelaciones.requestFocus(false);
                btnConjuntos.setActivoSiempre(true);
                btnConjuntos.requestFocus(true);

                spTutorial.setViewportView(lbImagenConjuntos);

                cambiarAColorGris(btnRelaciones);
                cambiarAColorMorado(btnConjuntos);

                setTitle(titulo + " - Conjuntos");
                pnCabecera.actualizarTitulo(titulo + " - Conjuntos");
            }
        });
        btnRelaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnConjuntos.setActivoSiempre(false);
                btnConjuntos.requestFocus(false);
                btnRelaciones.setActivoSiempre(true);
                btnRelaciones.requestFocus(true);

                spTutorial.setViewportView(lbImagenRelaciones);

                cambiarAColorGris(btnConjuntos);
                cambiarAColorMorado(btnRelaciones);

                setTitle(titulo + " - Relaciones");
                pnCabecera.actualizarTitulo(titulo + " - Relaciones");
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
}
