/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unipamplona.MDiscretas.interfaz;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author WILMER
 */
public class PnCentralRelaciones extends JPanel {

    private JTextField v;

    public PnCentralRelaciones() {
        super();
        crearPanel();
    }

    private void crearPanel() {
        this.setBackground(PatronDisenho.GRIS_FONDO);
        this.setLayout(new java.awt.BorderLayout(0, 0));

        JPanel a = new JPanel();
        a.setLayout(new java.awt.BorderLayout(0, 0));
        a.setBackground(Color.yellow);

        v = new JTextField();
        v.setBackground(Color.red);
        a.add(v);

        this.add(a);
    }

    public JTextField getV() {
        return v;
    }

    public void setV(JTextField v) {
        this.v = v;
    }
}
