import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public abstract class Person {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    protected Person(String firstName, String lastName, LocalDate birthDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
    public int age (){
        LocalDate localDate = LocalDate.now();
        Period period = Period.between(birthDate, localDate);
        return period.getYears();
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public LocalDate getBirthDate(){
        return birthDate;
    }
    @Override
    public String toString(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Name : " + firstName + ". Surname : " + lastName + ". Date of birth : " + birthDate.format(dateTimeFormatter);
    }
    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        if (o == null){
            return false;
        }
        if (o.getClass() != this.getClass()){
            return false;
        }
        Person person = (Person) o;
        return person.getFirstName().equals(getFirstName()) && person.getLastName().equals(getLastName()) && person.getBirthDate().equals(getBirthDate());
    }
    @Override
    public int hashCode(){
        int hashCode = 13;
        hashCode = 13 * hashCode + firstName.hashCode();
        hashCode = 13 * hashCode + lastName.hashCode();
        return 13 * hashCode + birthDate.hashCode();
    }

}
