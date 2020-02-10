package view.gui;
import controller.CreateCommand;
import controller.SelectCommand;
import controller.MoveCommand;
import model.ShapeGenerator;
import model.interfaces.IShapeListSubject;
import model.interfaces.IApplicationState;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.StartAndEndPointMode;

public class MouseHandler extends MouseAdapter {
    private Point temporaryStartPoint;
    private Point temporaryEndPoint;
    private Point startPoint;
    private Point endPoint;
    private IApplicationState applicationState;
    private IShapeListSubject shapeList;
    private ShapeGenerator shapeGenerator;
    private PaintCanvas paintCanvas;

    public MouseHandler(IApplicationState applicationState, IShapeListSubject shapeList, ShapeGenerator shapeGenerator, PaintCanvas paintCanvas) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.shapeGenerator = shapeGenerator;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void mousePressed(MouseEvent e) { temporaryStartPoint = new Point(e.getX(), e.getY()); }

    @Override
    public void mouseReleased(MouseEvent e) {
        temporaryEndPoint = new Point(e.getX(), e.getY());
        int x = Math.min(temporaryStartPoint.getX(), temporaryEndPoint.getX());
        int y = Math.min(temporaryStartPoint.getY(), temporaryEndPoint.getY());
        startPoint = new Point(x, y);
        int a = Math.max(temporaryStartPoint.getX(), temporaryEndPoint.getX());
        int b = Math.max(temporaryStartPoint.getY(), temporaryEndPoint.getY());
        endPoint = new Point(a, b);

        applicationState.setStartPoint(startPoint);
        applicationState.setEndPoint(endPoint);
        applicationState.setTemporaryStartPoint(temporaryStartPoint);
        applicationState.setTemporaryEndPoint(temporaryEndPoint);
        StartAndEndPointMode mouseMode = applicationState.getActiveStartAndEndPointMode();

        if (mouseMode.equals(StartAndEndPointMode.DRAW)) {
            CreateCommand createShape = new CreateCommand(applicationState, shapeList, shapeGenerator, paintCanvas);
            createShape.run();
        } else if (mouseMode.equals(StartAndEndPointMode.SELECT)) {
            SelectCommand selectShape = new SelectCommand(applicationState, shapeList);
            selectShape.run();
        } else if (mouseMode.equals(StartAndEndPointMode.MOVE)) {
            MoveCommand moveShape = new MoveCommand(applicationState, shapeList);
            moveShape.run();
        }
    }
}
