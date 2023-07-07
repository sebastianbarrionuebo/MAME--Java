package PingPong;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Pelota extends Rectangle{
    
    private Random random;
    private int xVelocidad;
    private int yVelocidad;
    public  int velocidadInicial = 2;
    
    public Pelota(int x, int y, int width, int height) {
        super(x,y,width,height);
        initPelotaRandom();
    }
    
    
    public void initPelotaRandom(){
        random = new Random();
        int randomX = random.nextInt(2);
        int randomY = random.nextInt(2);
        if(randomX == 0){
        randomX--;
        }
        if(randomY == 0){
        randomY--;
        }
        setXeYDireccion(randomX*this.velocidadInicial,randomY*this.velocidadInicial);
    }
    
    public void setXeYDireccion(int xDireccion, int yDirecion){
        this.xVelocidad = xDireccion;
        this.yVelocidad = yDirecion;
    }
    
    public void movimiento(){
    x += this.xVelocidad;
    y += this.yVelocidad;
    }
    
    public void dibujar(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height); 
    }

    public int getxVelocidad() {
        return xVelocidad;
    }

    public void setxVelocidad(int xVelocidad) {
        this.xVelocidad = xVelocidad;
    }

    public int getyVelocidad() {
        return yVelocidad;
    }

    public void setyVelocidad(int yVelocidad) {
        this.yVelocidad = yVelocidad;
    }
    
    
}
