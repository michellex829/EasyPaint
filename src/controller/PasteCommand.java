package controller;

import model.interfaces.IShapeListSubject;
import view.interfaces.IShapeDrawer;
import java.util.ArrayList;

public class PasteCommand implements ICommand, IUndoRedo {
    IShapeListSubject shapeList;
    IShapeDrawer newShape;
    private final ArrayList<IShapeDrawer> temporaryPastedShapeList = new ArrayList<IShapeDrawer>();

    public PasteCommand(IShapeListSubject shapeList) { this.shapeList = shapeList; }

    public void run() {
        pasteSelectedShapes();
        CommandHistory.add(this);
}

    public void pasteSelectedShapes() {
        temporaryPastedShapeList.clear();
        for (IShapeDrawer shape : shapeList.getCopiedShapeList()) {
            newShape = shape.cloneShapes(shape);
            shapeList.addToMasterShapeList(newShape);
            temporaryPastedShapeList.add(newShape);
        }
        shapeList.getCopiedShapeList().clear();
        for (IShapeDrawer shape : temporaryPastedShapeList) { shapeList.addToCopiedShapeList(shape); }
    }


    public void undo() {
        for (IShapeDrawer shape : temporaryPastedShapeList) {
            shapeList.removeShapeFromMasterShapeList(shape);
        }
    }

    @Override
    public void redo() {
        for (IShapeDrawer shape : temporaryPastedShapeList) { shapeList.addToMasterShapeList(shape); }
    }
}
