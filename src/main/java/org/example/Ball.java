package org.example;

import javafx.scene.canvas.GraphicsContext;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class Ball extends GraphicsItem{
    private Point2D moveVector;
    private double vel;

    private Ball(){
        this.moveVector=new Point2D(1,-1).normalize();
        this.vel=0.05;
        this.width=0.05;
        this.height=0.05;

    }
    public void setPosition(Point2D position){
        this.x=position.getX()/canvasW;
        this.y=position.getY()/canvasH;
    }
    public void updatePosition(){
        this.x+=moveVector.getX()*vel;
        this.y+=moveVector.getY()*vel;
        if (x <= 0 || x >= 1 - width) {
            moveVector = new Point2D(-moveVector.getX(), moveVector.getY());
        }
        if (y <= 0) {
            moveVector = new Point2D(moveVector.getX(), -moveVector.getY());
        }
    }
    @Override
    public void draw(GraphicsContext graphicsC) {
        graphicsC.setFill(Color.PURPLE);
        graphicsC.fillOval(x*canvasW,y*canvasH,width*canvasW,height*canvasH);

    }
}
