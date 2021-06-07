/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Unipamplona.MDiscretas.interfaz.pnCentralesRelaciones;

import main.java.Unipamplona.MDiscretas.interfaz.Boton;
import static main.java.Unipamplona.MDiscretas.interfaz.InterfazMain.alto;
import static main.java.Unipamplona.MDiscretas.interfaz.InterfazMain.ancho;
import main.java.Unipamplona.MDiscretas.interfaz.PatronDisenho;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class PnMatrizEntrada extends JPanel {

    private JPanel pnFondo;
    private JPanel pnCentral;
    private JPanel pnDerecha;

    private JLabel lbTitulo;
    private JLabel lbtamanho;

    private JPanel pnBotonMatriz;
    private JPanel pnCrearMatriz;
    private JPanel pnTamanho;
    private Boton btnCrearMatriz;
    private JTextField txtTamanho;

    private Boton btnCalcular;
    private Boton btnLimpiar;

    private JPanel pnSalida;
    private JLabel lbTituloSalida;
    private JLabel lbSalida;
    private JScrollPane spSalida;

    private JScrollPane spMatriz;
    private JPanel pnMatriz;

    private String[][] matriz;

    private int tamanho = (int) (ancho * 0.003);

    public PnMatrizEntrada() {
        super();
        crearPaneles();
    }

    private void crearPaneles() {
        this.setPreferredSize(new Dimension((int) (ancho * (0.327)), (int) (alto * 0.29)));
        this.setBackground(PatronDisenho.GRIS_FONDO);
        this.setLayout(new java.awt.BorderLayout(3, 3));

        lbTitulo = new JLabel("  Analizar matriz");
        lbTitulo.setOpaque(true);
        lbTitulo.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbTitulo.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbTitulo.setFont(PatronDisenho.SEGOE_16);
        }
        lbTitulo.setBackground(PatronDisenho.BLANCO);

        pnFondo = new JPanel();
        pnFondo.setBackground(PatronDisenho.GRIS_FONDO);
        pnFondo.setLayout(new java.awt.GridLayout(1, 2, 5, 5));

        pnMatriz = new JPanel();
        pnMatriz.setBackground(PatronDisenho.GRIS_FONDO);

        crearMatrizInicial();

        spMatriz = new JScrollPane(pnMatriz,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        spMatriz.setBorder(null);
        spMatriz.setViewportView(pnMatriz);

        actualizarPanelMatriz();

        pnCrearMatriz = new JPanel(new java.awt.BorderLayout());
        pnCrearMatriz.setBackground(PatronDisenho.GRIS_FONDO);

        pnBotonMatriz = new JPanel();
        pnBotonMatriz.setBackground(PatronDisenho.GRIS_FONDO);
        pnBotonMatriz.setLayout(new java.awt.GridLayout(1, 2, 0, 0));

        pnTamanho = new JPanel();
        pnTamanho.setBackground(PatronDisenho.GRIS_FONDO);
        pnTamanho.setLayout(new java.awt.BorderLayout());

        txtTamanho = new JTextField();
        txtTamanho = modificarPnEntrada(txtTamanho);

        pnTamanho.add(txtTamanho, java.awt.BorderLayout.CENTER);
        pnTamanho.add(crearOrilla(), java.awt.BorderLayout.SOUTH);

        btnCrearMatriz = new Boton("Crear matriz", null, new Dimension(20, 20), tamanho, Boton.SUR, Boton.TEXTO,
                PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, 0);

        pnBotonMatriz.add(pnTamanho);
        pnBotonMatriz.add(btnCrearMatriz);

        lbtamanho = new JLabel("   Tamaño");
        lbtamanho.setOpaque(true);
        lbtamanho.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbtamanho.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbtamanho.setFont(PatronDisenho.SEGOE_16);
        }
        lbtamanho.setBackground(PatronDisenho.BLANCO);

        pnCrearMatriz.add(lbtamanho, java.awt.BorderLayout.NORTH);
        pnCrearMatriz.add(pnBotonMatriz, java.awt.BorderLayout.CENTER);

        btnCalcular = new Boton("Calcular", null, new Dimension(20, 20), tamanho, Boton.SUR, Boton.TEXTO,
                PatronDisenho.MORADO_CABECERA, PatronDisenho.MORADO_CLARO,
                PatronDisenho.MORADO_CABECERA_HOVER, PatronDisenho.MORADO_CABECERA_CLICK, PatronDisenho.BLANCO, 0);

        btnLimpiar = new Boton("Limpiar", null, new Dimension(20, 20), tamanho, Boton.SUR, Boton.TEXTO,
                PatronDisenho.BLANCO, PatronDisenho.ROJO_OSCURO, PatronDisenho.GRIS_HOVER,
                PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, 0);

        lbTituloSalida = new JLabel("  Salida");
        lbTituloSalida.setOpaque(true);
        lbTituloSalida.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbTituloSalida.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbTituloSalida.setFont(PatronDisenho.SEGOE_16);
        }
        lbTituloSalida.setBackground(PatronDisenho.BLANCO);

        lbSalida = new JLabel("     Reflexiva");
        lbSalida.setOpaque(true);
        lbSalida.setForeground(PatronDisenho.MORADO_OSCURO);
        if (ancho < 1500) {
            lbSalida.setFont(PatronDisenho.SEGOE_12);
        } else {
            lbSalida.setFont(PatronDisenho.SEGOE_16);
        }
        lbSalida.setBackground(PatronDisenho.BLANCO);

        spSalida = new JScrollPane(lbSalida,
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        spSalida.setBorder(null);
        spSalida.setViewportView(lbSalida);

        pnSalida = new JPanel(new java.awt.BorderLayout());
        pnSalida.add(lbTituloSalida, java.awt.BorderLayout.NORTH);
        pnSalida.add(spSalida, java.awt.BorderLayout.CENTER);

        pnDerecha = new JPanel(new java.awt.GridLayout(0, 1, 5, 5));
        pnDerecha.setBackground(PatronDisenho.GRIS_FONDO_2);

        pnDerecha.add(pnCrearMatriz);
        pnDerecha.add(btnCalcular);
        pnDerecha.add(btnLimpiar);
        pnDerecha.add(pnSalida);

        pnFondo.add(pnDerecha, java.awt.BorderLayout.WEST);
        pnFondo.add(spMatriz, java.awt.BorderLayout.CENTER);

        this.add(lbTitulo, java.awt.BorderLayout.NORTH);
        this.add(pnFondo, java.awt.BorderLayout.CENTER);
    }

    private String[][] crearMatrizInicial() {
        String[][] temp
                = {{" ", "A", "B", "C", "D", "E"},
                {"A", "1", "0", "0", "0", "0"},
                {"B", "0", "1", "0", "0", "0"},
                {"C", "0", "0", "1", "0", "0"},
                {"D", "0", "0", "0", "1", "0"},
                {"E", "0", "0", "0", "0", "1"}};

        matriz = temp;
        return matriz;
    }

    public void modificarMatriz(int i, int j){
        if(matriz[i][j].equals("0")){
            matriz[i][j] = "1";
        }else{
            matriz[i][j] = "0";
        }
        actualizarPanelMatriz();
    }
    
    public boolean matrizVacia(){
        int cont = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if(matriz[i][j].equals("1")){
                    cont++;
                }
            }
        }
        return cont == 0;
    }
    
    private void actualizarPanelMatriz() {
        pnMatriz.removeAll();
        pnMatriz.setLayout(new java.awt.GridLayout(matriz.length, matriz[0].length, 3, 3));
        int contador = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                boolean p = i == 0;
                boolean q = j == 0;
                Boton temp = null;
                if (p || q) {
                    temp = new Boton(matriz[i][j], null, new Dimension(20, 20), tamanho, Boton.SUR, Boton.TEXTO,
                            PatronDisenho.MORADO_CABECERA, PatronDisenho.MORADO_CLARO,
                            PatronDisenho.MORADO_CABECERA_HOVER, PatronDisenho.MORADO_CABECERA_CLICK, PatronDisenho.BLANCO, 0);
                    temp.setEnabled(false);
                } else {
                    switch (matriz[i][j]) {
                        case "0":
                            temp = new Boton("0", null, new Dimension(20, 20), tamanho, Boton.SUR, Boton.TEXTO,
                                    PatronDisenho.BLANCO, PatronDisenho.GRIS_RESALTADOR, PatronDisenho.GRIS_HOVER,
                                    PatronDisenho.GRIS_CLICK, PatronDisenho.GRIS_RESALTADOR, contador);
                            break;
                        case "1":
                            temp = new Boton("1", null, new Dimension(20, 20), tamanho, Boton.SUR, Boton.TEXTO,
                                    PatronDisenho.VERDE_CLARO, PatronDisenho.VERDE_RESALTADOR, PatronDisenho.VERDE_HOVER,
                                    PatronDisenho.VERDE_CLICK, PatronDisenho.VERDE_OSCURO, contador);
                            break;
                        case "-1":
                            temp = new Boton("1", null, new Dimension(20, 20), tamanho, Boton.SUR, Boton.TEXTO,
                                    PatronDisenho.ROJO_CLARO, PatronDisenho.ROJO_CLICK, PatronDisenho.ROJO_CLARO_HOVER,
                                    PatronDisenho.ROJO_CLARO_CLICK, PatronDisenho.ROJO_OSCURO, contador);
                            break;
                    }
                }
                contador++;
                pnMatriz.add(temp);
            }
        }
        pnMatriz.update(pnMatriz.getGraphics());
    }

    private JTextField modificarPnEntrada(JTextField campo) {

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
                campo.setBackground(PatronDisenho.GRIS_FONDO);
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
        return campo;
    }

    public String[][] crearMatriz(int tamanho) {
        String[][] temp = new String[tamanho + 1][tamanho + 1];
        char filas = 65;
        char columnas = 65;

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                if (i == 0 && j == 0) {
                    temp[i][j] = " ";
                } else if (i == 0) {
                    temp[i][j] = Character.toString(columnas);
                    columnas += 1;
                } else if (j == 0) {
                    temp[i][j] = Character.toString(filas);
                    filas += 1;
                } else {
                    temp[i][j] = "0";
                }
            }
        }
        matriz = temp;
        actualizarPanelMatriz();
        return temp;
    }

    private JPanel crearOrilla() {
        JPanel pnOrilla = new JPanel();
        pnOrilla.setVisible(true);
        pnOrilla.setPreferredSize(new java.awt.Dimension((int) (ancho * 0.002), (int) (ancho * 0.002)));
        pnOrilla.setBackground(PatronDisenho.GRIS_FONDO_3);
        return pnOrilla;
    }

    public JPanel getPnMatriz() {
        return pnMatriz;
    }

    public void setPnMatriz(JPanel pnMatriz) {
        this.pnMatriz = pnMatriz;
    }

    public String[][] getMatriz() {
        return matriz;
    }

    public void restablecerMatriz(){
        matriz = crearMatrizInicial();
        actualizarPanelMatriz();
    }
    
    public void setMatriz(String[][] matriz) {
        this.matriz = matriz;
    }

    public Boton getBtnCrearMatriz() {
        return btnCrearMatriz;
    }

    public Boton getBtnCalcular() {
        return btnCalcular;
    }

    public Boton getBtnLimpiar() {
        return btnLimpiar;
    }

    public JTextField getTxtTamanho() {
        return txtTamanho;
    }

    public JLabel getLbSalida() {
        return lbSalida;
    }

    
}
