package view;

import model.*;
import view.gui.PaintCanvas;
import view.gui.Point;
import java.awt.*;

class TriangleStrategy extends AbstractShapeClass {
    private ShapeGenerator shapeGenerator;
    private Point startPoint;
    private Point endPoint;
    private Point temporaryStartPoint;
    private Point temporaryEndPoint;
    private int width;
    private int height;
    private Color primaryColor;
    private Color secondaryColor;
    private PaintCanvas paintCanvas;

    public TriangleStrategy(ShapeGenerator shapeGenerator) {
        super(shapeGenerator);
        this.shapeGenerator = shapeGenerator;
        this.startPoint = shapeGenerator.getStartPoint();
        this.endPoint = shapeGenerator.getEndPoint();
        this.temporaryStartPoint = shapeGenerator.getTemporaryStartPoint();
        this.temporaryEndPoint = shapeGenerator.getTemporaryEndPoint();
        this.width = shapeGenerator.getWidth();
        this.height = shapeGenerator.getHeight();
        this.primaryColor = ColorMap.getColor(getShapeGenerator().getActivePrimaryColor());
        this.secondaryColor = ColorMap.getColor(getShapeGenerator().getActiveSecondaryColor());;
        this.paintCanvas = shapeGenerator.getPaintCanvas();
    }

    public void drawFilledInShading(Color primaryColor) {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(primaryColor);
        graphics2d.fillPolygon(new int[]{temporaryStartPoint.getX(), temporaryEndPoint.getX(), temporaryStartPoint.getX()}, new int[]{temporaryStartPoint.getY(), temporaryEndPoint.getY(), temporaryEndPoint.getY()}, 3);
    }
    public void drawOutlineShading(Color primaryColor){
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(primaryColor);
        graphics2d.drawPolygon(new int[]{temporaryStartPoint.getX(), temporaryEndPoint.getX(), temporaryStartPoint.getX()}, new int[]{temporaryStartPoint.getY(), temporaryEndPoint.getY(), temporaryEndPoint.getY()}, 3);
    }
    public void drawOutlineFilledInShading(Color primaryColor, Color secondaryColor) {
        drawFilledInShading(primaryColor);
        drawOutlineShading(secondaryColor);
    }

    public void drawSelectedOutline() {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(Color.BLACK);
        int startPointX = temporaryStartPoint.getX();
        int startPointY = temporaryStartPoint.getY();
        int endPointX = temporaryEndPoint.getX();
        int endPointY = temporaryEndPoint.getY();
        if (startPointX < endPointX && startPointY < endPointY) {
            graphics2d.drawPolygon(new int[]{startPointX - 10, endPointX + 40, startPointX - 10}, new int[]{startPointY - 25, endPointY + 7, endPointY + 10}, 3);
        }
        if (startPointX > endPointX && startPointY < endPointY) {
            graphics2d.drawPolygon(new int[]{startPointX + 10, endPointX - 15, startPointX + 10}, new int[]{startPointY - 32, endPointY + 10, endPointY + 10}, 3);
        }
        if (startPointX < endPointX && startPointY > endPointY) {
            graphics2d.drawPolygon(new int[]{startPointX - 10, endPointX + 32, startPointX - 10}, new int[]{startPointY + 32, endPointY - 15, endPointY - 15}, 3);
        }
        if (startPointX > endPointX && startPointY > endPointY) {
            graphics2d.drawPolygon(new int[]{startPointX + 20, endPointX - 32, startPointX + 20}, new int[]{startPointY + 40, endPointY - 15, endPointY - 15}, 3);
        }
    }

    public ShapeGenerator getShapeGenerator() { return shapeGenerator; }

    public void setStartPoint(Point startPoint) { this.startPoint = startPoint; }

    public void setEndPoint(Point endPoint){ this.endPoint = endPoint;}

    public Point getStartPoint() { return startPoint; }

    public Point getEndPoint() { return endPoint; }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() { return width; }

    public int getHeight() { return height; }

    public PaintCanvas getPaintCanvas() { return paintCanvas;}

    public Point getTemporaryStartPoint(){ return temporaryStartPoint; }

    public Point getTemporaryEndPoint(){ return temporaryEndPoint; }

    public void movedX(int dx) {
        temporaryStartPoint.setX(temporaryStartPoint.getX() + dx);
        temporaryEndPoint.setX(temporaryEndPoint.getX() + dx);
        startPoint.setX(Math.min(temporaryStartPoint.getX(), temporaryEndPoint.getX()));
    }

    public void movedY(int dy) {
        temporaryStartPoint.setY(temporaryStartPoint.getY() + dy);
        temporaryEndPoint.setY(temporaryEndPoint.getY() + dy);
        startPoint.setY(Math.min(temporaryStartPoint.getY(), temporaryEndPoint.getY()));
    }
}
