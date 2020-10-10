/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unipamplona.MDiscretas.interfaz.pnCentralesConjuntos;

import Unipamplona.MDiscretas.interfaz.Boton;
import static Unipamplona.MDiscretas.interfaz.InterfazMain.alto;
import javax.swing.JPanel;
import static Unipamplona.MDiscretas.interfaz.InterfazMain.ancho;
import Unipamplona.MDiscretas.interfaz.PatronDisenho;
import java.awt.Dimension;
import javax.swing.JLabel;

/**
 *
 * @author WILMER
 */
public class PnImagenSalida extends JPanel {

    private final Dimension dimension = new Dimension(10, (int) (alto * 0.063));

    private JPanel pnCentral;

    private Boton btnGuardar;

    private JLabel lbTitulo;
    private JLabel lbImagen;

    public PnImagenSalida() {
        super();
        crearPanel();
    }

    private void crearPanel() {
        this.setBackground(PatronDisenho.GRIS_FONDO);
        this.setMinimumSize(dimension);
        this.setPreferredSize(dimension);
        this.setLayout(new java.awt.BorderLayout(5, 0));

        pnCentral = new JPanel();
        pnCentral.setLayout(new java.awt.BorderLayout());
        pnCentral.setBackground(PatronDisenho.BLANCO);

        lbImagen = new JLabel("    imagen");
        pnCentral.add(lbImagen, java.awt.BorderLayout.CENTER);
        
        lbTitulo = new JLabel("    Fórmula evaluada:");
        lbTitulo.setBackground(PatronDisenho.MORADO_CLICK);
        lbTitulo.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbTitulo.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbTitulo.setFont(PatronDisenho.SEGOE_16);
        }
        pnCentral.add(lbTitulo, java.awt.BorderLayout.NORTH);

        

        btnGuardar = new Boton("Guardar", null, new Dimension((int) (ancho * 0.07), (int) (alto * 0.063)),
                (int) (ancho * 0.003), Boton.SUR, Boton.TEXTO, PatronDisenho.MORADO_CABECERA, PatronDisenho.MORADO_CLARO,
                PatronDisenho.MORADO_CABECERA_HOVER, PatronDisenho.MORADO_CABECERA_CLICK, PatronDisenho.BLANCO);

        this.add(pnCentral, java.awt.BorderLayout.CENTER);
        this.add(btnGuardar, java.awt.BorderLayout.EAST);
    }
}
