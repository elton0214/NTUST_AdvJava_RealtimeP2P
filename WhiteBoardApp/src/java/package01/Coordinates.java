/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package01;

/**
 *
 * @author 4 弦
 */
public class Coordinates {
    private float x01;
    private float y01;
    
    public Coordinates(float input_x, float input_y){
        this.x01 =input_x;
        this.y01 =input_y;
    }
    
    public float getX(){ return x01; }
    public void setX(float input_x){ this.x01 =input_x; }
    public float getY(){ return y01; }
    public void setY(float input_y){ this.y01 =input_y; }
}
