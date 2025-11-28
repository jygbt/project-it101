package it.project.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.util.Optional;

public class Popup {

    private static void configurePopup(Alert alert, Window window, String title, String header, String content) {

        if (window != null) {
            alert.initOwner(window);
        }
        alert.initModality(Modality.WINDOW_MODAL);

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.initStyle(StageStyle.UNDECORATED);

        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.getDialogPane().setGraphic(null);
    }

    public static void showError(Window window, String title, String header, String content) {

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);

        configurePopup(errorAlert, window, title, header, content);

        errorAlert.showAndWait();
    }

    public static boolean showConfirmation(Window window, String title, String header, String content) {

        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);

        configurePopup(confirmAlert, window, title, header, content);
        Optional<ButtonType> result = confirmAlert.showAndWait();

        return result.isPresent() && result.get() == ButtonType.OK;
    }

    public void showInformation(Window window, String title, String header, String content) {

        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);

        configurePopup(infoAlert, window, title, header, content);

        infoAlert.showAndWait();
    }
}
