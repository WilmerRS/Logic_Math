/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unipamplona.MDiscretas.interfaz;

import static Unipamplona.MDiscretas.interfaz.InterfazMain.alto;
import static Unipamplona.MDiscretas.interfaz.InterfazMain.ancho;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author Luis Alfredo
 */
public class VnAbout extends javax.swing.JDialog{

    private PnCabecera pnCabecera;
    private String titulo;
    private JLabel lbImagen;
    private JScrollPane spTutorial;

      public VnAbout(java.awt.Frame parent, boolean modal, String titulo) {
        super(parent, modal);
        this.titulo = titulo;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.setPreferredSize(new java.awt.Dimension((int) (ancho * 0.45), (int) (alto * 0.58)));
        this.setLayout(new java.awt.BorderLayout(5,5));
        this.setBackground(PatronDisenho.GRIS_FONDO);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setLayout(new java.awt.BorderLayout());
        this.setResizable(false);
        this.setIconImage(new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png").getImage());
        this.setTitle(titulo);
        
        pnCabecera = new PnCabecera("   " + titulo);
        pnCabecera.setPreferredSize(new java.awt.Dimension((int) (ancho * 0.3073), (int) (alto * 0.063)));
        
        lbImagen = new JLabel();
        lbImagen.setIcon(new ImageIcon("./data/Iconos/1x/Acerca_de.png"));
        if(ancho < 1500){
            lbImagen.setIcon(new ImageIcon("./data/Iconos/1x/Acerca_de_min.png"));
        }
        lbImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImagen.setOpaque(true);
        lbImagen.setBackground(PatronDisenho.BLANCO);
        spTutorial= new JScrollPane(lbImagen,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        spTutorial.setBorder(null);
        spTutorial.setViewportView(lbImagen);
        
        this.add(this.pnCabecera, java.awt.BorderLayout.NORTH);
        this.add(this.spTutorial, java.awt.BorderLayout.CENTER);
        pack();
        
    }
    
}
