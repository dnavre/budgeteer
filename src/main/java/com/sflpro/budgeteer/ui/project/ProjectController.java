package com.sflpro.budgeteer.ui.project;

import com.sflpro.budgeteer.ui.ViewFactory;
import com.sflpro.budgeteer.ui.launcher.LauncherController;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ProjectController {

    @FXML
    private BorderPane mainBorderPane;

    @Autowired
    public ProjectController(final ApplicationContext ctx) {
    }

    public static void show(final ApplicationContext ctx, String projectName) {
        ViewFactory viewFactory = ctx.getBean(ViewFactory.class);

        Scene projectScene = new Scene(viewFactory.getProjectView());

        final Stage stage = new Stage();
        stage.setScene(projectScene);
        stage.setTitle("Budgeteer: " + projectName);
        stage.centerOnScreen();
        stage.show();

        stage.setOnCloseRequest(event -> {
            LauncherController.showLauncherWindow(ctx);
        });
    }
}
