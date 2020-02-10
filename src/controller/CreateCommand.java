package controller;
import model.*;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeListSubject;
import view.ShapeFactory;
import view.gui.PaintCanvas;
import view.interfaces.IShapeDrawer;
import java.security.InvalidParameterException;

public class CreateCommand implements ICommand, IUndoRedo {
    private IApplicationState applicationState;
    private ShapeFactory shapeFactory = new ShapeFactory();
    private ShapeGenerator shapeGenerator;
    private IShapeListSubject shapeList;
    private PaintCanvas paintCanvas;
    private IShapeDrawer newShape;

    public CreateCommand(IApplicationState applicationState, IShapeListSubject shapeList, ShapeGenerator shapeGenerator, PaintCanvas paintCanvas) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.shapeGenerator = shapeGenerator;
        this.paintCanvas = paintCanvas;
    }

    public void run() {
        shapeGenerator = new ShapeGenerator().shapeGenerator(applicationState);
        shapeGenerator.setPaintCanvas(paintCanvas);
        if (shapeGenerator.getShapeType().equals(ShapeType.RECTANGLE))     newShape = ShapeFactory.createRectangle(shapeGenerator);
        else if (shapeGenerator.getShapeType().equals(ShapeType.ELLIPSE))  newShape = ShapeFactory.createEllipse(shapeGenerator);
        else if (shapeGenerator.getShapeType().equals(ShapeType.TRIANGLE)) newShape = ShapeFactory.createTriangle(shapeGenerator);
        else{ throw new InvalidParameterException("Parameter must be the correct shape"); }
        shapeList.addToMasterShapeList(newShape);

        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        shapeList.removeShapeFromMasterShapeList(newShape);
    }

    @Override
    public void redo() {
        shapeList.addToMasterShapeList(newShape);
    }
}

