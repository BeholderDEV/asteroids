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
public class Poligono extends Drawable{
    
    public int sides = 5;
    public float anguloInterno = 0;
    public float anguloVertice = 0;
    public float vertices[][];
    public float aresta = 0;
    
    public Poligono(int sides, float aresta) {
        x = -0.5f;
        y = -0.5f;
        this.aresta = aresta;
        vertices = new float [sides][3];
        this.sides = sides;
        this.anguloInterno = (float) ((Math.PI)*(this.sides-2));
        this.anguloVertice = this.anguloInterno/(this.sides);
        this.anguloVertice = (float) ((Math.PI) - this.anguloVertice);
        
        for (int i = 0; i < this.sides; i++) {
            this.vertices[i][0] = 0;
            this.vertices[i][1] = -aresta;
            this.vertices[i][2] = 0;
        }
        float tempAngle = this.actualAngle;
        for (int i = 0; i < this.sides; i++) {
            tempAngle+= anguloVertice;
            rotate(i, tempAngle);
        }
    }
    
    public void scale (float aresta){
        for (int i = 0; i < this.sides; i++) {
            this.vertices[i][0] = 0;
            this.vertices[i][1] = -aresta;
        }
        for (int i = 0; i < this.sides; i++) {
            scale_rotate(i, this.vertices[i][2]);
        }
        this.aresta = aresta;
    }
    
    public void scale_rotate(int vertice,float angulo){
        float s = (float) Math.sin(angulo);
        float c = (float) Math.cos(angulo);
        float xnew = this.vertices[vertice][0] * c - this.vertices[vertice][1] * s;
        float ynew = this.vertices[vertice][0] * s + this.vertices[vertice][1] * c;
        this.vertices[vertice][0] = xnew;
        this.vertices[vertice][1] = ynew;    
    }
    
    public void rotate(int vertice,float angulo){
        float s = (float) Math.sin(angulo);
        float c = (float) Math.cos(angulo);
        float xnew = this.vertices[vertice][0] * c - this.vertices[vertice][1] * s;
        float ynew = this.vertices[vertice][0] * s + this.vertices[vertice][1] * c;
        this.vertices[vertice][0] = xnew;
        this.vertices[vertice][1] = ynew;
        this.vertices[vertice][2] += angulo;
    }
    
    public void rotate(int vertice,float angulo, float x, float y){
        float s = (float) Math.sin(angulo);
        float c = (float) Math.cos(angulo);
        this.vertices[vertice][0]-= x;
        this.vertices[vertice][1]-= y;
        float xnew = this.vertices[vertice][0] * c - this.vertices[vertice][1] * s;
        float ynew = this.vertices[vertice][0] * s + this.vertices[vertice][1] * c;
        this.vertices[vertice][0] = xnew + x;
        this.vertices[vertice][1] = ynew + y;
        this.vertices[vertice][2] += angulo;
    }
    
    @Override
    public void draw(GL2 gl) {
        gl.glColor3f(1f,1f,1f);
        gl.glBegin(GL2.GL_POLYGON);
        for (int i = 0; i < this.sides; i++) {
            gl.glVertex2f(this.vertices[i][0]+x,this.vertices[i][1]+y);
        }        
        gl.glEnd();
    }

    @Override
    public void rotate(float angle) {
        for (int i = 0; i < this.sides; i++) {
            rotate(i, angle);
        }
    }
    
}
