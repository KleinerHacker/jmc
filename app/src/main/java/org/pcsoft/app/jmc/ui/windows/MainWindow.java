package org.pcsoft.app.jmc.ui.windows;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.pcsoft.framework.jfex.mvvm.Fxml;

public class MainWindow extends Stage {

    private final MainWindowViewModel viewModel;
    private final MainWindowView viewController;

    public MainWindow() {
        setTitle("Java Media Center");

        final var tuple = Fxml.from(MainWindowView.class).load();
        setScene(new Scene(tuple.getView(), 1024, 800));

        viewModel = tuple.getViewModel();
        viewController = tuple.getViewController();
    }
}
