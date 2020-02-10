package model.interfaces;

import view.interfaces.IShapeDrawer;
import java.util.ArrayList;

public interface IShapeListSubject {
    void addToMasterShapeList(IShapeDrawer shape);
    void addToSelectedShapeList(IShapeDrawer shape);
    void addToCopiedShapeList(IShapeDrawer shape);
    void removeShapeFromMasterShapeList(IShapeDrawer shape);
    void clearSelectedShapeList();
    void clearCopiedShapeList();
    ArrayList<IShapeDrawer> getMasterShapeList();
    ArrayList<IShapeDrawer> getSelectedShapeList();
    ArrayList<IShapeDrawer> getCopiedShapeList();
    void registerObserver(IShapeListObserver observer);
    void removeObserver(IShapeListObserver observer);
    void notifyObserver();
}
