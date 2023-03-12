package Lab3.Homework;

import java.util.HashMap;

/**
 * The type Programmer, a child of Person who contains
 * In addition we have a String programmingLanguage member and a boolean usesVSCode variable.
 * @author Apricopoai Andrei
 * @version 1.0.
 */
public class Programmer extends Person{

    private String programmingLanguage;
    private boolean usesVSCode;

    /**
     * Instantiates a new Programmer.
     *
     * @param name                the name
     * @param birthDate           the birthdate
     * @param programmingLanguage the programming language
     * @param usesVSCode          the uses vs code
     */
    public Programmer(String name, String birthDate, String programmingLanguage, boolean usesVSCode) {
        super(name, birthDate);
        this.programmingLanguage = programmingLanguage;
        this.usesVSCode = usesVSCode;

    }

    /**
     * Instantiates a new Programmer.
     *
     * @param name                the name
     * @param birthDate           the birthdate
     * @param programmingLanguage the programming language
     * @param usesVSCode          the uses vs code
     * @param realtionships       the realtionships
     */
    public Programmer(String name, String birthDate,String programmingLanguage, boolean usesVSCode, HashMap<Node, String> realtionships) {
        super(name, birthDate, realtionships);
        this.programmingLanguage = programmingLanguage;
        this.usesVSCode = usesVSCode;
    }

    /**
     * Gets programming language.
     *
     * @return the programming language
     */
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    /**
     * Sets programming language.
     *
     * @param programmingLanguage the programming language
     */
    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    /**
     * Is uses vs code boolean.
     *
     * @return the boolean
     */
    public boolean isUsesVSCode() {
        return usesVSCode;
    }

    /**
     * Sets uses vs code.
     *
     * @param usesVSCode the uses vs code
     */
    public void setUsesVSCode(boolean usesVSCode) {
        this.usesVSCode = usesVSCode;
    }


    /**
     * This function generates a nice textual representation of the Designer object created.
     *
     * @return a nice textual representation of the Designer object created as a String object.
     */
    @Override
    public String toString() {
        return "Programmer{" +
                "programmingLanguage='" + programmingLanguage + '\'' +
                ", usesVSCode=" + usesVSCode +
                '}';
    }
}
