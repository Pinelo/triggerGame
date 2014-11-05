/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.JFrame;

/**
 *
 * @author Casa
 */
public class Trigger extends JFrame implements Runnable, KeyListener
        , MouseListener {
    
    private Graphics graGraficaApplet;  // Objeto grafico de la Imagen
    private Image    imaImagenApplet;   // Imagen a proyectar en Applet	
    
    public void init(){
        this.setSize(800,600);
        
        // Movimiento del personaje principal hacia el frete
        Image imaMovF1 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina Frente1.png"));
        Image imaMovF2 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina Frente2.png"));
        Image imaMovF3 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina Frente3.png"));    
        
        Image imaMovA1 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina arriba1.png"));
        Image imaMovA2 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina arriba2.png"));
        Image imaMovA3 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina arriba3.png"));
        
        Image imaMovD1 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina der1.png"));
        Image imaMovD2 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina der2.png"));
        Image imaMovD3 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina der3.png"));  
        
        Image imaMovI1 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina izq1.png"));
        Image imaMovI2 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina izq2.png"));
        Image imaMovI3 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina izq3.png"));  
    }
    
    public Trigger(){
        init();
        start();
    }

    public void start() {
        // Declaras un hilo
        Thread th = new Thread (this);
        // Empieza el hilo
        th.start ();
    }
    
    @Override
    public void run () {
        // se realiza el ciclo del juego en este caso nunca termina
        while (true) {
            /* mientras dure el juego, se actualizan posiciones de jugadores
               se checa si hubo colisiones para desaparecer jugadores o corregir
               movimientos y se vuelve a pintar todo
            */ 
            actualiza();
            checaColision();
            repaint();
            try	{
                // El thread se duerme.
                Thread.sleep (20);
            }
            catch (InterruptedException iexError)	{
                System.out.println("Hubo un error en el juego " + 
                        iexError.toString());
            }
	}
    }
    
    public void actualiza(){
        
    }
    
    public void checaColision(){
        
    }
    
        /**
     * update
     * 
     * Metodo sobrescrito de la clase <code>Applet</code>,
     * heredado de la clase Container.<P>
     * En este metodo lo que hace es actualizar el contenedor y 
     * define cuando usar ahora el paint
     * @param graGrafico es el <code>objeto grafico</code> usado para dibujar.
     * 
     */
    public void paint (Graphics graGrafico){
        // Inicializan el DoubleBuffer
        if (imaImagenApplet == null){
            imaImagenApplet = createImage (this.getSize().width, 
                    this.getSize().height);
                graGraficaApplet = imaImagenApplet.getGraphics();
        }
        URL urlImageBack = this.getClass().getResource("we.png");
            Image imaBack = Toolkit.getDefaultToolkit().
                getImage(urlImageBack);
        
        // Desplegar imagen de fondo
        graGraficaApplet.drawImage(imaBack, 0, 0, 
                getWidth(), getHeight(), this);
        
        // Actualizar el foreground
        graGraficaApplet.setColor (getForeground());
            paint1(graGraficaApplet);
       
        // Dibuja la imagen actualizada
        graGrafico.drawImage (imaImagenApplet, 0, 0, this);
    }
    
    /**
     * paint
     * 
     * Metodo sobrescrito de la clase <code>Applet</code>,
     * heredado de la clase Container.<P>
     * En este metodo se dibuja la imagen con la posicion actualizada,
     * ademas que cuando la imagen es cargada te despliega una advertencia.
     * @param g es el <code>objeto grafico</code> usado para dibujar.
     * 
     */
    public void paint1(Graphics g) {
    
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
