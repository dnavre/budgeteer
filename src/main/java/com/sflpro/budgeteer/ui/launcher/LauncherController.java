package com.sflpro.budgeteer.ui.launcher;

import com.sflpro.budgeteer.BudgeteerShutdownHandler;
import com.sflpro.budgeteer.BugeteerConfiguration;
import com.sflpro.budgeteer.ui.ViewFactory;
import com.sflpro.budgeteer.ui.newproject.NewProjectController;
import com.sflpro.budgeteer.ui.project.ProjectController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class LauncherController {

    private final BudgeteerShutdownHandler shutdownHandler;
    private final ApplicationContext ctx;

    @FXML
    private BorderPane mainBorderPane;

    @Autowired
    public LauncherController(final BudgeteerShutdownHandler shutdownHandler,
                              final ApplicationContext ctx) {
        this.shutdownHandler = shutdownHandler;
        this.ctx = ctx;
    }

    public void quit(ActionEvent actionEvent) {
        this.shutdownHandler.commenceShutdown();
    }

    public void showNewProjectDialog(ActionEvent actionEvent) {
        NewProjectController.showNewProjectDialog(ctx, (Stage) mainBorderPane.getScene().getWindow());
    }

    public static void showLauncherWindow(final ApplicationContext ctx) {
        showLauncherWindow(ctx, new Stage());
    }

    public static void showLauncherWindow(final ApplicationContext ctx, Stage stage) {
        ViewFactory viewFactory = ctx.getBean(ViewFactory.class);
        BugeteerConfiguration configuration = ctx.getBean(BugeteerConfiguration.class);

        Scene launcher = new Scene(viewFactory.getLauncherView());
        launcher.getStylesheets().add(configuration.getMainCssPath());

        stage.setScene(launcher);
        stage.setTitle("Budgeteer: Project selection");
        stage.setResizable(false);
        stage.setOnCloseRequest(e -> {
            ctx.getBean(BudgeteerShutdownHandler.class).commenceShutdown();
        });
        stage.centerOnScreen();
        stage.show();
    }

    public void loadProject(ActionEvent actionEvent) {
        ((Stage)mainBorderPane.getScene().getWindow()).close();
        ProjectController.show(ctx, "aaa");
    }
}
