/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unipamplona.MDiscretas.interfaz.pnCentralesConjuntos;

import Unipamplona.MDiscretas.interfaz.Boton;
import Unipamplona.MDiscretas.interfaz.InterfazMain;
import static Unipamplona.MDiscretas.interfaz.InterfazMain.alto;
import static Unipamplona.MDiscretas.interfaz.InterfazMain.ancho;
import Unipamplona.MDiscretas.interfaz.PatronDisenho;
import Unipamplona.MDiscretas.interfaz.VnConjunto;
import Unipamplona.MDiscretas.mundo.Conjunto;
import Unipamplona.MDiscretas.mundo.Conjuntos;
import Unipamplona.MDiscretas.mundo.Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author WILMER
 */
public class PnConjuntos extends JPanel {

    private ArrayList<Conjunto> conjuntos; 
    
    private JPanel pnSuperior;
    private JPanel pnInferior;

    private ArrayList<JPanel> filasPaneles;

    private JLabel lbTitulo;
    private Boton btnAgregar;

    public PnConjuntos() {
        super();
        conjuntos = new ArrayList<>();
        crearPanel();
    }

    private void crearPanel() {
        this.setLayout(new java.awt.BorderLayout());

        pnSuperior = new JPanel();
        pnSuperior.setLayout(new java.awt.BorderLayout());
        pnSuperior.setBackground(PatronDisenho.BLANCO);

        lbTitulo = new JLabel("    Conjuntos registrados:");
        lbTitulo.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbTitulo.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbTitulo.setFont(PatronDisenho.SEGOE_16);
        }
        pnSuperior.add(lbTitulo, java.awt.BorderLayout.CENTER);

        btnAgregar = new Boton("Agregar", null, new Dimension((int) (ancho * 0.06), (int) (alto * 0.043)),
                (int) (ancho * 0.003), Boton.SUR, Boton.TEXTO,
                PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR);
        ventanaEmergente();

        pnSuperior.add(btnAgregar, java.awt.BorderLayout.EAST);

        PnConjunto temp1 = new PnConjunto(Color.yellow, new Dimension((int) (ancho * 0.035), (int) (ancho * 0.035)));
        PnConjunto temp2 = new PnConjunto(Color.black, new Dimension((int) (ancho * 0.035), (int) (ancho * 0.035)));
        PnConjunto temp3 = new PnConjunto(Color.green, new Dimension((int) (ancho * 0.035), (int) (ancho * 0.035)));

        pnInferior = new JPanel();
        pnInferior.setBackground(PatronDisenho.GRIS_FONDO_2);
        pnInferior.setLayout(new java.awt.GridBagLayout());

        GridBagConstraints constrains = new GridBagConstraints();
        constrains.gridx = 0;
        constrains.gridy = GridBagConstraints.RELATIVE;
        constrains.gridwidth = GridBagConstraints.RELATIVE;
        constrains.gridheight = GridBagConstraints.RELATIVE;
        constrains.weightx = 1f;
        constrains.weighty = 0.1;
        constrains.ipadx = 0;
        constrains.ipady = 0;
        constrains.insets = new Insets(10, 10, 10, 10);
        constrains.fill = GridBagConstraints.HORIZONTAL;
        constrains.anchor = GridBagConstraints.PAGE_START;

        pnInferior.add(temp1, constrains);
        pnInferior.add(temp2, constrains);
        pnInferior.add(temp3, constrains);

        JScrollPane spConjuntos = new JScrollPane(pnInferior,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        spConjuntos.setBorder(null);

        spConjuntos.setViewportView(pnInferior);

        this.add(pnSuperior, java.awt.BorderLayout.NORTH);
        this.add(spConjuntos, java.awt.BorderLayout.CENTER);
    }

    private void ventanaEmergente() {
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Conjunto temp = new Conjunto("B", new ArrayList(), PatronDisenho.MORADO_CABECERA_CLICK);
                VnConjunto vnConjunto = new VnConjunto(InterfazMain.getFrames()[0], true, "Agregar un nuevo conjunto", temp);
                vnConjunto.setVisible(true);
                Conjuntos conjuntos = Main.getTodo();
            }
        });
    }

}
