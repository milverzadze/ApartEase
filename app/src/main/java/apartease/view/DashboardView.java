package apartease.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class DashboardView extends BorderPane {
    // Tombol menu di sidebar agar bisa dideteksi kliknya nanti
    public Button menuKamarBtn;
    public Button menuPenyewaBtn;
    public Button menuKomplainBtn;
    public Button logoutBtn;
    
    // Area kanan yang isinya bisa berubah-ubah sesuai menu yang diklik
    public VBox contentArea;

    public DashboardView() {
        // Menggunakan BorderPane: Kiri untuk Sidebar, Tengah untuk Konten Utama
        initSidebar();
        initContentArea();
    }

    private void initSidebar() {
        VBox sidebar = new VBox();
        sidebar.setSpacing(15);
        sidebar.setPadding(new Insets(25, 15, 25, 15));
        sidebar.setStyle("-fx-background-color: #94b1ffff;"); // Warna Navy Blue (UI Design)
        sidebar.setPrefWidth(220);

        // Logo / Judul Aplikasi di bagian atas sidebar
        Label logoLabel = new Label("ApartEase");
        logoLabel.setFont(new Font("Segoe UI", 24));
        logoLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 0 0 20 0;");

        // Membuat tombol-tombol menu
        menuKamarBtn = createMenuButton("🏠 Kelola Kamar");
        menuPenyewaBtn = createMenuButton("👥 Data Penyewa");
        menuKomplainBtn = createMenuButton("⚠️ Komplain Penghuni");
        
        // Tombol logout ditaruh agak di bawah (diberi jarak)
        logoutBtn = createMenuButton("🚪 Keluar");
        logoutBtn.setStyle("-fx-background-color: #f58efeff; -fx-text-fill: white; -fx-alignment: SIDEBAR_LEFT; -fx-cursor: hand;");

        // Masukkan semua ke sidebar
        sidebar.getChildren().addAll(logoLabel, menuKamarBtn, menuPenyewaBtn, menuKomplainBtn, logoutBtn);
        
        // Letakkan susunan VBox ini di posisi sebelah kiri (LEFT) BorderPane
        this.setLeft(sidebar);
    }

    private void initContentArea() {
        contentArea = new VBox();
        contentArea.setPadding(new Insets(30));
        contentArea.setSpacing(20);
        contentArea.setStyle("-fx-background-color: #eef684ff;"); // Konten utama warna putih

        // Tampilan default saat admin baru pertama masuk dashboard (UX Ringkasan)
        Label welcomeLabel = new Label("Selamat Datang, Admin!");
        welcomeLabel.setFont(new Font("Segoe UI", 24));
        welcomeLabel.setStyle("-fx-text-fill: #1F2937; -fx-font-weight: bold;");

        Label descLabel = new Label("Silakan pilih menu di sebelah kiri untuk mengelola data apartemen.");
        descLabel.setFont(new Font("Segoe UI", 14));
        descLabel.setStyle("-fx-text-fill: #4B5563;");

        contentArea.getChildren().addAll(welcomeLabel, descLabel);
        
        // Letakkan di posisi tengah (CENTER) BorderPane
        this.setCenter(contentArea);
    }

    // Fungsi pembantu (helper) untuk menyamakan style semua tombol menu
    private Button createMenuButton(String text) {
        Button btn = new Button(text);
        btn.setMaxWidth(Double.MAX_VALUE); // Biar lebar tombol penuh memenuhi sidebar
        btn.setPadding(new Insets(10, 15, 10, 15));
        btn.setFont(new Font("Segoe UI", 14));
        btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #E5E7EB; -fx-alignment: BASELINE_LEFT; -fx-cursor: hand;");
        
        // Efek UX hover sederhana saat mouse mendekati tombol
        btn.setOnMouseEntered(e -> btn.setStyle("-fx-background-color: #90aaf1ff; -fx-text-fill: white; -fx-alignment: BASELINE_LEFT; -fx-cursor: hand;"));
        btn.setOnMouseExited(e -> btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #E5E7EB; -fx-alignment: BASELINE_LEFT; -fx-cursor: hand;"));
        
        return btn;
    }
}