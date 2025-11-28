package it.project.control;

import it.project.util.OrderTotal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class ResetActionHandler implements EventHandler<ActionEvent> {

    private final List<Label> allQuantityLabels;
    private final List<HBox> allQuantityBoxes;
    private final OrderTotal orderTotal;

    public ResetActionHandler(List<Label> allQuantityLabels, List<HBox> allQuantityBoxes, OrderTotal orderTotal) {

        this.allQuantityLabels = allQuantityLabels;
        this.allQuantityBoxes = new ArrayList<>();
        this.orderTotal = orderTotal;
    }

    @Override
    public void handle(ActionEvent event) {

        for (Label quantityLabel : allQuantityLabels) {
            quantityLabel.setText("1");
        }

        for (HBox quantityBox : allQuantityBoxes) {
            quantityBox.setVisible(false);
        }

        orderTotal.resetTotal();
    }
}
