package com.sflpro.budgeteer.impl;

import com.sflpro.budgeteer.BudgeteerShutdownHandler;
import com.sflpro.budgeteer.BugeteerConfiguration;
import javafx.application.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BudgeteerShutdownHandlerImpl implements BudgeteerShutdownHandler {

    private static final Logger logger = LoggerFactory.getLogger(BudgeteerShutdownHandlerImpl.class);

    private final BugeteerConfiguration configuration;

    private final ApplicationContext ctx;

    @Autowired
    public BudgeteerShutdownHandlerImpl(BugeteerConfiguration configuration, ApplicationContext ctx) {
        this.configuration = configuration;
        this.ctx = ctx;
    }

    @Override
    public void commenceShutdown() {
        logger.info("Stopping {}!", configuration.getAppName());
        SpringApplication.exit(ctx);
        Platform.exit();

        logger.debug("Stopped {}!", configuration.getAppName());
        System.exit(0);
    }
}
