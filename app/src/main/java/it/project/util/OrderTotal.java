package it.project.util;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class OrderTotal {

    private double totalAmount = 0.0;
    private final Label totalLabel;
    private final HBox container;

    public OrderTotal() {

        totalLabel = new Label("Total: Php 0.00");

        container = new HBox(totalLabel);
        container.setPadding(new Insets(20));
    }

    public void updateTotal(double amount) {

        totalAmount = amount;
        totalLabel.setText(String.format("Total: Php %.2f", totalAmount));
    }

    public void addTotal(double amount) {

        totalAmount += amount;
        totalLabel.setText(String.format("Total: Php %.2f", totalAmount));
    }

    public void subtractTotal(double amount) {

        totalAmount -= amount;

        if (totalAmount < 0) totalAmount = 0.0;
        totalLabel.setText(String.format("Total: Php %.2f", totalAmount));
    }

    public void resetTotal() {

        totalAmount = 0.0;
        totalLabel.setText(String.format("Total: Php %.2f", totalAmount));
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public HBox getContainer() {
        return container;
    }
}
