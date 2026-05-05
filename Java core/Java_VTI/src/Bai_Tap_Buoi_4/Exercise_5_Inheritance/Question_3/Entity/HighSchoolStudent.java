package Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_3.Entity;

public class HighSchoolStudent extends Student
{
    private String clazz;
    private String desiredUniversity;

    public HighSchoolStudent()
    {

    }

    public HighSchoolStudent(String name, int id, String clazz, String desiredUniversity) {
        super(name, id);
        this.clazz = clazz;
        this.desiredUniversity = desiredUniversity;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getDesiredUniversity() {
        return desiredUniversity;
    }

    public void setDesiredUniversity(String desiredUniversity) {
        this.desiredUniversity = desiredUniversity;
    }
    public void showIn4() {
        System.out.println("--- Thông tin HighSchoolStudent ---");
        System.out.println("ID: " + this.getId());
        System.out.println("Họ tên: " + this.getName());
        System.out.println("Lớp: " + this.getClazz());
        System.out.println("Trường ĐH mong muốn: " + this.getDesiredUniversity());
    }
}
