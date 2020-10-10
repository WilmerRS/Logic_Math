/**
 * Clase que maneja el panel del diagrama de Venn
 * Tiene como objetivo mostrar el diagrama de Venn
 */
package Unipamplona.MDiscretas.interfaz.pnCentralesConjuntos;

import static Unipamplona.MDiscretas.interfaz.InterfazMain.ancho;
import Unipamplona.MDiscretas.interfaz.PatronDisenho;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author WILMER
 */
public class PnDiagramaVenn extends JPanel {

    JLabel lbTitulo;
    public PnDiagramaVenn() {
        super();
        crearPanel();
    }

    private void crearPanel() {
        this.setBackground(PatronDisenho.BLANCO);
        this.setLayout(new java.awt.BorderLayout());
        
        lbTitulo = new JLabel("    Diagrama de Venn:");
        lbTitulo.setBackground(PatronDisenho.MORADO_CLICK);
        lbTitulo.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbTitulo.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbTitulo.setFont(PatronDisenho.SEGOE_16);
        }
        
        this.add(lbTitulo, java.awt.BorderLayout.NORTH);
    }
}
