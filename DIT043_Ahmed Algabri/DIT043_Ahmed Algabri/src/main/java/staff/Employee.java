package staff;

import enums.EmployeeExceptionCase;
import exceptions.*;
import addon.IO;

public abstract class Employee implements Comparable<Employee> {

    private final String emp_id;
    private String emp_name;
    private double emp_salary;


    public Employee(String emp_id, String emp_name, double emp_salary) throws Exception {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_salary = IO.truncate(emp_salary, 2);

        if(emp_id.isEmpty())
        {
            throw new InvalidEmployeeException(EmployeeExceptionCase.INVALID_EMPLOYEE_ID);
        }
        if(emp_name.isBlank()) {
            throw new InvalidEmployeeException(EmployeeExceptionCase.INVALID_EMPLOYEE_NAME);
        }
        if(emp_salary <= 0) {
            throw new InvalidEmployeeException(EmployeeExceptionCase.INVALID_EMPLOYEE_SALARY);
        }

    }

    public abstract boolean isRole(String empRole);

    public abstract double getGrossSalary();

    public abstract double getNetSalary();

    public abstract String toString();

    public String getId() {
        return this.emp_id;
    }


    public void setName(String n) {
        this.emp_name = n;
    }

    public String getName() {
        return this.emp_name;
    }
    public void setRawSalary(double salary) {
        this.emp_salary = salary;
    }
    public double getRawSalary() {
        return this.emp_salary;
    }



    public int compareTo(Employee another){
        if(getGrossSalary() > another.getGrossSalary() ) {
            return 1;
        } else if(getGrossSalary() == another.getGrossSalary()){
            return 0;
        } else{
            return -1;
        }
    }


}
