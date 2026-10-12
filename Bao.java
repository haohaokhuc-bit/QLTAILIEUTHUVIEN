public class Bao extends TaiLieu {

    // Khai bao thuoc tinh rieng cua Bao
    private String ngayPhatHanh;

    // Constructor
    public Bao(String maTaiLieu, String tenNhaXuatBan,
               int soBanPhatHanh, String ngayPhatHanh) {

        // Goi constructor cua lop cha TaiLieu
        super(maTaiLieu, tenNhaXuatBan, soBanPhatHanh);

        this.ngayPhatHanh = ngayPhatHanh;
    }

    // Lay ngay phat hanh
    public String getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    // Hien thi thong tin Bao
    @Override
    public void hienThiThongTin() {
        System.out.println("Loai tai lieu: Bao");

        // Hien thi thong tin chung tu lop cha
        super.hienThiThongTin();

        // Hien thi thong tin rieng cua Bao
        System.out.println("Ngay phat hanh: " + ngayPhatHanh);
    }
}