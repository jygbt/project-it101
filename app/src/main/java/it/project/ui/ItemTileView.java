package it.project.ui;

import it.project.util.Item;
import it.project.util.ItemList;
import it.project.util.ItemTile;
import it.project.util.OrderTotal;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.util.List;

public class ItemTileView extends VBox {

    private static final double TILE_SIZE = 300;

    public ItemTileView(OrderTotal orderTotal, List<Label> allQuantityLabels, List<HBox> allQuantityBoxes) {

        Label titleLabel = new Label("Kiosk");

        VBox titleGroup = new VBox(
                10,
                titleLabel
        );
        titleGroup.setAlignment(Pos.CENTER);

        TilePane tilePane = new TilePane();
        tilePane.setHgap(10);
        tilePane.setVgap(10);
        tilePane.setPrefWidth(TILE_SIZE);
        tilePane.setPrefHeight(TILE_SIZE);
        tilePane.setAlignment(Pos.CENTER);
        tilePane.setPadding(new Insets(20));

        List<Item> items = ItemList.getItemList();

        for (Item item : items) {

            ItemTile itemTile = new ItemTile(
                    item,
                    orderTotal,
                    allQuantityLabels,
                    allQuantityBoxes,
                    TILE_SIZE
            );
            tilePane.getChildren().add(itemTile);
        }

        super.getChildren().addAll(
                titleGroup,
                tilePane
        );
        super.setAlignment(Pos.CENTER);
        super.setSpacing(20);

        VBox.setVgrow(tilePane, Priority.ALWAYS);
    }
}
