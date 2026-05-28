package apartease.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class LoginView extends VBox {
    // Komponen dijadikan variabel publik agar bisa dideteksi oleh kelas utama nanti
    public TextField usernameField;
    public PasswordField passwordField;
    public Button loginButton;

    public LoginView() {
        // 1. Pengaturan Jarak & Latar Belakang Kontainer (Konsep UX)
        this.setSpacing(15);
        this.setPadding(new Insets(30));
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: #eeff90ff;"); 

        // 2. Desain Label Judul Aplikasi (Konsep UI)
        Label titleLabel = new Label("ApartEase Admin");
        titleLabel.setFont(new Font("Segoe UI", 26));
        titleLabel.setStyle("-fx-text-fill: #9fb9ffff; -fx-font-weight: bold;"); 

        // 3. Elemen Form Input
        usernameField = new TextField();
        usernameField.setPromptText("Masukkan Username Admin");
        usernameField.setMaxWidth(260);
        usernameField.setStyle("-fx-background-radius: 5; -fx-padding: 8;");

        passwordField = new PasswordField();
        passwordField.setPromptText("Masukkan Password");
        passwordField.setMaxWidth(260);
        passwordField.setStyle("-fx-background-radius: 5; -fx-padding: 8;");

        // 4. Elemen Tombol Aksi
        loginButton = new Button("Sign In");
        loginButton.setMaxWidth(260);
        loginButton.setStyle("-fx-background-color: #eea9ddff; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 5; -fx-padding: 10; -fx-cursor: hand;");

        // 5. Satukan semua komponen ke dalam susunan Vertikal (VBox)
        this.getChildren().addAll(titleLabel, usernameField, passwordField, loginButton);
    }
}