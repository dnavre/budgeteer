package com.sflpro.budgeteer.ui.launcher;

import com.sflpro.budgeteer.BudgeteerShutdownHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LauncherController {

    private final BudgeteerShutdownHandler shutdownHandler;

    @Autowired
    public LauncherController(final BudgeteerShutdownHandler shutdownHandler,
                              final ApplicationContext ctx) throws IOException {
        this.shutdownHandler = shutdownHandler;
    }

    public void quit(ActionEvent actionEvent) {
        this.shutdownHandler.commenceShutdown();
    }
}
