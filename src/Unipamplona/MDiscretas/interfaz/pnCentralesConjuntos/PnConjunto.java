/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unipamplona.MDiscretas.interfaz.pnCentralesConjuntos;

import Unipamplona.MDiscretas.interfaz.Boton;
import static Unipamplona.MDiscretas.interfaz.InterfazMain.ancho;
import Unipamplona.MDiscretas.interfaz.PatronDisenho;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author WILMER
 */
public class PnConjunto extends JPanel {

    private int tamanho = (int) (ancho * 0.003);

    private Color colorConjunto;

    private JPanel pnIzquierda;
    private JPanel pnColor;
    private JPanel pnColorInterno;

    private JPanel pnBotones;

    private JLabel lbConjunto;

    private Boton btnEliminar;
    private Boton btnEditar;

    private JScrollPane spConjunto;

    private Dimension dimension;

    private String elementos;

    private boolean editarActivo;
    
    private int indice;

    public PnConjunto(Color color, Dimension dimension, String elementos, boolean editarActivo, int indice) {
        super();
        colorConjunto = color;
        this.elementos = elementos;
        this.dimension = dimension;
        this.editarActivo = editarActivo;
        this.indice = indice;
        crearPanel();
    }

    private void crearPanel() {
        this.setLayout(new java.awt.BorderLayout());

        pnColor = new JPanel();
        pnColor.setPreferredSize(dimension);
        pnColor.setLayout(new java.awt.GridLayout());

        pnColorInterno = new JPanel();
        pnColorInterno.setPreferredSize(new Dimension(10, 10));
        pnColorInterno.setBackground(colorConjunto);

        GridBagConstraints c = new GridBagConstraints(GridBagConstraints.RELATIVE, GridBagConstraints.RELATIVE,
                GridBagConstraints.REMAINDER, GridBagConstraints.REMAINDER, 1f, 1f, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 10, 10);

        pnColor.add(pnColorInterno, c);

        pnBotones = new JPanel();
        pnBotones.setLayout(new java.awt.GridLayout(1, 1));

        btnEliminar = new Boton(" X ", null, dimension, tamanho, Boton.SUR, Boton.TEXTO,
                PatronDisenho.BLANCO, PatronDisenho.ROJO_OSCURO, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, indice);
        if (editarActivo) {
            btnEditar = new Boton(" E ", null, dimension, tamanho, Boton.SUR, Boton.TEXTO,
                    PatronDisenho.BLANCO, PatronDisenho.MORADO_OSCURO, PatronDisenho.GRIS_HOVER,
                    PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, indice);
            pnBotones.add(btnEditar);
        }
        pnBotones.add(btnEliminar);

        lbConjunto = new JLabel("     " + elementos);

        lbConjunto.setForeground(PatronDisenho.MORADO_OSCURO);
        lbConjunto.setOpaque(true);
        lbConjunto.setBackground(PatronDisenho.BLANCO);

        if (ancho < 1500) {
            lbConjunto.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbConjunto.setFont(PatronDisenho.SEGOE_16);
        }

        spConjunto = new JScrollPane(lbConjunto,
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        spConjunto.setBorder(null);

        spConjunto.setViewportView(lbConjunto);

        pnIzquierda = new JPanel();
        pnIzquierda.setPreferredSize(dimension);
        pnIzquierda.setLayout(new java.awt.BorderLayout());

        pnIzquierda.add(pnColor, java.awt.BorderLayout.WEST);
        pnIzquierda.add(spConjunto, java.awt.BorderLayout.CENTER);

        this.add(pnIzquierda, java.awt.BorderLayout.CENTER);
        this.add(pnBotones, java.awt.BorderLayout.EAST);
    }

    public void actualizarElementos(String elementos) {
        this.elementos = elementos;
        lbConjunto.setText("     " + elementos);
        lbConjunto.updateUI();
    }


    public Boton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(Boton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public Boton getBtnEditar() {
        return btnEditar;
    }

    public void setBtnEditar(Boton btnEditar) {
        this.btnEditar = btnEditar;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
}
