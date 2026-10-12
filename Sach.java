public class Sach extends TaiLieu {

    // Khai bao cac thuoc tinh rieng cua Sach
    private String tenTacGia;
    private int soTrang;

    // Constructor
    public Sach(String maTaiLieu, String tenNhaXuatBan,
                int soBanPhatHanh, String tenTacGia, int soTrang) {

        // Goi constructor cua lop cha TaiLieu
        super(maTaiLieu, tenNhaXuatBan, soBanPhatHanh);

        this.tenTacGia = tenTacGia;
        this.soTrang = soTrang;
    }

    // Lay ten tac gia
    public String getTenTacGia() {
        return tenTacGia;
    }

    // Lay so trang
    public int getSoTrang() {
        return soTrang;
    }

    // Hien thi thong tin Sach
    @Override
    public void hienThiThongTin() {
        System.out.println("Loai tai lieu: Sach");

        // Hien thi thong tin chung tu lop cha
        super.hienThiThongTin();

        // Hien thi thong tin rieng cua Sach
        System.out.println("Ten tac gia: " + tenTacGia);
        System.out.println("So trang: " + soTrang);
    }
}