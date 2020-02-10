package model.interfaces;

import view.gui.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.StartAndEndPointMode;

public interface IApplicationState {
    void setStartPoint(Point startPoint);

    void setEndPoint(Point endPoint);

    Point getStartPoint();

    Point getEndPoint();

    void setTemporaryStartPoint(Point temporaryStartPoint);

    void setTemporaryEndPoint(Point temporaryEndPoint);

    Point getTemporaryStartPoint();

    Point getTemporaryEndPoint();

    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();

    ShapeType getActiveShapeType();

    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    ShapeShadingType getActiveShapeShadingType();

    StartAndEndPointMode getActiveStartAndEndPointMode();
}
