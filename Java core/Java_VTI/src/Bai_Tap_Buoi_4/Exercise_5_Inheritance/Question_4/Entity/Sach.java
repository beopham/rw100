package Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_4.Entity;

public class Sach extends TaiLieu{
    private String tenTacGia;
    private int soTrang;
    public Sach()
    {

    }
    public Sach(String maTaiLieu, String tenNXB, int soBanPhatHanh, String tenTacGia, int soTrang) {
        super(maTaiLieu, tenNXB, soBanPhatHanh);
        this.tenTacGia = tenTacGia;
        this.soTrang = soTrang;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    @Override
    public void show() {
        System.out.println("---------- THÔNG TIN SÁCH ----------");
        System.out.println("Mã tài liệu: " + getMaTaiLieu());
        System.out.println("Tên nhà xuất bản: " + getTenNXB());
        System.out.println("Số bản phát hành: " + getSoBanPhatHanh());
        System.out.println("Tên tác giả: " + this.tenTacGia);
        System.out.println("Số trang: " + this.soTrang);
        System.out.println("------------------------------------");
    }
}
