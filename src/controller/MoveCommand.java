package controller;

import model.interfaces.IApplicationState;
import model.interfaces.IShapeListSubject;
import view.interfaces.IShapeDrawer;

public class MoveCommand implements ICommand, IUndoRedo {
    private final IApplicationState applicationState;
    private IShapeListSubject shapeList;
    int offsetX;
    int offsetY;

    public MoveCommand(IApplicationState applicationState, IShapeListSubject shapeList) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        offsetX = applicationState.getTemporaryEndPoint().getX() - applicationState.getTemporaryStartPoint().getX();
        offsetY = applicationState.getTemporaryEndPoint().getY() - applicationState.getTemporaryStartPoint().getY();
    }

    public void run() {
        moveShapes();
        CommandHistory.add(this);
    }

    public void moveShapes() {
        IShapeDrawer oldShape;
        for (IShapeDrawer selectedShape : shapeList.getSelectedShapeList()) {
            oldShape = selectedShape;
            selectedShape.movedX(offsetX);
            selectedShape.movedY(offsetY);
            shapeList.addToMasterShapeList(selectedShape);
            shapeList.removeShapeFromMasterShapeList(oldShape);
        }
    }

    public void undo() {
        IShapeDrawer oldShape;
        for (IShapeDrawer selectedShape : shapeList.getSelectedShapeList()) {
            oldShape = selectedShape;
            selectedShape.movedX((-1)*offsetX);
            selectedShape.movedY((-1)*offsetY);
            shapeList.addToMasterShapeList(selectedShape);
            shapeList.removeShapeFromMasterShapeList(oldShape);
        }
    }

    @Override
    public void redo() { moveShapes(); }
}

