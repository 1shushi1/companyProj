import java.math.BigDecimal;
import java.time.LocalDate;

public class Worker extends Employee{
    private LocalDate employmentDate;
    private BigDecimal bonus;

    public Worker(String name, String surname, LocalDate birthDate, BigDecimal salary, LocalDate employmentDate, BigDecimal bonus){
        super(name, surname, birthDate, salary);
        this.employmentDate = employmentDate;
        this.bonus = bonus;
    }

    public LocalDate getEmploymentDate(){
        return employmentDate;
    }
    public BigDecimal getBonus(){
        return bonus;
    }
}
