package it.project.ui;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class Inventory {

    private final StackPane root = new StackPane();

    public Inventory() {

        root.getChildren().add(null);
    }

    public Node getRoot() {
        return root;
    }
}
