package it.project.control;

import it.project.util.OrderTotal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class QuantityActionHandler implements EventHandler<ActionEvent> {

    private final Label quantityLabel;
    private final OrderTotal orderTotal;
    private final double itemPrice;
    private final boolean isIncrease;

    public QuantityActionHandler(Label quantityLabel, OrderTotal orderTotal, double itemPrice, boolean isIncrease) {
        this.quantityLabel = quantityLabel;
        this.orderTotal = orderTotal;
        this.itemPrice = itemPrice;
        this.isIncrease = isIncrease;
    }

    @Override
    public void handle(ActionEvent event) {

        int quantity = Integer.parseInt(quantityLabel.getText());

        if (isIncrease) {
            quantityLabel.setText(String.valueOf(quantity + 1));
            orderTotal.addTotal(itemPrice);
        } else {
            if (quantity > 1) {
                quantityLabel.setText(String.valueOf(quantity - 1));
                orderTotal.subtractTotal(itemPrice);
            }
        }
    }
}
