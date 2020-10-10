/**
 * Clase del panel lateral
 * Crear el panel lateral y sus botones
 */
package Unipamplona.MDiscretas.interfaz;

import static Unipamplona.MDiscretas.interfaz.InterfazMain.alto;
import static Unipamplona.MDiscretas.interfaz.InterfazMain.ancho;
import javax.swing.JPanel;
import java.awt.Dimension;

/**
 *
 * @author WILMER
 */
public class PnLateral extends JPanel {

    private JPanel pnSuperior;
    private JPanel pnInferior;

    private Boton btnMenu;
    private Boton btnConjuntos;
    private Boton btnMatrices;
    private Boton btnAbout;

    /**
     * determina el tamanho de los botones en el panel
     */
    private final java.awt.Dimension dimensionBotones = new java.awt.Dimension((int) (ancho * 0.043), (int) (ancho * 0.035));

    private int tamanho = (int) (ancho * 0.003);

    public PnLateral() {
        super();
        crearPanel();
    }

    private void crearPanel() {
        /**
         * Determinar las propiedades principales del panel Lateral
         */
        this.setBackground(PatronDisenho.MORADO_OSCURO);
        this.setMinimumSize(new java.awt.Dimension((int) (ancho * 0.043), 100));
        this.setPreferredSize(new java.awt.Dimension((int) (ancho * 0.043), 591));
        this.setLayout(new java.awt.BorderLayout(0, 0));

        /**
         * Creacion de paneles auxialiares
         */
        pnSuperior = new JPanel();
        pnInferior = new JPanel();

        pnSuperior.setBackground(PatronDisenho.MORADO_OSCURO);
        pnInferior.setBackground(PatronDisenho.MORADO_OSCURO);

        pnSuperior.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        /**
         * Creacion de botones de mando
         */
        btnMenu = new Boton("[[]]", null, dimensionBotones, tamanho, Boton.OESTE, Boton.TEXTO,
                PatronDisenho.MORADO_OSCURO, PatronDisenho.MORADO_CLARO, PatronDisenho.MORADO_HOVER,
                PatronDisenho.MORADO_CLICK, PatronDisenho.BLANCO);
        btnConjuntos = new Boton("C", null, dimensionBotones, tamanho, Boton.OESTE, Boton.TEXTO,
                PatronDisenho.MORADO_OSCURO, PatronDisenho.MORADO_CLARO, PatronDisenho.MORADO_HOVER,
                PatronDisenho.MORADO_CLICK, PatronDisenho.BLANCO);
        btnMatrices = new Boton("R", null, dimensionBotones, tamanho, Boton.OESTE, Boton.TEXTO,
                PatronDisenho.MORADO_OSCURO, PatronDisenho.MORADO_CLARO, PatronDisenho.MORADO_HOVER,
                PatronDisenho.MORADO_CLICK, PatronDisenho.BLANCO);
        btnAbout = new Boton("?", null, dimensionBotones, tamanho, Boton.OESTE, Boton.TEXTO,
                PatronDisenho.MORADO_OSCURO, PatronDisenho.MORADO_CLARO, PatronDisenho.MORADO_HOVER,
                PatronDisenho.MORADO_CLICK, PatronDisenho.BLANCO);

        pnSuperior.add(btnMenu);
        pnSuperior.add(btnConjuntos);
        pnSuperior.add(btnMatrices);
        pnInferior.add(btnAbout);

        /**
         * Añadir paneles a panel general
         */
        this.add(pnSuperior, java.awt.BorderLayout.CENTER);
        this.add(pnInferior, java.awt.BorderLayout.SOUTH);
    }

    
    public Boton getBtnMenu() {
        return btnMenu;
    }

    public void setBtnMenu(Boton btnMenu) {
        this.btnMenu = btnMenu;
    }

    public Boton getBtnConjuntos() {
        return btnConjuntos;
    }

    public void setBtnConjuntos(Boton btnConjuntos) {
        this.btnConjuntos = btnConjuntos;
    }

    public Boton getBtnMatrices() {
        return btnMatrices;
    }

    public void setBtnMatrices(Boton btnMatrices) {
        this.btnMatrices = btnMatrices;
    }

    public Boton getBtnAbout() {
        return btnAbout;
    }

    public void setBtnAbout(Boton btnAbout) {
        this.btnAbout = btnAbout;
    }

}
