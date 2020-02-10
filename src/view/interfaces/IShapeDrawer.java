package view.interfaces;

import model.ShapeGenerator;
import view.gui.Point;
import java.awt.*;

public interface IShapeDrawer  {

    void drawAShape();

    void drawFilledInShading(Color primaryColor);

    void drawOutlineShading(Color primaryColor);

    void drawOutlineFilledInShading(Color primaryColor, Color secondaryColor );

    void drawSelectedOutline();

    IShapeDrawer cloneShapes(IShapeDrawer shape);

    ShapeGenerator getShapeGenerator();

    int getWidth();

    int getHeight();

    Point getStartPoint();

    Point getTemporaryStartPoint();

    Point getTemporaryEndPoint();

    void movedX(int dx);

    void movedY(int dy);

    Point getEndPoint();

    void setWidth(int width);

    void setHeight(int height);

    void setEndPoint(Point endPoint);

    void setStartPoint(Point startPoint);
}
