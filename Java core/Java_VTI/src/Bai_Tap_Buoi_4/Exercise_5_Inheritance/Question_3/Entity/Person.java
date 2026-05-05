package Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_3.Entity;

public abstract class Person {

    private String name;
    public Person()
    {

    }
    // Constructor có 1 parameter name
    public Person(String name) {
        this.name = name;
    }

    // Getter và Setter (nếu cần)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
