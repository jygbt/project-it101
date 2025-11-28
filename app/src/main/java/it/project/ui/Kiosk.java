package it.project.ui;

import it.project.control.ResetActionHandler;
import it.project.util.OrderTotal;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;

public class Kiosk {

    private final StackPane root = new StackPane();
    private final OrderTotal orderTotal = new OrderTotal();
    private final List<Label> allQuantityLabels = new ArrayList<>();
    private final List<HBox> allQuantityBoxes = new  ArrayList<>();
    private final List<Label> allItemLabels = new ArrayList<>();
    private static final double TILE_SIZE = 300;

    public Kiosk() {

        ItemTileView selectionView = new ItemTileView(
                orderTotal,
                allQuantityLabels,
                allQuantityBoxes
        );

        ScrollPane scrollPane = new ScrollPane(selectionView);
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        scrollPane.viewportBoundsProperty().addListener((observable, oldBounds, newBounds) -> {
            selectionView.setPrefWidth(newBounds.getWidth());
        });

        Button resetButton = new Button("Reset");
        resetButton.setOnAction(new ResetActionHandler(
                allQuantityLabels,
                allQuantityBoxes,
                orderTotal
        ));

        Button checkoutButton = new  Button("Checkout");

        HBox bottomGroup = new HBox(
                20,
                orderTotal.getContainer(),
                resetButton,
                checkoutButton
        );
        bottomGroup.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        root.getChildren().addAll(scrollPane, bottomGroup);
        StackPane.setAlignment(bottomGroup, Pos.BOTTOM_RIGHT);
        StackPane.setMargin(bottomGroup, new Insets(20));
    }

    public Node getRoot() {
        return root;
    }
}
