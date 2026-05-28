package apartease.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class WelcomeView extends VBox {
    public Button adminRoleBtn;
    public Button penyewaRoleBtn;
    public Button keluarBtn;

    public WelcomeView() {
        this.setSpacing(25);
        this.setPadding(new Insets(40));
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: #a2c1ffff;");

        // Header Menu Utama
        Label titleLabel = new Label("Selamat Datang di ApartEase");
        titleLabel.setFont(new Font("Chiller Regular", 32));
        titleLabel.setStyle("-fx-text-fill: #f9328fff; -fx-font-weight: bold;");

        Label subtitleLabel = new Label("Silakan pilih jenis pengguna untuk masuk ke sistem:");
        subtitleLabel.setFont(new Font("Chiller Regular", 16));
        subtitleLabel.setStyle("-fx-text-fill: #4B5563;");

        // Kotak Horizontal untuk Tombol Pilihan Role (UI/UX agar seimbang)
        HBox roleContainer = new HBox(30);
        roleContainer.setAlignment(Pos.CENTER);

        adminRoleBtn = createRoleButton("👨‍💼 ADMIN", "#5abf5aff"); // Warna Teal Hijau Tua
        penyewaRoleBtn = createRoleButton("👥 PENYEWA", "#5abf5aff"); // Warna Oranye Terbakar

        roleContainer.getChildren().addAll(adminRoleBtn, penyewaRoleBtn);

        // Tombol Keluar Aplikasi di bagian bawah
        keluarBtn = new Button("❌ Keluar Aplikasi");
        keluarBtn.setStyle("-fx-background-color: #cb1818ff; -fx-text-fill: white; -fx-padding: 10 20; -fx-background-radius: 5; -fx-cursor: hand;");

        this.getChildren().addAll(titleLabel, subtitleLabel, roleContainer, keluarBtn);
    }

    private Button createRoleButton(String text, String colorHex) {
        Button btn = new Button(text);
        btn.setPrefSize(150, 50); // Bikin tombol kotak besar yang interaktif
        btn.setFont(new Font("Segoe UI", 16));
        btn.setWrapText(true);
        btn.setStyle("-fx-background-color: " + colorHex + "; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 10; -fx-cursor: hand; -fx-text-alignment: center;");
        
        // Efek Hover UX
        btn.setOnMouseEntered(e -> btn.setStyle("-fx-background-color: #8cb1ffff; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 10; -fx-cursor: hand; -fx-text-alignment: center;"));
        btn.setOnMouseExited(e -> btn.setStyle("-fx-background-color: " + colorHex + "; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 10; -fx-cursor: hand; -fx-text-alignment: center;"));
        
        return btn;
    }
}