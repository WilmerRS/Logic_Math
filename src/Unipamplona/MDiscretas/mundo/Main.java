
package Unipamplona.MDiscretas.mundo;

import Unipamplona.MDiscretas.interfaz.InterfazMain;

/**
 *
 * @author WILMER
 */
public class Main {
    
    private static Conjuntos conjuntos;
    
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /*
        * Ejecuta la ventana principal de la aplicacion
        */
        java.awt.EventQueue.invokeLater(() -> {
            new InterfazMain().setVisible(true);
        });
    }

    public static Conjuntos getTodo() {
        return conjuntos;
    }

    public static void setConjuntos(Conjuntos conjuntos) {
        conjuntos = conjuntos;
    }
    
}
