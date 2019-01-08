package com.sflpro.budgeteer.impl;

import com.sflpro.budgeteer.BugeteerConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public final class BugeteerSpringBasedConfigurationImpl implements BugeteerConfiguration {

    private final String appName;

    private final String mainCssPath;

    @Autowired
    public BugeteerSpringBasedConfigurationImpl(@Value("${budgeteer.appName}") final String appName,
                                                @Value("${budgeteer.ui.mainCssPath}") final String mainCssPath) {
        this.appName = appName;
        this.mainCssPath = mainCssPath;
    }

    @Override
    public String getAppName() {
        return appName;
    }

    @Override
    public String getMainCssPath() {
        return mainCssPath;
    }
}
