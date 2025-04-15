package menus;
import addon.IO;
import products.Item;

public class MainMenu
{
    public void menu()
    {
        int choice;
        choice = IO.readInt("Main Menu: Please choose among the options below.\n" +
                "0. Close system.\n" +
                "1. Open Item options.\n" +
                "2. Open Review options.\n" +
                "3. Open Transaction History options.\n" +
                "4. Employee Options.\n" +
        "Type an option number:\n");
        switch (choice)
        {
            case 0:
                System.out.println("Exiting system.");
                System.exit(0);
                break;
            case 1:
                ItemOptions itemOptions = new ItemOptions();
                itemOptions.menu();
                break;
            case 2:
                    ReviewOptions reviewOptions = new ReviewOptions();
                    reviewOptions.menu();
                break;
            case 3:
                TransactionHistoryOptions transactionHistoryOptions = new TransactionHistoryOptions();
                transactionHistoryOptions.menu();
                break;
            case 4:
                EmployeeOptions employeeOptions = new EmployeeOptions();
                employeeOptions.menu();
                break;
            default:
                System.out.println("Invalid menu option. Please type another option.");
        }

    }
}
