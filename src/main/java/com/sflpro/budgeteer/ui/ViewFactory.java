package com.sflpro.budgeteer.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ViewFactory {

    private final ApplicationContext ctx;

    private volatile BorderPane launcherView;
    private volatile AnchorPane projectView;
    private volatile AnchorPane newProjectView;

    @Autowired
    public ViewFactory(final ApplicationContext ctx) throws IOException {
        this.ctx = ctx;
    }


    public BorderPane getLauncherView() {
        if(launcherView == null) {
            synchronized (this) {
                if(launcherView == null) {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setControllerFactory(ctx::getBean);
                    try {
                        this.launcherView = loader.load(getClass().getResourceAsStream("launcher/fxml/launcher.fxml"));
                    } catch (IOException e) {
                        throw new IllegalStateException(e);
                    }
                }
            }
        }
        return launcherView;
    }

    public AnchorPane getProjectView() {
        if(projectView == null) {
            synchronized (this) {
                if(projectView == null) {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setControllerFactory(ctx::getBean);
                    try {
                        this.projectView = loader.load(getClass().getResourceAsStream("project/fxml/project.fxml"));
                    } catch (IOException e) {
                        throw new IllegalStateException(e);
                    }
                }
            }
        }
        return projectView;
    }

    public AnchorPane getNewProjectView() {
        if(newProjectView == null) {
            synchronized (this) {
                if(newProjectView == null) {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setControllerFactory(ctx::getBean);
                    try {
                        this.newProjectView = loader.load(getClass().getResourceAsStream("newproject/fxml/newproject.fxml"));
                    } catch (IOException e) {
                        throw new IllegalStateException(e);
                    }
                }
            }
        }
        return newProjectView;
    }
}
