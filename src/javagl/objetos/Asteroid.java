/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagl.objetos;

import com.jogamp.opengl.GL2;
import java.util.Random;

/**
 *
 * @author Alisson Steffens
 */
public class Asteroid extends Poligono{
    
    private final Random gerador = new Random();
    public float v_x = 0;
    public float v_y = 0;
    
    
    public Asteroid(int sides, float aresta) {
        super(sides, aresta);
        desregular();
    }
    
    public void setVelocidade(float x, float y){
        v_x = x;
        v_y = y;
    }
    
    public void desregular(){
        for (int i = 0; i < this.sides; i++) {
            this.vertices[i][0] += (gerador.nextFloat()*aresta)-(aresta/2);
            this.vertices[i][1] += (gerador.nextFloat()*aresta)-(aresta/2);
        }  
    }
    
    @Override
    public void draw(GL2 gl) {
        gl.glColor3f(1f,1f,1f);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2f(this.vertices[sides-1][0]+x,this.vertices[sides-1][1]+y);
        gl.glVertex2f(this.vertices[0][0]+x,this.vertices[0][1]+y);
        for (int i = 1; i < this.sides; i++) {
            gl.glVertex2f(this.vertices[i-1][0]+x,this.vertices[i-1][1]+y);
            gl.glVertex2f(this.vertices[i][0]+x,this.vertices[i][1]+y);
        }        
        gl.glEnd();
        update();
    }
    
    public void update(){
        x += v_x;
        y += v_y;
        rotate(0.01f);
    }
    
    
}
