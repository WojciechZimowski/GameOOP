package org.example;

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
}
