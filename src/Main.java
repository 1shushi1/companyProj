import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Managers
        Manager boss = new Manager("John", "Doe", LocalDate.of(1980, 5, 15), new BigDecimal("7000"), LocalDate.of(2010, 1, 1), new BigDecimal("1000"));
        Manager deputy = new Manager("Jane", "Smith", LocalDate.of(1975, 10, 20), new BigDecimal("6000"), LocalDate.of(2005, 6, 15), new BigDecimal("1200"));
        Manager workerManager = new Manager("Michael", "Johnson", LocalDate.of(1982, 8, 25), new BigDecimal("5500"), LocalDate.of(2008, 3, 20), new BigDecimal("800"));
        Manager traineeManager = new Manager("Emily", "Williams", LocalDate.of(1978, 3, 12), new BigDecimal("5000"), LocalDate.of(2012, 9, 10), new BigDecimal("1500"));

        //Workers
        Worker worker1 = new Worker("John", "Doe", LocalDate.of(1980, 5, 15), new BigDecimal("2500"), LocalDate.of(2010, 1, 1), new BigDecimal("500"));
        Worker worker2 = new Worker("Jane", "Smith", LocalDate.of(1975, 10, 20), new BigDecimal("3000"), LocalDate.of(2005, 6, 15), new BigDecimal("600"));
        Worker worker3 = new Worker("Michael", "Johnson", LocalDate.of(1982, 8, 25), new BigDecimal("2800"), LocalDate.of(2008, 3, 20), new BigDecimal("400"));
        Worker worker4 = new Worker("Emily", "Williams", LocalDate.of(1978, 3, 12), new BigDecimal("3500"), LocalDate.of(2012, 9, 10), new BigDecimal("700"));
        Worker worker5 = new Worker("David", "Brown", LocalDate.of(1985, 9, 5), new BigDecimal("3200"), LocalDate.of(2015, 4, 25), new BigDecimal("550"));
        Worker worker6 = new Worker("Sarah", "Ally", LocalDate.of(1970, 12, 8), new BigDecimal("2700"), LocalDate.of(2004, 11, 18), new BigDecimal("800"));
        Worker worker7 = new Worker("Daniel", "Martinez", LocalDate.of(1990, 4, 17), new BigDecimal("2900"), LocalDate.of(2013, 7, 3), new BigDecimal("600"));
        Worker worker8 = new Worker("Amy", "Garcia", LocalDate.of(1988, 7, 21), new BigDecimal("3100"), LocalDate.of(2009, 12, 12), new BigDecimal("700"));
        Worker worker9 = new Worker("Robert", "Antena", LocalDate.of(1973, 2, 28), new BigDecimal("3300"), LocalDate.of(2006, 8, 9), new BigDecimal("500"));
        Worker worker10 = new Worker("Emma", "Rodriguez", LocalDate.of(1983, 6, 9), new BigDecimal("2800"), LocalDate.of(2011, 5, 7), new BigDecimal("600"));

        Worker worker11 = new Worker("Tolya", "Rodriguez", LocalDate.of(1983, 6, 9), new BigDecimal("2800"), LocalDate.of(2011, 5, 7), null);


        //Trainee
        Trainee trainee1 = new Trainee("John", "Akim", LocalDate.of(1995, 5, 15), new BigDecimal("1500"), LocalDate.of(2023, 1, 1), 90);
        Trainee trainee2 = new Trainee("Jane", "Smith", LocalDate.of(1997, 10, 20), new BigDecimal("1600"), LocalDate.of(2022, 6, 15), 100);
        Trainee trainee3 = new Trainee("Michael", "Johnson", LocalDate.of(1996, 8, 25), new BigDecimal("1550"), LocalDate.of(2021, 3, 20), 80);
        Trainee trainee4 = new Trainee("Emily", "Williams", LocalDate.of(1998, 3, 12), new BigDecimal("1700"), LocalDate.of(2020, 9, 10), 110);
        Trainee trainee5 = new Trainee("David", "Brown", LocalDate.of(1999, 9, 5), new BigDecimal("1650"), LocalDate.of(2019, 4, 25), 95);
        Trainee trainee6 = new Trainee("Sarah", "Taylor", LocalDate.of(1994, 12, 8), new BigDecimal("1580"), LocalDate.of(2018, 11, 18), 120);
        Trainee trainee7 = new Trainee("Daniel", "Martinez", LocalDate.of(1993, 4, 17), new BigDecimal("1610"), LocalDate.of(2017, 7, 3), 85);
        Trainee trainee8 = new Trainee("Amy", "Garcia", LocalDate.of(1992, 7, 21), new BigDecimal("1540"), LocalDate.of(2016, 12, 12), 95);
        Trainee trainee9 = new Trainee("Robert", "Lee", LocalDate.of(1991, 2, 28), new BigDecimal("1680"), LocalDate.of(2015, 8, 9), 110);
        Trainee trainee10 = new Trainee("Emma", "Rodriguez", LocalDate.of(1990, 6, 9), new BigDecimal("1520"), LocalDate.of(2014, 5, 7), 100);

        //setting up subordination for TRAINEE MANAGER
        traineeManager.addSubordinateToManager(trainee1);
        traineeManager.addSubordinateToManager(trainee2);
        traineeManager.addSubordinateToManager(trainee3);
        traineeManager.addSubordinateToManager(trainee4);
        traineeManager.addSubordinateToManager(trainee5);
        traineeManager.addSubordinateToManager(trainee6);
        traineeManager.addSubordinateToManager(trainee7);
        traineeManager.addSubordinateToManager(trainee8);
        traineeManager.addSubordinateToManager(trainee9);
        traineeManager.addSubordinateToManager(trainee10);


//        traineeManager.getAllSubordinates().forEach(e -> System.out.println(e));


        //setting up subordination for WORKER MANAGER
        workerManager.addSubordinateToManager(worker1);
        workerManager.addSubordinateToManager(worker2);
        workerManager.addSubordinateToManager(worker3);
        workerManager.addSubordinateToManager(worker4);
        workerManager.addSubordinateToManager(worker5);
        workerManager.addSubordinateToManager(worker6);
        workerManager.addSubordinateToManager(worker7);
        workerManager.addSubordinateToManager(worker8);
        workerManager.addSubordinateToManager(worker9);
        workerManager.addSubordinateToManager(worker10);
        workerManager.addSubordinateToManager(worker11);

//        workerManager.getAllSubordinates().forEach(e -> System.out.println(e));


//        //setting up subordination for DEPUTY
        deputy.addSubordinateToManager(workerManager);
        deputy.addSubordinateToManager(traineeManager);

//        deputy.getAllSubordinates().forEach(e -> System.out.println(e));
//
//        //setting up subordination from BOSS
        boss.addSubordinateToManager(deputy);
        boss.addSubordinateToManager(workerManager);
        boss.addSubordinateToManager(traineeManager);

//        boss.getAllSubordinates().forEach(e -> System.out.println(e));

//      traineeManager.getAllSubordinates().forEach(e -> System.out.println(e));

        //подготовка заработной платы для всех работников
//        List<PayrollEntry> payrollToEmployees = HumanResourcesStatistic.payroll(boss.getAllSubordinates().stream().toList());
//        payrollToEmployees.forEach(e -> System.out.println(e));

// подготовка заработной платы для подчиненных данного менеджера
//        List<PayrollEntry> payrollManEmp = HumanResourcesStatistic.payrollForPartManagerSubordinates(workerManager);
//        payrollManEmp.forEach(e -> System.out.println(e));

        //вычисления общей стоимости бонусов
//        BigDecimal totalBonusAmount = HumanResourcesStatistic.totalBonusAmount(boss.getAllSubordinates().stream().toList());
//        System.out.println(totalBonusAmount);

        //поиск сотрудника со старейшим стажем
//        Employee employee = HumanResourcesStatistic.theMostExperienceEmp(boss.getAllSubordinates().stream().toList());
//        System.out.println(employee);

        //поиск самой высокой зарплаты без бонуса (зряплата должна быть возвращена)
//        BigDecimal highestSalary = HumanResourcesStatistic.theHighestSalary(boss.getAllSubordinates().stream().toList());
//        System.out.println(highestSalary);

        //поиск самой низкой зарплаты с бонусом (зряплата должна быть возвращена)
//        BigDecimal theLowestSalIncludingBonus = HumanResourcesStatistic.theLowestSalIncludingBonus(boss.getAllSubordinates().stream().toList());
//        System.out.println(theLowestSalIncludingBonus);

        //поиск сотрудников, фамилии которых начинаются с буквы "А" данного менеджера
//        List<Employee> findingBySurname = HumanResourcesStatistic.findBySurname(boss.getAllSubordinates().stream().toList());
//        findingBySurname.forEach(e -> System.out.println(e));

        //Поиск сотрудников, зарабатывающих более 1000 s
//        List<Employee> employeesWhoHasSalaryGreaterThan1000 = HumanResourcesStatistic.salaryMoreThan1000(boss.getAllSubordinates().stream().toList(), new BigDecimal(4000.00));
//        employeesWhoHasSalaryGreaterThan1000.forEach(e -> System.out.println(e));

        //Сколько сотрудников, являющихся непосредственными подчиненными конкретного менеджера
        //зарабатывают более такой-то суммы?
//        Long amountOfEmployeesEarningMoreThanPartSum = HumanResourcesStatistic.amountOfEmpEarningMoreThanPartSum(workerManager, new BigDecimal(3000.00));
//        System.out.println(amountOfEmployeesEarningMoreThanPartSum);

        //визначити кількість якихось конкретних співробітників з віком від та до
//        long amountOfEmployeesWithParticularAge = HumanResourcesStatistic.amountOfEmployeesWithPartAge(boss.getAllSubordinates().stream().toList(), new String("Trainee"), 28, 35);
//        System.out.println(amountOfEmployeesWithParticularAge);

        //checker for age of trainee
//        traineeManager.getSubordinates().forEach(e -> System.out.println(e + "  -  " + e.age()));

        //old emp salary
//        boss.getAllSubordinates().forEach(e -> System.out.println(e + " - " + e.getSalary()));
//        System.out.println("+++++++++++++++++++");

        //збільшити зарплптню на 10% для всіх співробітників, які заробляють в загальному менше  суми що передається
//        List<Employee> employees = HumanResourcesStatistic.salaryIncrease(boss.getAllSubordinates().stream().toList(), new BigDecimal(2000.0));
//        employees.forEach(e -> System.out.println(e));

        //визначити кількість співробітників по кожній з посад
//       HumanResourcesStatistic.amountOfEmployeesOnEachPosition(boss.getAllSubordinates().stream().toList()).entrySet()
//       .forEach(e -> System.out.println("Position : " + e.getKey() + " - " + "Amount of workers : " + e.getValue()));

        //підрахувати фонд зарплат по кожній посаді
//
//        HumanResourcesStatistic.sumOfMoneyEachManagerShouldPayToEmp(boss.getAllSubordinates().stream().toList()).entrySet()
//        .forEach(e -> System.out.println("Position : " + e.getKey() + " - " + "Money to pay : " + e.getValue().getSum()));

        ////вивести всіх спывробытників для кожної посади
//        Map<String, List<Employee>> positionEmployeeList = HumanResourcesStatistic.positionEmployeeList(boss.getAllSubordinates().stream().toList());
//        for (Map.Entry<String, List<Employee>> entry : positionEmployeeList.entrySet()){
//            String position = entry.getKey();
//            System.out.println(position);
//            List<Employee> employeesList = entry.getValue();
//            for (Employee emp : employeesList){
//                System.out.println("List of workers : " + emp);
//            }
//        }

        //знайти посаду  в якій найбільше співробытників
//        String position = HumanResourcesStatistic.positionWithTheMostEmp(boss.getAllSubordinates().stream().toList());
//        System.out.println(position);

        //знайти кількість співробітників що немають бонусів на даний момент
//        long empWhoDoesntHaveBonuses = HumanResourcesStatistic.amountOfEmpWhoDoesntHaveBonuses(boss.getAllSubordinates().stream().toList());
//        System.out.println(empWhoDoesntHaveBonuses);

        //знайти прізвища співробітників, які отримають прибуток в такому-то діапвзоні і видати іх у порядку зменшення довжин цих прізвищ
//        List<Employee> empWhichGetsSalInPartRangeBySurnameLengthDESC =
//                HumanResourcesStatistic.empWhichGetsSalInPartRangeBySurnameLengthDESC(boss.getAllSubordinates().stream().toList(), new BigDecimal(1500), new BigDecimal(3000));
//        empWhichGetsSalInPartRangeBySurnameLengthDESC.forEach(e -> System.out.println(e));

        //приймає масив стрінгів та повертаєто суму цифр в ньому
//        String[] arr = {"hello1", "world6", "java9", "programming10", "openAI20", "languageModel4", "artificialIntelligence7", "dataScience24", "machineLearning9", "deepLearning23"};
//        long sumOfTheNum = HumanResourcesStatistic.sumOfTheNum(arr);
//        System.out.println(sumOfTheNum);

        //є файл текстовий. Визначити скільки в нього слів (роздільником є пробіл ) з розміром більше такого-то
//        long amountOfWords = HumanResourcesStatistic.method("1234567", "C:\\Users\\bemro\\IdeaProjects\\companyProj\\src\\text");
//        System.out.println(amountOfWords);

        //ф-я  скачує текстовий файл та повертає кільеість приголосних в ньому
//        long amountOfConsonants = HumanResourcesStatistic.amountOfConsonants("C:\\Users\\bemro\\IdeaProjects\\companyProj\\src\\text");
//        System.out.println(amountOfConsonants);

        //приймаємо лист інтів та повертаємо суму цифр з них
//        List<Integer> integers = new ArrayList<>();
//        Collections.addAll(integers, 144, 22, 3, 4333, 555, 61, 77, 81, 9, 10);
//        long sum = HumanResourcesStatistic.sumOfTheNumbers(integers);
//        System.out.println(sum);

        //приймаємо лист стрінгів та визначаємо кількість кожного зі стрінгів
//        List<String> names = new ArrayList<>();
//        Collections.addAll(names,
//                "John", "Alice", "Bob", "Mary", "David", "Emily", "Michael", "Sara", "Chris",
//                "Alice", "Bob", "David", "Michael", "Sara",
//                "John", "Alice", "Bob", "Mary", "David", "Emily", "Michael", "Sara", "Chris",
//                "Alice", "Bob", "Mary", "David", "Emily", "Michael", "Sara");
//        HumanResourcesStatistic.stringLongMap(names).forEach((s, l) -> System.out.println("Names : " + s + " - Amount : " + l));

        //отримаємо масив інтів та повертаємо лист відсортований за спаданням без дублікатів та парних чисел
//        HumanResourcesStatistic.sortedIntegers(new int[]{2, 5, 25, 3, 4, 10, 11, 13, 14, 44, 65, 77, 88, 21, 23, 23, 9, 0, 1, 81}).forEach(e -> System.out.println(e));

        //приймаємо 2д масив типу інт та повертаємо номер горизонтального масиву з найбільшою сумою елементів
//        int index = HumanResourcesStatistic.foundTheHighestSumRow(new int[][]{{3,4,8, 11}, {23, 4, 9, 1}, {8, 9, 0}});
//        System.out.println(index);

        ////приймаємо 2д масив інтів та повертаємо для кожного рядка середнє чисел в ньому
//        HumanResourcesStatistic.avgOfEachRow(new int[][]{{3,4,8, 11}, {23, 4, 9, 1}, {8, 9, 0}}).forEach((i, a) -> System.out.println(Arrays.toString(i) + " - " + "Avg num : " + a));

        ////приймаємо лист лонгів та повертаємо кількість цифр в всіх лонгах
        List<Long> longs = new ArrayList<>();
        Collections.addAll(longs, 10216l, 38669l);
//        long amount = HumanResourcesStatistic.amountOfNumbersInLongVal(longs);
//        System.out.println(amount);

        //кількість кожної з цифр в листі лонгів
//        HumanResourcesStatistic.amountOfTimeEachNumberRepeats(longs).forEach((l1, l2) -> System.out.println(l1 + " - " + l2));

        //для кожного лонга знайти максимальну цифру в ньому
        HumanResourcesStatistic.maxValInEachLong(longs).forEach((a,b) -> System.out.println("Long value : " + a + " - " +  "Max number in this long val : " + b));
    }
}
