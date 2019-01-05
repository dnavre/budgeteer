package com.sflpro.budgeteer.ui.newproject;

import com.sflpro.budgeteer.ui.ViewFactory;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component

public class NewProjectController {

    public static void showNewProjectDialog(ApplicationContext ctx) {
        ViewFactory viewFactory = ctx.getBean(ViewFactory.class);

        Scene newProjectScene = new Scene(viewFactory.getNewProjectView());

        Stage s = new Stage();
        s.setScene(newProjectScene);
        s.setTitle("New project");
        s.setAlwaysOnTop(true);
        s.setResizable(false);
        s.show();
    }
}
