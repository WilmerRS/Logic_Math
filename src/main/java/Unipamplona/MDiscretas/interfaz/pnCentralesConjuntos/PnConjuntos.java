/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Unipamplona.MDiscretas.interfaz.pnCentralesConjuntos;

import static main.java.Unipamplona.MDiscretas.interfaz.InterfazMain.alto;
import static main.java.Unipamplona.MDiscretas.interfaz.InterfazMain.ancho;
import main.java.Unipamplona.MDiscretas.interfaz.Boton;
import main.java.Unipamplona.MDiscretas.interfaz.PatronDisenho;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author WILMER
 */
public class PnConjuntos extends JPanel {

    private final String AGREGAR = "Agregar";
    private final String BORRAR = "Borrar todo";

    private JPanel pnSuperior;
    private JPanel pnInferior;

//    private ArrayList<JPanel> filasPaneles;
    private JLabel lbTitulo;
    private Boton btnPrincipal;

    private String titulo;
    private String btnNombre;

    public PnConjuntos(String titulo, String btnNombre) {
        super();
        this.titulo = titulo;
        this.btnNombre = btnNombre;
        crearPanel();
    }

    private void crearPanel() {
        this.setLayout(new java.awt.BorderLayout());

        pnSuperior = new JPanel();
        pnSuperior.setLayout(new java.awt.BorderLayout());
        pnSuperior.setBackground(PatronDisenho.BLANCO);

        lbTitulo = new JLabel("    " + titulo + ": ");
        lbTitulo.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbTitulo.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbTitulo.setFont(PatronDisenho.SEGOE_16);
        }
        pnSuperior.add(lbTitulo, java.awt.BorderLayout.CENTER);

        agregarBoton(btnNombre);

        pnSuperior.add(btnPrincipal, java.awt.BorderLayout.EAST);

        pnInferior = new JPanel();
        pnInferior.setBackground(PatronDisenho.GRIS_FONDO_2);
        pnInferior.setLayout(new java.awt.GridBagLayout());

        pnInferior.setBackground(PatronDisenho.GRIS_FONDO_2);
        JScrollPane spConjuntos = new JScrollPane(pnInferior,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        spConjuntos.setBorder(null);

        spConjuntos.setViewportView(pnInferior);

        this.add(pnSuperior, java.awt.BorderLayout.NORTH);
        this.add(spConjuntos, java.awt.BorderLayout.CENTER);
    }

    private void agregarBoton(String nombre) {
        switch (nombre) {
            case AGREGAR:
                btnPrincipal = new Boton("Agregar", null, new Dimension((int) (ancho * 0.06), (int) (alto * 0.043)),
                (int) (ancho * 0.003), Boton.SUR, Boton.TEXTO,
                PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, 0);
                break;
            case BORRAR:
                btnPrincipal = new Boton("Borrar Todo", null, new Dimension((int) (ancho * 0.06), (int) (alto * 0.043)),
                (int) (ancho * 0.003), Boton.SUR, Boton.TEXTO, PatronDisenho.ROJO_OSCURO, PatronDisenho.ROJO_CLARO,
                PatronDisenho.ROJO_HOVER, PatronDisenho.ROJO_CLICK, PatronDisenho.BLANCO, 0);
        }
    }

    public Boton getBtnPrincipal() {
        return btnPrincipal;
    }

    public void setBtnPrincipal(Boton btnPrincipal) {
        this.btnPrincipal = btnPrincipal;
    }

    public JPanel getPnInferior() {
        return pnInferior;
    }

    public void setPnInferior(JPanel pnInferior) {
        this.pnInferior = pnInferior;
    }
}
