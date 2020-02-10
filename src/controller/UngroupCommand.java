package controller;

import model.interfaces.IShapeListSubject;
import view.CompositeObject;
import view.interfaces.IShapeDrawer;
import java.util.ArrayList;

public class UngroupCommand implements ICommand, IUndoRedo {
    private IShapeListSubject shapeList;
    private final ArrayList<IShapeDrawer> temporaryGroupShapeList = new ArrayList<IShapeDrawer>();

    public UngroupCommand(IShapeListSubject shapeList) {
        this.shapeList = shapeList;
    }

    public void run() {
        ungroupShapeGroup();
        CommandHistory.add(this);
    }

    public void ungroupShapeGroup() {
        for (IShapeDrawer shape : shapeList.getSelectedShapeList()) {
            if (shape instanceof CompositeObject) {
            shapeList.removeShapeFromMasterShapeList(shape);
            temporaryGroupShapeList.add(shape);
            for (IShapeDrawer child: ((CompositeObject) shape).getChildren()) { shapeList.addToMasterShapeList(child); }
            }
        }
    }
    @Override
    public void undo() {
        for (IShapeDrawer shape: temporaryGroupShapeList) {
            shapeList.addToMasterShapeList(shape);
            for (IShapeDrawer child: ((CompositeObject) shape).getChildren()) {
                shapeList.removeShapeFromMasterShapeList(child);
            }
        }
        temporaryGroupShapeList.clear();
    }

    @Override
    public void redo() { ungroupShapeGroup(); }
}

