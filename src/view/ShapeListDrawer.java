package view;

import java.awt.*;
import model.interfaces.IShapeListObserver;
import model.interfaces.IShapeListSubject;
import view.gui.PaintCanvas;
import view.interfaces.IShapeDrawer;

public class ShapeListDrawer implements IShapeListObserver {
    private IShapeListSubject shapeList;
    private PaintCanvas paintCanvas;

    public ShapeListDrawer(IShapeListSubject shapeList, PaintCanvas paintCanvas) {
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
        shapeList.registerObserver(this);
    }

    public void update() {
    	Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.WHITE);
        graphics2d .fillRect(0, 0, paintCanvas.getWidth(), paintCanvas.getHeight());

    	for (IShapeDrawer aShape: shapeList.getMasterShapeList()) {
            aShape.drawAShape();
            if (shapeList.getSelectedShapeList().contains(aShape)) {
                aShape.drawSelectedOutline();
            }
    	}
    }
}
