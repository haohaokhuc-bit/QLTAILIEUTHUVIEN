public class TapChi extends TaiLieu {

    // Khai bao cac thuoc tinh rieng cua Tap Chi
    private int soPhatHanh;
    private int thangPhatHanh;

    // Constructor
    public TapChi(String maTaiLieu, String tenNhaXuatBan,
                  int soBanPhatHanh, int soPhatHanh,
                  int thangPhatHanh) {

        // Goi constructor cua lop cha TaiLieu
        super(maTaiLieu, tenNhaXuatBan, soBanPhatHanh);

        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
    }

    // Lay so phat hanh
    public int getSoPhatHanh() {
        return soPhatHanh;
    }

    // Lay thang phat hanh
    public int getThangPhatHanh() {
        return thangPhatHanh;
    }

    // Hien thi thong tin Tap Chi
    @Override
    public void hienThiThongTin() {
        System.out.println("Loai tai lieu: Tap Chi");

        // Hien thi thong tin chung tu lop cha
        super.hienThiThongTin();

        // Hien thi thong tin rieng cua Tap Chi
        System.out.println("So phat hanh: " + soPhatHanh);
        System.out.println("Thang phat hanh: " + thangPhatHanh);
    }
}