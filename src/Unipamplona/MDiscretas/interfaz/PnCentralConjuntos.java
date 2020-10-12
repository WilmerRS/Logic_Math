/**
 * Clase que controla los paneles internos del centro
 */
package Unipamplona.MDiscretas.interfaz;

import static Unipamplona.MDiscretas.interfaz.InterfazMain.ancho;
import Unipamplona.MDiscretas.interfaz.pnCentralesConjuntos.PnConjunto;
import javax.swing.JPanel;
import Unipamplona.MDiscretas.interfaz.pnCentralesConjuntos.PnConjuntos;
import Unipamplona.MDiscretas.interfaz.pnCentralesConjuntos.PnDiagramaVenn;
import Unipamplona.MDiscretas.interfaz.pnCentralesConjuntos.PnEntradaDatos;
import Unipamplona.MDiscretas.interfaz.pnCentralesConjuntos.PnImagenSalida;
import Unipamplona.MDiscretas.interfaz.pnCentralesConjuntos.PnTablaVerdad;
import Unipamplona.MDiscretas.mundo.Conjunto;
import Unipamplona.MDiscretas.mundo.Conjuntos;
import Unipamplona.MDiscretas.mundo.Interpretador;
import Unipamplona.MDiscretas.mundo.LaTex;
import Unipamplona.MDiscretas.mundo.OperacionesConjuntos;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author WILMER
 */
public class PnCentralConjuntos extends JPanel {

    private final String TITULO_RELACIONES = "Conjuntos y lógica";
    private final String CONJUNTOS = "CONJUNTOS";
    private final String HISTORIAL = "HISTORIAL";
    private final String AGREGAR = "Agregar";
    private final String BORRAR = "Borrar todo";

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
    private PnConjuntos pnHistorial;
    private PnTablaVerdad pnTabla;
    private PnImagenSalida pnImgSalida;
//    private PnElementosConjunto pnElementos;

    private Conjuntos conjuntos;
    private Conjuntos historial;

    private VnConjunto vnConjunto;

    private LaTex latex;
    private String operacion = operacionInicialMatriz;
    /**
     * *
     * Variables para poder editar un conjunto
     */
    private int iteradorConjunto = 0;
//    private int iteradorHistorial = 0;

    Conjunto conjuntoEditar;

    public PnCentralConjuntos() {
        super();
        interpretador = new Interpretador();
        conjuntos = new Conjuntos(CONJUNTOS);
        historial = new Conjuntos(HISTORIAL);
        latex = new LaTex(operacionInicialMatriz);
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

        pnAdminConjunto = new PnConjuntos("Conjuntos registrados", AGREGAR);
        agregarEventoAgregar();

        pnIzqAbajo.add(pnAdminConjunto);

        pnImgSalida = new PnImagenSalida();

        pnAtrasDerecha.add(java.awt.BorderLayout.NORTH, pnImgSalida);

        pnTabla = new PnTablaVerdad(operacionInicialMatriz, operacionInicialTitulo);
        pnDerAbajo.add(pnTabla);
        agregarEventoCalcular();

        // Paneles de la derecha
        pndVenn = new PnDiagramaVenn();
        pnIzqAbajo.add(pndVenn);

        pnHistorial = new PnConjuntos("Historial de resultados", BORRAR);
        actualizarConjuntos();
        actualizarHistorial();
        agregarEventoSlider();

        int inicial = 40;
        if (ancho < 1500) {
            inicial = 25;
        }
        pnImgSalida.getLbImagen().setIcon(latex.actualizarIconLaTex(operacionInicialMatriz, inicial));
        agregarEventoBorrarTodo();
        pnDerAbajo.add(pnHistorial);
    }

    private void agregarEventoCalcular() {
        pnEntDatos.getBtnCalcular().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (pnEntDatos.getContadorParentesis() == 0) { // Parentesis completos
                    operacion = interpretador.descomponerOperacion(pnEntDatos.getTxtEntrada().getText());
                    OperacionesConjuntos operaciones = new OperacionesConjuntos(conjuntos);
                    Conjunto conTemp = operaciones.resultadoConjunto(operacion);
                    if (conTemp != null) {
                        int inicial = 40;
                        if (ancho < 1500) {
                            inicial = 25;
                        }
                        pnImgSalida.getLbImagen().setIcon(latex.actualizarIconLaTex(operacion, inicial));
                        pnImgSalida.getLbImagen().updateUI();

                        pnTabla.setOperacionInfija(operacion);
                        pnTabla.actualizarTabla();
                        pnTabla.updateUI();

                        conTemp.setNombre(pnEntDatos.getTxtEntrada().getText());
                        historial.addConjunto(conTemp);
                        actualizarConjuntos();
                        actualizarHistorial();

                    } else {
                        JOptionPane.showMessageDialog(null, "La operación ingresada no es válida.\n"
                                + "Intente nuevamente con otra entrada.", "Error al realizar operación",
                                JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Los parentesis ingresados no coinciden.\n"
                            + "Verifique que estén completos, e intente nuevamente.", "Error al realizar operación",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
                }
            }
        });
    }

    private void agregarEventoSlider() {
        pnImgSalida.getSlider().addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                int valor = pnImgSalida.getSlider().getValue();
                pnImgSalida.getLbImagen().setIcon(latex.actualizarIconLaTex(operacion, valor));
            }
        });
    }

    private void agregarEventoAgregar() {
        pnAdminConjunto.getBtnPrincipal().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Conjunto temp = new Conjunto(conjuntos.getNombreRecomendado(), new ArrayList(), conjuntos.getColorRecomendado());
                vnConjunto = new VnConjunto(InterfazMain.getFrames()[0], true, "Agregar un nuevo conjunto", temp);
                vnConjunto.getBtnAceptar().addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        Conjunto conjunto = vnConjunto.getConjuntoTemporal();
                        if ((conjuntos.buscarConjunto(conjunto.getNombre()) == -1)) {
                            conjuntos.addConjunto(conjunto);
                            actualizarConjuntos();
                            vnConjunto.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "El nombre del conjunto \"" + conjunto.getNombre() + "\", ya está  asignado a un"
                                    + "conjunto existente.\nSolo están permitidos nombres que no estén registrados.", "Error al agregar conjunto",
                                    JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
                        }
                    }
                });
                vnConjunto.setVisible(true);
            }
        });
    }

    private void agregarEventoBorrarConjunto() {
        for (int i = 0; i < pnAdminConjunto.getPnInferior().getComponentCount(); i++) {
            PnConjunto pnConjunto = (PnConjunto) pnAdminConjunto.getPnInferior().getComponent(i);

            pnConjunto.getBtnEliminar().addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    int h = 0;
                    Boton a = (Boton) evt.getSource();
                    for (int i = 0; i < pnAdminConjunto.getPnInferior().getComponentCount(); i++) {
                        PnConjunto panelCOnjunto = (PnConjunto) pnAdminConjunto.getPnInferior().getComponent(i);
                        Boton botonTemp = (Boton) panelCOnjunto.getBtnEliminar();
                        if (a.getIndice() == botonTemp.getIndice()) {
                            h = i;
                        }
                    }
                    int cancelar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea borrar este conjunto?   \n", "Borrar conjunto",
                            JOptionPane.OK_CANCEL_OPTION, 0, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
                    if (cancelar == 0) {
                        conjuntos.getConjuntos().remove(h);
                        actualizarConjuntos();
                    }
                }
            });
        }
    }

    private void agregarEventoBorrarHistorial() {
        for (int i = 0; i < pnHistorial.getPnInferior().getComponentCount(); i++) {
            PnConjunto pnConjunto = (PnConjunto) pnHistorial.getPnInferior().getComponent(i);

            pnConjunto.getBtnEliminar().addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    Boton a = (Boton) evt.getSource();
                    int h = 0;
                    for (int i = 0; i < pnHistorial.getPnInferior().getComponentCount(); i++) {
                        PnConjunto panelCOnjunto = (PnConjunto) pnHistorial.getPnInferior().getComponent(i);
                        Boton botonTemp = (Boton) panelCOnjunto.getBtnEliminar();
                        if (a.getIndice() == botonTemp.getIndice()) {
                            h = i;
                        }
                    }
                    int cancelar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea borrar este conjunto?   \n", "Borrar conjunto",
                            JOptionPane.OK_CANCEL_OPTION, 0, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
                    if (cancelar == 0) {
                        historial.getConjuntos().remove(h);
                        actualizarHistorial();
                    }
                }
            });
        }
    }

    private void agregarEventoEditar() {
        for (int i = 0; i < pnAdminConjunto.getPnInferior().getComponentCount(); i++) {
            PnConjunto pnConjunto = (PnConjunto) pnAdminConjunto.getPnInferior().getComponent(i);

            pnConjunto.getBtnEditar().addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    Boton a = (Boton) evt.getSource();
                    for (int i = 0; i < pnAdminConjunto.getPnInferior().getComponentCount(); i++) {
                        PnConjunto panelCOnjunto = (PnConjunto) pnAdminConjunto.getPnInferior().getComponent(i);
                        Boton botonTemp = (Boton) panelCOnjunto.getBtnEditar();
                        if (a.getIndice() == botonTemp.getIndice()) {
                            iteradorConjunto = i;
                        }
                    }
                    conjuntoEditar = conjuntos.getConjuntos().get(iteradorConjunto);
                    vnConjunto = new VnConjunto(InterfazMain.getFrames()[0], true, "Agregar un nuevo conjunto", conjuntoEditar);
                    vnConjunto.getBtnAceptar().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            Conjunto conjunto = vnConjunto.getConjuntoTemporal();
                            if (conjuntos.buscarConjunto(conjunto.getNombre()) == -1 || conjunto.getNombre().equals(conjuntoEditar.getNombre())) {
                                conjuntos.reemplazarConjunto(conjunto, iteradorConjunto);
                                actualizarConjuntos();
                                vnConjunto.dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "El nombre del conjunto \"" + conjunto.getNombre() + "\", ya está  asignado a un"
                                        + "conjunto existente.\nSolo están permitidos nombres que no estén registrados.", "Error al editar conjunto",
                                        JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
                            }
                        }
                    });
                    vnConjunto.setVisible(true);
                }
            });
        }
    }

    private void actualizarConjuntos() {
        pnAdminConjunto.getPnInferior().removeAll();

        GridBagConstraints constrains = new GridBagConstraints();
        constrains.gridx = 0;
        constrains.gridy = GridBagConstraints.RELATIVE;
        constrains.gridwidth = 1;
        constrains.gridheight = 1;
        constrains.weightx = 1f;
        constrains.weighty = 0.1f;
        constrains.ipadx = 0;
        constrains.ipady = 0;
        constrains.insets = new Insets(5, 5, 0, 5);
        constrains.fill = GridBagConstraints.HORIZONTAL;
        constrains.anchor = GridBagConstraints.PAGE_START;

        ArrayList<Conjunto> tempConjuntos = conjuntos.getConjuntos();
        for (int i = 0; i < tempConjuntos.size(); i++) {
            PnConjunto pnTemp = new PnConjunto(tempConjuntos.get(i).getColor(), new Dimension((int) (ancho * 0.035), (int) (ancho * 0.035)),
                    tempConjuntos.get(i).getCadenaElementos(), true, i);
            pnAdminConjunto.getPnInferior().add(pnTemp, constrains);
        }
        agregarEventoEditar();
        agregarEventoBorrarConjunto();
        pnAdminConjunto.updateUI();
    }

    private void actualizarHistorial() {
        pnHistorial.getPnInferior().removeAll();

        GridBagConstraints constrains = new GridBagConstraints();
        constrains.gridx = 0;
        constrains.gridy = GridBagConstraints.RELATIVE;
        constrains.gridwidth = 1;
        constrains.gridheight = 1;
        constrains.weightx = 1f;
        constrains.weighty = 0.1f;
        constrains.ipadx = 0;
        constrains.ipady = 0;
        constrains.insets = new Insets(5, 5, 0, 5);
        constrains.fill = GridBagConstraints.HORIZONTAL;
        constrains.anchor = GridBagConstraints.PAGE_START;

        ArrayList<Conjunto> tempConjuntos = historial.getConjuntos();

        for (int i = 0; i < tempConjuntos.size(); i++) {
            PnConjunto pnTemp = new PnConjunto(tempConjuntos.get(i).getColor(), new Dimension((int) (ancho * 0.035), (int) (ancho * 0.035)),
                    tempConjuntos.get(i).getCadenaElementos(), false, i);
            pnHistorial.getPnInferior().add(pnTemp, constrains);
        }
//        agregarEventoBorrarConjunto();
        agregarEventoBorrarHistorial();

        pnHistorial.updateUI();
    }

    private void agregarEventoBorrarTodo() {
        pnHistorial.getBtnPrincipal().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int cancelar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea borrar todo el historial?   \n", "Borrar historial",
                        JOptionPane.OK_CANCEL_OPTION, 0, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
                if (cancelar == 0) {
                    historial.eliminarTodo();
                    actualizarHistorial();
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

    public String getTITULO_RELACIONES() {
        return TITULO_RELACIONES;
    }

}
