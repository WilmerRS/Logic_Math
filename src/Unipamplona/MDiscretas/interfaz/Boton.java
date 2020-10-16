/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unipamplona.MDiscretas.interfaz;

import static Unipamplona.MDiscretas.interfaz.InterfazMain.ancho;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author WILMER
 */
public class Boton extends JButton {

    public static final int NORTE = 1;
    public static final int SUR = 2;
    public static final int ESTE = 3;
    public static final int OESTE = 4;

    public static final int TEXTO = 1;
    public static final int ICONO = 2;
    public static final int TEXTO_ICONO = 3;

    private Color PRIMARIO;
    private Color FOCO;
    private Color HOVER;
    private Color CLICK;

    private final int TAMANHO;

    private JPanel pnFondo;
    private JPanel pnOrilla;
    private JPanel pnDerecha;

    private Font FUENTE;
    private Color COLOR_FUENTE = PatronDisenho.BLANCO;

    private boolean activoSiempre;

    private JLabel lbTexto;
    JLabel lbIcono;
    private int indice;

    public Boton(String texto, String ruta, Dimension dimension, int tamanho, int foco, int textoIcono,
            Color PRIMARIO, Color FOCO, Color HOVER, Color CLICK, Color COLOR_FUENTE, int indice) {
        super();
        activoSiempre = false;
        this.PRIMARIO = PRIMARIO;
        this.FOCO = FOCO;
        this.HOVER = HOVER;
        this.CLICK = CLICK;
        this.COLOR_FUENTE = COLOR_FUENTE;
        this.TAMANHO = tamanho;
        this.indice = indice;
        iniciar(texto, ruta, foco, textoIcono, dimension);
    }

    private void iniciar(String texto, String ruta, int foco, int textoIcono, Dimension dimension) {
        this.setLayout(new java.awt.BorderLayout());
        this.setText(texto);
        this.setMargin(new java.awt.Insets(0, 0, 0, 0));
        this.setBorder(null);

        if (ancho < 1500) {
            FUENTE = PatronDisenho.SEGOE_12;
        } else {
            FUENTE = PatronDisenho.SEGOE_16;
        }
        pnFondo = new JPanel();
        pnFondo.setLayout(new java.awt.BorderLayout());
        pnFondo.setPreferredSize(dimension);
        pnFondo.setBackground(PRIMARIO);

        pnDerecha = new JPanel();
        pnDerecha.setLayout(new java.awt.BorderLayout());
        pnDerecha.setBackground(PRIMARIO);

        pnOrilla = new JPanel();
        pnOrilla.setVisible(false);

        addEventos();
        posiciontextoIcono(textoIcono, texto, ruta);
        posicionFoco(foco);

        pnFondo.add(java.awt.BorderLayout.CENTER, pnDerecha);
        this.add(java.awt.BorderLayout.CENTER, pnFondo);

    }

    private void posicionFoco(int foco) {
        switch (foco) {
            case NORTE:
                pnOrilla.setPreferredSize(new java.awt.Dimension(0, TAMANHO));
                pnOrilla.setBackground(FOCO);
                pnFondo.add(java.awt.BorderLayout.NORTH, pnOrilla);
                break;
            case SUR:
                pnOrilla.setPreferredSize(new java.awt.Dimension(0, TAMANHO));
                pnOrilla.setBackground(FOCO);
                pnFondo.add(java.awt.BorderLayout.SOUTH, pnOrilla);
                break;
            case ESTE:
                pnOrilla.setPreferredSize(new java.awt.Dimension(TAMANHO, 0));
                pnOrilla.setBackground(FOCO);
                pnFondo.add(java.awt.BorderLayout.EAST, pnOrilla);
                break;
            case OESTE:
                pnOrilla.setPreferredSize(new java.awt.Dimension(TAMANHO, 0));
                pnOrilla.setBackground(FOCO);
                pnFondo.add(java.awt.BorderLayout.WEST, pnOrilla);
                break;
        }
    }

    private void addEventos() {

        // EVENTOS DEL MOUSE
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnDerecha.setBackground(HOVER);
                pnDerecha.updateUI();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!activoSiempre) {
                    pnDerecha.setBackground(PRIMARIO);
                }
                pnDerecha.updateUI();
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnDerecha.setBackground(CLICK);
                pnDerecha.updateUI();
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnDerecha.setBackground(HOVER);
                pnDerecha.updateUI();
            }
        });

        // EVENTOS DEL FOCO
        this.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                getPnOrilla().setVisible(true);
                pnDerecha.setBackground(HOVER);
                pnDerecha.updateUI();
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (!activoSiempre) {
                    getPnOrilla().setVisible(false);
                    pnDerecha.setBackground(PRIMARIO);
                }
                pnDerecha.updateUI();
            }
        });
    }

    private void posiciontextoIcono(int textoIcono, String texto, String ruta) {
        switch (textoIcono) {
            case TEXTO:
                lbTexto = new javax.swing.JLabel();
                lbTexto.setFont(FUENTE);
                lbTexto.setForeground(COLOR_FUENTE);
                lbTexto.setText(texto);
                lbTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                pnDerecha.add(lbTexto);
                break;
            case ICONO:
                lbIcono = new javax.swing.JLabel();
                lbTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                pnDerecha.add(lbTexto);
                break;
            case TEXTO_ICONO:
                lbTexto = new javax.swing.JLabel();
                lbTexto.setFont(FUENTE);
                lbTexto.setForeground(COLOR_FUENTE);
                lbTexto.setText(texto);
                lbTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                pnDerecha.add(java.awt.BorderLayout.SOUTH, lbTexto);

                lbIcono = new javax.swing.JLabel();
                lbIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//                iconoBtn.setIcon();
                pnDerecha.add(java.awt.BorderLayout.CENTER, lbTexto);
                break;
        }
    }

    public boolean isActivoSiempre() {
        return activoSiempre;
    }

    public void setActivoSiempre(boolean activoSiempre) {
        this.activoSiempre = activoSiempre;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public void setPRIMARIO(Color PRIMARIO) {
        this.PRIMARIO = PRIMARIO;
    }

    public void setFOCO(Color FOCO) {
        this.FOCO = FOCO;
    }

    public void setHOVER(Color HOVER) {
        this.HOVER = HOVER;
    }

    public void setCLICK(Color CLICK) {
        this.CLICK = CLICK;
    }

    public void setFUENTE(Font FUENTE) {
        this.FUENTE = FUENTE;
    }

    public void setCOLOR_FUENTE(Color COLOR_FUENTE) {
        this.COLOR_FUENTE = COLOR_FUENTE;
    }

    public JPanel getPnOrilla() {
        return pnOrilla;
    }

    public JLabel getLbTexto() {
        return lbTexto;
    }

    public JPanel getPnFondo() {
        return pnFondo;
    }

    public JPanel getPnDerecha() {
        return pnDerecha;
    }
}
