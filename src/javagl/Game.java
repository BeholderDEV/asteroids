/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagl;

import javagl.objetos.Nave;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import javagl.objetos.Poligono;
import javax.swing.JFrame;

/**
 *
 * @author 5663296
 */
public class Game extends JFrame implements GLEventListener{
    public Nave nave = new Nave();
    public Poligono pentagono = new Poligono(5, 0.3f);

    public Game() {
        
    }
    
    
    @Override 
    public void display( GLAutoDrawable drawable ) { 
        control();
        final GL2 gl = drawable.getGL().getGL2();
        gl.glColor3f(0.1f,0.1f,0.1f);
        gl.glBegin(GL2.GL_POLYGON);
        gl.glVertex2f(-1f,-1f);
        gl.glVertex2f(1f,-1f);
        gl.glVertex2f(1f,1f);
        gl.glVertex2f(-1f,1f);
        gl.glEnd(); 
        //nave.draw(gl);
        pentagono.draw(gl);
    }
    
    private void control(){
        if(Main.KeyBuffer[Main.LEFT]){
            //nave.rotate(0.15f);
            pentagono.scale(pentagono.aresta+0.001f);
        }
        if(Main.KeyBuffer[Main.RIGHT]){
            //nave.rotate(-0.15f);
            pentagono.scale(pentagono.aresta-0.001f);
        }
        if(Main.KeyBuffer[Main.UP]){
            nave.forward(0.008f);
        }
    }


    @Override 
    public void dispose( GLAutoDrawable arg0 ) { 
        System.out.println("asda");
       System.exit(1);
    } 

    @Override 
    public void init( GLAutoDrawable drawable ) {   
       GL2 gl = drawable.getGL().getGL2();
       
    } 

    @Override 
    public void reshape( GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4 ) {    
       // method body 
    } 
    
    
   
 //end of main 
	
 } //end of class 