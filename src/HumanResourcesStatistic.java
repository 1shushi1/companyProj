import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public static Map<String, DoubleSummaryStatistics> sumOfMoneyEachManagerShouldPayToEmp(List<Employee> employees) {
        return payroll(employees).stream().collect(Collectors.groupingBy(e -> e.getEmployee().getClass().getSimpleName(), Collectors.summarizingDouble(e -> e.getSalaryPlusBonus().doubleValue())));
    }

    //вивести всых спывробытникыв для кожноъ посади
    public static Map<String, List<Employee>> positionEmployeeList(List<Employee> employees) {
        return employees.stream().distinct().collect(Collectors.groupingBy(e -> e.getClass().getSimpleName()));
    }

    //знайти посаду в якій найбільше співробітників
    public static String positionWithTheMostEmp(List<Employee> employees) {
        return positionEmployeeList(employees).entrySet().stream().max((a, b) -> a.getValue().size() - b.getValue().size()).get().getKey();
    }

    //знайти кількість співробітників що немають бонусів на даний момент
    public static long amountOfEmpWhoDoesntHaveBonuses(List<Employee> employees) {
        return employees.stream().distinct().filter(e -> !(e instanceof Worker) || ((Worker) e).getBonus() == null).count();
    }

    //значти прізвища співробітників, які отримають прибуток в такому-то діапвзоні і видати іх у порядку зменшення довжин цих прізаищ
    public static List<Employee> empWhichGetsSalInPartRangeBySurnameLengthDESC(List<Employee> employees, BigDecimal salaryFrom, BigDecimal salaryTo) {
        return payroll(employees).stream().filter(e -> e.getSalaryPlusBonus().compareTo(salaryFrom) >= 1 && e.getSalaryPlusBonus().compareTo(salaryTo) <= 1)
                .sorted((a, b) -> -(a.getEmployee().getLastName().length() - b.getEmployee().getLastName().length())).map(e -> e.getEmployee()).toList();
    }

    //приймає масив стрінгів та повертаєто суму цифр в ньому
    public static long sumOfTheNum(String[] arr) {
        return Arrays.stream(arr).reduce((s1, s2) -> s1 + s2).get().chars().filter(e -> Character.isDigit(e)).map(e -> e - 48).reduce((s1, s2) -> s1 + s2).getAsInt();
    }

    //є файл текстовий. Визначити скільки в нього слів (роздільником є пробіл ) з розміром більше такого-то
    public static long method(String wordToCompare, String path) throws IOException {
        return Files.lines(Path.of(path)).flatMap(e -> Arrays.stream(e.split(" "))).filter(e -> e.length() > wordToCompare.length()).count();

    }

    //ф-я  скачує текстовий файл та повертає кільеість приголосних в ньому
    public static long amountOfConsonants(String path) throws IOException {
        return Files.readString(Path.of(path)).chars().mapToObj(c -> (char) c).filter(c -> Character.isLetter(c) &&
                !(c.equals('a') || c.equals('e') || c.equals('i') || c.equals('u') || c.equals('o') || c.equals('A') || c.equals('E') || c.equals('I') || c.equals('U') || c.equals('O'))).count();
    }

    //приймаємо лист інтів та повертаємо суму цифр з них
    public static int sumOfTheNumbers(List<Integer> integers) {
        return integers.stream().map(e -> e + "").reduce((s1, s2) -> s1 + s2).get().chars().map(e -> e - 48).reduce((c1, c2) -> c1 + c2).getAsInt();
    }

    //приймаємо лист стрінгів та визначаємо кількість кожного зі стрінгів
    public static Map<String, Long> stringLongMap(List<String> strings) {
        return strings.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }

    //отримаємо масив інтів та повертаємо лист відсортований за спаданням без дублікатів та парних чисел
    public static List<Integer> sortedIntegers(int[] integers) {
        return Arrays.stream(integers).boxed().distinct().filter(e -> e % 2 != 0).sorted((i1, i2) -> i2.compareTo(i1)).toList();
    }

    //приймаємо 2д масив типу інт та повертаємо номер горизонтального масиву з найбільшою сумою елементів
    public static int foundTheHighestSumRow(int[][] arr2D) {
        int[] arr = new int[]{-1, 0, Integer.MIN_VALUE};
        Arrays.stream(arr2D).map(e -> Arrays.stream(e).sum()).forEach(e -> {
            arr[0]++;
            if (arr[2] < e) {
                arr[2] = e;
                arr[1] = arr[0];
            }
        });
        return arr[1];
    }
    //приймаємо 2д масив інтів та повертаємо для кожного рядка середнє чисел в ньому
    public static Map<int[], Double> avgOfEachRow(int [][] arr2D) {
        return Arrays.stream(arr2D).collect(Collectors.groupingBy(e -> e, Collectors.averagingDouble(e -> Arrays.stream(e).average().getAsDouble())));
    }
    //приймаємо лист лонгів та повертаємо кількість цифр в всіх лонгах
    public static long amountOfNumbersInLongVal(List<Long> longs){
        return longs.stream().map(e -> e + "").reduce((s1, s2) -> s1 + s2).get().chars().toArray().length;
    }
    //кількість кожної з цифр в листі лонгів
    public static Map<Integer, Long> amountOfTimeEachNumberRepeats(List<Long> longs){
        return longs.stream().map(e -> e + "").reduce((s1, s2) -> s1 + s2).get().chars().map(e -> e - 48).boxed().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }
    //для кожного лонга знайти максимальну цифру в ньому
    public static Map<Long, Integer> maxValInEachLong(List<Long> longs){
        Map<Long, Integer> map = new HashMap<>();
        longs.stream().forEach(e -> {
            map.put(e, (e + "").chars().max().getAsInt() - 48);
        });
        return map;
    }
}
