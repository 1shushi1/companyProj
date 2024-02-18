import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class HumanResourcesStatistic {
    //подготовка заработной платы для всех работников
    public static List<PayrollEntry> payroll(List<Employee> employees) {
        return employees.stream().distinct().map(e -> new PayrollEntry(e, e.getSalary(), e instanceof Worker ? ((Worker) e).getBonus() : null)).toList();
    }

    //подготовка заработной платы для подчиненных данного менеджера
    public static List<PayrollEntry> payrollForPartManagerSubordinates(Manager manager) {
        return payroll(manager.getSubordinates());
    }

    //вычисления общей стоимости бонусов
    public static BigDecimal totalBonusAmount(List<Employee> employees) {
        return employees.stream().distinct().map(e -> e instanceof Worker && ((Worker) e).getBonus() != null ? ((Worker) e).getBonus() : BigDecimal.ZERO).reduce((b1, b2) -> b1.add(b2)).get();
    }

    //поиск сотрудника со старейшим стажем
    public static Employee theMostExperienceEmp(List<Employee> employees) {
        return employees.stream().distinct().filter(e -> e instanceof Worker).max((e1, e2) -> ((Worker) e1).getEmploymentDate().compareTo(((Worker) e2).getEmploymentDate())).get();
    }

    //поиск самой высокой зарплаты без бонуса (зряплата должна быть возвращена)
    public static BigDecimal theHighestSalary(List<Employee> employees) {
        return employees.stream().distinct().map(e -> e.getSalary()).max((s1, s2) -> s1.compareTo(s2)).get();
    }

    //поиск самой низкой зарплаты с бонусом (зряплата должна быть возвращена)

    public static BigDecimal theLowestSalIncludingBonus(List<Employee> employees) {
        return payroll(employees).stream().map(s -> s.getSalaryPlusBonus()).min((s1, s2) -> s1.compareTo(s2)).get();
    }

    //поиск сотрудников, фамилии которых начинаются с буквы "А" данного менеджера
    public static List<Employee> findBySurname(Manager manager) {
        return manager.getSubordinates().stream().distinct().filter(e -> e.getLastName().startsWith("A")).toList();
    }

    //Поиск сотрудников, зарабатывающих более 1000 s
    public static List<Employee> salaryMoreThanPartSum(List<Employee> employees, BigDecimal comparisonValue) {
        return payroll(employees).stream().distinct().filter(e -> e.getSalaryPlusBonus().compareTo(comparisonValue) > 0).map(e -> e.getEmployee()).toList();
    }

    //Сколько сотрудников, являющихся непосредственными подчиненными конкретного менеджера
    //зарабатывают более такой-то суммы?

    public static long amountOfEmpEarningMoreThanPartSum(Manager manager, BigDecimal comparisonValue) {
        return manager.getSubordinates().stream().distinct().filter(e -> e.getSalary().compareTo(comparisonValue) > 0).count();
    }

    //визначити кількість якихось конкретних співробітників з віком від та до.
    public static long amountOfEmployeesWithPartAge(List<Employee> allEmployees, String position, int ageFrom, int ageTo) {
        return allEmployees.stream().distinct().filter(e -> e.getClass().getSimpleName().equalsIgnoreCase(position) && e.age() > ageFrom && e.age() < ageTo).count();
    }

    //збільшити зарплптню на 10% для всіх співробітників, які заробляють в загальному менше  суми що передається
    public static List<Employee> salaryIncrease(List<Employee> employees, BigDecimal sal) {
        return payroll(employees).stream().distinct().filter(e -> e.getSalaryPlusBonus().compareTo(sal) < 0)
                .peek(e -> e.getEmployee().getSalary().add(e.getEmployee().getSalary().multiply(new BigDecimal(0.1)))).map(e -> e.getEmployee()).toList();
    }

    //визначити кількість співробітників по кожній з посад
    public static Map<String, Long> amountOfEmployeesOnEachPosition(List<Employee> employees) {
        return employees.stream().distinct().collect(Collectors.groupingBy(e -> e.getClass().getSimpleName(), Collectors.counting()));
    }

    //підрахувати фонд зарплат по кожній посаді
    public static Map<String, DoubleSummaryStatistics> sumOfMoneyEachManagerShouldPayToEmp(List<Employee> employees){
        return payroll(employees).stream().collect(Collectors.groupingBy(e -> e.getEmployee().getClass().getSimpleName(), Collectors.summarizingDouble(e -> e.getSalaryPlusBonus().doubleValue())));
    }
    //вивести всых спывробытникыв для кожноъ посади
    public static Map<String, List<Employee>> positionEmployeeList (List<Employee> employees){
        return employees.stream().distinct().collect(Collectors.groupingBy(e -> e.getClass().getSimpleName()));
    }
    //знайти посаду в якій найбільше співробітників
    public static String positionWithTheMostEmp(List<Employee> employees){
        return positionEmployeeList(employees).entrySet().stream().max((a, b) -> a.getValue().size() - b.getValue().size()).get().getKey();
    }

    //знайти кількість співробітників що немають бонусів на даний момент
    public static long amountOfEmpWhoDoesntHaveBonuses (List<Employee> employees){
        return employees.stream().distinct().filter(e -> !(e instanceof Worker) || ((Worker) e).getBonus() == null).count();
    }

    //значти прізвища співробітників, які отримають прибуток в такому-то діапвзоні і видати іх у порядку зменшення довжин цих прізаищ
    public static List<Employee> empWhichGetsSalInPartRangeBySurnameLengthDESC(List<Employee> employees, BigDecimal salaryFrom, BigDecimal salaryTo){
        return payroll(employees).stream().filter(e -> e.getSalaryPlusBonus().compareTo(salaryFrom) >= 1 && e.getSalaryPlusBonus().compareTo(salaryTo) <= 1)
                .sorted((a, b) -> -(a.getEmployee().getLastName().length() - b.getEmployee().getLastName().length())).map(e -> e.getEmployee()).toList();
    }

    //приймає масив стрінгів та повертаєто суму цифр в ньому
    public static long sumOfTheNum (String [] arr){
        return Arrays.stream(arr)
                .mapToLong(str -> str.chars()
                        .filter(Character::isDigit)
                        .mapToObj(Character::getNumericValue)
                        .mapToInt(Integer::intValue)
                        .sum())
                .sum();
    }
}
