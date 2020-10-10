/**
 * Clase que controla los paneles internos del centro
 */
package Unipamplona.MDiscretas.interfaz;

import javax.swing.JPanel;
import Unipamplona.MDiscretas.interfaz.pnCentralesConjuntos.PnConjuntos;
import Unipamplona.MDiscretas.interfaz.pnCentralesConjuntos.PnDiagramaVenn;
import Unipamplona.MDiscretas.interfaz.pnCentralesConjuntos.PnElementosConjunto;
import Unipamplona.MDiscretas.interfaz.pnCentralesConjuntos.PnEntradaDatos;
import Unipamplona.MDiscretas.interfaz.pnCentralesConjuntos.PnImagenSalida;
import Unipamplona.MDiscretas.interfaz.pnCentralesConjuntos.PnTablaVerdad;
import Unipamplona.MDiscretas.mundo.Interpretador;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author WILMER
 */
public class PnCentralConjuntos extends JPanel {

    private String operacionInicialConjuntos = "( A Uni B ) Ints ( Compl ( C ) )";
    private String operacionInicialTitulo = "( ( ¬ R ) ^ ( Q v P )  )";
    private String operacionInicialMatriz = "AB+C#*";
    private boolean ventanaActiva;
    
    private Interpretador interpretador;
    /**
     * Paneles auxialiares de diseño
     */
    JPanel pnAtrasDerecha;
    JPanel pnAtrasIzquierda;
    JPanel pnIzqAbajo;
    JPanel pnDerAbajo;

    /**
     * Paneles de componentes principales
     */
    private PnDiagramaVenn pndVenn;
    private PnEntradaDatos pnEntDatos;
    private PnConjuntos pnAdminConjunto;
    private PnTablaVerdad pnTabla;
    private PnImagenSalida pnImgSalida;
    private PnElementosConjunto pnElementos;

    public PnCentralConjuntos() {
        super();
        interpretador= new Interpretador();
        crearPanel();
    }

    public PnEntradaDatos getPnEntDatos() {
        return pnEntDatos;
    }

    public void setPnEntDatos(PnEntradaDatos pnEntDatos) {
        this.pnEntDatos = pnEntDatos;
    }

    private void crearPanel() {
        this.setBackground(PatronDisenho.GRIS_FONDO);
        this.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

        pnAtrasDerecha = new JPanel();
        pnAtrasDerecha.setBackground(PatronDisenho.GRIS_FONDO);
        pnAtrasDerecha.setLayout(new java.awt.BorderLayout(0, 5));

        pnAtrasIzquierda = new JPanel();
        pnAtrasIzquierda.setBackground(PatronDisenho.GRIS_FONDO);
        pnAtrasIzquierda.setLayout(new java.awt.BorderLayout(0, 5));

        pnIzqAbajo = new JPanel();
        pnIzqAbajo.setBackground(PatronDisenho.GRIS_FONDO);
        pnIzqAbajo.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        pnDerAbajo = new JPanel();
        pnDerAbajo.setBackground(PatronDisenho.GRIS_FONDO);
        pnDerAbajo.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        agregarComponentes();

        pnAtrasIzquierda.add(pnIzqAbajo, java.awt.BorderLayout.CENTER);
        pnAtrasDerecha.add(pnDerAbajo, java.awt.BorderLayout.CENTER);

        this.add(pnAtrasIzquierda);
        this.add(pnAtrasDerecha);
    }

    private void agregarComponentes() {
        // Paneles de la Izquierda
        pnEntDatos = new PnEntradaDatos(operacionInicialConjuntos);
        pnAtrasIzquierda.add(java.awt.BorderLayout.NORTH, pnEntDatos);

        pnAdminConjunto = new PnConjuntos();
        pnIzqAbajo.add(pnAdminConjunto);

//        pnTabla = new PnTablaVerdad(null,null);
//        pnIzqAbajo.add(pnTabla);
        
        pnImgSalida = new PnImagenSalida();
        pnAtrasDerecha.add(java.awt.BorderLayout.NORTH, pnImgSalida);
        
        pnTabla = new PnTablaVerdad(operacionInicialMatriz, operacionInicialTitulo);
        pnDerAbajo.add(pnTabla);
        agregarEventoCalcular();

        // Paneles de la derecha
        pndVenn = new PnDiagramaVenn();
        pnIzqAbajo.add(pndVenn);

//        pnImgSalida = new PnImagenSalida();
//        pnDerAbajo.add(java.awt.BorderLayout.NORTH, pnImgSalida);

        pnElementos = new PnElementosConjunto();
        pnDerAbajo.add(pnElementos);

    }

    private void agregarEventoCalcular(){
        pnEntDatos.getBtnCalcular().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (pnEntDatos.getContadorParentesis() == 0) { // Parentesis completos
                    pnTabla.setOperacionInfija(interpretador.descomponerOperacion(pnEntDatos.getTxtEntrada().getText()));
                    pnTabla.actualizarTabla();
                    pnTabla.updateUI();
//                    System.out.println(interpretador.analizarCadena(txtEntrada.getText()));
//                    System.out.println(interpretador.descomponerOperacion(txtEntrada.getText()));
//                    System.out.println(in.cadenaInterpretada(in.descomponerOperacion(txtEntrada.getText())));

                } else {
                    JOptionPane.showMessageDialog(null, "Los parentesis ingresados no coinciden.\n"
                            + "Verifique que estén completos, e intente nuevamente.", "Error al realizar operación",
                                    JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
                }
            }
        });
    }
    
    public boolean isVentanaActiva() {
        return ventanaActiva;
    }

    public void setVentanaActiva(boolean ventanaActiva) {
        this.ventanaActiva = ventanaActiva;
    }
}
