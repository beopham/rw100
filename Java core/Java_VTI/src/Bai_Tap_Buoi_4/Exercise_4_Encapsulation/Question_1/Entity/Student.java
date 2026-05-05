package Bai_Tap_Buoi_4.Exercise_4_Encapsulation.Question_1.Entity;

public class Student {
    private int id;
    private String name;
    private String hometown;
    private double score; // Điểm học lực

    public Student() {

    }

    public Student(int id, String name, String hometown) {
        this.id = id;
        this.name = name;
        this.hometown = hometown;
        this.score = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        if (score >= 0 && score <= 10) {
            this.score = score;
        } else {
            System.out.println("Cảnh báo: Điểm " + score + " không hợp lệ!");
        }
    }

    //    Tạo 1 method cho phép cộng thêm điểm
    public double CongThemDiem(double diem_cong) {

        double Diemtamthoi=0;
        Diemtamthoi=this.score+diem_cong;
        // ta cập nhập điểm;
        this.score=Diemtamthoi;
        return this.score;
    }
    // Hàm hiển thị thông tin
    public void showInfo() {
        System.out.println("Thông tin sinh viên:");
        System.out.println("ID: " + id);
        System.out.println("Tên: " + name);
        System.out.println("Quê quán: " + hometown);
        if(this.score >=8)
        {
            System.out.println("Điểm: " + score);
            System.out.println("giỏi");
        }
        else if(this.score >=6 && this.score<8)
        {
            System.out.println("Điểm: " + score);
            System.out.println("khá");
        }
        else if(this.score >=4 && this.score<6)
        {
            System.out.println("Điểm: " + score);
            System.out.println("TB");
        }
        else
        {
            System.out.println("YẾU");
        }
        System.out.println("--------------------");
    }
}
