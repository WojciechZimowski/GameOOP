package org.example;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import javafx.scene.input.MouseEvent;

public class GameCanvas extends Canvas {
    private GraphicsContext graphicsC;
    private Paddle paddle;

    public GameCanvas(double width, double height){
        super(width, height);
        graphicsC = this.getGraphicsContext2D();

        GraphicsItem.setCanvasW(width);
        GraphicsItem.setCanvasH(height);

        paddle = new Paddle();

        this.setOnMouseMoved(this::mouseMovementHandler);
    }
    private void mouseMovementHandler(MouseEvent e){
        paddle.centerPlatformX(e.getX());
        draw();
    }


    public void draw(){
        graphicsC.setFill(Color.BLACK);
        graphicsC.fillRect(0, 0, getWidth(), getHeight());

        paddle.draw(graphicsC);
    }

}
