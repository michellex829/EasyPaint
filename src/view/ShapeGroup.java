package view;

import model.ShapeGenerator;
import view.gui.PaintCanvas;
import view.gui.Point;
import view.interfaces.IShapeDrawer;
import java.awt.*;
import java.util.ArrayList;

public class ShapeGroup extends CompositeObject {
    private ArrayList<IShapeDrawer> children;
    private PaintCanvas paintCanvas;
    private Point groupStartPoint;
    private Point groupEndPoint;
    private int width;
    private int height;
    private IShapeDrawer newGroupSingleShape;
    private ShapeGroup groupObject;

    public ShapeGroup(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
        children = new ArrayList<IShapeDrawer>();
    }

    public void addChild(IShapeDrawer shapeDrawer) { children.add(shapeDrawer); }

    public void drawAShape() {
        for (IShapeDrawer child: children) { child.drawAShape(); }
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(Color.MAGENTA);
        graphics2d.drawRect(this.groupStartPoint.getX() - 12, this.groupStartPoint.getY() - 12, width + 24, height + 24);
    }

    public void drawSelectedOutline() {
        for (IShapeDrawer child: children) { child.drawSelectedOutline(); }
    }

    public ArrayList<IShapeDrawer> getChildren() { return children;}

    public IShapeDrawer cloneShapes(IShapeDrawer groupShape) {
        groupObject = new ShapeGroup(paintCanvas);
        Point newStartPoint = new Point(groupShape.getStartPoint().getX() + 100, groupShape.getStartPoint().getY() + 150);
        Point newEndPoint = new Point(groupShape.getEndPoint().getX() + 100, groupShape.getEndPoint().getY() + 150);
        groupObject.setHeight(groupShape.getHeight());
        groupObject.setWidth(groupShape.getWidth());
        for (IShapeDrawer child : ((ShapeGroup) groupShape).getChildren()) {
            newGroupSingleShape = child.cloneShapes(child);
            groupObject.addChild(newGroupSingleShape);
        }
        groupObject.setStartPoint(newStartPoint);
        groupObject.setEndPoint(newEndPoint);
        return groupObject;
    }

    public int getWidth() {
        width = groupEndPoint.getX() - groupStartPoint.getX();
        return width;
    }

    public int getHeight() {
        height = groupEndPoint.getY() - groupStartPoint.getY();
        return height;
    }

    public Point getStartPoint() { return groupStartPoint; }

    public Point getEndPoint() { return groupEndPoint; }

    public void setStartPoint(Point groupStartPoint) { this.groupStartPoint = groupStartPoint;}

    public void setEndPoint(Point groupEndPoint) { this.groupEndPoint = groupEndPoint;}

    public void setWidth(int width) { this.width = width; }

    public void setHeight(int height) { this.height = height;}

    public Point getTemporaryStartPoint() { return null;}

    public Point getTemporaryEndPoint() { return null;}

    public void movedX(int dx) {
        for (IShapeDrawer child: children) { child.movedX(dx); }
        this.groupStartPoint.setX(groupStartPoint.getX() + dx);
        this.groupEndPoint.setX(groupEndPoint.getX() + dx);
    }

    public void movedY(int dy) {
        for (IShapeDrawer child: children) { child.movedY(dy); }
        this.groupStartPoint.setY(groupStartPoint.getY() + dy);
        this.groupEndPoint.setY(groupEndPoint.getY() + dy);
    }

    public void drawFilledInShading(Color primaryColor) {}

    public void drawOutlineShading(Color primaryColor) {}

    public void drawOutlineFilledInShading(Color primaryColor, Color secondaryColor ) {}

    public ShapeGenerator getShapeGenerator()  { throw new UnsupportedOperationException(); }
}
