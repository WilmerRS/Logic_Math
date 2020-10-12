/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unipamplona.MDiscretas.interfaz.pnCentralesConjuntos;

import Unipamplona.MDiscretas.interfaz.Boton;
import javax.swing.JPanel;
import static Unipamplona.MDiscretas.interfaz.InterfazMain.alto;
import static Unipamplona.MDiscretas.interfaz.InterfazMain.ancho;
import Unipamplona.MDiscretas.interfaz.PatronDisenho;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 *
 * @author WILMER
 */
public class PnEntradaDatos extends JPanel {

    /**
     * determina el tamanho de los botones en el panel
     */
    private final java.awt.Dimension dimensionBotones = new Dimension((int) (ancho * 0.025), (int) (alto * 0.063));

    private String[] simbolosEntrada = {"(", ")", "UNI", "INTS", "COMPL", "DIF", "SIM"};
    private String[] simbolosSalida = {"(", ")", "+", "*", "#", "-", "^"};

    private JPanel pnEntrada;

    private Boton btnUnion;
    private Boton btnInterseccion;
    private Boton btnComplemento;
    private Boton btnDiferencia;
    private Boton btnDifSimetrica;
    private Boton btnParentesisIzq;
    private Boton btnParentesisDer;

    private Boton btnCalcular;
    private Boton btnLimpiar;

    private JPanel pnSuperior;
    private JPanel pnOrilla;
    private JPanel pnInferior;

    private JTextArea txtEntrada;
    private JLabel lbEntrada;

    private JScrollPane spEntrada;

    private int tamanho = (int) (ancho * 0.003);
    private int contadorParentesis = 0;
    
    private String operacionInicial;
    

    public PnEntradaDatos(String operacionInicial) {
        super();
        this.operacionInicial=operacionInicial;
        crearPanel();
    }

    public JTextArea getTxtEntrada() {
        return txtEntrada;
    }

    public void setTxtEntrada(JTextArea txtEntrada) {
        this.txtEntrada = txtEntrada;
    }

    private void crearPanel() {
        this.setBackground(PatronDisenho.GRIS_FONDO);
        this.setMinimumSize(new Dimension(10, (int) (alto * 0.07 * 2)));
        this.setPreferredSize(new Dimension(10, (int) (alto * 0.07 * 2)));
        this.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        lbEntrada = new JLabel("    Entrada de operaciones:");
        lbEntrada.setBackground(PatronDisenho.MORADO_CLICK);
        lbEntrada.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbEntrada.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbEntrada.setFont(PatronDisenho.SEGOE_16);
        }

        pnSuperior = new JPanel();
        pnSuperior.setBackground(PatronDisenho.GRIS_FONDO);
        pnSuperior.setLayout(new java.awt.BorderLayout(5, 0));

        pnEntrada = new JPanel();
        pnEntrada.setBackground(PatronDisenho.BLANCO);
        pnEntrada.setLayout(new java.awt.BorderLayout());

        pnOrilla = new JPanel();
        pnOrilla.setVisible(false);
        pnOrilla.setPreferredSize(new java.awt.Dimension(0, tamanho));
        pnOrilla.setBackground(PatronDisenho.GRIS_RESALTADOR);
        pnEntrada.add(java.awt.BorderLayout.SOUTH, pnOrilla);

        modificarPnEntrada(operacionInicial);

        btnCalcular = new Boton("Calcular", null, new Dimension((int) (ancho * 0.07), (int) (alto * 0.063)),
                tamanho, Boton.SUR, Boton.TEXTO, PatronDisenho.MORADO_CABECERA, PatronDisenho.MORADO_CLARO,
                PatronDisenho.MORADO_CABECERA_HOVER, PatronDisenho.MORADO_CABECERA_CLICK, PatronDisenho.BLANCO, 0);

        pnSuperior.add(pnEntrada, java.awt.BorderLayout.CENTER);
        pnSuperior.add(btnCalcular, java.awt.BorderLayout.EAST);

        pnInferior = new JPanel();
        pnInferior.setBackground(PatronDisenho.GRIS_FONDO);
        pnInferior.setLayout(new java.awt.GridLayout(1, 0, 0, 0));

        Dimension dimBotonesOper = new Dimension((int) (ancho * 0.037), (int) (alto * 0.063));
        btnUnion = new Boton(" U ", null, dimBotonesOper, tamanho, Boton.SUR, Boton.TEXTO,
                PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, 0);
        btnInterseccion = new Boton(" I ", null, dimBotonesOper, tamanho, Boton.SUR, Boton.TEXTO,
                PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, 0);
        btnComplemento = new Boton(" C ", null, dimBotonesOper, tamanho, Boton.SUR, Boton.TEXTO,
                PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, 0);
        btnDiferencia = new Boton(" D ", null, dimBotonesOper, tamanho, Boton.SUR, Boton.TEXTO,
                PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, 0);
        btnDifSimetrica = new Boton(" DS ", null, dimBotonesOper, tamanho, Boton.SUR, Boton.TEXTO,
                PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, 0);
        btnParentesisIzq = new Boton(" ( ", null, dimBotonesOper, tamanho, Boton.SUR, Boton.TEXTO,
                PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, 0);
        btnParentesisDer = new Boton(" ) ", null, dimBotonesOper, tamanho, Boton.SUR, Boton.TEXTO,
                PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, 0);
        btnLimpiar = new Boton("Limpiar ", null, dimBotonesOper,
                tamanho, Boton.SUR, Boton.TEXTO, PatronDisenho.ROJO_OSCURO, PatronDisenho.ROJO_CLARO,
                PatronDisenho.ROJO_HOVER, PatronDisenho.ROJO_CLICK, PatronDisenho.BLANCO, 0);

        agregarEventosBtn();

        pnInferior.add(btnUnion);
        pnInferior.add(btnInterseccion);
        pnInferior.add(btnComplemento);
        pnInferior.add(btnDiferencia);
        pnInferior.add(btnDifSimetrica);
        pnInferior.add(btnParentesisIzq);
        pnInferior.add(btnParentesisDer);
        pnInferior.add(btnLimpiar);
        pnEntrada.add(lbEntrada, BorderLayout.NORTH);

        this.add(java.awt.BorderLayout.NORTH, pnSuperior);
        this.add(java.awt.BorderLayout.SOUTH, pnInferior);
    }

    private void modificarPnEntrada(String operacionInicial) {
        txtEntrada = new JTextArea(operacionInicial);
        txtEntrada.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            txtEntrada.setFont(PatronDisenho.SEGOE_12);
            txtEntrada.setBorder(new Border() {
                @Override
                public void paintBorder(Component cmpnt, Graphics grphcs, int i, int i1, int i2, int i3) {
                }

                @Override
                public Insets getBorderInsets(Component cmpnt) {
                    return new Insets(6, 19, 6, 19);
                }

                @Override
                public boolean isBorderOpaque() {
                    return true;
                }
            });
        } else {
            txtEntrada.setFont(PatronDisenho.SEGOE_18);
            txtEntrada.setBorder(new Border() {
                @Override
                public void paintBorder(Component cmpnt, Graphics grphcs, int i, int i1, int i2, int i3) {
                }

                @Override
                public Insets getBorderInsets(Component cmpnt) {
                    return new Insets(8, 19, 8, 19);
                }

                @Override
                public boolean isBorderOpaque() {
                    return true;
                }
            });
        }
        txtEntrada.setCaretColor(PatronDisenho.MORADO_OSCURO);
        txtEntrada.setSelectedTextColor(PatronDisenho.BLANCO);
        txtEntrada.setSelectionColor(PatronDisenho.MORADO_OSCURO);

        txtEntrada.setMargin(new java.awt.Insets(10, 10, 10, 10));

        txtEntrada.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                pnOrilla.setVisible(true);
                txtEntrada.setBackground(PatronDisenho.GRIS_FONDO_2);
                txtEntrada.paint(txtEntrada.getGraphics());
            }

            @Override
            public void focusLost(FocusEvent fe) {
                pnOrilla.setVisible(false);
                txtEntrada.setBackground(PatronDisenho.BLANCO);
                txtEntrada.paint(txtEntrada.getGraphics());
            }
        });

        agregarRestricciones();

        spEntrada = new JScrollPane(txtEntrada, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        spEntrada.setViewportView(txtEntrada);
        spEntrada.setBorder(null);

        pnEntrada.add(spEntrada);
    }

    private void agregarRestricciones() {
        txtEntrada.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                controlarEntrada();
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                controlarEntrada();
            }
        });
    }

    private void controlarEntrada() {
        String temp = txtEntrada.getText();
        try {
            if (!((temp.charAt(temp.length() - 1) > 64 && temp.charAt(temp.length() - 1) < 91) // Letras mayusculas
                    || (temp.charAt(temp.length() - 1) > 96 && temp.charAt(temp.length() - 1) < 123)// Letras miniculas
                    || (temp.charAt(temp.length() - 1) > 39 && temp.charAt(temp.length() - 1) < 42) // Parentesis
                    || (temp.charAt(temp.length() - 1) == 32))) {                                   // Espaciados

                String temp1 = txtEntrada.getText();

                String r = "";
                for (int i = 0; i < temp1.length() - 1; i++) {
                    r += temp1.charAt(i);
                }
                txtEntrada.setText(r);
            }
        } catch (Exception e) {
        }
    }

    private void agregarEventosBtn() {
        operadorBoton(btnUnion, "Uni");
        operadorBoton(btnInterseccion, "Ints");
        operadorBoton(btnComplemento, "Compl(");
        operadorBoton(btnDiferencia, "Dif");
        operadorBoton(btnDifSimetrica, "Sim");
        operadorBoton(btnParentesisIzq, "(");
        operadorBoton(btnParentesisDer, ")");
        operadorBoton(btnLimpiar, "");

    }

    private void operadorBoton(Boton boton, String texto) {
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (boton == btnLimpiar) {
                    txtEntrada.setText("");
                    txtEntrada.requestFocus();
                } else {
                    txtEntrada.insert(" " + texto + " ", txtEntrada.getCaretPosition());
                    txtEntrada.requestFocus();
                }
            }
        });
    }

    private int contarParentesis() {
        String temp = txtEntrada.getText();
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == 40) {
                contadorParentesis++;
            } else if (temp.charAt(i) == 41) {
                contadorParentesis--;
            }
        }
        System.out.println(contadorParentesis);
        int n = contadorParentesis;
        contadorParentesis = 0;
        return n;
    }

    public Boton getBtnCalcular() {
        return btnCalcular;
    }

    public int getContadorParentesis() {
        return contadorParentesis;
    }
    
    
}
