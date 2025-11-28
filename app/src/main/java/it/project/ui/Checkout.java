package it.project.ui;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class Checkout {

    private final StackPane root = new StackPane();

    public Checkout() {


        root.getChildrenUnmodifiable().add(root);
    }

    public Node getRoot() {
        return root;
    }
}
