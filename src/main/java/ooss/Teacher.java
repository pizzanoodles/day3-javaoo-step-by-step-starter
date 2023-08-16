package ooss;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private List<Klass> classes = new ArrayList<>();

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        if (this.classes.size() == 1) {
            if (this.classes.get(0).getLeader() != null) {
                return String.format("My name is %s. I am %d years old. I am a %s. I teach Class %d. I know %s become leader.",
                        super.getName(), super.getAge(), "teacher", this.classes.get(0).getNumber(), this.classes.get(0).getLeader());
            }
            return String.format("My name is %s. I am %d years old. I am a %s. I teach Class %d.",
                    super.getName(), super.getAge(), "teacher", this.classes.get(0).getNumber());
        } else {
            return String.format("My name is %s. I am %d years old. I am a %s. I teach Class %s.",
                    super.getName(), super.getAge(), "teacher", buildMultipleClassesString(getClassNumberList()));
        }
    }

    private String buildMultipleClassesString(List<Integer> classNumbersList) {
        StringBuilder classNumbersString = new StringBuilder();
        classNumbersList.forEach(number -> classNumbersString.append(number).append(", "));
        return classNumbersString.deleteCharAt(classNumbersString.length() - 2)
                .toString().trim();
    }

    private List<Integer> getClassNumberList() {
        return this.classes.stream()
                .map(Klass::getNumber)
                .collect(Collectors.toList());
    }

    public void assignTo(Klass klass) {
        this.classes.add(klass);
    }

    public boolean belongsTo(Klass klassToFind) {
        return this.classes.contains(klassToFind);
    }

    public boolean isTeaching(Student student) {
        return this.classes.contains(student.getKlass());
    }

    public List<Klass> getClasses() {
        return classes;
    }
}
