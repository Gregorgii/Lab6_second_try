package things;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvRecurse;
import condition.StudyGroupGenerator;

import java.time.ZonedDateTime;


/**
* The hugest class that include all info about students and calls Study group
*/

public class StudyGroup implements Comparable<StudyGroup> {
    private static final StudyGroupGenerator STUDY_GROUP_GENERATOR = new StudyGroupGenerator();
    @CsvBindByName(column = "IDOFGROUP", required = true)
    private Integer id;//Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @CsvBindByName(column = "NAMEOFGROUP", required = true)
    private String name; //Поле не может быть null, Строка не может быть пустой
    @CsvRecurse
    private Coordinates coordinates; //Поле не может быть null
    @CsvCustomBindByName(column = "CREATIONDATE", required = true, converter = DateConverter.class)
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    @CsvBindByName(column = "STUDENTSCOUNT", required = true)
    private Long studentsCount; //Значение поля должно быть больше 0
    @CsvBindByName(column = "SHOULDBEEXPELLED", required = true)
    private Integer shouldBeExpelled; //Значение поля должно быть больше 0, Поле может быть null
    @CsvBindByName(column = "TRANSFERREDSTUDENTS", required = true)
    private Integer transferredStudents; //Значение поля должно быть больше 0, Поле может быть null
    @CsvBindByName(column = "SEMESTER", required = false)
    private Semester semesterEnum; //Поле не может быть null
    @CsvRecurse
    private Person groupAdmin; //Поле не может быть null

    public StudyGroup(StudyGroupBuilder studyGroupBuilder){
        this.name = studyGroupBuilder.getName();
        this.coordinates = studyGroupBuilder.getCoordinates();
        this.studentsCount = studyGroupBuilder.getStudentsCount();
        this.shouldBeExpelled = studyGroupBuilder.getShouldBeExpelled();
        this.transferredStudents = studyGroupBuilder.getTransferredStudents();
        this.semesterEnum = studyGroupBuilder.getSemesterEnum();
        this.groupAdmin = studyGroupBuilder.getGroupAdmin();
    }


    public void setId(Integer id) {this.id = id;}

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
    * @return The info about Study Group (id)
    */

    public Integer getId(){
        return id;
    }
    /**
    * @return The info about Study Group (name)
    */
    public String getName(){
        return name;
    }
    /**
    * @return The info about Study Group (coordinates)
    */

    public Coordinates getCoordinates(){
        return coordinates;
    }
    /**
    * @return The info about Study Group (creation date)
    */

    public ZonedDateTime getCreationDate(){
        return creationDate;
    }

    /**
    * @return The info about Study Group (count of studs)
    */

    public Long getStudentsCount(){
        return studentsCount;
    }
    /**
    * @return The info about Study Group (how much should be expelled)
    */
    

    public Integer getShouldBeExpelled(){
        return shouldBeExpelled;
    }
    /**
    * @return The info about Study Group (how much was transferred)
    */

    public Integer getTransferredStudents(){
        return transferredStudents;
    }
    /**
    * @return The info about Study Group (number of sem)
    */

    public Semester getSemesterEnum(){
        return semesterEnum;
    }
    /**
    * @return The info about Study Group (groups admin)
    */

    public Person getGroupAdmin(){
        return groupAdmin;
    }
    public static StudyGroupGenerator getStudyGroupGenerator(){return STUDY_GROUP_GENERATOR; }


    @Override
    public int compareTo(StudyGroup o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString(){
        return "Name of group " + name + " with id: " + id + "\n"
                + "with count of students " + studentsCount +" and should be expelled " + shouldBeExpelled + "\n"
                + "with transferred students " + transferredStudents + " and semester " + semesterEnum + "\n"
                + "and with group admin " + groupAdmin.toString() + "\n";
    }
}