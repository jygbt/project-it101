package it.project.control;

import javafx.scene.layout.StackPane;

import java.util.List;

public class ViewHandler {

    private final List<StackPane> panes;
    public static final int INDEX_LOGIN_PANE = 0;
    public static final int INDEX_ADMIN_PANE = 1;
    public static final int INDEX_KIOSK_PANE = 2;

    public ViewHandler(List<StackPane> panes) {

        this.panes = panes;

        if (!panes.isEmpty()) {
            switchView(INDEX_LOGIN_PANE);
        }
    }

    public void switchView(int index) {

        if (index < 0|| index >= panes.size()) {
            return;
        }

        for (int i = 0; i < panes.size(); i++) {

            panes.get(i).setVisible(i == index);
        }
    }
}