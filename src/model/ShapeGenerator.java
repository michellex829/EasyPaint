package model;

import model.interfaces.IApplicationState;
import view.gui.PaintCanvas;
import view.gui.Point;

public class ShapeGenerator{
    private IApplicationState applicationState ;
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

    public ShapeGenerator shapeGenerator (IApplicationState applicationState){
        ShapeGenerator shapeGenerator = new ShapeGenerator();
        shapeGenerator.applicationState = applicationState;
        shapeGenerator.setShapeType(shapeType);
        shapeGenerator.setActivePrimaryColor(activePrimaryColor);
        shapeGenerator.setActiveSecondaryColor(activeSecondaryColor);
        shapeGenerator.setShapeShadingType(activeShapeShadingType);
        shapeGenerator.setStartPoint(startPoint);
        shapeGenerator.setEndPoint(endPoint);
        shapeGenerator.setTemporaryStartPoint(temporaryStartPoint);
        shapeGenerator.setTemporaryEndPoint(temporaryEndPoint);
        shapeGenerator.setWidth(width);
        shapeGenerator.setHeight(height);
        shapeGenerator.setPaintCanvas(paintCanvas);
        return shapeGenerator;
    }

    public void setApplicationState(IApplicationState applicationState) { this.applicationState = applicationState; }

    public IApplicationState getApplicationState() { return this.applicationState; }

    public void setShapeType(ShapeType shapeType) { this.shapeType = applicationState.getActiveShapeType(); }

    public ShapeType getShapeType() { return this.shapeType;  }

    public void setPaintCanvas(PaintCanvas paintCanvas) { this.paintCanvas = paintCanvas; }

    public PaintCanvas getPaintCanvas() { return paintCanvas;}

    public void setActivePrimaryColor(ShapeColor activePrimaryColor)  { this.activePrimaryColor = applicationState.getActivePrimaryColor(); }

    public void setActiveSecondaryColor(ShapeColor activeSecondaryColor) { this.activeSecondaryColor = applicationState.getActiveSecondaryColor(); }

    public ShapeColor getActivePrimaryColor() { return this.activePrimaryColor; }

    public ShapeColor getActiveSecondaryColor() { return this.activeSecondaryColor; }

    public void setShapeShadingType(ShapeShadingType activeShapeShadingType) { this.activeShapeShadingType = applicationState.getActiveShapeShadingType(); }

    public ShapeShadingType getShapeShadingType() { return activeShapeShadingType;}

    public void setStartPoint(Point startPoint) { this.startPoint = applicationState.getStartPoint(); }

    public void setEndPoint(Point endPoint) {  this.endPoint = applicationState.getEndPoint(); }

    public Point getStartPoint() { return startPoint; }

    public Point getEndPoint() { return endPoint; }

    public void setTemporaryStartPoint(Point temporaryStartPoint){ this.temporaryStartPoint =  applicationState.getTemporaryStartPoint(); }

    public void setTemporaryEndPoint(Point temporaryEndPoint){ this.temporaryEndPoint = applicationState.getTemporaryEndPoint(); }

    public Point getTemporaryStartPoint(){ return temporaryStartPoint; }

    public Point getTemporaryEndPoint(){ return temporaryEndPoint; }

    public void setHeight(int height) { this.height =  applicationState.getEndPoint().getY() - applicationState.getStartPoint().getY(); }

    public void setWidth(int width) { this.width = applicationState.getEndPoint().getX() - applicationState.getStartPoint().getX(); }

    public int getWidth() { return this.width; }

    public int getHeight() { return this.height;}
}