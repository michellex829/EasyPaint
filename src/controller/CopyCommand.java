package controller;

import model.interfaces.IShapeListSubject;
import view.interfaces.IShapeDrawer;

public class CopyCommand implements ICommand{
    private IShapeListSubject shapeList;

    public CopyCommand(IShapeListSubject shapeList) {
        this.shapeList = shapeList;
    }

    public void run() {
        shapeList.clearCopiedShapeList();
        for (IShapeDrawer selectedShape : shapeList.getSelectedShapeList()) {
            shapeList.addToCopiedShapeList(selectedShape);
        }
    }
}
