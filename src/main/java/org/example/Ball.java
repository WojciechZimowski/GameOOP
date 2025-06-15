package org.example;

import javafx.scene.canvas.GraphicsContext;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class Ball extends GraphicsItem{
    private Point2D moveVector;
    private double vel;

    public Ball(){
        this.moveVector=new Point2D(1,-1).normalize();
        this.vel=300;
        this.width=0.05;
        this.height=0.05;

    }
    public void setPosition(Point2D position){
        this.x=position.getX()/canvasW;
        this.y=position.getY()/canvasH;
    }
    public void updatePosition(double deltaTime){
        double dx = (moveVector.getX() * vel * deltaTime) / canvasW;
        double dy = (moveVector.getY() * vel * deltaTime) / canvasH;

        this.x += dx;
        this.y += dy;

        if (x <= 0 || x >= 1 - width) {
            bounceHorizontally();
            if (x < 0) x = 0;
            if (x > 1 - width) x = 1 - width;
        }
        if (y <= 0) {
            bounceVertically();
            y = 0;
        }
    }

    @Override
    public void draw(GraphicsContext graphicsC) {
        graphicsC.setFill(Color.PURPLE);
        graphicsC.fillOval(x*canvasW,y*canvasH,width*canvasW,height*canvasH);

    }
    public void bounceHorizontally() {
        moveVector = new Point2D(-moveVector.getX(), moveVector.getY());
    }

    public void bounceVertically() {
        moveVector = new Point2D(moveVector.getX(), -moveVector.getY());
    }
}
