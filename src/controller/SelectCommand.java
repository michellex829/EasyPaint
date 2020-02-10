package controller;

import model.interfaces.IApplicationState;
import model.interfaces.IShapeListSubject;
import view.gui.Point;
import view.interfaces.IShapeDrawer;
import java.awt.*;

public class SelectCommand implements ICommand {
    private IShapeListSubject shapeList;
    private Point startPoint;
    private Point endPoint;

    public SelectCommand(IApplicationState applicationState, IShapeListSubject shapeList) {
        this.shapeList = shapeList;
        this.startPoint = applicationState.getStartPoint();
        this.endPoint = applicationState.getEndPoint();
    }

    public void run() {
        shapeList.clearSelectedShapeList();
        Rectangle selectBox = new Rectangle(startPoint.getX(), startPoint.getY(), endPoint.getX() - startPoint.getX(), endPoint.getY() - startPoint.getY());
        for (IShapeDrawer shape : shapeList.getMasterShapeList()) {
            Rectangle boundingBox = new Rectangle(shape.getStartPoint().getX(), shape.getStartPoint().getY(), shape.getWidth(), shape.getHeight());
            if (selectBox.x < boundingBox.x + boundingBox.width && selectBox.x + selectBox.width > boundingBox.x && selectBox.y < boundingBox.y + boundingBox.height && selectBox.y + selectBox.height > boundingBox.y) {
                { shapeList.addToSelectedShapeList(shape); }
            }
        }
    }
}