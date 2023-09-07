package things;

import java.time.LocalDate;

/**
* The class Person th work w persons
*/

public class Person {

    private String name; //Поле не может быть null, Строка не может быть пустой

    private LocalDate birthday; //Поле не может быть null

    private Long weight; //Значение поля должно быть больше 0

    private String passportID; //Строка не может быть пустой, Поле не может быть null

    /**
     * @param name
     * @param birthday
     * @param weight
     * @param passportID
     */
    public Person(String name, LocalDate birthday, Long weight, String passportID){
        this.name = name;
        this.birthday = birthday;
        this.weight = weight;
        this.passportID = passportID;
    }
    /**
     * @return The persons name
     */

    public Person(){

    }

    public String getName(){
        return name;
    }
    /**
     * @return The persons bday
     */

    public LocalDate getBirthday(){
        return birthday;
    }
    /**
     * @return The perss weight
     */

    public Long getWeight(){
        return weight;
    }

    /**
     * @return The perses passportID
     */

    public String getPassportID(){
        return passportID;
    }

    @Override
    public String toString(){
        return " Admin with name " + name + " and with birthday " + birthday + "\n"
                + "and passport ID " + passportID + "\n";
    }
    
}
