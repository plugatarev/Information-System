package app.gui.controllers.interfaces;

import app.model.Entity;
import javafx.stage.Stage;

public interface ContextWindowBuilder<E extends Entity> {
    Stage buildWindow(E entity);
}