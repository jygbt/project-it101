package it.project.ui;

import it.project.control.ViewHandler;
import it.project.data.Credentials;
import it.project.control.LoginHandler;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Login {

    private final StackPane root = new StackPane();
    private final LoginHandler loginHandler;

    public Login() {

        Credentials credentials = new Credentials();

        Label titleLabel = new Label("Login");

        Region r1 = new Region();

        Label usernameLabel = new Label("Username");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        Region r2 = new Region();

        Label passwordLabel = new Label("Password");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Region r3 = new Region();

        Button loginButton = new Button("Login");
        Button exitButton = new Button("Exit");

        VBox loginForm  = new VBox(
                10,
                titleLabel,
                r1,
                usernameLabel,
                usernameField,
                r2,
                passwordLabel,
                passwordField,
                r3,
                loginButton,
                exitButton
        );
        loginForm.setAlignment(Pos.CENTER);
        loginForm.setFillWidth(false);
        loginForm.prefWidthProperty().bind(root.widthProperty().multiply(0.3));
        loginForm.prefHeightProperty().bind(root.heightProperty().multiply(0.5));

        root.getChildren().addAll(loginForm);

        BooleanBinding isButtonDisabled = Bindings.createBooleanBinding(
                () -> usernameField.getText().trim().isBlank() || passwordField.getText().trim().isBlank(),
                usernameField.textProperty(),
                passwordField.textProperty()
        );

        loginButton.disableProperty().bind(isButtonDisabled);

        loginHandler = new LoginHandler(usernameField, passwordField, credentials.getAccounts());

        loginButton.setOnAction(loginHandler);

        exitButton.setOnAction(e -> Platform.exit());
    }

    public void setView(ViewHandler viewManager) {
        loginHandler.setView(viewManager);
    }

    public Node getRoot() {
        return root;
    }
}
