package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.AbstractShapeClass;
import model.ShapeListSubject;
import model.ShapeGenerator;
import model.interfaces.IShapeListSubject;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.MouseHandler;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;
import view.ShapeListDrawer;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        ShapeGenerator shapeGenerator = new ShapeGenerator();
        IShapeListSubject shapeList = new ShapeListSubject();
        PaintCanvas paintCanvas = new PaintCanvas();
        ShapeListDrawer shapeListDrawer = new ShapeListDrawer(shapeList, paintCanvas);
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        MouseHandler pressReleaseHandler = new MouseHandler(appState, shapeList, shapeGenerator, paintCanvas);
        paintCanvas.setCursor((new Cursor(Cursor.HAND_CURSOR)));
        IJPaintController controller = new JPaintController(uiModule, appState, shapeList, paintCanvas);
        paintCanvas.addMouseListener(pressReleaseHandler);
        controller.setup();
    }
}
