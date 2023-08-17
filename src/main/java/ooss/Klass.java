package ooss;

public class Klass {
    private final int number;
    private Student leader;
    private Teacher attachedTeacher;
    private Student attachedStudent;

    public Klass(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass klass = (Klass) o;
        return number == klass.number;
    }

    public int getNumber() {
        return number;
    }

    public void assignLeader(Student student) {
        //TODO: this can be converted into Stream to make it shorter
        if (this == student.getKlass()) {
            this.leader = student;
            if (this.attachedTeacher != null) {
                Klass klass = attachedTeacher.getClasses().get(0);
                System.out.printf("I am %s, teacher of Class %d. I know %s become Leader.",
                        attachedTeacher.getName(), klass.getNumber(), klass.getLeader().getName());
            }
            if (this.attachedStudent != null) {
                Klass klass = attachedStudent.getKlass();
                System.out.printf("I am %s, student of Class %d. I know %s become Leader.",
                        attachedStudent.getName(), klass.getNumber(), klass.getLeader().getName());
            }
        } else System.out.println("It is not one of us.");
    }

    public boolean isLeader(Student student) {
        return this.leader == student;
    }

    public Student getLeader() {
        return this.leader;
    }

    //TODO: this can be converted into observer patter to avoid duplicate methods

    public void attach(Teacher teacher) {
        this.attachedTeacher = teacher;
    }
    public void attach(Student student) {
        this.attachedStudent = student;
    }
}
