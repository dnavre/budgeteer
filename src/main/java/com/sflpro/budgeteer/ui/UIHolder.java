package com.sflpro.budgeteer.ui;

import javafx.scene.Parent;

public class UIHolder<T extends Parent,E> {
    private final T scene;
    private final E controller;

    public UIHolder(T scene, E controller) {
        this.scene = scene;
        this.controller = controller;
    }

    public T getScene() {
        return scene;
    }

    public E getController() {
        return controller;
    }
}
