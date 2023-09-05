package condition;

import things.Person;
import things.Semester;

import java.util.ArrayDeque;
import java.util.Scanner;

public abstract class Condition {
    private String name;
    private Double x;
    private Float y;
    private Long studentsCount;
    private Integer shouldBeExpelled;
    private Semester semesterEnum;
    private Person groupAdmin;
    private Scanner scanner;
    private ArrayDeque<String> errs = new ArrayDeque<>();

    public Condition(Scanner scanner) { this.scanner = scanner; }

    public abstract void generateStudyGroupFields();

    public boolean isCorrect() { return errs.isEmpty(); }

    public void errHandler() {
        while (!errs.isEmpty()){
            System.out.println(errs.remove());
        }
    }
    public String getName() { return name; }

    public Double getX() {return x; }

    public Float getY() {return y; }

    public Long getStudentsCount() {return studentsCount; }

    public Integer getShouldBeExpelled() {return shouldBeExpelled; }

    public Semester getSemesterEnum() {return semesterEnum; }

    public Person getGroupAdmin() {return groupAdmin; }

    public void setName(String name) {this.name = name; }

    public void setX(Double x) {this.x = x; }

    public void setY(Float y) {this.y = y; }

    public void setStudentsCount(Long studentsCount) {this.studentsCount = studentsCount; }

    public void setShouldBeExpelled(Integer shouldBeExpelled) {this.shouldBeExpelled = shouldBeExpelled; }

    public void setSemesterEnum(Semester semesterEnum) {this.semesterEnum = semesterEnum; }

    public void setGroupAdmin(Person groupAdmin) {this.groupAdmin = groupAdmin; }

    public Scanner getScanner() {return scanner; }

    public ArrayDeque<String> getErrs() {return errs; }

    public void setErrs(ArrayDeque<String> errs) {this.errs = errs; }

    public void setScanner(Scanner scanner) {this.scanner = scanner; }
}
