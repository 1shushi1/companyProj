import java.math.BigDecimal;

public final class PayrollEntry {
    private final Employee employee;
    private final BigDecimal salaryPlusBonus;
    public PayrollEntry(Employee employee, BigDecimal salary, BigDecimal bonus){
        this.employee = employee;
//        if (salary != null && bonus != null){
//            salaryPlusBonus = salary.add(bonus);
//        } else if (salary == null && bonus != null){
//            salaryPlusBonus = bonus;
//        } else if (salary != null && bonus == null){
//            salaryPlusBonus = salary;
//        } else {
//            salaryPlusBonus = BigDecimal.ZERO;
//        }

        if (salary == null){
            salary = BigDecimal.ZERO;
        }
        if (bonus == null){
            bonus = BigDecimal.ZERO;
        }
        salaryPlusBonus = salary.add(bonus);
    }
}
