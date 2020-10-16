/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unipamplona.MDiscretas.interfaz;

import static Unipamplona.MDiscretas.interfaz.InterfazMain.alto;
import static Unipamplona.MDiscretas.interfaz.InterfazMain.ancho;
import Unipamplona.MDiscretas.interfaz.pnCentralesRelaciones.PnEntradaRelaciones;
import Unipamplona.MDiscretas.interfaz.pnCentralesRelaciones.PnMatrizEntrada;
import Unipamplona.MDiscretas.interfaz.pnCentralesRelaciones.PnMatrizSalida;
import Unipamplona.MDiscretas.mundo.Conjunto;
import Unipamplona.MDiscretas.mundo.Relacion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author WILMER
 */
public class PnCentralRelaciones extends JPanel {

    private final String TITULO_RELACIONES = "Relaciones";

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

    public PnCentralRelaciones() {
        super();
        crearPanel();

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
        agregarEventoEditarConjunto();
        agregarEventoEditarRelacion();

        agregarEventoLimpiar();
        agregarEventoCrear();
        agregarEventosMatriz();

        this.add(pnFondo, java.awt.BorderLayout.CENTER);
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
                                JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "El tamaño ingresado no es válido.\n"
                            + "Solo están permitidos números enteros mayores a cero.", "Error en la entrada",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
                }
            }
        });
    }

    private void agregarEventoLimpiar() {
        pnMatrizEntrada.getBtnLimpiar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int cancelar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea limpiar la matriz? \n", "Limpiar la matriz",
                        JOptionPane.OK_CANCEL_OPTION, 0, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
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
                int cancelar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar los elementos del conjunto?\n", "Eliminar elementos de conjunto",
                        JOptionPane.OK_CANCEL_OPTION, 0, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
                if (cancelar == 0) {
                    conjuntoA.setElementos(new ArrayList());
                    actualizarPanel(CONJUNTO, conjuntoA.getNombre());
                }
            }
        });

        pnEntradaRelaciones.getPnConjuntoB().getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int cancelar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar los elementos del conjunto?\n", "Eliminar elementos de conjunto",
                        JOptionPane.OK_CANCEL_OPTION, 0, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
                if (cancelar == 0) {
                    conjuntoB.setElementos(new ArrayList());
                    actualizarPanel(CONJUNTO, conjuntoB.getNombre());
                }
            }
        });

        pnEntradaRelaciones.getPnConjuntoC().getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int cancelar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar los elementos del conjunto?\n", "Eliminar elementos de conjunto",
                        JOptionPane.OK_CANCEL_OPTION, 0, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
                if (cancelar == 0) {
                    conjuntoC.setElementos(new ArrayList());
                    actualizarPanel(CONJUNTO, conjuntoC.getNombre());
                }
            }
        });

        pnEntradaRelaciones.getPnRelacionR().getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int cancelar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar los elementos del conjunto?\n", "Eliminar elementos de conjunto",
                        JOptionPane.OK_CANCEL_OPTION, 0, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
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
                        JOptionPane.OK_CANCEL_OPTION, 0, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
                if (cancelar == 0) {
                    relacionS.setPares(new ArrayList());
                    actualizarPanel(RELACION, relacionS.getNombre());
                }
            }
        });

    }

    private void agregarEventoEditarConjunto() {
        pnEntradaRelaciones.getPnConjuntoA().getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                vnConjunto = new VnConjunto(InterfazMain.getFrames()[0], true, "Editar conjunto", conjuntoA, false);
                vnConjunto.getBtnAceptar().addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        Conjunto conjunto = vnConjunto.getConjuntoTemporal();
                        conjuntoA = conjunto;
                        actualizarPanel(CONJUNTO, conjuntoA.getNombre());
                        vnConjunto.dispose();
                    }
                });
                vnConjunto.setVisible(true);
            }
        });

        pnEntradaRelaciones.getPnConjuntoB().getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                vnConjunto = new VnConjunto(InterfazMain.getFrames()[0], true, "Editar conjunto", conjuntoB, false);
                vnConjunto.getBtnAceptar().addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        Conjunto conjunto = vnConjunto.getConjuntoTemporal();
                        conjuntoB = conjunto;
                        actualizarPanel(CONJUNTO, conjuntoB.getNombre());
                        vnConjunto.dispose();
                    }
                });
                vnConjunto.setVisible(true);
            }
        });

        pnEntradaRelaciones.getPnConjuntoC().getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                vnConjunto = new VnConjunto(InterfazMain.getFrames()[0], true, "Editar conjunto", conjuntoC, false);
                vnConjunto.getBtnAceptar().addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        Conjunto conjunto = vnConjunto.getConjuntoTemporal();
                        conjuntoC = conjunto;
                        actualizarPanel(CONJUNTO, conjuntoC.getNombre());
                        vnConjunto.dispose();
                    }
                });
                vnConjunto.setVisible(true);
            }
        });
    }

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
