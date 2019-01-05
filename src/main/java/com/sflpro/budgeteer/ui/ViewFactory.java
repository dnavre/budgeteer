package com.sflpro.budgeteer.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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


    public Parent getLauncherView() {
        return constructScene("launcher/fxml/launcher.fxml");
    }

    public Parent getProjectView() {
        return constructScene("project/fxml/project.fxml");
    }

    public Parent getNewProjectView() {
        return constructScene("newproject/fxml/newproject.fxml");
    }

    private Parent constructScene(final String path) {
        Parent scene;
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(ctx::getBean);
        try {
            scene = loader.load(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        return scene;
    }
}
