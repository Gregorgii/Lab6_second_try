package managers;

import exceptions.WrongField;
import things.Coordinates;
import things.Person;
import things.Semester;
import things.StudyGroup;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class IoManager {
    /**
     * Read integer from terminal.
     * @return Integer number or null, if input is empty.
     * @throws NumberFormatException if input does not integer number.
     */
    public Integer inputInt() throws NumberFormatException{
        Scanner scanner = new Scanner(System.in);
        String raw = scanner.nextLine();
        if(raw.isEmpty()) return null;
        return Integer.parseInt(raw);
    }

    /**
     * Read long int from terminal.
     * @return Long number or null, if input is empty.
     * @throws NumberFormatException if input does not long integer number.
     */
    public String inputString() {
        Scanner scanner = new Scanner(System.in);
        String raw = scanner.nextLine();
        if(raw.isEmpty()) return null;
        return raw;
    }



    /**
     * Read long int from terminal.
     * @return Long number or null, if input is empty.
     * @throws NumberFormatException if input does not long integer number.
     */
    public Long inputLong() throws NumberFormatException{
        Scanner scanner = new Scanner(System.in);
        String raw = scanner.nextLine();
        if(raw.isEmpty()) return null;
        return Long.parseLong(raw);
    }

    /**
     * Read float from terminal.
     * @return Float number or null, if input is empty.
     * @throws NumberFormatException if input does not floating point number.
     */
    public Float inputFloat() throws NumberFormatException{
        Scanner scanner = new Scanner(System.in);
        String raw = scanner.nextLine();
        if(raw.isEmpty()) return null;
        return Float.parseFloat(raw);
    }


    /**
     * Read double from terminal.
     * @return Double number or null, if input is empty.
     * @throws NumberFormatException if input does not floating point number.
     */
    public Double inputDouble() throws NumberFormatException{
        Scanner scanner = new Scanner(System.in);
        String raw = scanner.nextLine();
        if(raw.isEmpty()) return null;
        return Double.parseDouble(raw);
    }


    /**
     * Requests Coordinates from terminal.
     * @return Coordinates object
     * @see Coordinates
     */
    public Coordinates requestCoordinates(){
        Coordinates coordinates = new Coordinates();

        // request X
        while (true){
            try{
                System.out.println("Введите координату x");
                coordinates.setX(this.inputDouble());
                break;
            } catch (WrongField e){
                System.out.println("Wrong X. " + e.getMessage() + ". Enter again");
            } catch (NumberFormatException e){
                System.out.println("x должен быть типа double");
            }
        }

        // request Y
        while (true){
            try{
                System.out.println("Введите координату y");
                coordinates.setY(this.inputFloat());
                break;
            }catch (WrongField e){
                System.out.println("Wrong Y. " + e.getMessage() + ". Enter again");
            }catch (NumberFormatException e){
                System.out.println("Y должен быть типа float");
            }
        }

        return coordinates;
    }


    public StudyGroup requestStudyGroup() {
        System.out.println("Введите название группы");
        String name = inputString();
        Coordinates coordinates = requestCoordinates();
        ZonedDateTime creationDate = ZonedDateTime.now();
        System.out.println("Введите количество студентов");
        Long studentsCount = inputLong();
        System.out.println("Введите количество отчисляемых");
        Integer shouldBeExpelled  = inputInt();
        System.out.println("Введите количество переведенных");
        Integer transferredStudents = inputInt();
        System.out.println("Введите название семестра");
        Semester semesterEnum = requestSemester();
        Person groupAdmin = requestPerson();

        return new StudyGroup(name, coordinates, creationDate, studentsCount, shouldBeExpelled, transferredStudents, semesterEnum, groupAdmin);
    }

    public Semester requestSemester() {
        Semester outSemester;
        for (Semester semester : Semester.values()) {
            System.out.println(semester);
        }
        System.out.println();
        while (true) {
            try {
                String option = this.inputString().strip();
                outSemester = Semester.valueOf(option.toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Выберите один из выведенных семестров");
            } catch (NullPointerException e) {
                outSemester = null;
                break;
            }
        }
        return outSemester;
    }


    public Person requestPerson(){
        System.out.println("Введите имя человека");
        String name = inputString();
        System.out.println("Введите дату в формате yyyy-MM-dd:");
        LocalDate birthday = requestDate();
        System.out.println("Введите вес человека");
        long weight = inputLong();
        System.out.println("Введите номер паспорта");
        String passportID = inputString();
        return new Person(name, birthday, weight, passportID);
    }


    private LocalDate requestDate() {
        LocalDate date = null;
        while (date == null) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                date = LocalDate.parse(inputString(), formatter);
            } catch (Exception e) {
                System.out.println("Неверный формат даты. Попробуйте еще раз.");
            }
        }
        return date;
    }
}

