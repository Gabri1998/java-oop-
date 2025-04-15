package menus;

import addon.IO;
import facade.Facade;

public class ReviewOptions
{
    Facade facade;
    public ReviewOptions()
    {
        facade = new Facade();
    }
    public void menu()
    {
        int choice = IO.readInt("Reviews options menu:\n" +
                "0. Return to Main Menu.\n" +
                "1. Create a review for an Item.\n" +
                "2. Print a specific review of an Item.\n" +
                "3. Print all reviews of an Item.\n" +
                "4. Print mean grade of an Item\n" +
                "5. Print all comments of an Item.\n" +
                "6. Print all registered reviews.\n" +
                "7. Print item(s) with most reviews.\n" +
                "8. Print item(s) with least reviews.\n" +
                "9. Print item(s) with best mean review grade.\n" +
                "10. Print item(s) with worst mean review grade.\n" +
                "Type an option number:");
        switch (choice)
        {
            case 0:
                System.out.println("Returning to main menu.");
                MainMenu mainMenu = new MainMenu();
                mainMenu.menu();
                break;
            case 1:
                createReview();
                break;
            case 2:
                printReview();
                break;
            case 3:
                printAllReviews();
                break;
            case 4:
                printMeanGrade();
                break;
            case 5:
                printComments();
                break;
            case 6:
                printRegisteredReviews();
                break;
            case 7:
                printMostReviewedItems();
                break;
            case 8:
                printLeastReviewedItems();
                break;
            case 9:
                printBestMean();
                break;
            case 10:
                printWorstMean();
            default:
                System.out.println("Invalid menu Option. please type another option");
        }

    }
    public  void createReview()
    {
        String id,comment,result;
        int grade;
        id = IO.readString("Enter the ID of the item to review: ");
        grade = IO.readInt("Enter the grade for " + id + ": ");
        comment = IO.readString("Enter a comment for " + id + " (Optional): ").strip();
        result = facade.reviewItem(id, comment, grade);
        System.out.println(result);
    }
    public void printReview()
    {
        String id, result;
        int index;
        id = IO.readString("Enter the ID of the item to read a review of: ");
        index = IO.readInt("Enter the index for the desired review: ");

        result = facade.getPrintedItemReview(id,index);
        System.out.println(result);
    }
    public void printAllReviews()
    {
        String id, result;
        id = IO.readString("Enter the ID of the item to read reviews of: ");

        result = facade.getPrintedReviews(id);
        System.out.println(result);
    }


    public void printComments()
    {
        String id,result;
        id = IO.readString("Enter the ID of the item to read comments of: ");

        result = facade.getItemCommentsPrinted(id);
        System.out.println(result);
    }
    public void printRegisteredReviews()
    {
        String regReviews = facade.printAllReviews();
        System.out.println(regReviews);
    }
    public void printLeastReviewedItems()
    {
        String leastReviews = facade.printLeastReviewedItems();
        System.out.println(leastReviews);
    }
    public void printMostReviewedItems()
    {
        String mostReviewedItems = facade.printMostReviewedItems();
        System.out.println(mostReviewedItems);
    }
    public void printBestMean()
    {
        String bestMean = facade.printBestReviewedItems();
        System.out.println(bestMean);
    }
    public void printWorstMean()
    {
        String worstMean = facade.printWorseReviewedItems();
        System.out.println(worstMean);
    }
    public void printMeanGrade()
    {
        String id;
        double result;
        id = IO.readString("Enter the ID of the item to retrieve the mean grade of: ");

        result =  facade.getItemMeanGrade(id);
        switch((int)result){
            case 0:
                System.out.println("Item " + facade.getItemName(id) + " has not been reviewed yet.");
                break;
            case -1:
                System.out.println("Item" + id + " was not registered yet.");
                break;
            default:
                System.out.println(result);
        }

    }
}
