package enums;

public enum EmployeeExceptionCase {

    INVALID_EMPLOYEE_EXCEPTION("Exception: Invalid usage of InvalidEmployeeException."),
    INVALID_EMPLOYEE_ID("ID cannot be blank."),
    INVALID_EMPLOYEE_NAME("Name cannot be blank."),
    INVALID_EMPLOYEE_SALARY("Salary must be greater than zero."),
    NO_ID_EXISTS("Employee %s was not registered yet."),
    NO_EMPLOYEES_REGISTERED("No employees registered yet."),
    INVALID_EMPLOYEE_DEGREE("Degree must be one of the options: BSc, MSc or PhD."),
    INVALID_EMPLOYEE_DEPARTMENT("Department must be one of the options: Business, Human Resources or Technical."),
    INVALID_EMPLOYEE_GPA("%d outside range. Must be between 0-10."),
    NO_COMPATIBLE_TYPE("Exception: Incompatible Employee type.");

    private final String msg;

    EmployeeExceptionCase(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return this.msg;
    }
}
