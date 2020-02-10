package model;
import java.util.ArrayList;
import model.interfaces.IShapeListObserver;
import model.interfaces.IShapeListSubject;
import view.interfaces.IShapeDrawer;

public class ShapeListSubject implements IShapeListSubject {
    private ArrayList<IShapeDrawer> masterShapeList;
    private ArrayList<IShapeDrawer> selectedShapeList;
    public ArrayList<IShapeDrawer> copiedShapeList;
    private final ArrayList<IShapeListObserver> observers;

    public ShapeListSubject() {
        masterShapeList = new ArrayList<IShapeDrawer>();
        observers = new ArrayList<IShapeListObserver>();
        selectedShapeList = new ArrayList<IShapeDrawer>();
        copiedShapeList =  new ArrayList<IShapeDrawer>();
    }

    public void addToMasterShapeList(IShapeDrawer shape) {
        masterShapeList.add(shape);
        notifyObserver();
    }

    public void addToSelectedShapeList(IShapeDrawer shape) {
        selectedShapeList.add(shape);
        notifyObserver();
    }

    public void addToCopiedShapeList(IShapeDrawer shape) {
        copiedShapeList.add(shape);
    }

    public void removeShapeFromMasterShapeList(IShapeDrawer shape) {
        masterShapeList.remove(shape);
        notifyObserver();
    }

    public void clearSelectedShapeList() {
        selectedShapeList = new ArrayList<IShapeDrawer>();
        notifyObserver();
    }

    public void clearCopiedShapeList() {
        copiedShapeList =  new ArrayList<IShapeDrawer>();
    }

    public ArrayList<IShapeDrawer> getMasterShapeList() { return masterShapeList; }

    public ArrayList<IShapeDrawer> getSelectedShapeList() { return selectedShapeList; }

    public ArrayList<IShapeDrawer> getCopiedShapeList() { return copiedShapeList; }

    public void registerObserver(IShapeListObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IShapeListObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (IShapeListObserver observer: observers) { observer.update(); }
    }
}