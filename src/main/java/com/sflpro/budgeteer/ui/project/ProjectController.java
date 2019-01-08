package com.sflpro.budgeteer.ui.project;

import com.sflpro.budgeteer.model.Project;
import com.sflpro.budgeteer.ui.UIHolder;
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

    public static void show(final ApplicationContext ctx, Project project) {
        ViewFactory viewFactory = ctx.getBean(ViewFactory.class);

        UIHolder<BorderPane, ProjectController> uiHolder = viewFactory.getProjectView();
        Scene projectScene = new Scene(uiHolder.getScene());

        final Stage stage = new Stage();
        stage.setScene(projectScene);
        stage.setTitle("Budgeteer: " + project.getName());
        stage.centerOnScreen();
        stage.show();

        stage.setOnCloseRequest(event -> {
            LauncherController.showLauncherWindow(ctx);
        });
    }
}
