package it.project.ui;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Admin {

    private final StackPane root = new StackPane();

    public Admin() {

        Label titleLabel = new Label("Control Panel");

        Region r1 = new Region();

        Button inventoryButton = new Button("Inventory");
        Button salesButton = new Button("Sales");

        VBox controlPanel = new VBox(
                15,
                titleLabel,
                r1,
                inventoryButton,
                salesButton
        );
        controlPanel.setAlignment(Pos.CENTER);
        controlPanel.setFillWidth(false);
        controlPanel.prefWidthProperty().bind(root.widthProperty().multiply(0.3));
        controlPanel.prefHeightProperty().bind(root.heightProperty().multiply(0.5));

        root.getChildren().add(controlPanel);
    }

    public Node getRoot() {
        return root;
    }
}
