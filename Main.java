import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class Main {

    // Ham nhap chuoi khong duoc de trong
    public static String nhapChuoi(Scanner sc, String thongBao) {
        while (true) {
            System.out.print(thongBao);
            String giaTri = sc.nextLine().trim();

            if (!giaTri.isEmpty()) {
                return giaTri;
            }
            System.out.println("Khong duoc de trong!");
        }
    }

    // Ham nhap so nguyen
    public static int nhapSoNguyen(Scanner sc, String thongBao) {
        while (true) {
            System.out.print(thongBao);

            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen!");
            }
        }
    }

    // Ham nhap so nguyen duong
    public static int nhapSoDuong(Scanner sc, String thongBao) {
        while (true) {
            int so = nhapSoNguyen(sc, thongBao);

            if (so > 0) {
                return so;
            }
            System.out.println("Gia tri phai lon hon 0!");
        }
    }

    // Ham nhap thang tu 1 den 12
    public static int nhapThang(Scanner sc) {
        while (true) {
            int thang = nhapSoNguyen(sc, "Nhap thang phat hanh: ");

            if (thang >= 1 && thang <= 12) {
                return thang;
            }
            System.out.println("Thang phai tu 1 den 12!");
        }
    }

    // Ham nhap ngay phat hanh hop le
    public static String nhapNgay(Scanner sc) {
        DateTimeFormatter dinhDang = DateTimeFormatter
                .ofPattern("dd/MM/uuuu")
                .withResolverStyle(ResolverStyle.STRICT);

        while (true) {
            String ngay = nhapChuoi(sc,
                    "Nhap ngay phat hanh (dd/MM/yyyy): ");

            try {
                LocalDate.parse(ngay, dinhDang);
                return ngay;
            } catch (DateTimeParseException e) {
                System.out.println("Ngay khong hop le!");
            }
        }
    }

    // Chuc nang 1: Them tai lieu
    public static void themMoi(Scanner sc, QuanLyTaiLieu ql) {

        System.out.println("\n=== THEM TAI LIEU ===");
        System.out.println("1. Them Sach");
        System.out.println("2. Them Tap Chi");
        System.out.println("3. Them Bao");

        int loai = nhapSoNguyen(sc, "Chon loai tai lieu: ");

        if (loai < 1 || loai > 3) {
            System.out.println("Loai tai lieu khong hop le!");
            return;
        }

        // Nhap thong tin chung
        String ma = nhapChuoi(sc, "Nhap ma tai lieu: ");
        String nxb = nhapChuoi(sc, "Nhap ten nha xuat ban: ");
        int soBan = nhapSoDuong(sc, "Nhap so ban phat hanh: ");

        TaiLieu taiLieu;

        switch (loai) {

            case 1:
// Nhap thong tin Sach
                String tacGia = nhapChuoi(sc, "Nhap ten tac gia: ");
                int soTrang = nhapSoDuong(sc, "Nhap so trang: ");

                taiLieu = new Sach(ma, nxb, soBan, tacGia, soTrang);
                break;

            case 2:
                // Nhap thong tin Tap Chi
                int soPhatHanh = nhapSoDuong(sc,
                        "Nhap so phat hanh: ");
                int thang = nhapThang(sc);

                taiLieu = new TapChi(ma, nxb, soBan,
                        soPhatHanh, thang);
                break;

            case 3:
                // Nhap thong tin Bao
                String ngay = nhapNgay(sc);

                taiLieu = new Bao(ma, nxb, soBan, ngay);
                break;

            default:
                return;
        }

        // Them vao danh sach
        if (ql.themTaiLieu(taiLieu)) {
            System.out.println("Them tai lieu thanh cong!");
        } else {
            System.out.println("Ma tai lieu da ton tai!");
        }
    }

    // Ham main: Diem bat dau cua chuong trinh
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        QuanLyTaiLieu ql = new QuanLyTaiLieu();

        int luaChon;

        do {
            System.out.println("\n===== QUAN LY TAI LIEU THU VIEN =====");
            System.out.println("1. Them moi tai lieu");
            System.out.println("2. Xoa tai lieu theo ma");
            System.out.println("3. Hien thi tat ca tai lieu");
            System.out.println("4. Tim kiem tai lieu theo loai");
            System.out.println("5. Thoat");

            luaChon = nhapSoNguyen(sc, "Nhap lua chon: ");

            switch (luaChon) {

                case 1:
                    themMoi(sc, ql);
                    break;

                case 2:
                    System.out.println("\n=== XOA TAI LIEU ===");

                    String maXoa = nhapChuoi(sc,
                            "Nhap ma tai lieu can xoa: ");

                    if (ql.xoaTaiLieu(maXoa)) {
                        System.out.println("Xoa thanh cong!");
                    } else {
                        System.out.println("Khong tim thay ma tai lieu!");
                    }
                    break;

                case 3:
                    System.out.println("\n=== HIEN THI TAI LIEU ===");
                    ql.hienThiTatCa();
                    break;

                case 4:
                    System.out.println("\n=== TIM KIEM THEO LOAI ===");
                    System.out.println("1. Sach");
                    System.out.println("2. Tap Chi");
                    System.out.println("3. Bao");

                    int loai = nhapSoNguyen(sc,
                            "Chon loai can tim: ");

                    ql.timKiemTheoLoai(loai);
                    break;

                case 5:
                    System.out.println("Da thoat chuong trinh!");
                    break;
default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (luaChon != 5);

        sc.close();
    }
}