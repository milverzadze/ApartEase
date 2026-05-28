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

        // LOGIKA INTERAKSI MENU PENYEWA
        pesanUnitBtn.setOnAction(e -> {
            contentArea.getChildren().clear();
            Label title = new Label("Form Pemesanan Unit Apartemen");
            title.setFont(Font.font("Segoe UI", javafx.scene.text.FontWeight.BOLD, 22));
            title.setStyle("-fx-text-fill: #2C3E50;");

            Label desc = new Label("Silakan lihat unit yang tersedia dan isi durasi sewa hunian Anda.");
            desc.setFont(Font.font("Segoe UI", 14));
            desc.setStyle("-fx-text-fill: #34495E;");
            contentArea.getChildren().addAll(title, desc);
        });

        bayarSewaBtn.setOnAction(e -> {
            contentArea.getChildren().clear();
            Label title = new Label("Portal Pembayaran Sewa Bulanan");
            title.setFont(Font.font("Segoe UI", javafx.scene.text.FontWeight.BOLD, 22));
            title.setStyle("-fx-text-fill: #2C3E50;");

            Label desc = new Label("Lihat total tagihan bulanan dan unggah bukti transfer pembayaran di sini.");
            desc.setFont(Font.font("Segoe UI", 14));
            desc.setStyle("-fx-text-fill: #34495E;");
            contentArea.getChildren().addAll(title, desc);
        });
    }

    private void initSidebar() {
        VBox sidebar = new VBox(15);
        sidebar.setPadding(new Insets(25, 15, 25, 15));
        sidebar.setStyle("-fx-background-color: #FADBD8;"); // Pink Pastel Lembut
        sidebar.setPrefWidth(220);

        Label logoLabel = new Label("ApartEase\n(Penyewa)");
        logoLabel.setFont(Font.font("Segoe UI", javafx.scene.text.FontWeight.BOLD, 22));
        logoLabel.setStyle("-fx-text-fill: #2C3E50; -fx-padding: 0 0 20 0;");

        pesanUnitBtn = createMenuButton("🏢 Pesan Unit Apt.");
        bayarSewaBtn = createMenuButton("💳 Bayar Sewa");
        
        logoutBtn = createMenuButton("🚪 Kembali ke Menu");
        logoutBtn.setStyle("-fx-background-color: #F1948A; -fx-text-fill: #2C3E50; -fx-font-weight: bold; -fx-alignment: BASELINE_LEFT; -fx-cursor: hand; -fx-background-radius: 5;");

        sidebar.getChildren().addAll(logoLabel, pesanUnitBtn, bayarSewaBtn, logoutBtn);
        this.setLeft(sidebar);
    }

    private void initContentArea() {
        contentArea = new VBox(20);
        contentArea.setPadding(new Insets(30));
        contentArea.setStyle("-fx-background-color: #F5EEF8;"); // Ungu Violet Pastel Sangat Muda
        
        Label welcome = new Label("Selamat Datang, Penyewa!");
        welcome.setFont(Font.font("Segoe UI", javafx.scene.text.FontWeight.BOLD, 26));
        welcome.setStyle("-fx-text-fill: #2C3E50;");
        
        Label descLabel = new Label("Silakan pilih menu di sebelah kiri untuk melihat informasi hunian Anda.");
        descLabel.setFont(Font.font("Segoe UI", 14));
        descLabel.setStyle("-fx-text-fill: #566573;");

        contentArea.getChildren().addAll(welcome, descLabel);
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