package Unipamplona.MDiscretas.interfaz;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

/**
 *
 * @author WILMER
 */
public class PatronDisenho {

    /**
     * Colores de la aplicacion
     */
    public static final Color MORADO_OSCURO = new Color(51, 52, 74);
    public static final Color MORADO_CLARO = new Color(174, 175, 206);
    public static final Color MORADO_HOVER = new Color(60, 66, 96);
    public static final Color MORADO_CLICK = new Color(67, 72, 104);

    public static final Color MORADO_CABECERA = new Color(70, 71, 113);
    public static final Color MORADO_CABECERA_HOVER = new Color(79, 85, 130);
    public static final Color MORADO_CABECERA_CLICK = new Color(90, 95, 145);

    public static final Color GRIS_RESALTADOR = new Color(69, 68, 72);
    public static final Color GRIS_FONDO = new Color(220, 220, 220);
    public static final Color GRIS_FONDO_2 = new Color(238, 238, 238);
    public static final Color GRIS_FONDO_3 = new Color(200, 200, 200);
    public static final Color GRIS_HOVER = new Color(242, 242, 242);
    public static final Color GRIS_CLICK = new Color(215, 215, 215);

    public static final Color BLANCO = new Color(255, 255, 255);

    public static final Color ROJO_OSCURO = new Color(127, 38, 40);
    public static final Color ROJO_HOVER = new Color(137, 48, 50);
    public static final Color ROJO_CLICK = new Color(150, 67, 69);
    public static final Color ROJO_CLARO = new Color(201, 137, 139);
    public static final Color ROJO_CLARO_HOVER = new Color(190, 126, 128);
    public static final Color ROJO_CLARO_CLICK = new Color(175, 110, 113);

    public static final Color VERDE_OSCURO = new Color(40, 127, 38);
    public static final Color VERDE_CLARO = new Color(139, 201, 137);
    public static final Color VERDE_HOVER = new Color(128, 190, 126);
    public static final Color VERDE_CLICK = new Color(113, 175, 110);
    public static final Color VERDE_RESALTADOR = new Color(67, 150, 69);

    /**
     * Fuentes de la aplicacion
     */
    public static final Font SEGOE_12 = new Font("Segoe UI Semibold", 0, 12);
    public static final Font SEGOE_14 = new Font("Segoe UI Semibold", 0, 14);
    public static final Font SEGOE_16 = new Font("Segoe UI Semibold", 0, 16);
    public static final Font SEGOE_18 = new Font("Segoe UI Semibold", 0, 18);

    public PatronDisenho() {
    }

    public static Color getColorAleatorio() {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return new Color(red, green, blue);
    }
}
