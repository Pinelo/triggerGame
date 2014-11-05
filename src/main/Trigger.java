/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.LinkedList;
import javax.swing.JFrame;

/**
 *
 * @author Casa
 */
public class Trigger extends JFrame implements Runnable, KeyListener
        , MouseListener {
    
    private Graphics graGraficaApplet;  // Objeto grafico de la Imagen
    private Animacion aniMovF;          // Movimiento del personaje principal F
    private Animacion aniMovI;  
    private Animacion aniMovD;
    private Animacion aniMovA;  
    private Character charPersonaje;
    private long tiempoActual;
    private boolean bMovimiento;
    private Image imaImagenApplet;   // Imagen a proyectar en Applet	
    private int cantTiles;              //variable temportal, destruir
    LinkedList map;                     //mapa del juego

    public void init(){

        bMovimiento = false;
        this.setSize(1000,1000);
    
        map = new LinkedList();     //el mapa se hace aqui
        
        cantTiles = 100;
        int posX = 22;
        int posY = 22;
        int contadorX = 0;
        int contadorY = 0;
        while(cantTiles > 0) {
            cantTiles--;
            Image tileImg = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Tile Piedra a Zacate Centro.png"));
            Terrain tile = new Terrain(posX*contadorX*6, posY*contadorY*6, tileImg, "Piedra", true);
            if(contadorX == 10) {
                contadorX = 0;
                contadorY++;
            }
            else{
            contadorX++;
            }        
            map.add(tile);
            
        }
        
        // Movimiento del personaje principal hacia el frete
        Image imaMovF1 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina Frente1.png"));
        Image imaMovF2 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina Frente2.png"));
        Image imaMovF3 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina Frente3.png"));    
        // Moviemiento del personaje principal hacia arriba
        Image imaMovA1 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina arriba1.png"));
        Image imaMovA2 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina arriba2.png"));
        Image imaMovA3 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina arriba3.png"));
        // Movimiento del personaje principal hacia la derecha
        Image imaMovD1 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina der1.png"));
        Image imaMovD2 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina der2.png"));
        Image imaMovD3 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina der3.png"));  
        // Movimiento del personaje principal hacia la izquierda
        Image imaMovI1 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina izq1.png"));
        Image imaMovI2 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina izq2.png"));
        Image imaMovI3 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Personaje Camina izq3.png"));   
        
        LinkedList invent = new LinkedList();
    
         // Animación de movimiento para enfrente
        aniMovF = new Animacion();
        aniMovF.sumaCuadro(imaMovF1, 100);
        aniMovF.sumaCuadro(imaMovF2, 100);
        aniMovF.sumaCuadro(imaMovF3, 100);
        
        aniMovI = new Animacion();
        aniMovI.sumaCuadro(imaMovI1, 100);
        aniMovI.sumaCuadro(imaMovI2, 100);
        aniMovI.sumaCuadro(imaMovI3, 100);
        
        aniMovA = new Animacion();
        aniMovA.sumaCuadro(imaMovA1, 100);
        aniMovA.sumaCuadro(imaMovA2, 100);
        aniMovA.sumaCuadro(imaMovA3, 100);
        
        aniMovD = new Animacion();
        aniMovD.sumaCuadro(imaMovD1, 100);
        aniMovD.sumaCuadro(imaMovD2, 100);
        aniMovD.sumaCuadro(imaMovD3, 100);  
        
        charPersonaje = new Character(100, 100, imaMovI3, aniMovF , 0, 100, 100, 5, 1,
                true, invent, true );
        charPersonaje.setX(getWidth() / 2);
        charPersonaje.setY(getHeight() / 2);
       
        addKeyListener(this);
        
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
        tiempoActual = System.currentTimeMillis();
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
        // Tiempo transcurrido desde que inicio el juego
        long tiempoTranscurrido=System.currentTimeMillis() - tiempoActual;
        //Guarda el tiempo actual
        if (bMovimiento){
            tiempoActual += tiempoTranscurrido;
            //Actualiza la animación de camion y pel en base al tiempo transcurrido
            aniMovF.actualiza(tiempoTranscurrido);
            aniMovA.actualiza(tiempoTranscurrido);
            aniMovD.actualiza(tiempoTranscurrido);
            aniMovI.actualiza(tiempoTranscurrido);
            
        }
        
        switch (charPersonaje.getDir()){
            case 1:{
                charPersonaje.setAnimacion(aniMovI);
                if(bMovimiento) {
                    for (Object tile : map) {
                    Terrain bloque = (Terrain)tile;
                    bloque.setX(bloque.getX() + charPersonaje.getSpeed());
                    }
                }
                break;
            }
            case 2:{
                charPersonaje.setAnimacion(aniMovD);
                if(bMovimiento) {
                    for (Object tile : map) {
                    Terrain bloque = (Terrain)tile;
                    bloque.setX(bloque.getX() - charPersonaje.getSpeed());
                    }
                }
                break;
            }
            case 3:{
                charPersonaje.setAnimacion(aniMovA);
                if(bMovimiento) {
                    for (Object tile : map) {
                    Terrain bloque = (Terrain)tile;
                    bloque.setY(bloque.getY() + charPersonaje.getSpeed());
                    }
                }
                break;
            }
            case 4:{
                charPersonaje.setAnimacion(aniMovF);
                if(bMovimiento) {
                    for (Object tile : map) {
                    Terrain bloque = (Terrain)tile;
                    bloque.setY(bloque.getY() - charPersonaje.getSpeed());
                    }
                }
                break;
            }
        }  
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
 
                //contadores para hacer el mapa
        if(map != null){
                  for (Object tile : map) {
                    Terrain bloque = (Terrain)tile;
                    g.drawImage(bloque.getImg(), bloque.getX(),
                            bloque.getY(), this);
                }
        }
        else if(map == null) {
            g.drawString("NULL", 100, 100);
        }
        g.drawImage(charPersonaje.getAnimacion().getImagen()
                , charPersonaje.getX() , charPersonaje.getY(), this);
                  
//                for (Object encBloque : encBloques) {
//                    Entidad bloque = (Entidad)encBloque;
//                    g.drawImage(bloque.getImagen(), bloque.getX(),
//                            bloque.getY(), this);
//                }
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A){
            bMovimiento = true;
            charPersonaje.setDir(1);
        } 
        else if (e.getKeyCode() == KeyEvent.VK_D){
            bMovimiento = true;
            charPersonaje.setDir(2);
        } 
        else if (e.getKeyCode() == KeyEvent.VK_W){
            bMovimiento = true;
            charPersonaje.setDir(3);
        } 
        else if (e.getKeyCode() == KeyEvent.VK_S){ 
            bMovimiento = true;
            charPersonaje.setDir(4);
        } 
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        bMovimiento = false;
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
