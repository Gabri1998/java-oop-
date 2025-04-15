package staff;

import addon.*;

public class RegularEmployee extends Employee {

    public RegularEmployee(String emp_id, String emp_name, double emp_salary) throws Exception {
        super(emp_id, emp_name, emp_salary);
    }

    @Override
    public boolean isRole(String emp_role) {
        return this.getClass().getName().equals(emp_role);
    }

    @Override
    public double getGrossSalary() {
        return super.getRawSalary();
    }

    public double getNetSalary() {
        return this.getRawSalary() * (1 - 0.1);
    }


    @Override
    public String toString() {
        return String.format("%s's gross salary is %s SEK per month.",
                this.getName(),
                IO.truncateToString(this.getRawSalary(),2)
                );
    }


}
