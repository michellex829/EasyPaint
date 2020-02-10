package model;

import view.gui.PaintCanvas;
import view.gui.Point;

public class ShapeGeneratorDuplicator extends ShapeGenerator{
    private Point startPoint;
    private Point endPoint;
    private Point temporaryStartPoint;
    private Point temporaryEndPoint;
    private int height;
    private int width;
    private ShapeType shapeType;
    private ShapeColor activePrimaryColor;
    private ShapeColor activeSecondaryColor;
    private ShapeShadingType activeShapeShadingType;
    private PaintCanvas paintCanvas;

    public ShapeGeneratorDuplicator(PaintCanvas paintCanvas, Point oldStartPoint, Point oldEndPoint, Point oldTemporaryStartPoint, Point oldTemporaryEndPoint, int height, int width, ShapeType shapeType, ShapeColor activePrimaryColor, ShapeColor activeSecondaryColor, ShapeShadingType activeShapeShadingType) {
        this.paintCanvas = paintCanvas;
        startPoint = new Point(oldStartPoint.getX(), oldStartPoint.getY());
        endPoint = new Point(oldEndPoint.getX(), oldEndPoint.getY());
        temporaryStartPoint = new Point(oldTemporaryStartPoint.getX(), oldTemporaryStartPoint.getY());
        temporaryEndPoint = new Point(oldTemporaryEndPoint.getX(), oldTemporaryEndPoint.getY());
        this.height = height;
        this.width = width;
        this.shapeType = shapeType;
        this.activePrimaryColor = activePrimaryColor;
        this.activeSecondaryColor = activeSecondaryColor;
        this.activeShapeShadingType = activeShapeShadingType;
    }
    public void setShapeType(ShapeType shapeType) { this.shapeType = shapeType; }

    public void setPaintCanvas(PaintCanvas paintCanvas) { this.paintCanvas = paintCanvas; }

    public PaintCanvas getPaintCanvas() { return paintCanvas; }

    public void setActivePrimaryColor(ShapeColor activePrimaryColor)  { this.activePrimaryColor = activePrimaryColor; }

    public void setActiveSecondaryColor(ShapeColor activeSecondaryColor) { this.activeSecondaryColor = activeSecondaryColor; }

    public ShapeType getShapeType() { return this.shapeType;  }

    public Point getStartPoint() { return startPoint; }

    public Point getEndPoint() { return endPoint; }

    public Point getTemporaryStartPoint(){ return temporaryStartPoint; }

    public Point getTemporaryEndPoint(){ return temporaryEndPoint; }

    public int getHeight() { return height;}

    public int getWidth() { return width;}

    public ShapeColor getActivePrimaryColor() { return activePrimaryColor;}

    public ShapeColor getActiveSecondaryColor() { return activeSecondaryColor;}

    public ShapeShadingType getShapeShadingType() { return activeShapeShadingType;}

}
