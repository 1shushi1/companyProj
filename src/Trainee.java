import java.math.BigDecimal;
import java.time.LocalDate;

public class Trainee extends Employee{
    private LocalDate practiceStartDate;
    private int amountOfPracticeDays;

    public Trainee(String name, String surname, LocalDate birthDate, BigDecimal salary, LocalDate practiceStartDate, int amountOfPracticeDays){
        super(name, surname, birthDate, salary);
        this.practiceStartDate = practiceStartDate;
        this.amountOfPracticeDays = amountOfPracticeDays;
    }
    public LocalDate getPracticeStartDate(){

        return practiceStartDate;
    }
    public int getAmountOfPracticeDays(){
        return amountOfPracticeDays;
    }
}
