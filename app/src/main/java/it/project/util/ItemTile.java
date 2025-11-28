package it.project.util;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class ItemTile extends VBox {

    private final HBox quantityGroup;
    private final Label quantityLabel;
    private final double itemPrice;
    private final double ITEM_IMAGE_FIT = 250;

    public ItemTile(
            Item item,
            OrderTotal orderTotal,
            List<Label> allQuantityLabels,
            List<HBox> allQuantityBoxes,
            double tileSize) {

        itemPrice = PriceParser.parsePrice(item.getItemPrice());

        Image image = new Image(item.getItemImagePath());

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(ITEM_IMAGE_FIT);
        imageView.setFitHeight(ITEM_IMAGE_FIT * 0.7);
        imageView.setPreserveRatio(true);

        Label itemNameLabel = new Label(item.getItemName());
        Label itemPriceLabel = new Label(item.getItemPrice());
        quantityLabel = new Label("1");

        Button decreaseButton = new Button("-");
        Button increaseButton = new Button("+");

        quantityGroup = new HBox(
                10,
                decreaseButton,
                quantityLabel,
                increaseButton
        );
        quantityGroup.setAlignment(Pos.CENTER_LEFT);
        quantityGroup.setVisible(false);

        super.getChildren().addAll(
                imageView,
                itemNameLabel,
                itemPriceLabel,
                quantityGroup
        );
        super.setAlignment(Pos.CENTER_LEFT);
        super.setSpacing(10);
        super.setPrefSize(tileSize, tileSize);
        super.setOnMouseClicked(event -> {

            boolean wasVisible = quantityGroup.isVisible();
            quantityGroup.setVisible(!wasVisible);

            if (!wasVisible) {
                orderTotal.addTotal(itemPrice);
            } else {

                int currentQuantity = Integer.parseInt(quantityLabel.getText());
                orderTotal.subtractTotal(itemPrice * currentQuantity);
                quantityLabel.setText("1");
            }
        });

        allQuantityLabels.add(quantityLabel);
        allQuantityBoxes.add(quantityGroup);
    }
}
