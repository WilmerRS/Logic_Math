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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;

/**
 *
 * @author WILMER
 */
public class PnImagenSalida extends JPanel {

    private final Dimension dimension = new Dimension(10, (int) (alto * 0.12));

    private JPanel pnArriba;

    private Boton btnGuardar;

    private JLabel lbTitulo;
    private JLabel lbImagen;
    private JScrollPane spImagen;
    private JSlider slider;

    public PnImagenSalida() {
        super();
        crearPanel();
    }

    private void crearPanel() {
        this.setBackground(PatronDisenho.GRIS_FONDO);
        this.setMinimumSize(dimension);
        this.setPreferredSize(dimension);
        this.setLayout(new java.awt.BorderLayout(5, 0));

        pnArriba = new JPanel();
        pnArriba.setLayout(new java.awt.BorderLayout());
        pnArriba.setBackground(PatronDisenho.BLANCO);

        lbTitulo = new JLabel("    Fórmula evaluada:");
        lbTitulo.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbTitulo.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbTitulo.setFont(PatronDisenho.SEGOE_16);
        }
        pnArriba.add(lbTitulo, java.awt.BorderLayout.CENTER);

        btnGuardar = new Boton("Guardar", null, new Dimension((int) (ancho * 0.06), (int) (alto * 0.04)),
                (int) (ancho * 0.003), Boton.SUR, Boton.TEXTO, PatronDisenho.MORADO_CABECERA, PatronDisenho.MORADO_CLARO,
                PatronDisenho.MORADO_CABECERA_HOVER, PatronDisenho.MORADO_CABECERA_CLICK, PatronDisenho.BLANCO, 0);
        pnArriba.add(btnGuardar, java.awt.BorderLayout.EAST);

        lbImagen = new JLabel();
//        lbImagen.setIcon(new ImageIcon("./data/Iconos/1x/Proximamente_1366.png"));
        lbImagen.setOpaque(true);
        lbImagen.setBackground(PatronDisenho.GRIS_FONDO_2);
        lbImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImagen.setVerticalAlignment(javax.swing.SwingConstants.CENTER);

        spImagen = new JScrollPane(lbImagen,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        spImagen.setBorder(null);
        spImagen.setViewportView(lbImagen);

        int max = 60,min = 30,ini= 40;
        if(ancho < 1500){
            System.out.println("2");
            max= 40;
            min = 20;
            ini = 25;
        }
        slider = new JSlider(JSlider.HORIZONTAL, min, max, ini);
        slider.setFocusable(false);

        this.add(pnArriba, java.awt.BorderLayout.NORTH);
        this.add(spImagen, java.awt.BorderLayout.CENTER);
        this.add(slider, java.awt.BorderLayout.SOUTH);

    }

    public JLabel getLbImagen() {
        return lbImagen;
    }

    public void setLbImagen(JLabel lbImagen) {
        this.lbImagen = lbImagen;
    }

    public JSlider getSlider() {
        return slider;
    }

    public void setSlider(JSlider slider) {
        this.slider = slider;
    }
}
