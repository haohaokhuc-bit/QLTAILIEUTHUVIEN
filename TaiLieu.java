public class TaiLieu {

    // Khai bao cac thuoc tinh
    private String maTaiLieu;
    private String tenNhaXuatBan;
    private int soBanPhatHanh;

    // Constructor
    public TaiLieu(String maTaiLieu,
                   String tenNhaXuatBan,
                   int soBanPhatHanh) {

        this.maTaiLieu = maTaiLieu;
        this.tenNhaXuatBan = tenNhaXuatBan;
        this.soBanPhatHanh = soBanPhatHanh;
    }

    // Lay ma tai lieu
    public String getMaTaiLieu() {
        return maTaiLieu;
    }

    // Hien thi thong tin
    public void hienThiThongTin() {
        System.out.println("Ma tai lieu: " + maTaiLieu);
        System.out.println("Nha xuat ban: " + tenNhaXuatBan);
        System.out.println("So ban phat hanh: " + soBanPhatHanh);
    }
}
