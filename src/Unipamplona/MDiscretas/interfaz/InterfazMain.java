package Unipamplona.MDiscretas.interfaz;

import javax.swing.ImageIcon;

/**
 *
 * @author WILMER
 */
public class InterfazMain extends javax.swing.JFrame {

    /**
     * Variables de ancho y alto de la pantalla donde se ejecuta la app Ayuda a
     * mantener la relacion de aspecto en diferentes resoluciones
     */
    public static final int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

    private PnLateral lateral;
    private PnCabecera cabecera;
    private PnCentralConjuntos centralConjuntos;
    private PnCentralRelaciones centralRelaciones;

    private final String TITULO = "Logic Math";
    private final String TITULO_CON = "Conjuntos - Operaciones";
    private final String TITULO_REL = "Relaciones - Operaciones";

    /**
     * Constructor de una nueva InterfazMain
     */
    public InterfazMain() {
        initComponents();
        crearPanelesPrincipales();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png").getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        pnDerechaFondo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension((int) (ancho * 0.5), (int)(alto * 0.5)));

        Background.setBackground(PatronDisenho.GRIS_FONDO);
        Background.setMinimumSize(new java.awt.Dimension((int)(ancho*0.5), (int)(alto*0.5)));
        Background.setPreferredSize(new java.awt.Dimension((int)(ancho*0.75), (int)(alto*0.75)));
        Background.setLayout(new java.awt.BorderLayout(5, 0));

        pnDerechaFondo.setBackground(PatronDisenho.GRIS_FONDO);
        pnDerechaFondo.setLayout(new java.awt.BorderLayout(0, 5));
        Background.add(pnDerechaFondo, java.awt.BorderLayout.CENTER);

        getContentPane().add(Background, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearPanelesPrincipales() {
        lateral = new PnLateral();
        cabecera = new PnCabecera(TITULO_CON);
        centralConjuntos = new PnCentralConjuntos();
        centralRelaciones = new PnCentralRelaciones();

        Background.add(lateral, java.awt.BorderLayout.LINE_START);
        pnDerechaFondo.add(cabecera, java.awt.BorderLayout.NORTH);
        pnDerechaFondo.add(centralConjuntos, java.awt.BorderLayout.CENTER);
        setTitle(TITULO + " - " + centralConjuntos.getTITULO_RELACIONES());
        agregarEventosBtnLaterales();
    }

    private void agregarEventosBtnLaterales() {
        lateral.getBtnConjuntos().setActivoSiempre(true);
        lateral.getBtnConjuntos().requestFocus();

        lateral.getBtnConjuntos().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lateral.getBtnMatrices().setActivoSiempre(false);
                lateral.getBtnMatrices().requestFocus(false);
                lateral.getBtnConjuntos().setActivoSiempre(true);
                lateral.getBtnConjuntos().requestFocus(true);

                centralConjuntos.setVisible(true);
                centralRelaciones.setVisible(false);
                pnDerechaFondo.add(centralConjuntos, java.awt.BorderLayout.CENTER);
                setTitle(TITULO + " - " + centralConjuntos.getTITULO_RELACIONES());
                cabecera.actualizarTitulo(TITULO_CON);
            }
        });

        lateral.getBtnMatrices().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lateral.getBtnConjuntos().setActivoSiempre(false);
                lateral.getBtnConjuntos().requestFocus(false);
                lateral.getBtnMatrices().setActivoSiempre(true);
                lateral.getBtnMatrices().requestFocus(true);

                centralConjuntos.setVisible(false);
                centralRelaciones.setVisible(true);
                pnDerechaFondo.add(centralRelaciones, java.awt.BorderLayout.CENTER);

                setTitle(TITULO + " - " + centralRelaciones.getTITULO_RELACIONES());
                cabecera.actualizarTitulo(TITULO_REL);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JPanel pnDerechaFondo;
    // End of variables declaration//GEN-END:variables

}
