package ir.ac.kntu;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RecursiveGUI {
    private static final int TOP_X = 200, TOP_Y = 20;

    private static final int LEFT_X = 60, LEFT_Y = 300;

    private static final int RIGHT_X = 340, RIGHT_Y = 300;

    private static final double SQRT = Math.sqrt(3.0) / 6;

    static void startPainting(GraphicsContext gc) {
        int order = 5;
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(0.5);
        drawFractal(order, TOP_X, TOP_Y, LEFT_X, LEFT_Y, gc);
        drawFractal(order, LEFT_X, LEFT_Y, RIGHT_X, RIGHT_Y, gc);
        drawFractal(order, RIGHT_X, RIGHT_Y, TOP_X, TOP_Y, gc);
    }

    public static void drawFractal(int order, int x1, int y1, int x5,
                                   int y5, GraphicsContext gc) {
        int deltaX, deltaY, x2, x3, x4, y2, y3, y4;
        if (order == 1) {
            gc.strokeLine(x1, y1, x5, y5);
        } else {
            deltaX = x5 - x1;
            deltaY = y5 - y1;
            x2 = x1 + deltaX / 3;
            y2 = y1 + deltaY / 3;
            x3 = (int) ((x1 + x5) / 2 + SQRT * (y1 - y5));
            y3 = (int) ((y1 + y5) / 2 + SQRT * (x5 - x1));
            x4 = x1 + deltaX * 2 / 3;
            y4 = y1 + deltaY * 2 / 3;
            drawFractal(order - 1, x1, y1, x2, y2, gc);
            drawFractal(order - 1, x2, y2, x3, y3, gc);
            drawFractal(order - 1, x3, y3, x4, y4, gc);
            drawFractal(order - 1, x4, y4, x5, y5, gc);
        }

    }

}