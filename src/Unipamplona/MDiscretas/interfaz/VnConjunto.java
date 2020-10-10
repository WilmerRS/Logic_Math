package Unipamplona.MDiscretas.interfaz;

import static Unipamplona.MDiscretas.interfaz.InterfazMain.alto;
import static Unipamplona.MDiscretas.interfaz.InterfazMain.ancho;
import Unipamplona.MDiscretas.mundo.Conjunto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class VnConjunto extends javax.swing.JDialog {

    private final String MAYUS = "MAYUS";
    private final String MINUS_MAYUS = "MINUS_MAYUS";
    private final String NUMEROS = "NUMEROS";

    private Conjunto conjuntoTemporal;

    private PnCabecera pnCabecera;
    private JPanel pnFondo;
    private JPanel pnInf;
    private JPanel pnDer;
    private JPanel pnIzq;
    private JPanel pnSup;
    private JPanel pnCentral;

    private JPanel pnNombreFondo;
    private JPanel pnAgregarFondo;
    private JPanel pnEliminarFondo;
    private JPanel pnElementosFondo;
    private JPanel pnBotonesFondo;

    private JPanel pnDerechaColor;
    private JPanel pnEtiquetaColor;
    private JPanel pnColor;
    private JPanel pnActualElementos;

    private JPanel pnEntradaAgregar;
    private JPanel pnEntradraEliminar;

    private JTextField txtNombre;
    private JTextField txtElemento;
    private JTextField txtPosicion;

    private String titulo;

    private Boton btnAgregar;
    private Boton btnEliminar;
    private Boton btnAceptar;
    private Boton btnCancelar;

    private JPanel pnNombreEntrada;

    private int tamanho = (int) (ancho * 0.003);

    public VnConjunto(java.awt.Frame parent, boolean modal, String titulo, Conjunto conjunto) {
        super(parent, modal);
        this.titulo = titulo;
        this.conjuntoTemporal = conjunto;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setLayout(new java.awt.BorderLayout());
        this.setResizable(false);
        this.setIconImage(new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png").getImage());
        this.setTitle(titulo);

        pnCabecera = new PnCabecera("   " + titulo);
        pnCabecera.setPreferredSize(new java.awt.Dimension((int) (ancho * 0.3073), (int) (alto * 0.063)));

        pnFondo = new JPanel();
        pnFondo.setPreferredSize(new java.awt.Dimension((int) (ancho * 0.3073), (int) (alto * 0.3797)));
        pnFondo.setLayout(new java.awt.BorderLayout(0, 0));
        pnFondo.setBackground(PatronDisenho.BLANCO);

        inicializarMargenes();

        pnCentral = new JPanel();
        pnCentral.setBackground(PatronDisenho.BLANCO);
        pnCentral.setLayout(new java.awt.GridLayout(0, 1, 15, 15));

        pnNombreFondo = new JPanel();
        pnNombreFondo.setBackground(PatronDisenho.BLANCO);
        pnNombreFondo.setLayout(new java.awt.BorderLayout(15, 15));
        pnNombreFondo.add(crearPnEtiqueta("Nombre del conjunto:"), java.awt.BorderLayout.WEST);

        pnNombreEntrada = new JPanel();
        pnNombreEntrada.setLayout(new BorderLayout());

        txtNombre = new JTextField(conjuntoTemporal.getNombre());
        txtNombre = modificarPnEntrada(txtNombre, MAYUS);
        pnNombreEntrada.add(txtNombre, java.awt.BorderLayout.CENTER);
        pnNombreEntrada.add(crearOrilla(), java.awt.BorderLayout.SOUTH);

        pnNombreFondo.add(pnNombreEntrada, java.awt.BorderLayout.CENTER);

        pnDerechaColor = new JPanel();
        pnDerechaColor.setBackground(PatronDisenho.BLANCO);
        pnDerechaColor.setLayout(new BorderLayout(10, 10));

        pnEtiquetaColor = crearPnEtiqueta("Color:");
        pnEtiquetaColor.setPreferredSize(new java.awt.Dimension((int) (ancho * 0.03), (int) (alto * 0.0468)));

        pnColor = new JPanel();
        pnColor.setBackground(conjuntoTemporal.getColor());
        pnColor.setPreferredSize(new java.awt.Dimension((int) (ancho * 0.032), (int) (alto * 0.03)));

        agregarEventosPnColor();

        pnDerechaColor.add(pnEtiquetaColor, java.awt.BorderLayout.WEST);
        pnDerechaColor.add(pnColor, java.awt.BorderLayout.CENTER);

        pnNombreFondo.add(pnDerechaColor, java.awt.BorderLayout.EAST);

        pnAgregarFondo = new JPanel();
        pnAgregarFondo.setBackground(PatronDisenho.BLANCO);
        pnAgregarFondo.setLayout(new java.awt.BorderLayout(15, 15));

        pnEntradaAgregar = new JPanel();
        pnEntradaAgregar.setBackground(PatronDisenho.BLANCO);
        pnEntradaAgregar.setLayout(new java.awt.BorderLayout(0, 0));

        txtElemento = new JTextField();
        txtElemento = modificarPnEntrada(txtElemento, MINUS_MAYUS);
        pnEntradaAgregar.add(txtElemento, java.awt.BorderLayout.CENTER);

        pnEntradaAgregar.add(crearPnEtiqueta("Elemento:"), java.awt.BorderLayout.NORTH);
        pnEntradaAgregar.add(crearOrilla(), java.awt.BorderLayout.SOUTH);

        btnAgregar = new Boton("Agregar", null, new Dimension((int) (ancho * 0.0666), 50),
                tamanho, Boton.SUR, Boton.TEXTO, PatronDisenho.MORADO_CABECERA, PatronDisenho.MORADO_CLARO,
                PatronDisenho.MORADO_CABECERA_HOVER, PatronDisenho.MORADO_CABECERA_CLICK, PatronDisenho.BLANCO);

        pnAgregarFondo.add(crearPnEtiqueta("Agregar elemento:"), java.awt.BorderLayout.WEST);
        pnAgregarFondo.add(pnEntradaAgregar, java.awt.BorderLayout.CENTER);
        pnAgregarFondo.add(btnAgregar, java.awt.BorderLayout.EAST);

        pnEliminarFondo = new JPanel();
        pnEliminarFondo.setBackground(PatronDisenho.BLANCO);
        pnEliminarFondo.setLayout(new java.awt.BorderLayout(15, 15));

        pnEntradraEliminar = new JPanel();
        pnEntradraEliminar.setBackground(PatronDisenho.BLANCO);
        pnEntradraEliminar.setLayout(new java.awt.BorderLayout(0, 0));

        txtPosicion = new JTextField();
        txtPosicion = modificarPnEntrada(txtPosicion, MINUS_MAYUS);
        pnEntradraEliminar.add(txtPosicion, java.awt.BorderLayout.CENTER);

        pnEntradraEliminar.add(crearPnEtiqueta("Elemento:"), java.awt.BorderLayout.NORTH);
        pnEntradraEliminar.add(crearOrilla(), java.awt.BorderLayout.SOUTH);

        btnEliminar = new Boton("Eliminar", null, new Dimension((int) (ancho * 0.0666), 50),
                tamanho, Boton.SUR, Boton.TEXTO, PatronDisenho.GRIS_FONDO_2, PatronDisenho.ROJO_OSCURO,
                PatronDisenho.GRIS_HOVER, PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR);

        pnEliminarFondo.add(crearPnEtiqueta("Eliminar elemento:"), java.awt.BorderLayout.WEST);
        pnEliminarFondo.add(pnEntradraEliminar, java.awt.BorderLayout.CENTER);
        pnEliminarFondo.add(btnEliminar, java.awt.BorderLayout.EAST);

        pnElementosFondo = new JPanel();
        pnElementosFondo.setBackground(PatronDisenho.BLANCO);
        pnElementosFondo.setLayout(new java.awt.BorderLayout(15, 15));

        pnActualElementos = new JPanel();
        pnActualElementos.setBackground(PatronDisenho.BLANCO);
        pnActualElementos.setLayout(new java.awt.BorderLayout(0, 0));

        actualizarElementos();

        pnElementosFondo.add(crearPnEtiqueta("Elementos actuales:"), java.awt.BorderLayout.WEST);
        pnElementosFondo.add(pnActualElementos, java.awt.BorderLayout.CENTER);

        pnBotonesFondo = new JPanel();
        pnBotonesFondo.setBackground(PatronDisenho.BLANCO);
        pnBotonesFondo.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 15, 0));

        btnAceptar = new Boton("Aceptar", null, new Dimension((int) (ancho * 0.08), 50),
                tamanho, Boton.SUR, Boton.TEXTO, PatronDisenho.MORADO_CABECERA, PatronDisenho.MORADO_CLARO,
                PatronDisenho.MORADO_CABECERA_HOVER, PatronDisenho.MORADO_CABECERA_CLICK, PatronDisenho.BLANCO);

        btnCancelar = new Boton("Cancelar", null, new Dimension((int) (ancho * 0.075), 50),
                tamanho, Boton.SUR, Boton.TEXTO, PatronDisenho.ROJO_OSCURO, PatronDisenho.ROJO_CLARO,
                PatronDisenho.ROJO_HOVER, PatronDisenho.ROJO_CLICK, PatronDisenho.BLANCO);

        pnBotonesFondo.add(btnAceptar);
        pnBotonesFondo.add(btnCancelar);

        agregarEventosBotones();

        pnCentral.add(pnNombreFondo);
        pnCentral.add(pnAgregarFondo);
        pnCentral.add(pnEliminarFondo);
        pnCentral.add(pnElementosFondo);
        pnCentral.add(pnBotonesFondo);

        pnFondo.add(pnSup, java.awt.BorderLayout.NORTH);
        pnFondo.add(pnInf, java.awt.BorderLayout.SOUTH);
        pnFondo.add(pnDer, java.awt.BorderLayout.EAST);
        pnFondo.add(pnIzq, java.awt.BorderLayout.WEST);
        pnFondo.add(pnCentral, java.awt.BorderLayout.CENTER);

        this.add(pnCabecera, java.awt.BorderLayout.NORTH);
        this.add(pnFondo, java.awt.BorderLayout.CENTER);
        pack();
    }

    private void actualizarElementos() {
        ArrayList<String> temporal = conjuntoTemporal.getElementos();
        String texto = "" + conjuntoTemporal.getNombre() + " = { ";

        for (int i = 0; i < temporal.size(); i++) {
            if (i != 0) {
                texto += ", ";
            }
            texto += temporal.get(i);
        }
        texto += " }";
        pnActualElementos.removeAll();
        pnActualElementos.add(crearOrilla(), java.awt.BorderLayout.SOUTH);
        pnActualElementos.add(crearPnEtiqueta(texto), java.awt.BorderLayout.CENTER);
        pnActualElementos.updateUI();
    }

    private JPanel crearPnEtiqueta(String texto) {
        JPanel temp = new JPanel();
        JLabel lbEtiqueta = new JLabel(texto);
        lbEtiqueta.setForeground(PatronDisenho.MORADO_OSCURO);
        lbEtiqueta.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        if (ancho < 1500) {
            lbEtiqueta.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbEtiqueta.setFont(PatronDisenho.SEGOE_16);
        }

        temp.setPreferredSize(new java.awt.Dimension((int) (ancho * 0.09), (int) (alto * 0.017)));
        temp.setLayout(new java.awt.BorderLayout());
        temp.setBackground(PatronDisenho.BLANCO);

        temp.add(lbEtiqueta);
        return temp;
    }

    private JPanel crearOrilla() {
        JPanel pnOrilla = new JPanel();
        pnOrilla.setVisible(true);
        pnOrilla.setPreferredSize(new java.awt.Dimension((int) (ancho * 0.002), (int) (ancho * 0.002)));
        pnOrilla.setBackground(PatronDisenho.GRIS_FONDO);
        return pnOrilla;
    }

    public Conjunto getTemporal() {
        return conjuntoTemporal;
    }

    public void setTemporal(Conjunto temporal) {
        this.conjuntoTemporal = temporal;
    }

    private void inicializarMargenes() {
        pnSup = new JPanel();
        pnSup.setBackground(PatronDisenho.BLANCO);
        pnSup.setPreferredSize(new java.awt.Dimension((int) (ancho * 0.01389), (int) (ancho * 0.01389)));

        pnInf = new JPanel();
        pnInf.setBackground(PatronDisenho.BLANCO);
        pnInf.setPreferredSize(new java.awt.Dimension((int) (ancho * 0.01389), (int) (ancho * 0.01389)));

        pnDer = new JPanel();
        pnDer.setBackground(PatronDisenho.BLANCO);
        pnDer.setPreferredSize(new java.awt.Dimension((int) (ancho * 0.01389), (int) (ancho * 0.01389)));

        pnIzq = new JPanel();
        pnIzq.setBackground(PatronDisenho.BLANCO);
        pnIzq.setPreferredSize(new java.awt.Dimension((int) (ancho * 0.01389), (int) (ancho * 0.01389)));
    }

    private JTextField modificarPnEntrada(JTextField campo, String RESTRICCION) {

        campo.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            campo.setFont(PatronDisenho.SEGOE_12);
            campo.setBorder(new Border() {
                @Override
                public void paintBorder(Component cmpnt, Graphics grphcs, int i, int i1, int i2, int i3) {
                }

                @Override
                public Insets getBorderInsets(Component cmpnt) {
                    return new Insets(4, 19, 3, 19);
                }

                @Override
                public boolean isBorderOpaque() {
                    return true;
                }
            });
        } else {
            campo.setFont(PatronDisenho.SEGOE_18);
            campo.setBorder(new Border() {
                @Override
                public void paintBorder(Component cmpnt, Graphics grphcs, int i, int i1, int i2, int i3) {
                }

                @Override
                public Insets getBorderInsets(Component cmpnt) {
                    return new Insets(7, 19, 6, 19);
                }

                @Override
                public boolean isBorderOpaque() {
                    return true;
                }
            });
        }
        campo.setCaretColor(PatronDisenho.MORADO_OSCURO);
        campo.setSelectedTextColor(PatronDisenho.BLANCO);
        campo.setSelectionColor(PatronDisenho.MORADO_OSCURO);

        campo.setMargin(new java.awt.Insets(7, 7, 7, 7));

        campo.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                campo.setBackground(PatronDisenho.GRIS_FONDO_2);
                campo.paint(campo.getGraphics());
            }

            @Override
            public void focusLost(FocusEvent fe) {
                try {
                    campo.setBackground(PatronDisenho.BLANCO);
                    campo.paint(campo.getGraphics());
                } catch (Exception e) {
                }

            }
        });
        agregarRestricciones(campo, RESTRICCION);
        return campo;
    }

    private void agregarRestricciones(JTextField campo, String RESTRICCION) {
        campo.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                controlarEntrada(campo, RESTRICCION);
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                controlarEntrada(campo, RESTRICCION);
            }
        });
    }

    private void controlarEntrada(JTextField campo, String RESTRICCION) {
        String temp = campo.getText();
        try {
            switch (RESTRICCION) {
                case MAYUS:
                    if (((temp.charAt(temp.length() - 1) > 64 && temp.charAt(temp.length() - 1) < 91) // Letras mayusculas
                            || (temp.charAt(temp.length() - 1) > 96 && temp.charAt(temp.length() - 1) < 123))) {// Letras miniculas 
                        String temp1 = campo.getText();

                        String texto = "";
                        texto += (temp1.charAt(temp1.length() - 1) + "").toUpperCase();
                        campo.setText(texto);
                        conjuntoTemporal.setNombre(texto);
                        actualizarElementos();
                    } else {
                        campo.setText("");
                    }
                    break;
                case MINUS_MAYUS:
                    if (((temp.charAt(temp.length() - 1) > 64 && temp.charAt(temp.length() - 1) < 91) // Letras mayusculas
                            || (temp.charAt(temp.length() - 1) > 96 && temp.charAt(temp.length() - 1) < 123)// Letras miniculas 
                            || (temp.charAt(temp.length() - 1) > 47 && temp.charAt(temp.length() - 1) < 58))) { // Numeros
                        String temp1 = campo.getText();

                        String r = "";
                        r += (temp1.charAt(temp1.length() - 1) + "");
                        campo.setText(r);
                    } else {
                        campo.setText("");
                    }
                    break;
            }

        } catch (Exception e) {
        }
    }

    private void agregarEventosPnColor() {
        pnColor.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Color color = JColorChooser.showDialog(pnColor, "Elige el color del conjunto", conjuntoTemporal.getColor());
                if (color != null && color != PatronDisenho.BLANCO) {
                    Color temp = new Color(color.getRGB());
                    pnColor.setBackground(temp);
                    conjuntoTemporal.setColor(temp);
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                pnColor.setBorder(BorderFactory.createLineBorder(PatronDisenho.MORADO_OSCURO, 2));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                pnColor.setBorder(null);
            }
        });
    }

    private void agregarEventosBotones() {
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (txtElemento.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "No puede agregar un elemento vacío.\n", "Error en la entrada",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
                } else {
                    if (!conjuntoTemporal.getElementos().contains(txtElemento.getText())) {
                        conjuntoTemporal.getElementos().add(txtElemento.getText());
                        actualizarElementos();
                    } else {
                        JOptionPane.showMessageDialog(null, "El elemento ya existe en el conjunto.\n", "Error en la entrada",
                                JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
                    }
                }
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (txtPosicion.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "No puede eliminar un elemento vacío.\n", "Error en la entrada",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
                } else {
                    if(conjuntoTemporal.getElementos().contains(txtPosicion.getText())){
                        conjuntoTemporal.getElementos().remove(txtPosicion.getText());
                            actualizarElementos();
                    }else{
                        JOptionPane.showMessageDialog(null, "El elemento indicado no existe dentro del conjunto.\n", "Error en la entrada",
                                    JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
                    }
                }
            }
        });
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Aceptar");
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int cancelar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir?   \n", "Salir de " + titulo,
                        JOptionPane.OK_CANCEL_OPTION, 0, new ImageIcon("./data/Iconos/1x/Icono-cabecera-50x50.png"));
                if (cancelar == 0) {
                    dispose();
                }
            }
        });
    }
    
}
