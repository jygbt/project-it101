package it.project.control;

import it.project.data.Credentials;
import it.project.util.Popup;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.util.Map;

public class LoginHandler implements EventHandler<ActionEvent> {

    private final TextField usernameField;
    private final PasswordField passwordField;
    private final Map<String, Credentials.Account> accounts;
    private ViewHandler viewManager;

    public LoginHandler(TextField usernameField, PasswordField passwordField, Map<String, Credentials.Account> accounts) {

        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this.accounts = accounts;
    }

    public void setView(ViewHandler viewManager) {
        this.viewManager = viewManager;
    }

    @Override
    public void handle(ActionEvent event) {

        Window owner = ((Node) event.getSource()).getScene().getWindow();

        boolean confirmed = Popup.showConfirmation(
                owner,
                "Login?",
                "LOGIN?",
                "Login with these credentials?"
        );

        if (confirmed) {
            String username = usernameField.getText();
            String password = passwordField.getText();

            Credentials.Account account = accounts.get(username);

            if (account != null && account.password().equals(password)) {
                String privilege = account.privilege();

                if ("ADMIN".equals(privilege)) {
                    viewManager.switchView(ViewHandler.INDEX_ADMIN_PANE);
                } else {
                    viewManager.switchView(ViewHandler.INDEX_KIOSK_PANE);
                }
            } else {
                Popup.showError(
                        owner,
                        "Login Failed",
                        "LOGIN FAILED",
                        "Invalid username or password"
                );
            }
        }
    }
}
