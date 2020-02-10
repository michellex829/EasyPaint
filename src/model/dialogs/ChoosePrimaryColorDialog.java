package model.dialogs;

import model.ShapeColor;
import model.interfaces.IApplicationState;
import view.interfaces.IDialogChoice;

import java.io.Serializable;

public class ChoosePrimaryColorDialog implements IDialogChoice<ShapeColor>, Serializable {

    private final IApplicationState applicationState;

    public ChoosePrimaryColorDialog(IApplicationState applicationState) {
        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Primary Color";
    }

    @Override
    public String getDialogText() {
        return "Select a primary color from the menu below:";
    }

    @Override
    public ShapeColor[] getDialogOptions() {
        return ShapeColor.values();
    }

    @Override
    public ShapeColor getCurrentSelection() {
        return applicationState.getActivePrimaryColor();
    }
}
