/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagl.objetos;

import com.jogamp.opengl.GL2;

/**
 *
 * @author 5663296
 */
public abstract class Drawable {
    public float x = 0;
    public float y = 0;
    public float width = 0;
    public float height = 0;
    public float actualAngle = (float) (Math.PI/2.0f);
    
    public abstract void draw(GL2 gl);
    public abstract void rotate(float angle);
}
