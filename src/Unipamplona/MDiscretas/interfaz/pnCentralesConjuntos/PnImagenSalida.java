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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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

    JFileChooser seleccionar;
    File archivo;

    FileInputStream entrada;
    FileOutputStream salida;

    public PnImagenSalida() {
        super();
        seleccionar = new JFileChooser();
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
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btnGuardarEvent(ae);
            }
        });
        pnArriba.add(btnGuardar, java.awt.BorderLayout.EAST);

        lbImagen = new JLabel();
        lbImagen.setOpaque(true);
        lbImagen.setBackground(PatronDisenho.GRIS_FONDO_2);
        lbImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImagen.setVerticalAlignment(javax.swing.SwingConstants.CENTER);

        spImagen = new JScrollPane(lbImagen,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        spImagen.setBorder(null);
        spImagen.setViewportView(lbImagen);

        int max = 60, min = 30, ini = 40;
        if (ancho < 1500) {
            max = 40;
            min = 20;
            ini = 25;
        }
        slider = new JSlider(JSlider.HORIZONTAL, min, max, ini);
        slider.setFocusable(false);

        this.add(pnArriba, java.awt.BorderLayout.NORTH);
        this.add(spImagen, java.awt.BorderLayout.CENTER);
        this.add(slider, java.awt.BorderLayout.SOUTH);

    }

    private void btnGuardarEvent(java.awt.event.ActionEvent evt) {
        seleccionar = new JFileChooser();
        seleccionar.setDialogTitle("Guardar Imagen");
        seleccionar.setFileFilter(new FileNameExtensionFilter("JPEG (*.jpg;*.jpeg)", "jpg", "jpeg"));
        seleccionar.setFileFilter(new FileNameExtensionFilter("PNG (*.png)", "png"));
        seleccionar.setFileFilter(new FileNameExtensionFilter("Mapa de Bits(*.bmp)", "bmp"));
        seleccionar.setFileFilter(new FileNameExtensionFilter("Todas las imágenes(*.jpg;*.jpeg;*.png;*.bmp)", "jpg", "jpeg", "png", "bmp"));
        seleccionar.setMultiSelectionEnabled(false);
        seleccionar.setName("Formula");
        if (seleccionar.showDialog(this, "Guardar") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            if (archivo.getName().endsWith(".jpg") || archivo.getName().endsWith(".png")
                    || archivo.getName().endsWith(".bmp") || archivo.getName().endsWith(".jpeg")) {
                try {
                    BufferedImage imagen = new BufferedImage(lbImagen.getWidth(), lbImagen.getHeight(), BufferedImage.TYPE_INT_ARGB);
                    lbImagen.paint(imagen.getGraphics());
                    guardarArchivo(archivo, imagen);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error en el sistema.\nIntente nuevamente.", "Error al guardar imagen",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
                }
            } else {
                archivo = null;
                JOptionPane.showMessageDialog(null, "El fórmato de imagen introducido no está permitido", "Error al guardar imagen",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
            }
        }
    }

    public void guardarArchivo(File pFile, BufferedImage imagen) throws IOException {
        try {
            salida = new FileOutputStream(pFile);
            String formato = archivo.getName();
            if (formato.endsWith("jpg")) {
                ImageIO.write(imagen, "jpg", pFile);
            } else if (formato.endsWith("png")) {
                ImageIO.write(imagen, "png", pFile);
            } else if (formato.endsWith("bmp")) {
                ImageIO.write(imagen, "bmp", pFile);
            } else if (formato.endsWith("jpeg")) {
                ImageIO.write(imagen, "jpeg", pFile);
            }
            JOptionPane.showMessageDialog(null, "Imagen guardada exitosamente", "Imagen guardada",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
        } catch (FileNotFoundException ex) {
        }
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
