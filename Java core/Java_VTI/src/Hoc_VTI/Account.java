package Hoc_VTI;

public class Account {
    private  int age;
    private Gioitinh gioitinh;
    public Account()
    {

    }

    public Account(int age, Gioitinh gioitinh) {
        this.age = age;
        this.gioitinh = gioitinh;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gioitinh getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Gioitinh gioitinh) {
        this.gioitinh = gioitinh;
    }

    public static void main(String[] args) {
        Account account1=new Account(12,Gioitinh.NAM);
        System.out.println(account1.getAge());
        System.out.println(account1.getGioitinh());
    }
}
