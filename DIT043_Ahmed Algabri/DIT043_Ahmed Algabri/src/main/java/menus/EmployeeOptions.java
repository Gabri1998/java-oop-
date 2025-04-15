package menus;

import addon.IO;
import facade.Facade;

public class EmployeeOptions
{
    public Facade facade;
    public  EmployeeOptions()
    {
        facade = new Facade();
    }
    public void menu()
    {
        try
        {
            int choice = IO.readInt("Employee options menu:\n" +
                    "0. Return to Main Menu.\n" +
                    "1. Create an employee (Regular Employee).\n" +
                    "2. Create an employee (Manager).\n" +
                    "3. Create an employee (Director).\n" +
                    "4. Create an employee (Intern).\n" +
                    "5. Remove an employee.\n" +
                    "6. Print specific employee.\n" +
                    "7. Print all registered employees.\n" +
                    "8. Print the total expense with net salary.\n" +
                    "9. Print all employees sorted by gross salary.\n" +
                    "Type an option number:\n");
            switch (choice)
            {
                case 0:
                    MainMenu mainMenu = new MainMenu();
                    System.out.println("Returning to main menu.");
                    mainMenu.menu();
                    break;
                case 1:
                    regularEmployee();
                    break;
                case 2:
                    manager();
                    break;
                case 3:
                    director();
                    break;
                case 4:
                    intern();
                    break;
                case 5:
                    removeEmployee();
                    break;
                case 6:
                    printEmployee();
                    break;
                case 7:
                    printAllEmployee();
                    break;
                case 8:
                    printNetSalary();
                    break;
                case 9:
                    printEmployeeByGrossSalary();
                    break;
                default:
                    System.out.println("Invalid menu option. please type another option.");
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public void regularEmployee()
    {

        try
        {
            String id,name;
            double salary;
            id = IO.readString("Enter an ID for the new employee: ");
            name = IO.readString(String.format("Enter a name for %s: ", id));
            salary = IO.readDouble(String.format("Enter the raw salary for %s: ",id));
            System.out.println(facade.createEmployee(id, name,salary));
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public void director()
    {
        try
        {
            String id, name,degree,department;
            double salary;
            id = IO.readString("Enter an ID for the new employee: ");
            name = IO.readString(String.format("Enter a name for %s: ", id));
            salary = IO.readDouble(String.format("Enter the raw salary for %s: ",id));
            degree = IO.readString(String.format("Enter a degree for %s: ",id));
            department = IO.readString(String.format("Enter a department for %s: ",id));
            System.out.println(facade.createEmployee(id, name, salary, degree, department ));
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
    public void manager()
    {
        try
        {
            String id,name,degree;
            double salary;
            id = IO.readString("Enter an ID for the new employee: ");
            name = IO.readString(String.format("Enter a name for %s: ",id));
            salary = IO.readDouble(String.format("Enter the raw salary for %s: ",id));
            degree= IO.readString(String.format("Enter a degree for %s: ",id));
            System.out.println(facade.createEmployee(id, name, salary, degree));
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
    public void intern()
    {
        try
        {
            String id,name;
            double salary;
            int gpa;
            id = IO.readString("Enter an ID for the new employee: ");
            name = IO.readString(String.format("Enter a name for %s: ", id));
            salary = IO.readDouble(String.format("Enter the raw salary for %s: ",id));
            gpa = IO.readInt(String.format("Enter GPA for %s: ",id));
            System.out.println(facade.createEmployee(id, name, salary, gpa));
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
    public void removeEmployee()
    {
        try
        {
            String id;
            id = IO.readString("Enter the ID of the employee to be deleted: ");
            System.out.println(facade.removeEmployee(id));
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
    public void printAllEmployee()
    {
        try
        {
            System.out.println(facade.printAllEmployees());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
    public void printEmployee()
    {
        try
        {
            String id;
            id = IO.readString("Enter the ID of the employee to print: ");
            System.out.println(facade.printEmployee(id));
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
    public void printNetSalary()
    {
        try
        {
            System.out.println(facade.getTotalNetSalary());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
    public void printEmployeeByGrossSalary()
    {
        try
        {
            System.out.println(facade.printSortedEmployees());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }

}
