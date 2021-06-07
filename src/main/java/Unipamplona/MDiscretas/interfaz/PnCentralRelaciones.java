/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Unipamplona.MDiscretas.interfaz;

import static main.java.Unipamplona.MDiscretas.interfaz.InterfazMain.alto;

import main.java.Unipamplona.MDiscretas.interfaz.pnCentralesRelaciones.PnEntradaRelaciones;
import main.java.Unipamplona.MDiscretas.interfaz.pnCentralesRelaciones.PnMatrizEntrada;
import main.java.Unipamplona.MDiscretas.interfaz.pnCentralesRelaciones.PnMatrizSalida;
import main.java.Unipamplona.MDiscretas.mundo.Conjunto;
import main.java.Unipamplona.MDiscretas.mundo.OperacionesRelaciones;
import main.java.Unipamplona.MDiscretas.mundo.Relacion;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author WILMER
 */
public class PnCentralRelaciones extends JPanel {

    private final String TITULO_RELACIONES = "Relaciones";

    private final String TIPO_RELACION = "RELACION";
    private final String TIPO_COMPOSICION = "COMPOSICION";

    private VnConjunto vnConjunto;
    private VnRelacion vnRelacion;

    private final String CONJUNTO = "CONJUNTO";
    private final String RELACION = "RELACION";

    private JPanel pnFondo;
    private JPanel pnSuperiorDerecha;
    private JPanel pnInferior;

    private PnEntradaRelaciones pnEntradaRelaciones;

    private PnMatrizEntrada pnMatrizEntrada;

    private PnMatrizSalida pnMatrizSalida;

    private Conjunto conjuntoA;
    private Conjunto conjuntoB;
    private Conjunto conjuntoC;

    private Relacion relacionR;
    private Relacion relacionS;

    private OperacionesRelaciones operRelaciones;

    public PnCentralRelaciones() {
        super();
        crearPanel();
        operRelaciones = new OperacionesRelaciones();
    }

    private void crearPanel() {
        this.setBackground(PatronDisenho.GRIS_FONDO);
        this.setLayout(new java.awt.BorderLayout(5, 5));

        pnFondo = new JPanel();
        pnFondo.setBackground(PatronDisenho.GRIS_FONDO);
        pnFondo.setLayout(new java.awt.BorderLayout(5, 5));

        pnInferior = new JPanel();
        pnInferior.setBackground(PatronDisenho.GRIS_FONDO_2);
        pnInferior.setPreferredSize(new Dimension(200, (int) (alto * 0.29)));
        pnInferior.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        pnSuperiorDerecha = new JPanel();
        pnSuperiorDerecha.setBackground(PatronDisenho.GRIS_FONDO);
        pnSuperiorDerecha.setLayout(new java.awt.BorderLayout(5, 5));

        pnMatrizSalida = new PnMatrizSalida();
        pnSuperiorDerecha.add(pnMatrizSalida, java.awt.BorderLayout.CENTER);

        pnSuperiorDerecha.add(pnInferior, java.awt.BorderLayout.SOUTH);

        pnFondo.add(pnSuperiorDerecha, java.awt.BorderLayout.CENTER);

        pnEntradaRelaciones = new PnEntradaRelaciones();
        pnFondo.add(pnEntradaRelaciones, java.awt.BorderLayout.WEST);

        pnMatrizEntrada = new PnMatrizEntrada();
        pnInferior.add(pnMatrizEntrada);

        inicializarConjuntos();
        inicializarRelaciones();

        agregarEventosBorrar();
//        agregarEventoEditarConjunto();
        agregarEventoEditarRelacion();

        agregarEventoLimpiar();
        agregarEventoCrear();
        agregarEventosMatriz();

        agregarEventoCalcular();

        agregarEventoAxB();
        agregarEventoRTrans();
        agregarEventoSTrans();
        agregarEventoRCompS();

        agregarEventosS();
        agregarEventosR();

        this.add(pnFondo, java.awt.BorderLayout.CENTER);
    }

    private void agregarEventosR() {
        pnEntradaRelaciones.getBtnReflexivaR().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String[][] matriz = operRelaciones.matrizA(relacionR.getPares(), conjuntoA.getElementos());

                try {
                    Object[] temp = operRelaciones.reflexiva(matriz);
                    matriz = (String[][]) temp[1];
                    boolean reflexiva = (boolean) temp[0];
                    if (reflexiva) {
                        pnEntradaRelaciones.getLbTipoRelacion().setText("  Relación reflexiva");
                        pnEntradaRelaciones.getLbTipoRelacion().updateUI();
                    } else {
                        pnEntradaRelaciones.getLbTipoRelacion().setText("  Relación no reflexiva");
                        pnEntradaRelaciones.getLbTipoRelacion().updateUI();
                    }

                    pnMatrizSalida.setConjuntoA(conjuntoA.getElementos());
                    pnMatrizSalida.setConjuntoB(conjuntoA.getElementos());
                    pnMatrizSalida.setRelacion1(operRelaciones.composicionParejas((String[][]) temp[1]));
                    pnMatrizSalida.crearDiagramaSagital(TIPO_RELACION);

                    pnEntradaRelaciones.getLbSalida().setText(operRelaciones.getCadenaElementos(operRelaciones.composicionParejas(matriz)));

                    pnMatrizSalida.setMatrizSalida(matriz);
                    pnMatrizSalida.actualizarMatriz();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "La Relacion No es válida para A.\n", "Error en la entrada",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
                }
            }
        });
        pnEntradaRelaciones.getBtnSimetricaR().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String[][] matriz = operRelaciones.matrizA(relacionR.getPares(), conjuntoA.getElementos());

                try {
                    Object[] temp = operRelaciones.simetrica(matriz);
                    matriz = (String[][]) temp[1];
                    boolean reflexiva = (boolean) temp[0];
                    if (reflexiva) {
                        pnEntradaRelaciones.getLbTipoRelacion().setText("  Relación simétrica");
                        pnEntradaRelaciones.getLbTipoRelacion().updateUI();
                    } else {
                        pnEntradaRelaciones.getLbTipoRelacion().setText("  Relación no simétrica");
                        pnEntradaRelaciones.getLbTipoRelacion().updateUI();
                    }

                    pnMatrizSalida.setConjuntoA(conjuntoA.getElementos());
                    pnMatrizSalida.setConjuntoB(conjuntoA.getElementos());
                    pnMatrizSalida.setRelacion1(operRelaciones.composicionParejas((String[][]) temp[1]));
                    pnMatrizSalida.crearDiagramaSagital(TIPO_RELACION);

                    pnEntradaRelaciones.getLbSalida().setText(operRelaciones.getCadenaElementos(operRelaciones.composicionParejas(matriz)));

                    pnMatrizSalida.setMatrizSalida(matriz);
                    pnMatrizSalida.actualizarMatriz();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "La Relacion No es válida para A.\n", "Error en la entrada",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
                }
            }
        });
        pnEntradaRelaciones.getBtnAntiSimetricaR().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String[][] matriz = operRelaciones.matrizA(relacionR.getPares(), conjuntoA.getElementos());

                try {
                    Object[] temp = operRelaciones.antisimetrica(matriz);
                    matriz = (String[][]) temp[1];
                    boolean reflexiva = (boolean) temp[0];
                    if (reflexiva) {
                        pnEntradaRelaciones.getLbTipoRelacion().setText("  Relación antisimétrica");
                        pnEntradaRelaciones.getLbTipoRelacion().updateUI();
                    } else {
                        pnEntradaRelaciones.getLbTipoRelacion().setText("  Relación no antisimétrica");
                        pnEntradaRelaciones.getLbTipoRelacion().updateUI();
                    }

                    pnEntradaRelaciones.getLbSalida().setText(operRelaciones.getCadenaElementos(operRelaciones.composicionParejas(matriz)));

                    pnMatrizSalida.setConjuntoA(conjuntoA.getElementos());
                    pnMatrizSalida.setConjuntoB(conjuntoA.getElementos());
                    pnMatrizSalida.setRelacion1(operRelaciones.composicionParejas((String[][]) temp[1]));
                    pnMatrizSalida.crearDiagramaSagital(TIPO_RELACION);

                    pnMatrizSalida.setMatrizSalida(matriz);
                    pnMatrizSalida.actualizarMatriz();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "La Relacion No es válida para A.\n", "Error en la entrada",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
                }
            }
        });
        pnEntradaRelaciones.getBtnTransitivaR().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String[][] matriz = operRelaciones.matrizA(relacionR.getPares(), conjuntoA.getElementos());

                try {
                    Object[] temp = operRelaciones.transitiva(matriz);
                    matriz = (String[][]) temp[1];
                    boolean reflexiva = (boolean) temp[0];
                    if (reflexiva) {
                        pnEntradaRelaciones.getLbTipoRelacion().setText("  Relación transitiva");
                        pnEntradaRelaciones.getLbTipoRelacion().updateUI();
                    } else {
                        pnEntradaRelaciones.getLbTipoRelacion().setText("  Relación no transitiva");
                        pnEntradaRelaciones.getLbTipoRelacion().updateUI();
                    }

                    pnEntradaRelaciones.getLbSalida().setText(operRelaciones.getCadenaElementos(operRelaciones.composicionParejas(matriz)));

                    pnMatrizSalida.setConjuntoA(conjuntoA.getElementos());
                    pnMatrizSalida.setConjuntoB(conjuntoA.getElementos());
                    pnMatrizSalida.setRelacion1(operRelaciones.composicionParejas((String[][]) temp[1]));
                    pnMatrizSalida.crearDiagramaSagital(TIPO_RELACION);

                    pnMatrizSalida.setMatrizSalida(matriz);
                    pnMatrizSalida.actualizarMatriz();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "La Relacion No es válida para A.\n", "Error en la entrada",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
                }
            }
        });
    }

    private void agregarEventosS() {
        pnEntradaRelaciones.getBtnReflexivaS().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String[][] matriz = operRelaciones.matrizA(relacionS.getPares(), conjuntoB.getElementos());

                try {
                    Object[] temp = operRelaciones.reflexiva(matriz);
                    matriz = (String[][]) temp[1];
                    boolean reflexiva = (boolean) temp[0];
                    if (reflexiva) {
                        pnEntradaRelaciones.getLbTipoRelacion().setText("  Relación reflexiva");
                        pnEntradaRelaciones.getLbTipoRelacion().updateUI();
                    } else {
                        pnEntradaRelaciones.getLbTipoRelacion().setText("  Relación no reflexiva");
                        pnEntradaRelaciones.getLbTipoRelacion().updateUI();
                    }

                    pnEntradaRelaciones.getLbSalida().setText(operRelaciones.getCadenaElementos(operRelaciones.composicionParejas(matriz)));

                    pnMatrizSalida.setConjuntoA(conjuntoB.getElementos());
                    pnMatrizSalida.setConjuntoB(conjuntoB.getElementos());
                    pnMatrizSalida.setRelacion1(operRelaciones.composicionParejas((String[][]) temp[1]));
                    pnMatrizSalida.crearDiagramaSagital(TIPO_RELACION);

                    pnMatrizSalida.setMatrizSalida(matriz);
                    pnMatrizSalida.actualizarMatriz();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "La Relacion No es válida para B.\n", "Error en la entrada",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
                }
            }
        });
        pnEntradaRelaciones.getBtnSimetricaS().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String[][] matriz = operRelaciones.matrizA(relacionS.getPares(), conjuntoB.getElementos());

                try {
                    Object[] temp = operRelaciones.simetrica(matriz);
                    matriz = (String[][]) temp[1];
                    boolean reflexiva = (boolean) temp[0];
                    if (reflexiva) {
                        pnEntradaRelaciones.getLbTipoRelacion().setText("  Relación simétrica");
                        pnEntradaRelaciones.getLbTipoRelacion().updateUI();
                    } else {
                        pnEntradaRelaciones.getLbTipoRelacion().setText("  Relación no simétrica");
                        pnEntradaRelaciones.getLbTipoRelacion().updateUI();
                    }
                    pnEntradaRelaciones.getLbSalida().setText(operRelaciones.getCadenaElementos(operRelaciones.composicionParejas(matriz)));

                    pnMatrizSalida.setConjuntoA(conjuntoB.getElementos());
                    pnMatrizSalida.setConjuntoB(conjuntoB.getElementos());
                    pnMatrizSalida.setRelacion1(operRelaciones.composicionParejas((String[][]) temp[1]));
                    pnMatrizSalida.crearDiagramaSagital(TIPO_RELACION);

                    pnMatrizSalida.setMatrizSalida(matriz);
                    pnMatrizSalida.actualizarMatriz();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "La Relacion No es válida para B.\n", "Error en la entrada",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
                }
            }
        });
        pnEntradaRelaciones.getBtnAntiSimetricaS().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String[][] matriz = operRelaciones.matrizA(relacionS.getPares(), conjuntoB.getElementos());

                try {
                    Object[] temp = operRelaciones.antisimetrica(matriz);
                    matriz = (String[][]) temp[1];
                    boolean reflexiva = (boolean) temp[0];
                    if (reflexiva) {
                        pnEntradaRelaciones.getLbTipoRelacion().setText("  Relación antisimétrica");
                        pnEntradaRelaciones.getLbTipoRelacion().updateUI();
                    } else {
                        pnEntradaRelaciones.getLbTipoRelacion().setText("  Relación no antisimétrica");
                        pnEntradaRelaciones.getLbTipoRelacion().updateUI();
                    }

                    pnEntradaRelaciones.getLbSalida().setText(operRelaciones.getCadenaElementos(operRelaciones.composicionParejas(matriz)));

                    pnMatrizSalida.setConjuntoA(conjuntoB.getElementos());
                    pnMatrizSalida.setConjuntoB(conjuntoB.getElementos());
                    pnMatrizSalida.setRelacion1(operRelaciones.composicionParejas((String[][]) temp[1]));
                    pnMatrizSalida.crearDiagramaSagital(TIPO_RELACION);

                    pnMatrizSalida.setMatrizSalida(matriz);
                    pnMatrizSalida.actualizarMatriz();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "La Relacion No es válida para B.\n", "Error en la entrada",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
                }
            }
        });
        pnEntradaRelaciones.getBtnTransitivaS().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String[][] matriz = operRelaciones.matrizA(relacionS.getPares(), conjuntoB.getElementos());

                try {
                    Object[] temp = operRelaciones.transitiva(matriz);
                    matriz = (String[][]) temp[1];
                    boolean reflexiva = (boolean) temp[0];
                    if (reflexiva) {
                        pnEntradaRelaciones.getLbTipoRelacion().setText("  Relación transitiva");
                        pnEntradaRelaciones.getLbTipoRelacion().updateUI();
                    } else {
                        pnEntradaRelaciones.getLbTipoRelacion().setText("  Relación no transitiva");
                        pnEntradaRelaciones.getLbTipoRelacion().updateUI();
                    }

                    pnMatrizSalida.setConjuntoA(conjuntoB.getElementos());
                    pnMatrizSalida.setConjuntoB(conjuntoB.getElementos());
                    pnMatrizSalida.setRelacion1(operRelaciones.composicionParejas((String[][]) temp[1]));
                    pnMatrizSalida.crearDiagramaSagital(TIPO_RELACION);

                    pnEntradaRelaciones.getLbSalida().setText(operRelaciones.getCadenaElementos(operRelaciones.composicionParejas(matriz)));

                    pnMatrizSalida.setMatrizSalida(matriz);
                    pnMatrizSalida.actualizarMatriz();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "La Relacion No es válida para B.\n", "Error en la entrada",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
                }
            }
        });
    }

    private void agregarEventoRCompS() {
        pnEntradaRelaciones.getBtnComposicion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ArrayList<String[]> t = operRelaciones.composiciones(relacionR.getPares(), relacionS.getPares());
                String[][] matriz = operRelaciones.matrizx(t);
                if (!pnMatrizSalida.matrizVacia(matriz)) {
                    pnMatrizSalida.setMatrizSalida(matriz);
                    pnMatrizSalida.actualizarMatriz();

                    pnMatrizSalida.setConjuntoA(conjuntoA.getElementos());
                    pnMatrizSalida.setConjuntoB(conjuntoB.getElementos());
                    pnMatrizSalida.setConjuntoC(conjuntoC.getElementos());
                    pnMatrizSalida.setRelacion1(relacionR.getPares());
                    pnMatrizSalida.setRelacion2(relacionS.getPares());
                    pnMatrizSalida.crearDiagramaSagital(TIPO_COMPOSICION);

                    pnEntradaRelaciones.getLbSalida().setText(operRelaciones.getCadenaElementos(t));
                    pnEntradaRelaciones.getLbSalida().updateUI();

                    if (matriz.length == matriz[0].length) {
                        try {
                            String res = operRelaciones.evaluarTodosLosTipos(matriz);
                            pnEntradaRelaciones.getLbTipoRelacion().setText(res);
                            pnEntradaRelaciones.getLbTipoRelacion().updateUI();
                        } catch (Exception e) {
                            pnMatrizSalida.restablecerMatriz();
                            JOptionPane.showMessageDialog(null, "Relación no permitida para esta operación.\n", "Error en la entrada",
                                    JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
                        }

                    } else {
                        pnEntradaRelaciones.getLbTipoRelacion().setText("   La matriz resultante no es cuadrada.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La Relacion a evaluar está vacía.\n"
                            + "Debe seleccionar las posiciones que desea activar.", "Error en la entrada",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
                }
            }
        });
    }

    private void agregarEventoRTrans() {
        pnEntradaRelaciones.getBtnInversaR().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String[][] matriz = operRelaciones.matrizx(relacionR.getPares());
                matriz = operRelaciones.matrizTras(matriz);
                ArrayList<String[]> rel = operRelaciones.composicionParejas(matriz);

                if (!pnMatrizSalida.matrizVacia(matriz)) {
                    pnMatrizSalida.setMatrizSalida(matriz);
                    pnMatrizSalida.actualizarMatriz();

                    pnMatrizSalida.setConjuntoA(conjuntoB.getElementos());
                    pnMatrizSalida.setConjuntoB(conjuntoA.getElementos());
                    pnMatrizSalida.setRelacion1(rel);
                    pnMatrizSalida.crearDiagramaSagital(TIPO_RELACION);

                    pnEntradaRelaciones.getLbSalida().setText(operRelaciones.getCadenaElementos(rel));
                    pnEntradaRelaciones.getLbSalida().updateUI();

                    if (matriz.length == matriz[0].length) {
                        try {
                            String res = operRelaciones.evaluarTodosLosTipos(matriz);
                            pnEntradaRelaciones.getLbTipoRelacion().setText(res);
                            pnEntradaRelaciones.getLbTipoRelacion().updateUI();
                        } catch (Exception e) {
                            pnMatrizSalida.restablecerMatriz();
                            JOptionPane.showMessageDialog(null, "Relación no permitida para esta operación.\n", "Error en la entrada",
                                    JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
                        }
                    } else {
                        pnEntradaRelaciones.getLbTipoRelacion().setText("   La matriz resultante no es cuadrada.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La Relacion a evaluar está vacía.\n"
                            + "Debe seleccionar las posiciones que desea activar.", "Error en la entrada",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
                }

            }
        });
    }

    private void agregarEventoSTrans() {
        pnEntradaRelaciones.getBtnInversaS().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                try {
                String[][] matriz = operRelaciones.matrizx(relacionS.getPares());
                matriz = operRelaciones.matrizTras(matriz);
                ArrayList<String[]> rel = operRelaciones.composicionParejas(matriz);
                if (!pnMatrizSalida.matrizVacia(matriz)) {
                    pnMatrizSalida.setMatrizSalida(matriz);
                    pnMatrizSalida.actualizarMatriz();

                    pnMatrizSalida.setConjuntoA(conjuntoC.getElementos());
                    pnMatrizSalida.setConjuntoB(conjuntoB.getElementos());
                    pnMatrizSalida.setRelacion1(rel);
                    pnMatrizSalida.crearDiagramaSagital(TIPO_RELACION);

                    pnEntradaRelaciones.getLbSalida().setText(operRelaciones.getCadenaElementos(rel));
                    pnEntradaRelaciones.getLbSalida().updateUI();

                    if (matriz.length == matriz[0].length) {
                        String res = operRelaciones.evaluarTodosLosTipos(matriz);
                        pnEntradaRelaciones.getLbTipoRelacion().setText(res);
                        pnEntradaRelaciones.getLbTipoRelacion().updateUI();
                    } else {
                        pnEntradaRelaciones.getLbTipoRelacion().setText("   La matriz resultante no es cuadrada.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La Relacion a evaluar está vacía.\n"
                            + "Debe seleccionar las posiciones que desea activar.", "Error en la entrada",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
                }
//                } catch (Exception e) {
//                }

            }
        });
    }

    private void agregarEventoAxB() {
        pnEntradaRelaciones.getBtnMultiplicacion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String[][] matriz = operRelaciones.matrizAB(conjuntoB.getElementos(), conjuntoA.getElementos());
                    ArrayList<String[]> rel = operRelaciones.composicionParejas(matriz);
                    if (!pnMatrizSalida.matrizVacia(matriz)) {
                        pnMatrizSalida.setMatrizSalida(matriz);
                        pnMatrizSalida.actualizarMatriz();

                        pnMatrizSalida.setConjuntoA(conjuntoA.getElementos());
                        pnMatrizSalida.setConjuntoB(conjuntoB.getElementos());
                        pnMatrizSalida.setRelacion1(rel);
                        pnMatrizSalida.crearDiagramaSagital(TIPO_RELACION);

                        pnEntradaRelaciones.getLbSalida().setText(operRelaciones.getCadenaElementos(rel));
                        pnEntradaRelaciones.getLbSalida().updateUI();

                        if (matriz.length == matriz[0].length) {
                            String res = operRelaciones.evaluarTodosLosTipos(matriz);
                            pnEntradaRelaciones.getLbTipoRelacion().setText(res);
                            pnEntradaRelaciones.getLbTipoRelacion().updateUI();
                        } else {
                            pnEntradaRelaciones.getLbTipoRelacion().setText("   La matriz resultante no es cuadrada.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La matriz resultado está vacía.\n"
                                + "Debe rellenar los conjuntos primeramente.", "Error en la entrada",
                                JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "La matriz resultado está vacía.\n"
                            + "Debe rellenar los conjuntos primeramente.", "Error en la entrada",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
                }
            }
        });
    }

    private void agregarEventoCalcular() {
        pnMatrizEntrada.getBtnCalcular().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String[][] matriz = pnMatrizEntrada.getMatriz();
                    if (!pnMatrizEntrada.matrizVacia()) {
                        String res = operRelaciones.evaluarTodosLosTipos(pnMatrizEntrada.getMatriz());
                        pnMatrizEntrada.getLbSalida().setText(res);
                    } else {
                        JOptionPane.showMessageDialog(null, "La matriz a evaluar está vacía.\n"
                                + "Debe seleccionar las posiciones que desea activar.", "Error en la entrada",
                                JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "La matriz a evaluar está vacía.\n"
                            + "Debe seleccionar las posiciones que desea activar.", "Error en la entrada",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
                }
            }
        });
    }

    private void agregarEventoCrear() {
        pnMatrizEntrada.getBtnCrearMatriz().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    int tam = Integer.parseInt(pnMatrizEntrada.getTxtTamanho().getText());
                    if (tam > 0) {
                        pnMatrizEntrada.setMatriz(pnMatrizEntrada.crearMatriz(tam));
                        agregarEventosMatriz();
                    } else {
                        JOptionPane.showMessageDialog(null, "El tamaño ingresado " + tam + " no es válido.\n"
                                + "Es necesario que el tamaño sea mayor a cero", "Error en la entrada",
                                JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "El tamaño ingresado no es válido.\n"
                            + "Solo están permitidos números enteros mayores a cero.", "Error en la entrada",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
                }
            }
        });
    }

    private void agregarEventoLimpiar() {
        pnMatrizEntrada.getBtnLimpiar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int cancelar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea limpiar la matriz? \n", "Limpiar la matriz",
                        JOptionPane.OK_CANCEL_OPTION, 0, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
                if (cancelar == 0) {
                    pnMatrizEntrada.restablecerMatriz();
                    agregarEventosMatriz();
                    pnMatrizEntrada.getBtnCalcular().requestFocus();
                }
            }
        });
    }

    private void agregarEventosMatriz() {
        JPanel panel = pnMatrizEntrada.getPnMatriz();
        for (int i = 0; i < panel.getComponentCount(); i++) {
            Boton boton = (Boton) panel.getComponent(i);
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    int pos = boton.getIndice();
                    int i = (int) (pos / (pnMatrizEntrada.getMatriz().length));
                    int j = (int) (pos % (pnMatrizEntrada.getMatriz().length));
                    pnMatrizEntrada.modificarMatriz(i, j);
                    agregarEventosMatriz();
                    pnMatrizEntrada.getBtnCalcular().requestFocus();
                }
            });
        }

    }

    private void inicializarConjuntos() {
        ArrayList elementos = new ArrayList();
        elementos.add("a");
        elementos.add("b");
        elementos.add("c");
        elementos.add("d");
        conjuntoA = new Conjunto("A", elementos, PatronDisenho.getColorAleatorio());
        actualizarPanel(CONJUNTO, conjuntoA.getNombre());

        elementos = null;
        elementos = new ArrayList();
        elementos.add("x");
        elementos.add("y");
        elementos.add("z");
        conjuntoB = new Conjunto("B", elementos, PatronDisenho.getColorAleatorio());
        actualizarPanel(CONJUNTO, conjuntoB.getNombre());

        elementos = null;
        elementos = new ArrayList();
        elementos.add("1");
        elementos.add("2");
        elementos.add("3");
        elementos.add("4");
        conjuntoC = new Conjunto("C", elementos, PatronDisenho.getColorAleatorio());
        actualizarPanel(CONJUNTO, conjuntoC.getNombre());

    }

    private void actualizarPanel(String tipo, String nombre) {
        switch (tipo) {
            case CONJUNTO:
                switch (nombre) {
                    case "A":
                        pnEntradaRelaciones.getPnConjuntoA().actualizarColor(conjuntoA.getColor());
                        pnEntradaRelaciones.getPnConjuntoA().actualizarElementos(conjuntoA.getCadenaElementos());
                        pnEntradaRelaciones.getPnConjuntoA().update(pnEntradaRelaciones.getPnConjuntoA().getGraphics());
                        break;
                    case "B":
                        pnEntradaRelaciones.getPnConjuntoB().actualizarColor(conjuntoB.getColor());
                        pnEntradaRelaciones.getPnConjuntoB().actualizarElementos(conjuntoB.getCadenaElementos());
                        pnEntradaRelaciones.getPnConjuntoB().update(pnEntradaRelaciones.getPnConjuntoB().getGraphics());
                        break;
                    case "C":
                        pnEntradaRelaciones.getPnConjuntoC().actualizarColor(conjuntoC.getColor());
                        pnEntradaRelaciones.getPnConjuntoC().actualizarElementos(conjuntoC.getCadenaElementos());
                        pnEntradaRelaciones.getPnConjuntoC().update(pnEntradaRelaciones.getPnConjuntoC().getGraphics());
                        break;
                }
                break;
            case RELACION:
                switch (nombre) {
                    case "R":
                        pnEntradaRelaciones.getPnRelacionR().actualizarColor(relacionR.getColor());
                        pnEntradaRelaciones.getPnRelacionR().actualizarElementos(relacionR.getCadenaElementos());
                        pnEntradaRelaciones.getPnRelacionR().update(pnEntradaRelaciones.getPnRelacionR().getGraphics());
                        break;
                    case "S":
                        pnEntradaRelaciones.getPnRelacionS().actualizarColor(relacionS.getColor());
                        pnEntradaRelaciones.getPnRelacionS().actualizarElementos(relacionS.getCadenaElementos());
                        pnEntradaRelaciones.getPnRelacionS().update(pnEntradaRelaciones.getPnRelacionS().getGraphics());
                        break;
                }
                break;
        }
    }

    private void inicializarRelaciones() {
        ArrayList elementos = new ArrayList();
        String[] temp = {"a", "x"};
        elementos.add(temp);
        String[] temp1 = {"b", "y"};
        elementos.add(temp1);
        String[] temp2 = {"c", "z"};
        elementos.add(temp2);
        String[] temp3 = {"d", "z"};
        elementos.add(temp3);
        relacionR = new Relacion("R", elementos, PatronDisenho.getColorAleatorio());
        actualizarPanel(RELACION, relacionR.getNombre());

        elementos = null;
        elementos = new ArrayList();
        String[] temp4 = {"x", "1"};
        elementos.add(temp4);
        String[] temp5 = {"y", "1"};
        elementos.add(temp5);
        String[] temp6 = {"y", "4"};
        elementos.add(temp6);
        String[] temp7 = {"z", "3"};
        elementos.add(temp7);
        relacionS = new Relacion("S", elementos, PatronDisenho.getColorAleatorio());
        actualizarPanel(RELACION, relacionS.getNombre());
    }

    private void agregarEventosBorrar() {
        pnEntradaRelaciones.getPnConjuntoA().getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                int cancelar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar los elementos del conjunto?\n", "Eliminar elementos de conjunto",
//                        JOptionPane.OK_CANCEL_OPTION, 0, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
//                if (cancelar == 0) {
//                    conjuntoA.setElementos(new ArrayList());
//                    actualizarPanel(CONJUNTO, conjuntoA.getNombre());
//                }
                JOptionPane.showMessageDialog(null, "Botón desabilitado temporalmente.\n"
                        + "Pronto estará en funcionalidad.", "Boton desabilidato",
                        JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
            }
        });

        pnEntradaRelaciones.getPnConjuntoB().getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                int cancelar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar los elementos del conjunto?\n", "Eliminar elementos de conjunto",
//                        JOptionPane.OK_CANCEL_OPTION, 0, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
//                if (cancelar == 0) {
//                    conjuntoB.setElementos(new ArrayList());
//                    actualizarPanel(CONJUNTO, conjuntoB.getNombre());
//                }
                JOptionPane.showMessageDialog(null, "Botón desabilitado temporalmente.\n"
                        + "Pronto estará en funcionalidad.", "Boton desabilidato",
                        JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
            }
        });

        pnEntradaRelaciones.getPnConjuntoC().getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                int cancelar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar los elementos del conjunto?\n", "Eliminar elementos de conjunto",
//                        JOptionPane.OK_CANCEL_OPTION, 0, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
//                if (cancelar == 0) {
//                    conjuntoC.setElementos(new ArrayList());
//                    actualizarPanel(CONJUNTO, conjuntoC.getNombre());
//                }
                JOptionPane.showMessageDialog(null, "Botón desabilitado temporalmente.\n"
                        + "Pronto estará en funcionalidad.", "Boton desabilidato",
                        JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
            }
        });

        pnEntradaRelaciones.getPnRelacionR().getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int cancelar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar los elementos del conjunto?\n", "Eliminar elementos de conjunto",
                        JOptionPane.OK_CANCEL_OPTION, 0, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
                if (cancelar == 0) {
                    relacionR.setPares(new ArrayList());
                    actualizarPanel(RELACION, relacionR.getNombre());
                }
            }
        });

        pnEntradaRelaciones.getPnRelacionS().getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int cancelar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar los elementos del conjunto?\n", "Eliminar elementos de conjunto",
                        JOptionPane.OK_CANCEL_OPTION, 0, new ImageIcon("src/main/java/resources/data/Iconos/1x/Icono-cabecera-50x50.png"));
                if (cancelar == 0) {
                    relacionS.setPares(new ArrayList());
                    actualizarPanel(RELACION, relacionS.getNombre());
                }
            }
        });

    }

//    private void agregarEventoEditarConjunto() {
//        pnEntradaRelaciones.getPnConjuntoA().getBtnEditar().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                vnConjunto = new VnConjunto(InterfazMain.getFrames()[0], true, "Editar conjunto", conjuntoA, false);
//                vnConjunto.getBtnAceptar().addActionListener(new java.awt.event.ActionListener() {
//                    @Override
//                    public void actionPerformed(java.awt.event.ActionEvent evt) {
//                        Conjunto conjunto = vnConjunto.getConjuntoTemporal();
//                        conjuntoA = conjunto;
//                        actualizarPanel(CONJUNTO, conjuntoA.getNombre());
//                        vnConjunto.dispose();
//                    }
//                });
//                vnConjunto.setVisible(true);
//            }
//        });
//
//        pnEntradaRelaciones.getPnConjuntoB().getBtnEditar().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                vnConjunto = new VnConjunto(InterfazMain.getFrames()[0], true, "Editar conjunto", conjuntoB, false);
//                vnConjunto.getBtnAceptar().addActionListener(new java.awt.event.ActionListener() {
//                    @Override
//                    public void actionPerformed(java.awt.event.ActionEvent evt) {
//                        Conjunto conjunto = vnConjunto.getConjuntoTemporal();
//                        conjuntoB = conjunto;
//                        actualizarPanel(CONJUNTO, conjuntoB.getNombre());
//                        vnConjunto.dispose();
//                    }
//                });
//                vnConjunto.setVisible(true);
//            }
//        });
//
//        pnEntradaRelaciones.getPnConjuntoC().getBtnEditar().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                vnConjunto = new VnConjunto(InterfazMain.getFrames()[0], true, "Editar conjunto", conjuntoC, false);
//                vnConjunto.getBtnAceptar().addActionListener(new java.awt.event.ActionListener() {
//                    @Override
//                    public void actionPerformed(java.awt.event.ActionEvent evt) {
//                        Conjunto conjunto = vnConjunto.getConjuntoTemporal();
//                        conjuntoC = conjunto;
//                        actualizarPanel(CONJUNTO, conjuntoC.getNombre());
//                        vnConjunto.dispose();
//                    }
//                });
//                vnConjunto.setVisible(true);
//            }
//        });
//    }
    private void agregarEventoEditarRelacion() {
        pnEntradaRelaciones.getPnRelacionR().getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                vnRelacion = new VnRelacion(InterfazMain.getFrames()[0], true, "Editar relación", relacionR, false);
                vnRelacion.getBtnAceptar().addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        Relacion relacion = vnRelacion.getTemporal();
                        relacionR = relacion;
                        actualizarPanel(RELACION, relacionR.getNombre());
                        vnRelacion.dispose();
                    }
                });
                vnRelacion.setVisible(true);
            }
        });

        pnEntradaRelaciones.getPnRelacionS().getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                vnRelacion = new VnRelacion(InterfazMain.getFrames()[0], true, "Editar relación", relacionS, false);
                vnRelacion.getBtnAceptar().addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        Relacion relacion = vnRelacion.getTemporal();
                        relacionS = relacion;
                        actualizarPanel(RELACION, relacionS.getNombre());
                        vnRelacion.dispose();
                    }
                });
                vnRelacion.setVisible(true);
            }
        });
    }

    public String getTITULO_RELACIONES() {
        return TITULO_RELACIONES;
    }

}
