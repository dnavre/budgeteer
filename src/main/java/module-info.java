 open module com.sflpro.budgeteer {
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.context;
    requires spring.core;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.boot.starter;
    requires slf4j.api;
    requires java.sql;

    exports com.sflpro.budgeteer to javafx.graphics;
    //opens com.sflpro.budgeteer to spring.core, spring.context, spring.beans, spring.boot;
}