package exceptions;

import enums.*;


public class InvalidEmployeeException extends Exception {

    private final EmployeeExceptionCase CASE;  //constant variable of EmployeeExceptionCase Enum


    /*constructor for Invalid ID Exception */
    public InvalidEmployeeException(String id) {
        super(String.format(EmployeeExceptionCase.NO_ID_EXISTS.getMessage(),id));
        this.CASE = EmployeeExceptionCase.NO_ID_EXISTS;
    }

    /*
    Constructor for Non-Existing ID or Invalid GPA Exceptions
     */
    public InvalidEmployeeException(EmployeeExceptionCase exceptionCase) throws InvalidEmployeeException {
        super(exceptionCase.getMessage());
        if(exceptionCase == EmployeeExceptionCase.NO_ID_EXISTS || exceptionCase == EmployeeExceptionCase.INVALID_EMPLOYEE_GPA) {
            throw new InvalidEmployeeException(EmployeeExceptionCase.INVALID_EMPLOYEE_EXCEPTION);
        }
        this.CASE = exceptionCase;
    }

    /*
    Constructor for Invalid Employee GPA Exception
     */
    public InvalidEmployeeException(int gpa) {
        super(String.format(EmployeeExceptionCase.INVALID_EMPLOYEE_GPA.getMessage(), gpa));
        this.CASE = EmployeeExceptionCase.INVALID_EMPLOYEE_GPA;
    }

    public EmployeeExceptionCase getCase() {
        return this.CASE;
    }
}
