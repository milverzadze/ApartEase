package apartease.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

        // ---- REKAYASA INTERAKSI MENU (UX) ----
        
        // 1. Jika menu Kelola Kamar diklik
        menuKamarBtn.setOnAction(e -> {
            contentArea.getChildren().clear(); // Bersihkan konten lama
            
            Label title = new Label("Form Kelola Kamar Apartemen");
            title.setFont(new Font("Segoe UI", 20));
            title.setStyle("-fx-text-fill: #eff48bff; -fx-font-weight: bold;");
            
            Label desc = new Label("Di sini nanti tempat tabel daftar kamar dan form input data unit.");
            desc.setFont(new Font("Segoe UI", 14));
            
            contentArea.getChildren().addAll(title, desc);
        });

        // 2. Jika menu Data Penyewa diklik
        menuPenyewaBtn.setOnAction(e -> {
            contentArea.getChildren().clear();
            
            Label title = new Label("Database Penghuni / Penyewa");
            title.setFont(new Font("Segoe UI", 20));
            title.setStyle("-fx-text-fill: #1E3A8A; -fx-font-weight: bold;");
            
            Label desc = new Label("Menampilkan daftar nama penyewa, nomor KTP, dan status pembayaran.");
            desc.setFont(new Font("Segoe UI", 14));
            
            contentArea.getChildren().addAll(title, desc);
        });

        // 3. Jika menu Komplain diklik
        menuKomplainBtn.setOnAction(e -> {
            contentArea.getChildren().clear();
            
            Label title = new Label("Pusat Pengaduan & Komplain");
            title.setFont(new Font("Segoe UI", 20));
            title.setStyle("-fx-text-fill: #1E3A8A; -fx-font-weight: bold;");
            
            Label desc = new Label("Daftar keluhan fasilitas dari penghuni apartemen yang belum diproses.");
            desc.setFont(new Font("Segoe UI", 14));
            
            contentArea.getChildren().addAll(title, desc);
        });
    }

    private void initSidebar() {
        VBox sidebar = new VBox();
        sidebar.setSpacing(15);
        sidebar.setPadding(new Insets(25, 15, 25, 15));
        sidebar.setStyle("-fx-background-color: #1E3A8A;");
        sidebar.setPrefWidth(220);

        Label logoLabel = new Label("ApartEase");
        logoLabel.setFont(new Font("Segoe UI", 24));
        logoLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 0 0 20 0;");

        menuKamarBtn = createMenuButton("🏠 Kelola Kamar");
        menuPenyewaBtn = createMenuButton("👥 Data Penyewa");
        menuKomplainBtn = createMenuButton("⚠️ Komplain Penghuni");
        
        logoutBtn = createMenuButton("🚪 Keluar");
        logoutBtn.setStyle("-fx-background-color: #def687ff; -fx-text-fill: white; -fx-alignment: BASELINE_LEFT; -fx-cursor: hand;");

        sidebar.getChildren().addAll(logoLabel, menuKamarBtn, menuPenyewaBtn, menuKomplainBtn, logoutBtn);
        this.setLeft(sidebar);
    }

    private void initContentArea() {
        contentArea = new VBox();
        contentArea.setPadding(new Insets(30));
        contentArea.setSpacing(20);
        contentArea.setStyle("-fx-background-color: #FFFFFF;");

        Label welcomeLabel = new Label("Selamat Datang, Admin!");
        welcomeLabel.setFont(new Font("Segoe UI", 24));
        welcomeLabel.setStyle("-fx-text-fill: #1F2937; -fx-font-weight: bold;");

        Label descLabel = new Label("Silakan pilih menu di sebelah kiri untuk mengelola data apartemen.");
        descLabel.setFont(new Font("Segoe UI", 14));
        descLabel.setStyle("-fx-text-fill: #4B5563;");

        contentArea.getChildren().addAll(welcomeLabel, descLabel);
        this.setCenter(contentArea);
    }

    private Button createMenuButton(String text) {
        Button btn = new Button(text);
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setPadding(new Insets(10, 15, 10, 15));
        btn.setFont(new Font("Segoe UI", 14));
        btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #E5E7EB; -fx-alignment: BASELINE_LEFT; -fx-cursor: hand;");
        
        btn.setOnMouseEntered(e -> btn.setStyle("-fx-background-color: #1D4ED8; -fx-text-fill: white; -fx-alignment: BASELINE_LEFT; -fx-cursor: hand;"));
        btn.setOnMouseExited(e -> btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #E5E7EB; -fx-alignment: BASELINE_LEFT; -fx-cursor: hand;"));
        
        return btn;
    }
}