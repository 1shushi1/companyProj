import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Employee extends Person{
    private BigDecimal salary;
    private Manager manager;
    protected Employee(String name, String surname, LocalDate birthDate, BigDecimal salary){
        super(name, surname, birthDate);
        this.salary = salary;
    }
    public void setManager(Manager manager){
        this.manager = manager;
    }
    public BigDecimal getSalary(){
        return salary;
    }
    public Manager getManager(){
        return manager;

    }
}
