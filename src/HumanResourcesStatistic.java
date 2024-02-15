import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class HumanResourcesStatistic{
    //подготовка заработной платы для всех работников
    public static List<PayrollEntry> payroll(List<Employee> employees){
        return employees.stream().distinct().map(e -> new PayrollEntry(e, e.getSalary(), e instanceof Worker ? ((Worker) e).getBonus() : null)).toList();
    }
    //подготовка заработной платы для подчиненных данного менеджера
    public static List<PayrollEntry> payrollForPartManagerSubordinates(Manager manager){
        return payroll(manager.getSubordinates());
    }

    //вычисления общей стоимости бонусов
    public static BigDecimal totalBonusAmount(List<Employee> employees){
        return employees.stream().distinct().map(e -> e instanceof Worker && ((Worker) e).getBonus() != null ? ((Worker) e).getBonus() : BigDecimal.ZERO).reduce((b1, b2) -> b1.add(b2)).get();
    }

    //поиск сотрудника со старейшим стажем
    public static Employee theMostExperienceEmp(List<Employee> employees){
        return employees.stream().distinct().filter(e -> e instanceof Worker).max((e1, e2) -> ((Worker) e1).getEmploymentDate().compareTo(((Worker) e2).getEmploymentDate())).get();
    }

    //поиск самой высокой зарплаты без бонуса (зряплата должна быть возвращена)
    public static BigDecimal theHighestSalary(List<Employee> employees){
        return employees.stream().distinct().map(e -> e.getSalary()).max((s1, s2) -> s1.compareTo(s2)).get();
    }

    //поиск самой низкой зарплаты с бонусом (зряплата должна быть возвращена)

    public static BigDecimal theLowestSalIncludingBonus(List<Employee> employees){
        return payroll(employees).stream().map(s -> s.getSalaryPlusBonus()).min((s1, s2) -> s1.compareTo(s2)).get();
    }

    //поиск сотрудников, фамилии которых начинаются с буквы "А" данного менеджера
    public static List<Employee> findBySurname(List<Employee> employees){
        return employees.stream().distinct().filter(e -> e.getLastName().startsWith("A")).toList();
    }

    //Поиск сотрудников, зарабатывающих более 1000 s
    public static List<Employee> salaryMoreThanPartSum(List<Employee> employees, BigDecimal comparisonValue){
        return employees.stream().distinct().filter(e -> e.getSalary().compareTo(comparisonValue) > 0).toList();
    }

    //Сколько сотрудников, являющихся непосредственными подчиненными конкретного менеджера
    //зарабатывают более такой-то суммы?

    public static long amountOfEmpEarningMoreThanPartSum(Manager manager, BigDecimal comparisonValue){
        return manager.getSubordinates().stream().distinct().filter(e -> e.getSalary().compareTo(comparisonValue) > 0).count();
    }
}
