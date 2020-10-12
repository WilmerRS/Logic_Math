/**
 * Clase que controla y crea la cabecera
 */
package Unipamplona.MDiscretas.interfaz;

import javax.swing.JPanel;
import static Unipamplona.MDiscretas.interfaz.InterfazMain.alto;
import static Unipamplona.MDiscretas.interfaz.InterfazMain.ancho;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author WILMER
 */
public class PnCabecera extends JPanel {

    private JLabel tituloCabecera;
    private JLabel espacio;
    private JLabel espacio2;
    private JPanel pnEspaciado;
    private String titulo;
    

    public PnCabecera(String titulo) {
        super();
        this.titulo = titulo;
        crearPanel();
    }

    public void actualizarTitulo(String titulo){
        this.titulo = titulo;
        tituloCabecera.setText("   "+titulo);
        tituloCabecera.updateUI();
    }
    
    private void crearPanel() {
        this.setBackground(PatronDisenho.MORADO_CABECERA);
        this.setMinimumSize(new Dimension(1000, (int) (alto * 0.063)));
        this.setPreferredSize(new Dimension(1000, (int) (alto * 0.063)));
        this.setLayout(new BorderLayout(0, 0));

        pnEspaciado = new JPanel();
        pnEspaciado.setLayout(new BorderLayout(0, 0));
        pnEspaciado.setBackground(PatronDisenho.MORADO_CABECERA);

        espacio2 = new JLabel("");
        espacio2.setPreferredSize(new Dimension((int) (alto * 0.025), (int) (alto * 0.03)));

        espacio = new JLabel("");
        espacio.setPreferredSize(new Dimension((int) (alto * 0.063), (int) (alto * 0.063)));
        

        tituloCabecera = new javax.swing.JLabel();
        tituloCabecera.setForeground(PatronDisenho.BLANCO);
        tituloCabecera.setText("   "+titulo);

        if (ancho < 1500) {
            tituloCabecera.setFont(PatronDisenho.SEGOE_14);
            espacio.setIcon(new ImageIcon("./data/Iconos/1x/Icono-cabecera-37x37.png"));
        } else {
            tituloCabecera.setFont(PatronDisenho.SEGOE_18);
            espacio.setIcon(new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
        }
        pnEspaciado.add(espacio2, BorderLayout.WEST);
        pnEspaciado.add(espacio, BorderLayout.CENTER);
        this.add(pnEspaciado, BorderLayout.WEST);
        this.add(tituloCabecera, BorderLayout.CENTER);
    }
}
