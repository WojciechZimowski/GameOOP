package org.example;

import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class GameCanvas extends Canvas {
    private GraphicsContext graphicsC;
    private Paddle paddle;
    private Ball ball;
    private boolean isPlaying;
    private AnimationTimer timer;

    private long lastFrameTime = 0;

    public GameCanvas(double width, double height) {
        super(width, height);
        graphicsC = this.getGraphicsContext2D();

        GraphicsItem.setCanvasW(width);
        GraphicsItem.setCanvasH(height);

        paddle = new Paddle();
        ball = new Ball();
        isPlaying = false;

        this.setOnMouseMoved(this::mouseMovementHandler);
        this.setOnMouseClicked(e -> isPlaying = true);

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (lastFrameTime == 0) {
                    lastFrameTime = now;
                    return;
                }

                double deltaTime = (now - lastFrameTime) / 1_000_000_000.0; // ns -> s
                lastFrameTime = now;

                draw(deltaTime);
            }
        };
        timer.start();
    }

    private void mouseMovementHandler(MouseEvent e) {
        paddle.centerPlatformX(e.getX());
    }

    public void draw(double deltaTime) {
        graphicsC.setFill(Color.BLACK);
        graphicsC.fillRect(0, 0, getWidth(), getHeight());

        if (isPlaying) {
            ball.updatePosition(deltaTime);

            if (shouldBallBounceHorizontally()) {
                ball.bounceHorizontally();
                if (ball.getX() < 0) ball.setX(0);
                if (ball.getX() > 1 - ball.getWidth()) ball.setX(1 - ball.getWidth());
            }

            if (shouldBallBounceVertically()) {
                ball.bounceVertically();
                if (ball.getY() < 0) ball.setY(0);
            }

            if (shouldBallBounceFromPaddle()) {
                ball.bounceVertically();
                ball.setY(paddle.getY() - paddle.getHeight() / 2 - ball.getHeight());
            }
        } else {
            double ballX = paddle.getX() * GraphicsItem.canvasW + (paddle.getWidth() * GraphicsItem.canvasW) / 2-40;
            double ballY = paddle.getY() * GraphicsItem.canvasH - 40;
            ball.setPosition(new Point2D(ballX, ballY));
        }

        paddle.draw(graphicsC);
        ball.draw(graphicsC);
    }

    private boolean shouldBallBounceHorizontally() {
        return (ball.getX() <= 0) || (ball.getX() >= 1 - ball.getWidth());
    }

    private boolean shouldBallBounceVertically() {
        return ball.getY() <= 0;
    }

    private boolean shouldBallBounceFromPaddle() {
        boolean verticalCollision = ball.getY() + ball.getHeight() >= paddle.getY() - paddle.getHeight() / 2;
        boolean horizontalCollision = (
                ball.getX() + ball.getWidth() >= paddle.getX() - paddle.getWidth() / 2) &&
                (ball.getX() <= paddle.getX() + paddle.getWidth() / 2);
        return verticalCollision && horizontalCollision;
    }
}
