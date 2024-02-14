import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Managers
        Manager boss = new Manager("John", "Doe", LocalDate.of(1980, 5, 15), new BigDecimal("5000"), LocalDate.of(2010, 1, 1), new BigDecimal("1000"));
        Manager deputy = new Manager("Jane", "Smith", LocalDate.of(1975, 10, 20), new BigDecimal("6000"), LocalDate.of(2005, 6, 15), new BigDecimal("1200"));
        Manager workerManager = new Manager("Michael", "Johnson", LocalDate.of(1982, 8, 25), new BigDecimal("5500"), LocalDate.of(2008, 3, 20), new BigDecimal("800"));
        Manager traineeManager = new Manager("Emily", "Williams", LocalDate.of(1978, 3, 12), new BigDecimal("7000"), LocalDate.of(2012, 9, 10), new BigDecimal("1500"));

        //Workers
        Worker worker1 = new Worker("John", "Doe", LocalDate.of(1980, 5, 15), new BigDecimal("2500"), LocalDate.of(2010, 1, 1), new BigDecimal("500"));
        Worker worker2 = new Worker("Jane", "Smith", LocalDate.of(1975, 10, 20), new BigDecimal("3000"), LocalDate.of(2005, 6, 15), new BigDecimal("600"));
        Worker worker3 = new Worker("Michael", "Johnson", LocalDate.of(1982, 8, 25), new BigDecimal("2800"), LocalDate.of(2008, 3, 20), new BigDecimal("400"));
        Worker worker4 = new Worker("Emily", "Williams", LocalDate.of(1978, 3, 12), new BigDecimal("3500"), LocalDate.of(2012, 9, 10), new BigDecimal("700"));
        Worker worker5 = new Worker("David", "Brown", LocalDate.of(1985, 9, 5), new BigDecimal("3200"), LocalDate.of(2015, 4, 25), new BigDecimal("550"));
        Worker worker6 = new Worker("Sarah", "Taylor", LocalDate.of(1970, 12, 8), new BigDecimal("2700"), LocalDate.of(2004, 11, 18), new BigDecimal("800"));
        Worker worker7 = new Worker("Daniel", "Martinez", LocalDate.of(1990, 4, 17), new BigDecimal("2900"), LocalDate.of(2013, 7, 3), new BigDecimal("600"));
        Worker worker8 = new Worker("Amy", "Garcia", LocalDate.of(1988, 7, 21), new BigDecimal("3100"), LocalDate.of(2009, 12, 12), new BigDecimal("700"));
        Worker worker9 = new Worker("Robert", "Lee", LocalDate.of(1973, 2, 28), new BigDecimal("3300"), LocalDate.of(2006, 8, 9), new BigDecimal("500"));
        Worker worker10 = new Worker("Emma", "Rodriguez", LocalDate.of(1983, 6, 9), new BigDecimal("2800"), LocalDate.of(2011, 5, 7), new BigDecimal("600"));


        //Trainee
        Trainee trainee1 = new Trainee("John", "Doe", LocalDate.of(1995, 5, 15), new BigDecimal("1500"), LocalDate.of(2023, 1, 1), 90);
        Trainee trainee2 = new Trainee("Jane", "Smith", LocalDate.of(1997, 10, 20), new BigDecimal("1600"), LocalDate.of(2022, 6, 15), 100);
        Trainee trainee3 = new Trainee("Michael", "Johnson", LocalDate.of(1996, 8, 25), new BigDecimal("1550"), LocalDate.of(2021, 3, 20), 80);
        Trainee trainee4 = new Trainee("Emily", "Williams", LocalDate.of(1998, 3, 12), new BigDecimal("1700"), LocalDate.of(2020, 9, 10), 110);
        Trainee trainee5 = new Trainee("David", "Brown", LocalDate.of(1999, 9, 5), new BigDecimal("1650"), LocalDate.of(2019, 4, 25), 95);
        Trainee trainee6 = new Trainee("Sarah", "Taylor", LocalDate.of(1994, 12, 8), new BigDecimal("1580"), LocalDate.of(2018, 11, 18), 120);
        Trainee trainee7 = new Trainee("Daniel", "Martinez", LocalDate.of(1993, 4, 17), new BigDecimal("1610"), LocalDate.of(2017, 7, 3), 85);
        Trainee trainee8 = new Trainee("Amy", "Garcia", LocalDate.of(1992, 7, 21), new BigDecimal("1540"), LocalDate.of(2016, 12, 12), 95);
        Trainee trainee9 = new Trainee("Robert", "Lee", LocalDate.of(1991, 2, 28), new BigDecimal("1680"), LocalDate.of(2015, 8, 9), 110);
        Trainee trainee10 = new Trainee("Emma", "Rodriguez", LocalDate.of(1990, 6, 9), new BigDecimal("1520"), LocalDate.of(2014, 5, 7), 100);

        //setting up subordination from BOSS
        boss.addSubordinateToManager(deputy);
        boss.addSubordinateToManager(workerManager);
        boss.addSubordinateToManager(traineeManager);

        //setting up subordination for DEPUTY
        deputy.addSubordinateToManager(workerManager);
        deputy.addSubordinateToManager(traineeManager);

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

        boss.getAllSubordinates().forEach(e -> System.out.println(e));



        List<Employee> employees = new ArrayList<>();

    }
}
