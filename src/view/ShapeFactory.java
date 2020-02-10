package view;

import model.AbstractShapeClass;
import model.ShapeGenerator;
import model.ShapeGeneratorDuplicator;

public class ShapeFactory {
    public static AbstractShapeClass createRectangle(ShapeGenerator shapeGenerator) {
        return new RectangleStrategy(shapeGenerator);
    }

    public static AbstractShapeClass createEllipse(ShapeGenerator shapeGenerator) {
        return new EllipseStrategy(shapeGenerator);
    }

    public static AbstractShapeClass createTriangle(ShapeGenerator shapeGenerator) {
        return new TriangleStrategy(shapeGenerator);
    }

    public ShapeGenerator dupeShapeGenerator(ShapeGenerator oldShapeGenerator) {
        ShapeGeneratorDuplicator shapeGeneratorDuplicator = new ShapeGeneratorDuplicator(oldShapeGenerator.getPaintCanvas(), oldShapeGenerator.getStartPoint(), oldShapeGenerator.getEndPoint(), oldShapeGenerator.getTemporaryStartPoint(), oldShapeGenerator.getTemporaryEndPoint(), oldShapeGenerator.getHeight(), oldShapeGenerator.getWidth(), oldShapeGenerator.getShapeType(), oldShapeGenerator.getActivePrimaryColor(), oldShapeGenerator.getActiveSecondaryColor(), oldShapeGenerator.getShapeShadingType());
        return shapeGeneratorDuplicator;
    }
}
