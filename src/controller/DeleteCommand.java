package controller;

import model.interfaces.IShapeListSubject;
import view.interfaces.IShapeDrawer;

public class DeleteCommand implements ICommand, IUndoRedo {
    private IShapeListSubject shapeList;

    public DeleteCommand(IShapeListSubject shapeList) {
        this.shapeList = shapeList;
    }

    public void run() {
        deleteSelectedShapes();
        CommandHistory.add(this);
    }

    public void deleteSelectedShapes() {
        for (IShapeDrawer selectedShape : shapeList.getSelectedShapeList()){
            shapeList.removeShapeFromMasterShapeList(selectedShape);
        }
    }

    @Override
    public void undo() {
        for (IShapeDrawer selectedShape : shapeList.getSelectedShapeList()){
            shapeList.addToMasterShapeList(selectedShape);
        }
    }

    @Override
    public void redo() { deleteSelectedShapes(); }
}
