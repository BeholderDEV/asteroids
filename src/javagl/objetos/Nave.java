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
public class Nave extends Drawable{
    private float ship[][] = {{0.0f,0.048f }, {0.036f, -0.048f}, {0.0f,-0.036f }, {-0.036f,-0.048f }, {0.0f, 0.048f}};
    
    @Override
    public void draw(GL2 gl){
        gl.glColor3f(1f,1f,1f);
        gl.glBegin(GL2.GL_POLYGON);
        //System.out.println(shipPosition.x);
        gl.glVertex2f(ship[0][0]+x,ship[0][1]+y);
        gl.glVertex2f(ship[1][0]+x,ship[1][1]+y);
        gl.glVertex2f(ship[2][0]+x,ship[2][1]+y);
        gl.glVertex2f(ship[3][0]+x,ship[3][1]+y);
        gl.glVertex2f(ship[4][0]+x,ship[4][1]+y);
        
        gl.glEnd(); 
        
        
    }

    @Override
    public void rotate(float angle){
        actualAngle += angle;
        for (int i = 0; i < ship.length; i++) {
            translatePoints(i, angle);
        }
    }
    
    private void translatePoints(int vertice , float angle)
    {
       float s = (float) Math.sin(angle);
       float c = (float) Math.cos(angle);
       
//       ship[vertice][0] -= x;
//       ship[vertice][1] -= y;
//       
       float xnew = ship[vertice][0] * c - ship[vertice][1] * s;
       float ynew = ship[vertice][0] * s + ship[vertice][1] * c;

        // translate point back:
       ship[vertice][0] = xnew;
       ship[vertice][1] = ynew;
    }
    
    public void forward(float speed)
    {
        this.x += (float) Math.cos(actualAngle)*speed;
        this.y+= (float) Math.sin(actualAngle)*speed;
        
        if(this.x < -1.05f){
            this.x = 1.05f;
        }
        if(this.x > 1.05f){
            this.x = -1.05f;
        }
        if(this.y < -1.05f){
            this.y = 1.05f;
        }
        if(this.y > 1.05f){
            this.y = -1.05f;
        }
    }
}
