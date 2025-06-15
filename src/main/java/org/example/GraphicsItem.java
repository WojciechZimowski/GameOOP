package org.example;

import javafx.scene.canvas.GraphicsContext;

public abstract class GraphicsItem {
    protected static double canvasW;
    protected static double canvasH;

    public static void setCanvasW(double canvasW) {
        GraphicsItem.canvasW = canvasW;
    }

    public static void setCanvasH(double canvasH) {
        GraphicsItem.canvasH = canvasH;
    }
    protected  double x;
    protected double y;
    protected double width;
    protected double height;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
    public abstract void draw(GraphicsContext graphicsC);

}
