package apartease.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class DashboardView extends BorderPane {
    public Button menuKamarBtn;
    public Button menuPenyewaBtn;
    public Button menuKomplainBtn;
    public Button logoutBtn;
    public VBox contentArea;

    public DashboardView() {
        initSidebar();
        initContentArea();

        // LOGIKA INTERAKSI MENU ADMIN
        menuKamarBtn.setOnAction(e -> {
            contentArea.getChildren().clear();
            Label title = new Label("Sistem Manajemen Unit Apartemen");
            title.setFont(Font.font("Segoe UI", javafx.scene.text.FontWeight.BOLD, 22));
            title.setStyle("-fx-text-fill: #2C3E50;"); // Jelas & terbaca

            Label desc = new Label("Gunakan halaman ini untuk memantau status hunian dan mengubah harga sewa.");
            desc.setFont(Font.font("Segoe UI", 14));
            desc.setStyle("-fx-text-fill: #34495E;");
            contentArea.getChildren().addAll(title, desc);
        });

        menuPenyewaBtn.setOnAction(e -> {
            contentArea.getChildren().clear();
            Label title = new Label("Database Penghuni & Penyewa Aktif");
            title.setFont(Font.font("Segoe UI", javafx.scene.text.FontWeight.BOLD, 22));
            title.setStyle("-fx-text-fill: #2C3E50;");
            
            Label desc = new Label("Menampilkan daftar lengkap nama penghuni, nomor identitas, serta berkas kontrak.");
            desc.setFont(Font.font("Segoe UI", 14));
            desc.setStyle("-fx-text-fill: #34495E;");
            contentArea.getChildren().addAll(title, desc);
        });

        menuKomplainBtn.setOnAction(e -> {
            contentArea.getChildren().clear();
            Label title = new Label("Pusat Layanan & Pengaduan Fasilitas");
            title.setFont(Font.font("Segoe UI", javafx.scene.text.FontWeight.BOLD, 22));
            title.setStyle("-fx-text-fill: #2C3E50;");
            
            Label desc = new Label("Daftar keluhan masuk dari penghuni apartemen terkait kerusakan fasilitas unit.");
            desc.setFont(Font.font("Segoe UI", 14));
            desc.setStyle("-fx-text-fill: #34495E;");
            contentArea.getChildren().addAll(title, desc);
        });
    }

    private void initSidebar() {
        VBox sidebar = new VBox();
        sidebar.setSpacing(15);
        sidebar.setPadding(new Insets(25, 15, 25, 15));
        sidebar.setStyle("-fx-background-color: #D4E6F1;"); // Biru Pastel Jernih
        sidebar.setPrefWidth(220);

        Label logoLabel = new Label("ApartEase\n(Admin)");
        logoLabel.setFont(Font.font("Segoe UI", javafx.scene.text.FontWeight.BOLD, 24));
        logoLabel.setStyle("-fx-text-fill: #2C3E50; -fx-padding: 0 0 20 0;");

        menuKamarBtn = createMenuButton("🏠 Kelola Kamar");
        menuPenyewaBtn = createMenuButton("👥 Data Penyewa");
        menuKomplainBtn = createMenuButton("⚠️ Kelola Komplain");
        
        logoutBtn = createMenuButton("🚪 Keluar");
        logoutBtn.setStyle("-fx-background-color: #E6B0AA; -fx-text-fill: #2C3E50; -fx-font-weight: bold; -fx-alignment: BASELINE_LEFT; -fx-cursor: hand; -fx-background-radius: 5;");

        sidebar.getChildren().addAll(logoLabel, menuKamarBtn, menuPenyewaBtn, menuKomplainBtn, logoutBtn);
        this.setLeft(sidebar);
    }

    private void initContentArea() {
        contentArea = new VBox();
        contentArea.setPadding(new Insets(30));
        contentArea.setSpacing(20);
        contentArea.setStyle("-fx-background-color: #FEF9E7;"); // Kuning Krem Teduh

        Label welcomeLabel = new Label("Selamat Datang, Admin!");
        welcomeLabel.setFont(Font.font("Segoe UI", javafx.scene.text.FontWeight.BOLD, 26));
        welcomeLabel.setStyle("-fx-text-fill: #2C3E50;"); 

        Label descLabel = new Label("Silakan pilih menu di sebelah kiri untuk mengelola data apartemen.");
        descLabel.setFont(Font.font("Segoe UI", 14));
        descLabel.setStyle("-fx-text-fill: #566573;");

        contentArea.getChildren().addAll(welcomeLabel, descLabel);
        this.setCenter(contentArea);
    }

    private Button createMenuButton(String text) {
        Button btn = new Button(text);
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setPadding(new Insets(10, 15, 10, 15));
        btn.setFont(Font.font("Segoe UI", 14));
        btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #2C3E50; -fx-alignment: BASELINE_LEFT; -fx-cursor: hand; -fx-font-weight: bold;");
        
        btn.setOnMouseEntered(e -> btn.setStyle("-fx-background-color: rgba(255, 255, 255, 0.6); -fx-text-fill: #2C3E50; -fx-alignment: BASELINE_LEFT; -fx-cursor: hand; -fx-background-radius: 5; -fx-font-weight: bold;"));
        btn.setOnMouseExited(e -> btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #2C3E50; -fx-alignment: BASELINE_LEFT; -fx-cursor: hand; -fx-font-weight: bold;"));
        
        return btn;
    }
}