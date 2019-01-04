package com.sflpro.budgeteer.impl;

import com.sflpro.budgeteer.BugeteerConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public final class BugeteerSpringBasedConfigurationImpl implements BugeteerConfiguration {

    private final String projectName;

    private final String mainCssPath;

    @Autowired
    public BugeteerSpringBasedConfigurationImpl(@Value("${budgeteer.projectName}") final String projectName,
                                                @Value("${budgeteer.ui.mainCssPath}") final String mainCssPath) {
        this.projectName = projectName;
        this.mainCssPath = mainCssPath;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public String getMainCssPath() {
        return mainCssPath;
    }
}
