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
        VBox sidebar = new VBox(15);
        sidebar.setPadding(new Insets(25, 15, 25, 15));
        sidebar.setStyle("-fx-background-color: #b5dbffff;"); // Warna Cokelat Tua sesuai diagrammu
        sidebar.setPrefWidth(220);

        Label logoLabel = new Label("ApartEase\n(Penyewa)");
        logoLabel.setFont(new Font("Segoe UI", 22));
        logoLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 0 0 20 0;");

        // Contoh beberapa tombol fitur dari diagram cokelatmu
        pesanUnitBtn = createMenuButton("🏢 Pesan Unit Apt.");
        bayarSewaBtn = createMenuButton("💳 Bayar Sewa");
        
        logoutBtn = new Button("🚪 Kembali ke Menu");
        logoutBtn.setMaxWidth(Double.MAX_VALUE);
        logoutBtn.setStyle("-fx-background-color: #f5f387ff; -fx-text-fill: white; -fx-padding: 10; -fx-cursor: hand;");

        sidebar.getChildren().addAll(logoLabel, pesanUnitBtn, bayarSewaBtn, logoutBtn);
        this.setLeft(sidebar);

        // Konten utama kanan
        contentArea = new VBox(20);
        contentArea.setPadding(new Insets(30));
        contentArea.setStyle("-fx-background-color: #a7f4f8ff;");
        
        Label welcome = new Label("Selamat Datang, Penyewa!");
        welcome.setFont(new Font("Segoe UI", 24));
        welcome.setStyle("-fx-text-fill: #fd9ff2ff; -fx-font-weight: bold;");
        
        contentArea.getChildren().add(welcome);
        this.setCenter(contentArea);
    }

    private Button createMenuButton(String text) {
        Button btn = new Button(text);
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setPadding(new Insets(10, 15, 10, 15));
        btn.setFont(new Font("Segoe UI", 14));
        btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #e6f487ff; -fx-alignment: BASELINE_LEFT; -fx-cursor: hand;");
        return btn;
    }
}