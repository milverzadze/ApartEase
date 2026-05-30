package apartease.model;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private List<Admin> daftarAdmin;
    private List<Penyewa> daftarPenyewa;
    private List<UnitApartemen> daftarUnit;
    private List<Booking> daftarBooking;
    private List<Komplain> daftarKomplain;
    private HargaSewa hargaSewa;

    public DataManager() {
    daftarAdmin = new ArrayList<>();
    daftarPenyewa = new ArrayList<>();
    daftarBooking = new ArrayList<>();
    daftarKomplain = new ArrayList<>();
    hargaSewa = new HargaSewa();
    daftarUnit = inisialisasiUnit();

    daftarAdmin.add(new Admin("Administrator", "admin", "admin123", "admin@gmail.com", "08000000000"));
    }      

    private List<UnitApartemen> inisialisasiUnit() {
        List<UnitApartemen> units = new ArrayList<>();
        for (int lantai = 2; lantai <= 20; lantai++) {
            for (char huruf = 'A'; huruf <= 'Z'; huruf++) {
                units.add(new UnitApartemen(lantai, huruf));
            }
        }
        return units;
    }

    public List<Admin> getDaftarAdmin() { return daftarAdmin; }
    public List<Penyewa> getDaftarPenyewa() { return daftarPenyewa; }
    public List<UnitApartemen> getDaftarUnit() { return daftarUnit; }
    public List<Booking> getDaftarBooking() { return daftarBooking; }
    public List<Komplain> getDaftarKomplain() { return daftarKomplain; }
    public HargaSewa getHargaSewa() { return hargaSewa; }

    public boolean usernameAdminSudahAda(String username) {
        for (Admin a : daftarAdmin) {
            if (a.getUsername().equals(username)) return true;
        }
        return false;
    }

    public boolean usernamePenyewaSudahAda(String username) {
        for (Penyewa p : daftarPenyewa) {
            if (p.getUsername().equals(username)) return true;
        }
        return false;
    }

    public Admin cariAdmin(String username, String password) {
        for (Admin a : daftarAdmin) {
            if (a.getUsername().equals(username) && a.getPassword().equals(password)) return a;
        }
        return null;
    }

    public Penyewa cariPenyewa(String username, String password) {
        for (Penyewa p : daftarPenyewa) {
            if (p.getUsername().equals(username) && p.getPassword().equals(password)) return p;
        }
        return null;
    }

    public UnitApartemen cariUnit(int lantai, char huruf) {
        for (UnitApartemen u : daftarUnit) {
            if (u.getLantai() == lantai && Character.toUpperCase(u.getHuruf()) == Character.toUpperCase(huruf)) {
                return u;
            }
        }
        return null;
    }

    public int hitungBookingPenyewa(String username) {
        int count = 0;
        for (Booking b : daftarBooking) {
            if (b.getUsernamePenyewa().equals(username)) count++;
        }
        return count;
    }

    public List<Booking> getBookingPenyewa(String username) {
        List<Booking> hasil = new ArrayList<>();
        for (Booking b : daftarBooking) {
            if (b.getUsernamePenyewa().equals(username)) hasil.add(b);
        }
        return hasil;
    }

    public List<Komplain> getKomplainPenyewa(String username) {
        List<Komplain> hasil = new ArrayList<>();
        for (Komplain k : daftarKomplain) {
            if (k.getUsernamePenyewa().equals(username)) hasil.add(k);
        }
        return hasil;
    }

    public Penyewa cariPenyewaByUsername(String username) {
        for (Penyewa p : daftarPenyewa) {
            if (p.getUsername().equals(username)) return p;
        }
        return null;
    }
}
