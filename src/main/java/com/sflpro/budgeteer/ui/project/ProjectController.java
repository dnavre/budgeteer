package com.sflpro.budgeteer.ui.project;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ProjectController {

    @Autowired
    public ProjectController(final ApplicationContext ctx) {
    }

}
