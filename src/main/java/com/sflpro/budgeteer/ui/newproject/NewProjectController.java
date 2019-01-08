package com.sflpro.budgeteer.ui.newproject;

import com.sflpro.budgeteer.model.Project;
import com.sflpro.budgeteer.ui.UIHolder;
import com.sflpro.budgeteer.ui.ViewFactory;
import com.sflpro.budgeteer.ui.project.ProjectController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class NewProjectController {

    private final ApplicationContext ctx;
    private final String defaultPathPrefix;

    private Stage previousStage;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private TextField name;

    @FXML
    public TextField path;

    @Autowired
    public NewProjectController(final ApplicationContext ctx,
                                @Value("${budgeteer.project.defaultPathPrefix}") final String defaultPathPrefix) {
        this.ctx = ctx;
        this.defaultPathPrefix = defaultPathPrefix;
    }

    public void setPreviousStage(Stage previousStage) {
        this.previousStage = previousStage;
    }

    public static void showNewProjectDialog(final ApplicationContext ctx, final Stage previousStage) {
        ViewFactory viewFactory = ctx.getBean(ViewFactory.class);

        UIHolder<BorderPane, NewProjectController> uiHolder = viewFactory.getNewProjectView();
        Scene newProjectScene = new Scene(uiHolder.getScene());
        uiHolder.getController().setPreviousStage(previousStage);

        final Stage stage = new Stage();
        stage.setScene(newProjectScene);
        stage.setTitle("New project");
        stage.centerOnScreen();
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.show();

        stage.setOnCloseRequest(event -> {
            if(previousStage.isShowing()) {
                previousStage.requestFocus();
            }
        });
    }

    public void createProject(ActionEvent actionEvent) {
        Project newProject = new Project();

        newProject.setName(name.getText());
        newProject.setPath(path.getText());

        ProjectController.show(ctx, newProject);

        previousStage.close();
        closeWindow();
    }

    public void closeWindow(ActionEvent actionEvent) {
        closeWindow();
    }

    private void closeWindow() {
        ((Stage)mainBorderPane.getScene().getWindow()).close();
    }
}
