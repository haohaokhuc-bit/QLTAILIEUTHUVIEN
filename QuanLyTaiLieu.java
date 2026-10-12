import java.util.ArrayList;

public class QuanLyTaiLieu {

    // Danh sach luu tru cac tai lieu
    private ArrayList<TaiLieu> danhSach;

    // Constructor
    public QuanLyTaiLieu() {
        danhSach = new ArrayList<>();
    }

    // 1. Them tai lieu moi
    public boolean themTaiLieu(TaiLieu taiLieu) {

        // Kiem tra ma tai lieu bi trung
        for (TaiLieu tl : danhSach) {
            if (tl.getMaTaiLieu().equalsIgnoreCase(
                    taiLieu.getMaTaiLieu())) {
                return false;
            }
        }

        danhSach.add(taiLieu);
        return true;
    }

    // 2. Xoa tai lieu theo ma
    public boolean xoaTaiLieu(String maTaiLieu) {

        for (int i = 0; i < danhSach.size(); i++) {

            if (danhSach.get(i).getMaTaiLieu()
                    .equalsIgnoreCase(maTaiLieu)) {

                danhSach.remove(i);
                return true;
            }
        }

        return false;
    }

    // 3. Hien thi tat ca tai lieu
    public void hienThiTatCa() {

        if (danhSach.isEmpty()) {
            System.out.println("Danh sach tai lieu rong!");
            return;
        }

        System.out.println("=== DANH SACH TAI LIEU ===");

        for (TaiLieu tl : danhSach) {
            tl.hienThiThongTin();
            System.out.println("--------------------");
        }
    }

    // 4. Tim kiem tai lieu theo loai
    public void timKiemTheoLoai(int loai) {

        if (loai < 1 || loai > 3) {
            System.out.println("Loai tai lieu khong hop le!");
            return;
        }

        boolean timThay = false;

        for (TaiLieu tl : danhSach) {

            if ((loai == 1 && tl instanceof Sach)
                    || (loai == 2 && tl instanceof TapChi)
                    || (loai == 3 && tl instanceof Bao)) {

                tl.hienThiThongTin();
                System.out.println("--------------------");
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay tai lieu!");
        }
    }
}