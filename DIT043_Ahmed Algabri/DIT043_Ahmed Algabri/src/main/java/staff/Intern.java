package staff;

import enums.GPA;
import addon.*;

public class Intern extends Employee {

    private int gpaVal;
    private GPA gpa;

    public Intern(String inter_Id, String inter_Name, double intern_Salary, int gpaVal) throws Exception {
        super(inter_Id, inter_Name, intern_Salary);
        this.gpa = GPA.getGPA(gpaVal);
        this.gpaVal = gpaVal;
    }

    public void setGpaValue(int gpaValue) throws Exception {
        this.gpaVal = gpaValue;
        this.gpa = GPA.getGPA(gpaValue);
    }

    public int getGpaValue() {
        return this.gpaVal;
    }

    @Override
    public boolean isRole(String role) {
        return this.getClass().getName().equals(role);
    }

    @Override
    public double getGrossSalary() {
        return super.getRawSalary() * this.gpa.getPAYOUT_RATE() + this.gpa.getBONUS();
    }

    @Override
    public double getNetSalary() {
        return getGrossSalary();
    }

    @Override
    public String toString() {
        return String.format(
                "%s's gross salary is %s SEK per month. GPA: %s",
                this.getName(),
                IO.truncateToString(this.getNetSalary(), 2),
                gpaVal
        );
    }
}