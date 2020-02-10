package view;

import model.*;
import view.gui.PaintCanvas;
import view.gui.Point;
import java.awt.*;

class EllipseStrategy extends AbstractShapeClass {
    private ShapeGenerator shapeGenerator;
    private Point startPoint;
    private Point endPoint;
    private int width;
    private int height;
    private Color primaryColor;
    private Color secondaryColor;
    private PaintCanvas paintCanvas;

    public EllipseStrategy(ShapeGenerator shapeGenerator) {
        super(shapeGenerator);
        this.shapeGenerator = shapeGenerator;
        this.startPoint = shapeGenerator.getStartPoint();
        this.endPoint = shapeGenerator.getEndPoint();
        this.width = shapeGenerator.getWidth();
        this.height = shapeGenerator.getHeight();
        this.primaryColor = ColorMap.getColor(getShapeGenerator().getActivePrimaryColor());
        this.secondaryColor = ColorMap.getColor(getShapeGenerator().getActiveSecondaryColor());
        this.paintCanvas = shapeGenerator.getPaintCanvas();
    }

    public void drawFilledInShading(Color primaryColor) {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(primaryColor);
        graphics2d.fillOval(startPoint.getX(), startPoint.getY(), width, height);
    }

    public void drawOutlineShading(Color primaryColor){
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(primaryColor);
        graphics2d.drawOval(startPoint.getX(), startPoint.getY(), width, height);
    }

    public void drawOutlineFilledInShading(Color primaryColor, Color secondaryColor ) {
        drawFilledInShading(primaryColor);
        drawOutlineShading(secondaryColor);
    }

    public void drawSelectedOutline() {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(Color.BLACK);
        graphics2d.drawOval(startPoint.getX() - 9, startPoint.getY() - 9, width + 18, height + 18);
    }

    public ShapeGenerator getShapeGenerator() {
        return shapeGenerator;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = shapeGenerator.getStartPoint();
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = shapeGenerator.getEndPoint();
    }

    public Point getTemporaryStartPoint(){ return startPoint; }

    public Point getTemporaryEndPoint(){ return endPoint; }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public void movedX(int dx) {
        startPoint.setX(startPoint.getX() + dx);
        endPoint.setX(endPoint.getX() + dx);
    }

    public void movedY(int dy) {
        startPoint.setY(startPoint.getY() + dy);
        endPoint.setY(endPoint.getY() + dy);
    }
}

