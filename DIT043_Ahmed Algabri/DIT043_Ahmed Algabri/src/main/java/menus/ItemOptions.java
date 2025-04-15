package menus;

import addon.IO;
import facade.*;
public class ItemOptions
{
    Facade facade;

    public  ItemOptions()
    {
        facade = new Facade();

    }
    public void menu()
    {
     int choice = IO.readInt("Item options menu:\n" +
             "0. Return to Main Menu.\n" +
             "1. Create an Item.\n" +
             "2. Remove an Item.\n" +
             "3. Print all registered Items.\n" +
             "4. Buy an Item.\n" +
             "5. Update an item’s name.\n" +
             "6. Update an item’s price.\n" +
             "7. Print a specific item.\n" +
             "Type an option number:");
     switch (choice)
     {
         case 0:
             MainMenu mainMenu = new MainMenu();
             System.out.println("Returning to main menu.");
             mainMenu.menu();
             break;

         case 1:
             createItem();
             break;
         case 2:
             removeItem();
             break;
         case 3:
             printAllItems();
             break;
         case 4:
             buyItem();
             break;
         case 5:
             updateItemName();
             break;
         case 6:
             updateItemPrice();
             break;
         case 7:
             printSpecificItem();
             break;
         default:
             System.out.println("Invalid menu option. Please type another option.");
     }

    }

    public void createItem()
    {
        String id, name;
        double price;
        id = IO.readString("Enter an ID for the new ite: ");
        name = IO.readString("Enter a name for "+id);
        price = IO.readDouble("Enter a price for "+name);
        String result = facade.createItem(id,name,price);
        System.out.println(result);
    }

    public void removeItem()
    {
        String id, result;
        id = IO.readString("Enter the ID of the item to be deleted");
        result = facade.removeItem(id);
        System.out.println(result);
    }

    public void updateItemName()
    {
        String id,name,result;
        id = IO.readString("Enter the ID of the Item to update the name of: ");
        name = IO.readString("Enter the new name for "+id);
        result = facade.updateItemName(id,name);
        System.out.println(result);
    }

    public void updateItemPrice()
    {
        String id,result;
        double price;
        id = IO.readString("Enter the ID of the item to update the price of: ");
        price = IO.readDouble("Enter the new price for "+id);
        result = facade.updateItemPrice(id,price);
        System.out.println(result);

    }

    public void printAllItems()
    {
        String outputResult = facade.printAllItems();
        System.out.println(outputResult);
    }
    public  void buyItem()
    {
        String id,result;
        double price;
        int amount;
        id = IO.readString("Enter the ID of the item you wish to buy: ");
        amount = IO.readInt("How many items you wish to buy");
        price = facade.buyItem(id,amount);
        result = (String.format("Cost: %.2f", price));
        System.out.println(result);

    }
    public void printSpecificItem()
    {
        String id,result;
        id = IO.readString("Enter the ID of the item you wish to print");
        result = facade.printItem(id);
        System.out.println(result);

    }
}
