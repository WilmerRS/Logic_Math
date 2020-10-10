/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unipamplona.MDiscretas.interfaz.pnCentralesConjuntos;

import Unipamplona.MDiscretas.interfaz.PatronDisenho;
import javax.swing.JPanel;

/**
 *
 * @author WILMER
 */
public class PnElementosConjunto extends JPanel {

    public PnElementosConjunto() {
        super();
        crearPanel();
    }

    private void crearPanel() {
        this.setBackground(PatronDisenho.ROJO_CLARO);
        this.setLayout(new java.awt.BorderLayout());

    }

}
