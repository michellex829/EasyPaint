package model.dialogs;

import model.ShapeShadingType;
import model.interfaces.IApplicationState;
import view.interfaces.IDialogChoice;

import java.io.Serializable;

public class ChooseShadingTypeDialog implements IDialogChoice<ShapeShadingType>, Serializable {
    private final IApplicationState applicationState;

    public ChooseShadingTypeDialog(IApplicationState applicationState) {

        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Shading Type";
    }

    @Override
    public String getDialogText() {
        return "Select a shading type from the menu below:";
    }

    @Override
    public ShapeShadingType[] getDialogOptions() {
        return ShapeShadingType.values();
    }

    @Override
    public ShapeShadingType getCurrentSelection() {
        return applicationState.getActiveShapeShadingType();
    }
}
