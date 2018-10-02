package pages;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenLocation;
import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Key;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.api.robot.desktop.DesktopMouse;

/**
 * 
 * @author Oswaldo Buitrago SQA S.A - fabio.betancourt@sqasa.com
 */

public class ActionGui {

    /**
     * Definicion de variables
     */
    static ScreenRegion sr;
    static ScreenLocation sl;
    static Target tr;
    static Mouse mouse;

    static Robot robot;
    static StringSelection seleccion;
    static Clipboard clipboard;
    static Transferable transferable;
    static DataFlavor dataflavor;

    // STATIC MODIFICT
    static Keyboard kb;
    // String ruta = "C:\\Users\\Johan Mora\\workspace\\Sikuli\\Imagenes\\";

    public File Obj_Archivo;
    public File Obj_Carpeta;
    public String Str_Nombre_Archivo = "ScreenShot_";
    public String Str_Fecha = "";
    public String Str_Ruta = "";
    public String Str_Error = "";
    public String Str_Ruta_ScreenShot = "";
    public SimpleDateFormat Dt_Fecha;

    String[][] arrayChar;

    public ActionGui() {
        try {
            robot = new Robot();
        } catch (Exception ex) {
            Logger.getLogger(ActionGui.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void pegarGui(String texto) throws Exception {
        Keyboard kb = new DesktopKeyboard();
        kb.paste(texto);
    }

    public void escribirGui(String texto) throws Exception {
        Keyboard kb = new DesktopKeyboard();
        kb.type(texto);
    }

    public void escribirRobot(CharSequence characters) {
        int length = characters.length();
        for (int i = 0; i < length; i++) {
            char character = characters.charAt(i);
            imprimirRobot(character);
        }
    }

    public void enter() {
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void escape() {
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    public void tab() {
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
    }

    public void backSpace() {
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
    }

    public void home() {
        robot.keyPress(KeyEvent.VK_HOME);
        robot.keyRelease(KeyEvent.VK_HOME);
    }

    public void end() {
        robot.keyPress(KeyEvent.VK_END);
        robot.keyRelease(KeyEvent.VK_END);
    }

    public void AvPag() {
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
    }

    public void RePag() {
        robot.keyPress(KeyEvent.VK_PAGE_UP);
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
    }

    public void delete() {
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
    }

    public void copy() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public void cut() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_X);
        robot.keyRelease(KeyEvent.VK_X);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public void paste() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public void selectAllA() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public void selectAllE() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }
    public void fechaArriba() {
        robot.keyPress(KeyEvent.VK_UP);
        robot.keyPress(KeyEvent.VK_UP);
    }
    public void findF() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_F);
        robot.keyRelease(KeyEvent.VK_F);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public void findB() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_B);
        robot.keyRelease(KeyEvent.VK_B);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public void next() {
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_RIGHT);
        robot.keyRelease(KeyEvent.VK_RIGHT);
        robot.keyRelease(KeyEvent.VK_ALT);
    }

    public void back() {
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_LEFT);
        robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyRelease(KeyEvent.VK_ALT);
    }

    public void closeTab() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public void closeAll() {
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_ALT);
    }

    public void imprimirFuncion(int function) {
        switch (function) {
            case 1:
                doChar(KeyEvent.VK_F1);
                break;
            case 2:
                doChar(KeyEvent.VK_F2);
                break;
            case 3:
                doChar(KeyEvent.VK_F3);
                break;
            case 4:
                doChar(KeyEvent.VK_F4);
                break;
            case 5:
                doChar(KeyEvent.VK_F5);
                break;
            case 6:
                doChar(KeyEvent.VK_F6);
                break;
            case 7:
                doChar(KeyEvent.VK_F7);
                break;
            case 8:
                doChar(KeyEvent.VK_F8);
                break;
            case 9:
                doChar(KeyEvent.VK_F9);
                break;
            case 10:
                doChar(KeyEvent.VK_F10);
                break;
            case 11:
                doChar(KeyEvent.VK_F11);
                break;
            case 12:
                doChar(KeyEvent.VK_F12);
                break;
            case 13:
                doChar(KeyEvent.VK_F13);
                break;
            case 14:
                doChar(KeyEvent.VK_F14);
                break;
            case 15:
                doChar(KeyEvent.VK_F15);
                break;
            case 16:
                doChar(KeyEvent.VK_F16);
                break;
            case 17:
                doChar(KeyEvent.VK_F17);
                break;
            case 18:
                doChar(KeyEvent.VK_F18);
                break;
            case 19:
                doChar(KeyEvent.VK_F19);
                break;
            case 20:
                doChar(KeyEvent.VK_F20);
                break;
            case 21:
                doChar(KeyEvent.VK_F21);
                break;
            case 22:
                doChar(KeyEvent.VK_F22);
                break;
            case 23:
                doChar(KeyEvent.VK_F23);
                break;
            case 24:
                doChar(KeyEvent.VK_F24);
                break;
        }
    }

    public void imprimirRobot(char character) {
        switch (character) {
            case 'a':
                doChar(KeyEvent.VK_A);
                break;
            case 'b':
                doChar(KeyEvent.VK_B);
                break;
            case 'c':
                doChar(KeyEvent.VK_C);
                break;
            case 'd':
                doChar(KeyEvent.VK_D);
                break;
            case 'e':
                doChar(KeyEvent.VK_E);
                break;
            case 'f':
                doChar(KeyEvent.VK_F);
                break;
            case 'g':
                doChar(KeyEvent.VK_G);
                break;
            case 'h':
                doChar(KeyEvent.VK_H);
                break;
            case 'i':
                doChar(KeyEvent.VK_I);
                break;
            case 'j':
                doChar(KeyEvent.VK_J);
                break;
            case 'k':
                doChar(KeyEvent.VK_K);
                break;
            case 'l':
                doChar(KeyEvent.VK_L);
                break;
            case 'm':
                doChar(KeyEvent.VK_M);
                break;
            case 'n':
                doChar(KeyEvent.VK_N);
                break;
            case 'o':
                doChar(KeyEvent.VK_O);
                break;
            case 'p':
                doChar(KeyEvent.VK_P);
                break;
            case 'q':
                doChar(KeyEvent.VK_Q);
                break;
            case 'r':
                doChar(KeyEvent.VK_R);
                break;
            case 's':
                doChar(KeyEvent.VK_S);
                break;
            case 't':
                doChar(KeyEvent.VK_T);
                break;
            case 'u':
                doChar(KeyEvent.VK_U);
                break;
            case 'v':
                doChar(KeyEvent.VK_V);
                break;
            case 'w':
                doChar(KeyEvent.VK_W);
                break;
            case 'x':
                doChar(KeyEvent.VK_X);
                break;
            case 'y':
                doChar(KeyEvent.VK_Y);
                break;
            case 'z':
                doChar(KeyEvent.VK_Z);
                break;
//            case 'Ã¡':
//                doChar(KeyEvent.VK_DEAD_ACUTE, KeyEvent.VK_A);
//                break;
//            case 'Ã©':
//                doChar(KeyEvent.VK_DEAD_ACUTE, KeyEvent.VK_E);
//                break;
//            case 'Ã­':
//                doChar(KeyEvent.VK_DEAD_ACUTE, KeyEvent.VK_I);
//                break;
//            case 'Ã³':
//                doChar(KeyEvent.VK_DEAD_ACUTE, KeyEvent.VK_O);
//                break;
//            case 'Ãº':
//                doChar(KeyEvent.VK_DEAD_ACUTE, KeyEvent.VK_U);
//                break;
//            case 'Ã¼':
//                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_DEAD_ACUTE);
//                doChar(KeyEvent.VK_U);
//                break;
            case 'A':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_A);
                break;
            case 'B':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
                break;
            case 'C':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_C);
                break;
            case 'D':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_D);
                break;
            case 'E':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_E);
                break;
            case 'F':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_F);
                break;
            case 'G':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_G);
                break;
            case 'H':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_H);
                break;
            case 'I':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_I);
                break;
            case 'J':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_J);
                break;
            case 'K':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_K);
                break;
            case 'L':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_L);
                break;
            case 'M':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_M);
                break;
            case 'N':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_N);
                break;
            case 'O':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_O);
                break;
            case 'P':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_P);
                break;
            case 'Q':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_Q);
                break;
            case 'R':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_R);
                break;
            case 'S':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_S);
                break;
            case 'T':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_T);
                break;
            case 'U':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_U);
                break;
            case 'V':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_V);
                break;
            case 'W':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_W);
                break;
            case 'X':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_X);
                break;
            case 'Y':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_Y);
                break;
            case 'Z':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_Z);
                break;
            case '`':
                doChar(KeyEvent.VK_BACK_QUOTE);
                break;
            case '0':
                doChar(KeyEvent.VK_0);
                break;
            case '1':
                doChar(KeyEvent.VK_1);
                break;
            case '2':
                doChar(KeyEvent.VK_2);
                break;
            case '3':
                doChar(KeyEvent.VK_3);
                break;
            case '4':
                doChar(KeyEvent.VK_4);
                break;
            case '5':
                doChar(KeyEvent.VK_5);
                break;
            case '6':
                doChar(KeyEvent.VK_6);
                break;
            case '7':
                doChar(KeyEvent.VK_7);
                break;
            case '8':
                doChar(KeyEvent.VK_8);
                break;
            case '9':
                doChar(KeyEvent.VK_9);
                break;
            case '!':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_1);
                break;
            case '"':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_2);
                break;
            case '#':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_3);
                break;
            case '$':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_4);
                break;
            case '%':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_5);
                break;
            case '&':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_6);
                break;
            case '/':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_7);
                break;
            case '(':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_8);
                break;
            case ')':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_9);
                break;
            case '=':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_0);
                break;
            case '+':
                doChar(KeyEvent.VK_PLUS);
                break;
            case '*':
                doChar(KeyEvent.VK_MULTIPLY);
                break;
            case '-':
                doChar(45);
                break;
            case '_':
                doChar(KeyEvent.VK_SHIFT, 45);
                break;
            case ',':
                doChar(KeyEvent.VK_COMMA);
                break;
            case ';':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_COMMA);
                break;
            case '.':
                doChar(KeyEvent.VK_PERIOD);
                break;
            case ':':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_PERIOD);
                break;
            case '<':
                doChar(KeyEvent.VK_LESS);
                break;
            case '>':
                doChar(KeyEvent.VK_SHIFT, KeyEvent.VK_LESS);
                break;
            case ' ':
                doChar(KeyEvent.VK_SPACE);
                break;
            case '@':
                doChar(KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_Q);
                break;
            case '\t':
                doChar(KeyEvent.VK_TAB);
                break;
            case '\n':
                doChar(KeyEvent.VK_ENTER);
                break;
            case '~':
                doChar(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD6);
                break;
            case '|':
                doChar(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD4);
                break;
            case '\\':
                doChar(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD9, KeyEvent.VK_NUMPAD2);
                break;
            case '\'':
                doChar(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD3, KeyEvent.VK_NUMPAD9);
                break;
            case '{':
                doChar(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD3);
                break;
            case '}':
                doChar(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD5);
                break;
            case '[':
                doChar(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD1);
                break;
            case ']':
                doChar(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD9, KeyEvent.VK_NUMPAD3);
                break;
            case '^':
                doChar(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD9, KeyEvent.VK_NUMPAD4);
                break;
            case '?':
                doChar(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD6, KeyEvent.VK_NUMPAD3);
                break;
            default:
                throw new IllegalArgumentException("Cannot type character " + character);
        }
    }

    private void doChar(int keyCode) {
        try {
            Robot robot = new Robot();
            robot.keyPress(keyCode);
            Thread.sleep(20);
            robot.keyRelease(keyCode);
            Thread.sleep(20);
        } catch (Exception e) {
            System.out.println("Invalid key code(s) for above character");
        }
    }

    private void doChar(int keyCode1, int keyCode2) {
        try {
            Robot robot = new Robot();
            robot.keyPress(keyCode1);
            Thread.sleep(20);
            robot.keyPress(keyCode2);
            Thread.sleep(20);
            robot.keyRelease(keyCode2);
            Thread.sleep(20);
            robot.keyRelease(keyCode1);
            Thread.sleep(20);
        } catch (Exception e) {
            System.out.println("Invalid key code(s) for above character");
        }
    }

    private void doChar(int keyCode1, int keyCode2, int keyCode3) {
        try {
            Robot robot = new Robot();
            robot.keyPress(keyCode1);
            Thread.sleep(20);
            robot.keyPress(keyCode2);
            Thread.sleep(20);
            robot.keyPress(keyCode3);
            Thread.sleep(20);
            robot.keyRelease(keyCode3);
            Thread.sleep(20);
            robot.keyRelease(keyCode2);
            Thread.sleep(20);
            robot.keyRelease(keyCode1);
            Thread.sleep(20);
        } catch (Exception e) {
            System.out.println("Invalid key code(s) for above character");
        }
    }

    private void doChar(int keyCode1, int keyCode2, int keyCode3, int keyCode4) {
        try {
            Robot robot = new Robot();
            robot.keyPress(keyCode1);
            Thread.sleep(20);
            robot.keyPress(keyCode2);
            Thread.sleep(20);
            robot.keyPress(keyCode3);
            Thread.sleep(20);
            robot.keyPress(keyCode4);
            Thread.sleep(20);
            robot.keyRelease(keyCode4);
            Thread.sleep(20);
            robot.keyRelease(keyCode3);
            Thread.sleep(20);
            robot.keyRelease(keyCode2);
            Thread.sleep(20);
            robot.keyRelease(keyCode1);
            Thread.sleep(20);
        } catch (Exception e) {
            System.out.println("Invalid key code(s) for above character");
        }
    }

    /**
     * Metodo para realizar la funcionalidad del click
     *
     * @param direccion en este parametro ira la direccion donde va a guardar
     * las imagnes
     * @param nombreImagen en este para metro ira el nombre de la imagen con su
     * extencion pertinente
     */
    public void click(String direccion, String nombreImagen) throws Exception {
        // el for lo que realiza es que busque varias veces la imagen
        for (int i = 0; i < 5; i++) {
            // Bloque try para capturar psoible error
            sr = new DesktopScreenRegion();
            tr = new ImageTarget(new File(direccion + nombreImagen));
            // tr = new ImageTarget(new File(ruta + "File.png"));
            sr.wait(tr, 5000);
            sr = sr.find(tr);
            mouse = new DesktopMouse();
            mouse.click(sr.getCenter());
            break;
        }
    }

    public void clickEspera(String direccion, String nombreImagen) throws Exception {
        // el for lo que realiza es que busque varias veces la imagen
        try {

            for (int i = 0; i < 20; i++) {
                // Bloque try para capturar psoible error
                sr = new DesktopScreenRegion();
                tr = new ImageTarget(new File(direccion + nombreImagen));
                // tr = new ImageTarget(new File(ruta + "File.png"));
                sr.wait(tr, 5000);
                sr = sr.find(tr);
                if (sr.equals("") || sr == null) {
                    System.out.println("Continua");
                    i = 20;
                } else {
                    System.out.println("Cargando...");
                    mouse = new DesktopMouse();
                    mouse.click(sr.getCenter());
                    Thread.sleep(5000);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("s");
        }
    }

    /**
     * Metodo para realizar la funcion de un doble click
     *
     * @param direccion en este parametro ira la direccion donde va a guardar
     * las imagnes
     * @param nombreImagen en este para metro ira el nombre de la imagen con su
     * extencion pertinente
     */
    public void doubleClick(String direccion, String nombreImagen) throws Exception {
        for (int i = 0; i < 5; i++) {
            sr = new DesktopScreenRegion();
            tr = new ImageTarget(new File(direccion + nombreImagen));
            // tr = new ImageTarget(new File(ruta + "dobleClick.png"));
            sr.wait(tr, 5000);
            sr = sr.find(tr);
            mouse = new DesktopMouse();
            mouse.doubleClick(sr.getCenter());
            break;
        }
    }

    /**
     * Metodo para encontrar una imagen pero sin realizar ninguna otra accion
     *
     * @param direccion en este parametro ira la direccion donde va a guardar
     * las imagnes
     * @param nombreImagen en este para metro ira el nombre de la imagen con su
     * extencion pertinente
     * @return
     */
    public boolean find(String direccion, String nombreImagen) throws Exception {
        boolean estado = false;
        for (int i = 0; i < 5; i++) {
            sr = new DesktopScreenRegion();

            tr = new ImageTarget(new File(direccion + nombreImagen));
            // tr = new ImageTarget(new File(ruta + "Encontrar.png"));
            sr.wait(tr, 5000);
            sr = sr.find(tr);
            mouse = new DesktopMouse();
            mouse.move(sr.getCenter());
            System.out.println("imagen encontrada");
            estado = true;
            break;

        }
        return estado;
    }

    /**
     * Metodo que permite realizar un click referente a una imagen como pocision
     * inicial y despues se desplazara de esa pocision con las coordenadas
     * enviadas
     *
     * @param direccion en este parametro ira la direccion donde va a guardar
     * las imagnes
     * @param nombreImagen en este para metro ira el nombre de la imagen con su
     * extencion pertinente
     * @param x cantidad que desea desplazar el mouse en la posicion x
     * @param y cantidad que desea desplazar el mouse en la posicion y
     */
    public void clickEspecial(String direccion, String nombreImagen, int x, int y) throws Exception {
        for (int i = 0; i < 10; i++) {
            sr = new DesktopScreenRegion();
            tr = new ImageTarget(new File(direccion + nombreImagen));
            // tr = new ImageTarget(new File(ruta + "MoverMouse.png"));
            sr.wait(tr, 5000);
            sr = sr.find(tr);
            mouse = new DesktopMouse();
            mouse.click(sr.getCenter().getRelativeScreenLocation(x, y));
            break;
        }
    }

    /**
     * Metodo que permite realizar un dobleclick referente a una imagen como
     * pocision inicial y despues se desplazara de esa pocision con las
     * coordenadas enviadas
     *
     * @param direccion en este parametro ira la direccion donde va a guardar
     * las imagnes
     * @param nombreImagen en este para metro ira el nombre de la imagen con su
     * extencion pertinente
     * @param x cantidad que desea desplazar el mouse en la posicion x
     * @param y cantidad que desea desplazar el mouse en la posicion y
     */
    public void doubleClickEspecial(String direccion, String nombreImagen, int x, int y) throws Exception {
        for (int i = 0; i < 10; i++) {
            sr = new DesktopScreenRegion();
            tr = new ImageTarget(new File(direccion + nombreImagen));
            // tr = new ImageTarget(new File(ruta + "clickEspecial2.png"));
            sr.wait(tr, 5000);
            sr = sr.find(tr);
            mouse = new DesktopMouse();
            mouse.doubleClick(sr.getCenter().getRelativeScreenLocation(x, y));
            break;
        }

    }

    /**
     * Metodo que permite dar un click pero con el robot ya que con Sikuli
     * algunas veces toca referenciarlo asi para que funcione
     *
     * @param direccion en este parametro ira la direccion donde va a guardar
     * las imagnes
     * @param nombreImagen en este para metro ira el nombre de la imagen con su
     * extencion pertinente
     */
    public void clickWithRobot(String direccion, String nombreImagen) throws Exception {

        for (int i = 0; i < 10; i++) {
            robot = new Robot();
            sr = new DesktopScreenRegion();
            tr = new ImageTarget(new File(direccion + nombreImagen));
            // tr = new ImageTarget(new File(ruta + "clickConRobot.png"));
            sr.wait(tr, 5000);
            sr = sr.find(tr);
            robot.mouseMove(sr.getCenter().getX(), sr.getCenter().getY());
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            break;
        }
    }

    /**
     * Metodo que permite colocar en un campo tipo input lo que desea escribir
     *
     * @param valor en este parametro debe ir lo que quiere escribir
     */
    public void spell(String valor) throws Exception {
        for (int i = 0; i < 5; i++) {
            Keyboard kb = new DesktopKeyboard();
            kb.paste(validateNull(valor));
            // }
            break;
        }

    }

    /**
     * Metodo que permite validar que el elemento envido tenga algun valor
     *
     * @param valor en este parametro debe enviar un String para validar que si
     * hay algo en esa variable y no un null
     * @return
     */
    public String validateNull(String valor) throws Exception {
        String answer = "";
        if (valor == null) {
            return "Error";
        } else {
            answer = valor.toString();
        }
        return answer;
    }

    /**
     * Metodo que permite escribir con el robot de Sikuli para diligenciar algun
     * campo
     *
     * @param valor n este parametro debe ir lo que quiere escribir
     */
    public void spellRobot(String valor) throws Exception {
        for (int i = 0; i < 5; i++) {
            robot = new Robot();
            seleccion = new StringSelection(validateNull(valor));
            clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(seleccion, null);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(86);
            robot.keyRelease(17);
            robot.keyRelease(86);

            break;
        }

    }

    /**
     * Metodo para escribir vocales con sus respectivas tildes
     *
     * @param valor cadena inicial
     * @param antiguo caracter que se desea reemplazar
     * @param nuevo caracter a introducir en la cadena
     */
    public void spellRobotEspecial(String valor, String antiguo, String nuevo) throws Exception {
        robot = new Robot();
        Keyboard kb = new DesktopKeyboard();
        int tam = validateNull(valor).replaceAll(antiguo, nuevo).length();
        if (tam > 0) {
            String[] array = valor.toString().replaceAll(antiguo, nuevo).split("");
            for (int i = 0; i < tam; i++) {
                switch (array[i]) {
                    case "prueba1":
                        robot.keyPress(KeyEvent.VK_DEAD_ACUTE);
                        robot.keyPress(KeyEvent.VK_A);

                        robot.keyRelease(KeyEvent.VK_A);
                        robot.keyRelease(KeyEvent.VK_DEAD_ACUTE);
                        break;
                    case "prueba2":
                        robot.keyPress(KeyEvent.VK_DEAD_ACUTE);
                        robot.keyPress(KeyEvent.VK_E);

                        robot.keyRelease(KeyEvent.VK_E);
                        robot.keyRelease(KeyEvent.VK_DEAD_ACUTE);
                        break;
                    case "prueba3":

                        robot.keyPress(KeyEvent.VK_DEAD_ACUTE);
                        robot.keyPress(KeyEvent.VK_I);

                        robot.keyRelease(KeyEvent.VK_I);
                        robot.keyRelease(KeyEvent.VK_DEAD_ACUTE);
                        break;
                    case "prueba4":

                        robot.keyPress(KeyEvent.VK_DEAD_ACUTE);
                        robot.keyPress(KeyEvent.VK_O);

                        robot.keyRelease(KeyEvent.VK_O);
                        robot.keyRelease(KeyEvent.VK_DEAD_ACUTE);
                        break;
                    case "prueba5":
                        robot.keyPress(KeyEvent.VK_DEAD_ACUTE);
                        robot.keyPress(KeyEvent.VK_U);

                        robot.keyRelease(KeyEvent.VK_U);
                        robot.keyRelease(KeyEvent.VK_DEAD_ACUTE);
                        break;
                    default:
                        kb.type(array[i]);
                }
                // esperarSegundos(1);
            }
        }
    }

    /**
     * Metodo que va a inserta en un campo un valor copiado anteriormente
     *
     * @param valor
     */
    public void paste(String valor) throws Exception {
        Keyboard kb = new DesktopKeyboard();
        kb.paste(validateNull(valor));
    }

    /**
     * Metodo que funciona para esperar para que cargue mejor el codigo
     *
     * @param segundos cantidad de tiempo en segundos que desea esperar
     */
    public void waitSeconds(int segundos) throws Exception {
        Thread.sleep(segundos * 1000);
    }

    /**
     * Metodo que se utiliza para borrar una cantidad de caracteres que haya en
     * un campo
     *
     * @param Pulsar entero que se utiliza para borrar una cantidad de
     * caracteres
     */
    public void cleanSikuli(int Pulsar) throws Exception {
        Keyboard kb = new DesktopKeyboard();

        for (int i = 1; i <= Pulsar; i++) {
            kb.type(Key.BACKSPACE);
        }
    }

    /**
     * Metodo para realzar una copia a una cantidad de caracteres seleccionados
     *
     * @return devuevle una cadena de texto seleccionada
     */
    public String copiAllRobot() throws Exception {
        String texto = "";
        robot = new Robot();
        /*
			 * robot.keyPress(KeyEvent.VK_SHIFT);
			 * robot.keyPress(KeyEvent.VK_END);
			 * robot.keyRelease(KeyEvent.VK_END);
			 * robot.keyRelease(KeyEvent.VK_SHIFT);
         */
        waitSeconds(1);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        waitSeconds(2);
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        transferable = clipboard.getContents(this);
        dataflavor = new DataFlavor("application/x-java-serialized-object; class=java.lang.String");
        if (transferable.isDataFlavorSupported(dataflavor)) {
            texto = (String) transferable.getTransferData(dataflavor);
        }
        return texto;
    }

    /**
     * Metodo que permite realizar la funcion de un click derecho
     *
     * @param direccion en este parametro ira la direccion donde va a guardar
     * las imagnes
     * @param nombreImagen en este para metro ira el nombre de la imagen con su
     * extencion pertinente
     */
    public void clickRight(String direccion, String nombreImagen) throws Exception {
        // el for lo que realiza es que busque varias veces la imagen
        for (int i = 0; i < 5; i++) {
            // Bloque try para capturar psoible error

            sr = new DesktopScreenRegion();
            tr = new ImageTarget(new File(direccion + nombreImagen));
            // tr = new ImageTarget(new File(ruta + "File.png"));
            sr.wait(tr, 5000);
            sr = sr.find(tr);
            mouse = new DesktopMouse();
            mouse.rightClick(sr.getCenter());
            break;
        }

    }

    /**
     * Metodo que captura una imagen y la guarda en una carpeta correspondiente
     */
    public void captureImage() throws Exception {

        Dt_Fecha = new SimpleDateFormat("dd-M-yyyy");
        Str_Ruta += Dt_Fecha.format(new Date()) + "\\";
        Str_Ruta = Str_Ruta.replaceAll("-", "_");
        Obj_Carpeta = new File(Str_Ruta);
        if (!Obj_Carpeta.isDirectory()) {
            Obj_Carpeta.mkdirs();
        }
        Dt_Fecha = new SimpleDateFormat("dd-M-yyyy hh:mm:ss mmm");
        Str_Nombre_Archivo += Dt_Fecha.format(new Date());
        Str_Nombre_Archivo = Str_Nombre_Archivo.replaceAll(":", "_");
        Str_Nombre_Archivo = Str_Nombre_Archivo.replaceAll("-", "_");
        Dimension Obj_Dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle Obj_Rectangulo = new Rectangle(Obj_Dimension);
        Robot Obj_Robot = new Robot();
        BufferedImage Obj_Imagen = Obj_Robot.createScreenCapture(Obj_Rectangulo);
        ImageIO.write(Obj_Imagen, "jpg", new File(Str_Ruta + Str_Nombre_Archivo + "GUI.jpg"));
        Str_Ruta_ScreenShot = Str_Ruta + Str_Nombre_Archivo + "GUI.jpg";
    }
}
