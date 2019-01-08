package com.sflpro.budgeteer.ui;

import com.sflpro.budgeteer.ui.launcher.LauncherController;
import com.sflpro.budgeteer.ui.newproject.NewProjectController;
import com.sflpro.budgeteer.ui.project.ProjectController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ViewFactory {

    private final ApplicationContext ctx;

    @Autowired
    public ViewFactory(final ApplicationContext ctx) throws IOException {
        this.ctx = ctx;
    }


    public UIHolder<BorderPane, LauncherController> getLauncherView() {
        return constructScene("launcher/fxml/launcher.fxml");
    }

    public UIHolder<BorderPane, ProjectController> getProjectView() {
        return constructScene("project/fxml/project.fxml");
    }

    public UIHolder<BorderPane, NewProjectController> getNewProjectView() {
        return constructScene("newproject/fxml/newproject.fxml");
    }

    private <T extends Parent, E> UIHolder<T, E> constructScene(final String path) {
        T scene;
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(ctx::getBean);
        try {
            scene = loader.load(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        return new UIHolder<>(scene, loader.getController());
    }
}
