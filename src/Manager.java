import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Manager extends Worker {

    //subordinates - підлеглі
    //immediate subordinates - безпосередні підлеглі
    private List<Employee> subordinates = new ArrayList<>(); // list of immediate subordinates
    private Set<Employee> allSubordinates = new HashSet<>(); // list of subordinates in all hierarchy


    public Manager(String name, String surname, LocalDate birthDate, BigDecimal salary, LocalDate employmentDate, BigDecimal bonus) {
        super(name, surname, birthDate, salary, employmentDate, bonus);
    }

    public void addSubordinateToManager(Employee employee) {
        subordinates.add(employee);
        allSubordinates.add(employee);
        if (employee instanceof Manager) {
            Manager manager = (Manager) employee;
            Set<Employee> employeeSet = manager.getAllSubordinates();
            this.allSubordinates.addAll(employeeSet);
        }
    }

    public void delSubordinateFromManager(Employee employee) {
        subordinates.remove(employee);
        allSubordinates.remove(employee);
    }

    public Set<Employee> getAllSubordinates() {
        return allSubordinates;
    }
    public List<Employee> getSubordinates(){
        return subordinates;
    }
}
