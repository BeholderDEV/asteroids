/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagl;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/**
 *
 * @author 5663296
 */
public class Main {
    
    static final int RIGHT = 0;
    static final int LEFT = 1;
    static final int UP = 2;
    static boolean[] KeyBuffer = {false,false,false} ;
    
    public static void main( String[] args ) { 

         //getting the capabilities object of GL2 profile  
         final GLProfile profile = GLProfile.get( GLProfile.GL2 ); 
         GLCapabilities capabilities = new GLCapabilities(profile); 

         // The canvas  
         final GLCanvas glcanvas = new GLCanvas( capabilities ); 
         Game game = new Game(); 
         glcanvas.addGLEventListener( game );
         glcanvas.setSize( 800, 800 ); 

         //creating frame 
         final JFrame frame = new JFrame ( "Colored Polygon" ); 
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.addKeyListener(new KeyAdapter() {
             @Override
             public void keyReleased(KeyEvent e) {
                 if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    KeyBuffer[LEFT] = false;
                 }
                 if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    KeyBuffer[RIGHT] = false;
                 }
                 if(e.getKeyCode() == KeyEvent.VK_UP){
                    KeyBuffer[UP] = false;
                 }
                 super.keyReleased(e); //To change body of generated methods, choose Tools | Templates.
             }
             
             
            
             @Override
             public void keyPressed(KeyEvent e) {
                 if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    KeyBuffer[LEFT] = true;
                 }
                 if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    KeyBuffer[RIGHT] = true;
                 }
                 if(e.getKeyCode() == KeyEvent.VK_UP){
                    KeyBuffer[UP] = true;
                 }
                 super.keyPressed(e); //To change body of generated methods, choose Tools | Templates.
             }
         });
         
//         frame.addKeyListener(new KeyAdapter() {
//
//             @Override
//             public void keyPressed(KeyEvent e) {
//                 if(e.getKeyCode() == KeyEvent.VK_LEFT){
//                     System.out.println("left");
//                     game.nave.rotate(0.15f);
//                 }
//                 if(e.getKeyCode() == KeyEvent.VK_RIGHT){
//                     game.nave.rotate(-0.15f);
//                     System.out.println("right");
//                 }
//                 if(e.getKeyCode() == KeyEvent.VK_UP){
//                     System.out.println("up");
//                     game.nave.forward(0.008f);
//                 }
//                 super.keyPressed(e); //To change body of generated methods, choose Tools | Templates.
//             }
//         });

         final FPSAnimator animator = new FPSAnimator(glcanvas, 300,true);
         animator.start();
         //adding canvas to frame 
         frame.getContentPane().add( glcanvas ); 
         frame.setSize(frame.getContentPane().getPreferredSize() ); 
         frame.setVisible( true );      
    }
   
}
