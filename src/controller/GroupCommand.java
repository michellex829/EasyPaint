package controller;

import model.interfaces.IShapeListSubject;
import view.CompositeObject;
import view.interfaces.IShapeDrawer;
import view.ShapeGroup;
import view.gui.PaintCanvas;
import view.gui.Point;
import java.util.ArrayList;
import java.util.Collections;

public class GroupCommand implements ICommand, IUndoRedo {
    private IShapeListSubject shapeList;
    private PaintCanvas paintCanvas;
    private CompositeObject groupObject;
    private Point groupStartPoint;
    private Point groupEndPoint;
    private int width;
    private int height;
    private ArrayList<IShapeDrawer> temporaryGroupShapeList = new ArrayList<IShapeDrawer>();

    public GroupCommand(IShapeListSubject shapeList, PaintCanvas paintCanvas) {
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
        this.groupStartPoint = getStartPoint();
        this.groupEndPoint = getEndPoint();
    }

    public void run() {
        groupShapes();
        CommandHistory.add(this);
    }

    public void groupShapes() {
        groupObject = new ShapeGroup(paintCanvas);
        for (IShapeDrawer shape : shapeList.getSelectedShapeList()) {
            groupObject.addChild(shape);
            shapeList.removeShapeFromMasterShapeList(shape);
        }
        groupObject.setStartPoint(groupStartPoint);
        groupObject.setEndPoint(groupEndPoint);
        groupObject.setHeight(getHeight());
        groupObject.setWidth(getWidth());
        groupObject.drawAShape();
        shapeList.addToMasterShapeList(groupObject);
        temporaryGroupShapeList.add(groupObject);
    }

    public Point getStartPoint() {
        ArrayList<Integer> coordinatesX =  new ArrayList<Integer>();
        ArrayList<Integer> coordinatesY =  new ArrayList<Integer>();
        int X;
        int Y;
        for (IShapeDrawer child : shapeList.getSelectedShapeList()) {
            X = child.getStartPoint().getX();
            coordinatesX.add(X);
            Y = child.getStartPoint().getY();
            coordinatesY.add(Y);
        }
        int minX = Collections.min(coordinatesX);
        int minY = Collections.min(coordinatesY);
        Point point = new Point(minX, minY);
        return point;
    }

    public Point getEndPoint() {
        ArrayList<Integer> coordinatesX =  new ArrayList<Integer>();
        ArrayList<Integer> coordinatesY =  new ArrayList<Integer>();
        int X;
        int Y;
        for (IShapeDrawer child : shapeList.getSelectedShapeList()) {
            X = child.getEndPoint().getX();
            coordinatesX.add(X);
            Y = child.getEndPoint().getY();
            coordinatesY.add(Y);
        }
        int maxX = Collections.max(coordinatesX);
        int maxY = Collections.max(coordinatesY);
        Point point = new Point(maxX, maxY);
        return point;
    }

    public int getWidth() {
        this.width = groupEndPoint.getX() - groupStartPoint.getX();
        return width;
    }

    public int getHeight() {
        this.height = groupEndPoint.getY() - groupStartPoint.getY();
        return height;
    }

    @Override
    public void undo() {
        for (IShapeDrawer child : groupObject.getChildren()) { shapeList.addToMasterShapeList(child); }
        for (IShapeDrawer group : temporaryGroupShapeList) { shapeList.removeShapeFromMasterShapeList(group); }
    }

    @Override
    public void redo() {
        for (IShapeDrawer child : groupObject.getChildren()) { shapeList.removeShapeFromMasterShapeList(child); }
        for (IShapeDrawer group : temporaryGroupShapeList) { shapeList.addToMasterShapeList(group); }
    }
}
