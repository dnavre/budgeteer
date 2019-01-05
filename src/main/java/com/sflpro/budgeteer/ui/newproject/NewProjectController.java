package com.sflpro.budgeteer.ui.newproject;

import com.sflpro.budgeteer.ui.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component

public class NewProjectController {

    @FXML
    private BorderPane mainBorderPane;

    public static void showNewProjectDialog(final ApplicationContext ctx, final Stage previousStage) {
        ViewFactory viewFactory = ctx.getBean(ViewFactory.class);

        Scene newProjectScene = new Scene(viewFactory.getNewProjectView());

        final Stage stage = new Stage();
        stage.setScene(newProjectScene);
        stage.setTitle("New project");
        stage.centerOnScreen();
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.show();

        stage.setOnCloseRequest(event -> {
            previousStage.requestFocus();
        });
    }

    public void createProject(ActionEvent actionEvent) {

    }

    public void cancel(ActionEvent actionEvent) {
        ((Stage)mainBorderPane.getScene().getWindow()).close();
    }
}
