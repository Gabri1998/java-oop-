# java-oop.
 As the whole project is based on Object-oriented concepts that means the project is around classes and objects that contain the data and behaviors. We have implemented the Object-Oriented Inheritance features by Inheriting Employee Abstract class by its subclasses like Internee, RegularEmployee, Director, and Manager. In the whole project, we have used the Overriding concept by overriding the method of java. lang.Object class but extensively we have used overriding concepts in Employee classes. The project is also using Overloading concepts by creating various methods with same in a single class with different signatures.
As EntryPoint we have used the Main class that contains main() method from which our project executes, and calls the menu() method of MainMenu class, and menu() of MainMenu() class calls all the other Menu classes. All the Menu classes like ItemOptions, ReviewOptions, TransactionHistoryOptions, and EmployeeOptions use Façade class method to make sure all tests pass on user inputs. Exception Handling is implemented for Employees through InvalidEmployeeException, the InvalidEmployeeException class uses various Exception Constant Messages in EmployeeExceptionCase enum.  There are other enums in the project like Department, Degree, GPA. The Director employees class is using Department enumeration, the Manager is using Degree enumeration, and Intern is using GPA enumeration. All classes in the project are using the IO class for User Input and Output.

