/**
 * Clase que maneja el panel del diagrama de Venn
 * Tiene como objetivo mostrar el diagrama de Venn
 */
package Unipamplona.MDiscretas.interfaz.pnCentralesConjuntos;

import static Unipamplona.MDiscretas.interfaz.InterfazMain.ancho;
import Unipamplona.MDiscretas.interfaz.PatronDisenho;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author WILMER
 */
public class PnDiagramaVenn extends JPanel {

    private JLabel lbTitulo;

    private JLabel lbIcono;
    private JScrollPane spIcono;

    public PnDiagramaVenn() {
        super();
        crearPanel();
    }

    private void crearPanel() {
        this.setBackground(PatronDisenho.BLANCO);
        this.setLayout(new java.awt.BorderLayout());

        lbIcono = new JLabel();
        lbIcono.setOpaque(true);
        lbIcono.setBackground(PatronDisenho.BLANCO);
        lbIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcono.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        
        lbTitulo = new JLabel("    Diagrama de Venn:");
        lbTitulo.setBackground(PatronDisenho.MORADO_CLICK);
        lbTitulo.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbTitulo.setFont(PatronDisenho.SEGOE_12);
            lbIcono.setIcon(new ImageIcon("./data/Iconos/1x/Proximamente_1366.png"));
        } else {
            lbTitulo.setFont(PatronDisenho.SEGOE_16);
            lbIcono.setIcon(new ImageIcon("./data/Iconos/1x/Proximamente_1920.png"));
        }
        spIcono = new JScrollPane(lbIcono,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        spIcono.setBorder(null);
        spIcono.setViewportView(lbIcono);

        this.add(lbTitulo, java.awt.BorderLayout.NORTH);
        this.add(spIcono, java.awt.BorderLayout.CENTER);

    }
}
