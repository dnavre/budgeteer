package com.sflpro.budgeteer;

import com.sflpro.budgeteer.ui.ViewFactory;
import com.sflpro.budgeteer.ui.launcher.LauncherController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:/com/sflpro/budgeteer/context.xml")
public class Budgeteer extends Application {

    private static final Logger log = LoggerFactory.getLogger(Budgeteer.class);

    private volatile ConfigurableApplicationContext springContext;
    private volatile BugeteerConfiguration configuration;
    private Scene scene;

    public static void main(final String[] args) {
        launch(Budgeteer.class, args);
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(Budgeteer.class);
        configuration = springContext.getBean(BugeteerConfiguration.class);


    }

    @Override
    public void stop() throws Exception {
        springContext.getBean(BudgeteerShutdownHandler.class).commenceShutdown();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        log.info("Starting {}!", configuration.getProjectName());
        LauncherController.showLauncherWindow(springContext, primaryStage);
    }
}
