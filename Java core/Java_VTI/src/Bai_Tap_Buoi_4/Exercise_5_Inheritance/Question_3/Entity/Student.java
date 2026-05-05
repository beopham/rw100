package Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_3.Entity;

public abstract class Student extends Person {
    private int id;
    public Student()
    {

    }

    public Student(int id) {
        this.id = id;
    }

    public Student(String name, int id) {
        super(name);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
