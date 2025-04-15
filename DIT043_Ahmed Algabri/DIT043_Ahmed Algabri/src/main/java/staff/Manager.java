package staff;

import enums.Degree;
import addon.*;

public class Manager extends Employee {

    private Degree deg;

    public Manager(String id, String emp_name, double emp_salary, Degree deg) throws Exception {
        super(id, emp_name, emp_salary);
        this.deg = deg;
    }
    @Override
    public boolean isRole(String role) {
        return this.getClass().getName().equals(role);
    }
    public void setDegree(Degree newDegree){
        this.deg = newDegree;
    }

    public Degree getDegree() {
        return this.deg;
    }

    @Override
    public double getGrossSalary() {
        return super.getRawSalary() * this.deg.getPayoutRate();
    }

    @Override
    public double getNetSalary() {
        return getGrossSalary() * (1 - 0.1);
    }

    @Override
    public String toString() {
        return String.format(
                "%s %s's gross salary is %s SEK per month.",
                deg.toString(),
                getName(),
                IO.truncateToString(getGrossSalary(), 2)
        );
    }


}
