package menus;

import addon.IO;
import facade.Facade;

public class TransactionHistoryOptions
{
    public Facade facade;
    public TransactionHistoryOptions()
    {
        facade = new Facade();
    }
    public void menu()
    {
        int choice = IO.readInt("Transaction History options menu:\n" +
                "0. Return to Main Menu.\n" +
                "1. Print total profit from all item purchases\n" +
                "2. Print total units sold from all item purchases\n" +
                "3. Print the total number of item transactions made.\n" +
                "4. Print all transactions made.\n" +
                "5. Print the total profit of a specific item.\n" +
                "6. Print the number of units sold of a specific item.\n" +
                "7. Print all transactions of a specific item.\n" +
                "8. Print item with highest profit.\n" +
                "Type an option number:");
        switch (choice)
        {
            case 0:
                System.out.println("Returning to main menu.");
                MainMenu mainMenu = new MainMenu();
                mainMenu.menu();
                break;
            case 1:
                totalProfit();
                break;
            case 2:
                totalSold();
                break;
            case 3:
                totalItemTransaction();
                break;
            case 4:
                allTransactions();
                break;
            case 5:
                specificProfit();
                break;
            case 6:
                specificUnitsSold();
                break;
            case 7:
                specificTransactions();
                break;
            case 8:
                highestProfit();
                break;
            default:
                System.out.println("Invalid menu option. please type another option");
        }
    }

    public void totalProfit()
    {
        double result = facade.getTotalProfit();
        System.out.println(result);
    }
    public void totalSold()
    {
        double result = facade.getTotalUnitsSold();
        System.out.println(result);
    }
    public void totalItemTransaction()
    {
        int result = facade.getTotalTransactions();
        System.out.println(result);
    }
    public void allTransactions()
    {
        String result = facade.printAllTransactions();
        System.out.println(result);
    }
    public void specificProfit()
    {
        String id;
        id = IO.readString("Enter the ID of the item print the total profit of: ");
        System.out.println(facade.getProfit(id));
    }
    public void specificUnitsSold()
    {
        String id;
        id = IO.readString("Enter the ID of the item print the total units sold of: ");
        System.out.println(facade.getUnitsSolds(id));
    }
    public void specificTransactions()
    {
        String id = IO.readString("Enter the ID of the item print the total number of transactions of: ");
        System.out.println(facade.printItemTransactions(id));
    }
    public void highestProfit()
    {
        String result = facade.printMostProfitableItems();
        System.out.println(result);
    }
}
