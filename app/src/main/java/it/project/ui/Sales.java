package it.project.ui;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class Sales {

    private final StackPane root = new StackPane();

    public Sales(){

        root.getChildren().add(null);
    }

    public Node getRoot(){
        return root;
    }
}
