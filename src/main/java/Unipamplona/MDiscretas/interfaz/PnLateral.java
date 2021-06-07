/**
 * Clase del panel lateral
 * Crear el panel lateral y sus botones
 */
package main.java.Unipamplona.MDiscretas.interfaz;

import static main.java.Unipamplona.MDiscretas.interfaz.InterfazMain.ancho;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author WILMER
 */
public class PnLateral extends JPanel {

    private final static String TITULO_ACERCA_DE = "Acerca de";
    private final static String TITULO_TUTORIAL = "Tutorial";
    private JPanel pnSuperior;
    private JPanel pnInferior;

    private Boton btnMenu;
    private Boton btnConjuntos;
    private Boton btnMatrices;
    private Boton btnAbout;
    private Boton btnTutorial;

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
        pnInferior.setLayout(new java.awt.GridLayout(0, 1));

        /**
         * Creacion de botones de mando
         */
        btnMenu = new Boton("[[]]", null, dimensionBotones, tamanho, Boton.OESTE, Boton.TEXTO,
                PatronDisenho.MORADO_OSCURO, PatronDisenho.MORADO_CLARO, PatronDisenho.MORADO_HOVER,
                PatronDisenho.MORADO_CLICK, PatronDisenho.BLANCO, 0);
        btnConjuntos = new Boton("C", null, dimensionBotones, tamanho, Boton.OESTE, Boton.TEXTO,
                PatronDisenho.MORADO_OSCURO, PatronDisenho.MORADO_CLARO, PatronDisenho.MORADO_HOVER,
                PatronDisenho.MORADO_CLICK, PatronDisenho.BLANCO, 0);
        btnMatrices = new Boton("R", null, dimensionBotones, tamanho, Boton.OESTE, Boton.TEXTO,
                PatronDisenho.MORADO_OSCURO, PatronDisenho.MORADO_CLARO, PatronDisenho.MORADO_HOVER,
                PatronDisenho.MORADO_CLICK, PatronDisenho.BLANCO, 0);
        btnAbout = new Boton("?", null, dimensionBotones, tamanho, Boton.OESTE, Boton.TEXTO,
                PatronDisenho.MORADO_OSCURO, PatronDisenho.MORADO_CLARO, PatronDisenho.MORADO_HOVER,
                PatronDisenho.MORADO_CLICK, PatronDisenho.BLANCO, 0);
        btnTutorial = new Boton("T", null, dimensionBotones, tamanho, Boton.OESTE, Boton.TEXTO,
                PatronDisenho.MORADO_OSCURO, PatronDisenho.MORADO_CLARO, PatronDisenho.MORADO_HOVER,
                PatronDisenho.MORADO_CLICK, PatronDisenho.BLANCO, 0);

        agregarEventoBotonAbout();
        agregarEventoBotonTutorial();

        pnSuperior.add(btnMenu);
        pnSuperior.add(btnConjuntos);
        pnSuperior.add(btnMatrices);
        pnInferior.add(btnTutorial);
        pnInferior.add(btnAbout);

        /**
         * Añadir paneles a panel general
         */
        this.add(pnSuperior, java.awt.BorderLayout.CENTER);
        this.add(pnInferior, java.awt.BorderLayout.SOUTH);
    }

    public void agregarEventoBotonAbout() {
        btnAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VnAbout vn = new VnAbout(InterfazMain.getFrames()[0], true, TITULO_ACERCA_DE);
                vn.setVisible(true);
            }
        });

    }

    public void agregarEventoBotonTutorial() {
        btnTutorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VnTutorial vn = new VnTutorial(InterfazMain.getFrames()[0], true, TITULO_TUTORIAL);
                vn.setVisible(true);
            }
        });
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
