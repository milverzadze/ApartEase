package apartease.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class PenyewaDashboardView extends BorderPane {
    public Button logoutBtn;
    public Button pesanUnitBtn;
    public Button bayarSewaBtn;
    public VBox contentArea;

    public PenyewaDashboardView() {
        initSidebar();
        initContentArea();

        // ---- REKAYASA INTERAKSI MENU PENYEWA (UX) ----

        // 1. Aksi ketika tombol "Pesan Unit" diklik
        pesanUnitBtn.setOnAction(e -> {
            contentArea.getChildren().clear(); // Bersihkan halaman welcome

            Label title = new Label("Form Pemesanan Unit Apartemen");
            title.setFont(new Font("Segoe UI", 20));
            title.setStyle("-fx-text-fill: #667706ff; -fx-font-weight: bold;"); // Tema Cokelat Penyewa

            Label desc = new Label("Silakan pilih unit tersedia, isi durasi sewa, dan lakukan pengajuan booking.");
            desc.setFont(new Font("Segoe UI", 14));

            contentArea.getChildren().addAll(title, desc);
        });

        // 2. Aksi ketika tombol "Bayar Sewa" diklik
        bayarSewaBtn.setOnAction(e -> {
            contentArea.getChildren().clear();

            Label title = new Label("Portal Pembayaran Sewa Bulanan");
            title.setFont(new Font("Segoe UI", 20));
            title.setStyle("-fx-text-fill: #667706ff; -fx-font-weight: bold;");

            Label desc = new Label("Menampilkan total tagihan berjalan, riwayat transaksi, dan upload bukti transfer.");
            desc.setFont(new Font("Segoe UI", 14));

            contentArea.getChildren().addAll(title, desc);
        });
    }

    private void initSidebar() {
        VBox sidebar = new VBox(15);
        sidebar.setPadding(new Insets(25, 15, 25, 15));
        sidebar.setStyle("-fx-background-color: #cfeb69ff;"); // Warna Cokelat Tua
        sidebar.setPrefWidth(220);

        Label logoLabel = new Label("ApartEase\n(Penyewa)");
        logoLabel.setFont(new Font("Segoe./ UI", 22));
        logoLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 0 0 20 0;");

        // Membuat tombol menu
        pesanUnitBtn = createMenuButton("🏢 Pesan Unit Apt.");
        bayarSewaBtn = createMenuButton("💳 Bayar Sewa");
        
        logoutBtn = new Button("🚪 Kembali ke Menu");
        logoutBtn.setMaxWidth(Double.MAX_VALUE);
        logoutBtn.setPadding(new Insets(10));
        logoutBtn.setStyle("-fx-background-color: #fca0f9ff; -fx-text-fill: white; -fx-font-weight: bold; -fx-cursor: hand;");

        sidebar.getChildren().addAll(logoLabel, pesanUnitBtn, bayarSewaBtn, logoutBtn);
        this.setLeft(sidebar);
    }

    private void initContentArea() {
        contentArea = new VBox(20);
        contentArea.setPadding(new Insets(30));
        contentArea.setStyle("-fx-background-color: #0a538fff;");
        
        Label welcome = new Label("Selamat Datang, Penyewa!");
        welcome.setFont(new Font("Segoe UI", 24));
        welcome.setStyle("-fx-text-fill: #1e1186ff; -fx-font-weight: bold;");
        
        Label descLabel = new Label("Silakan pilih menu di sebelah kiri untuk melihat informasi hunian Anda.");
        descLabel.setFont(new Font("Segoe UI", 14));
        descLabel.setStyle("-fx-text-fill: #1e1186ff;");

        contentArea.getChildren().addAll(welcome, descLabel);
        this.setCenter(contentArea);
    }

    private Button createMenuButton(String text) {
        Button btn = new Button(text);
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setPadding(new Insets(10, 15, 10, 15));
        btn.setFont(new Font("Segoe UI", 14));
        btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #1e1186ff; -fx-alignment: BASELINE_LEFT; -fx-cursor: hand;");
        
        // Efek Hover UX biar responsif saat disentuh mouse
        btn.setOnMouseEntered(e -> btn.setStyle("-fx-background-color: #1e1186ff; -fx-text-fill: white; -fx-alignment: BASELINE_LEFT; -fx-cursor: hand;"));
        btn.setOnMouseExited(e -> btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #b1a7ffff; -fx-alignment: BASELINE_LEFT; -fx-cursor: hand;"));
        
        return btn;
    }
}