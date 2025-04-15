package staff;

import enums.Degree;
import enums.Department;
import addon.*;

public class Director extends Manager {


    private Department dept;

    public Director(String emp_id, String name, double salary, Degree deg, Department dept) throws Exception {
        super(emp_id, name, salary, deg);
        this.dept = dept;
    }

    @Override
    public double getGrossSalary() {
        return super.getGrossSalary() + 5000;
    }

    @Override
    public double getNetSalary() {

        double empNetSalary = getGrossSalary();
        if (empNetSalary < 30000) {
            empNetSalary *= (1 - 0.1);
        } else if (empNetSalary < 50000) {
            empNetSalary *= (1 - 0.2);
        } else {
            empNetSalary = 30000 * (1 - 0.2) + (empNetSalary - 30000) * (1 - 0.4);
        }

        return empNetSalary;
    }

    public String getDepartment(){
        return this.dept.toString();
    }
    public void setDepartment(Department department){
        this.dept = department;
    }

    @Override
    public boolean isRole(String empRole) {
        return this.getClass().getName().equals(empRole);
    }

    @Override
    public String toString() {
        return String.format(
                "%s %s's gross salary is %s SEK per month. Dept: %s",
                this.getDegree(),
                this.getName(),
                IO.truncateToString(this.getGrossSalary(), 2),
                this.dept
        );
    }



}
