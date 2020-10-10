/**
 * Clase que controla los paneles internos del centro
 */
//package Unipamplona.MDiscretas.interfaz;
//
//import javax.swing.JPanel;
//import Unipamplona.MDiscretas.interfaz.pnCentrales.PnConjuntos;
//import Unipamplona.MDiscretas.interfaz.pnCentrales.PnDiagramaVenn;
//import Unipamplona.MDiscretas.interfaz.pnCentrales.PnElementosConjunto;
//import Unipamplona.MDiscretas.interfaz.pnCentrales.PnEntradaDatos;
//import Unipamplona.MDiscretas.interfaz.pnCentrales.PnImagenSalida;
//import Unipamplona.MDiscretas.interfaz.pnCentrales.PnTablaVerdad;
//
///**
// *
// * @author WILMER
// */
//public class PnCentralConjuntos extends JPanel {
//
//    /**
//     * Paneles auxialiares de diseño
//     */
//    JPanel pnAtrasDerecha;
//    JPanel pnAtrasIzquierda;
//    JPanel pnIzqAbajo;
//    JPanel pnDerAbajo;
//
//    /**
//     * Paneles de componentes principales
//     */
//    private PnDiagramaVenn pndVenn;
//    private PnEntradaDatos pnEntDatos;
//    private PnConjuntos pnAdminConjunto;
//    private PnTablaVerdad pnTabla;
//    private PnImagenSalida pnImgSalida;
//    private PnElementosConjunto pnElementos;
//
//    public PnCentralConjuntos() {
//        super();
//        crearPanel();
//    }
//
//    private void crearPanel() {
//        this.setBackground(PatronDisenho.GRIS_FONDO);
//        this.setLayout(new java.awt.GridLayout(1, 2, 5, 0));
//
//        pnAtrasDerecha = new JPanel();
//        pnAtrasDerecha.setBackground(PatronDisenho.GRIS_FONDO);
//        pnAtrasDerecha.setLayout(new java.awt.BorderLayout(0, 5));
//
//        pnAtrasIzquierda = new JPanel();
//        pnAtrasIzquierda.setBackground(PatronDisenho.GRIS_FONDO);
//        pnAtrasIzquierda.setLayout(new java.awt.BorderLayout(0, 5));
//
//        pnIzqAbajo = new JPanel();
//        pnIzqAbajo.setBackground(PatronDisenho.GRIS_FONDO);
//        pnIzqAbajo.setLayout(new java.awt.GridLayout(0, 1, 0, 5));
//
//        pnDerAbajo = new JPanel();
//        pnDerAbajo.setBackground(PatronDisenho.GRIS_FONDO);
//        pnDerAbajo.setLayout(new java.awt.GridLayout(0, 1, 0, 5));
//
//        agregarComponentes();
//
//        pnAtrasIzquierda.add(pnIzqAbajo, java.awt.BorderLayout.CENTER);
//        pnAtrasDerecha.add(pnDerAbajo, java.awt.BorderLayout.CENTER);
//
//        this.add(pnAtrasIzquierda);
//        this.add(pnAtrasDerecha);
//    }
//
//    private void agregarComponentes() {
//        // Paneles de la Izquierda
//        pnEntDatos = new PnEntradaDatos();
//        pnAtrasIzquierda.add(java.awt.BorderLayout.NORTH, pnEntDatos);
//
//        pnAdminConjunto = new PnConjuntos();
//        pnIzqAbajo.add(pnAdminConjunto);
//
////        pnTabla = new PnTablaVerdad(null,null);
////        pnIzqAbajo.add(pnTabla);
//        
//        pnImgSalida = new PnImagenSalida();
//        pnAtrasDerecha.add(java.awt.BorderLayout.NORTH, pnImgSalida);
//        
//        pnTabla = new PnTablaVerdad(null,null);
//        pnDerAbajo.add(pnTabla);
//
//        // Paneles de la derecha
//        pndVenn = new PnDiagramaVenn();
//        pnIzqAbajo.add(pndVenn);
//
////        pnImgSalida = new PnImagenSalida();
////        pnDerAbsajo.add(java.awt.BorderLayout.NORTH, pnImgSalida);
//
//        pnElementos = new PnElementosConjunto();
//        pnDerAbajo.add(pnElementos);
//
//    }
//}
