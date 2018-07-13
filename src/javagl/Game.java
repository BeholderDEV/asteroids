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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javagl.objetos.Asteroid;
import javax.swing.JFrame;

/**
 *
 * @author 5663296
 */
public class Game extends JFrame implements GLEventListener{
    
    public Nave nave = new Nave();
    private final Random gerador = new Random();
    public List<Asteroid> asteroids = new ArrayList<>();

    public Game() {
        for (int i = 0; i < 5; i++) {
            Asteroid a = new Asteroid(gerador.nextInt(10)+5, gerador.nextFloat()*0.25f);
            a.x = -1f;
            a.v_x = gerador.nextFloat()*0.001f;
            a.y = -1f;
            a.v_y = gerador.nextFloat()*0.001f;
            
            asteroids.add(a);
        }
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
        nave.draw(gl);
        for (Asteroid asteroid : asteroids) {
            asteroid.draw(gl);
        }
    }
    
    private void control(){
        if(Main.KeyBuffer[Main.LEFT]){
            nave.rotate(0.15f);
        }
        if(Main.KeyBuffer[Main.RIGHT]){
            nave.rotate(-0.15f);
        }
        if(Main.KeyBuffer[Main.UP]){
            nave.forward(0.008f);
        }
    }

    @Override 
    public void dispose( GLAutoDrawable arg0 ) {
        System.exit(1);
    } 

    @Override 
    public void init( GLAutoDrawable drawable ) {   
       GL2 gl = drawable.getGL().getGL2();
       
    }
    
    @Override 
    public void reshape( GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4 ) {    
    
    }	
 }