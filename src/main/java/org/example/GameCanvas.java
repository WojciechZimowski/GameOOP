package org.example;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameCanvas extends Canvas {
    private GraphicsContext graphicsC;

    public GameCanvas(double width, double height){
        super(width, height);
        graphicsC = this.getGraphicsContext2D();
    }

    public void draw(){
        graphicsC.setFill(Color.BLACK);
        graphicsC.fillRect(0, 0, getWidth(), getHeight());
    }
}
