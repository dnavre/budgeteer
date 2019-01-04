package com.sflpro.budgeteer.impl;

import com.sflpro.budgeteer.BudgeteerShutdownHandler;
import com.sflpro.budgeteer.BugeteerConfiguration;
import javafx.application.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BudgeteerShutdownHandlerImpl implements BudgeteerShutdownHandler {

    private static final Logger logger = LoggerFactory.getLogger(BudgeteerShutdownHandlerImpl.class);

    private final BugeteerConfiguration configuration;

    @Autowired
    public BudgeteerShutdownHandlerImpl(BugeteerConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void commenceShutdown() {
        logger.info("Stopping {}!", configuration.getProjectName());
        Platform.exit();

        logger.debug("Stopped {}!", configuration.getProjectName());
        System.exit(0);
    }
}
