package org.example;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Paddle extends GraphicsItem{
    public Paddle(){
        this.width = 0.1;
        this.height = 0.05;

        this.x=0.5;
        this.y=0.95;

    }
    @Override
    public void draw(GraphicsContext graphicsC) {
        graphicsC.setFill(Color.GREEN);
        double px=(x-width/2)* canvasW;
        double py=(y-height/2)*canvasH;
        double pW=width*canvasW;
        double pH=height*canvasH;
        graphicsC.fillRect(px,py,pW,pH);

    }
    public void centerPlatformX(double mouseX){
        double takenX=mouseX/canvasW;
        this.x=takenX;
    }
}
