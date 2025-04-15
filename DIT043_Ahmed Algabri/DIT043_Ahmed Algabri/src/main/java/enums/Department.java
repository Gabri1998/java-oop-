package enums;

import exceptions.InvalidEmployeeException;


public enum Department {

    BUSINESS("Business"),
    TECHNICAL("Technical"),
    HUMAN_RESOURCES("Human Resources");





    private final String deptName;

    Department(String n) {
        this.deptName = n;
    }

    @Override
    public String toString() {
        return this.deptName;
    }


    public static Department getDepartment(String dept) throws InvalidEmployeeException {
        switch(dept.toLowerCase()) {
            case "business":
                return BUSINESS;
            case "technical":
                return TECHNICAL;
            case "human resources":
                return HUMAN_RESOURCES;
            default:
                throw new InvalidEmployeeException(EmployeeExceptionCase.INVALID_EMPLOYEE_DEPARTMENT);
        }
    }
}
