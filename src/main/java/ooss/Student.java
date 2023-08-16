package ooss;

public class Student extends Person {
    private Klass klass;

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        return String.format("My name is %s. I am %d years old. I am a %s. I am in class %s.", super.getName(), super.getAge(), "student", klass.getNumber());
    }
    public void join(Klass klass) {
        this.klass = klass;
    }
    public boolean isIn(Klass klass) {
        return this.klass == klass;
    }
    public Klass getKlass() {
        return this.klass;
    }
}
