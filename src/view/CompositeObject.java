package view;

import view.interfaces.IShapeDrawer;
import java.util.ArrayList;

public abstract class CompositeObject implements IShapeDrawer {

    public void addChild(IShapeDrawer shapeDrawer) {
        throw new UnsupportedOperationException();
    }

    public void drawAShape() {
        throw new UnsupportedOperationException();
    }

    public ArrayList<IShapeDrawer> getChildren()  { throw new UnsupportedOperationException(); }

    public IShapeDrawer cloneShapes(IShapeDrawer shape) { throw new UnsupportedOperationException(); }
}
