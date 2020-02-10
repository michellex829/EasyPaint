package model;

import view.ShapeFactory;
import view.interfaces.IShapeDrawer;
import java.awt.*;
import java.security.InvalidParameterException;

public abstract class AbstractShapeClass implements IShapeDrawer {
    private ShapeShadingType shapeShadingType;
    private Color primaryColor;
    private Color secondaryColor;
    private ShapeFactory shapeFactory = new ShapeFactory();
    private IShapeDrawer newShape;

    public AbstractShapeClass(ShapeGenerator shapeGenerator) {
        this.shapeShadingType = shapeGenerator.getShapeShadingType();
        this.primaryColor = ColorMap.getColor(shapeGenerator.getActivePrimaryColor());
        this.secondaryColor = ColorMap.getColor(shapeGenerator.getActiveSecondaryColor());
    }

    public void drawAShape() {
        if (shapeShadingType.equals(ShapeShadingType.FILLED_IN)) {
            drawFilledInShading(primaryColor);
        } else if (shapeShadingType.equals(ShapeShadingType.OUTLINE)) {
            drawOutlineShading(primaryColor);
        } else if (shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
            drawOutlineFilledInShading(primaryColor, secondaryColor);
        }
    }

    public IShapeDrawer cloneShapes(IShapeDrawer shape) {
        ShapeGenerator oldShapeGenerator = shape.getShapeGenerator();
        ShapeGenerator newShapeGenerator = shapeFactory.dupeShapeGenerator(oldShapeGenerator);
        ShapeType shapeType = oldShapeGenerator.getShapeType();
        if (shapeType.equals(ShapeType.RECTANGLE))     newShape = ShapeFactory.createRectangle(newShapeGenerator);
        else if (shapeType.equals(ShapeType.ELLIPSE))  newShape = ShapeFactory.createEllipse(newShapeGenerator);
        else if (shapeType.equals(ShapeType.TRIANGLE)) newShape = ShapeFactory.createTriangle(newShapeGenerator);
        else{ throw new InvalidParameterException("Parameter must be the correct shape"); }
        newShape.movedX(100);
        newShape.movedY(150);
        return newShape;
    }
}
