package facade;

import java.util.*;
import java.util.List;
import java.util.Map;

import addon.IO;
import products.*;
import staff.*;
import exceptions.*;
import enums.*;



public class Facade
{

    // This class only has the skeleton of the methods used by the test.
    // You must fill in this class with your own code. You can (and should) create more classes
    // that implement the functionalities listed in the Facade and in the Test Cases.

    private final LinkedHashMap<String,Item> items;
    private final LinkedHashMap<String, Double> profitPerItem;
    private final LinkedHashMap<String,Employee> employees;
    private final List<Transaction> transactions;

    private  final static String EOL = System.lineSeparator();


    public Facade(){
        this.items = new LinkedHashMap<>();
        this.profitPerItem = new LinkedHashMap<>();
        employees = new LinkedHashMap<>();
        this.transactions = new ArrayList<>();


    }

    public String createItem(String itemID, String itemName, double unitPrice){
        String result="";
        if(!containsItem(itemID) && !itemID.isBlank() && !itemName.isBlank() && unitPrice>0)
        {
            items.put(itemID, new Item(itemID,itemName,unitPrice));
            profitPerItem.put(itemID, 0.0);
            result = "Item "+itemID+" was registered successfully.";
        }
        else
        {
            result = "Invalid data for item.";
        }
        return  result;
    }

    public String printItem(String itemID) {
     String result="";
     if(containsItem(itemID))
     {
         result+=items.get(itemID);  //retrieve the specified item in parenthesis
     }
     else
     {
         result+="Item "+itemID+" was not registered yet.";
     }
     return  result;

    }

    public String removeItem(String itemID) {
        String result="";
        if(containsItem(itemID))
        {
            items.remove(itemID);
            profitPerItem.put(itemID, 0.0);
            result = "Item "+itemID+" was successfully removed.";
        }
        else
        {
            result = "Item "+itemID+" could not be removed.";
        }
        return  result;
    }

    public boolean containsItem(String itemID) {
        if(items.containsKey(itemID))
        {
            return  true;
        }
        return  false;
    }

    public double buyItem(String itemID, int amount) {
        if(containsItem(itemID) && amount>0)
        {
            Item item = items.get(itemID);
            double totalPRice = item.buy(amount);

        }

        if(containsItem(itemID) && amount > 0) {
            Item item = items.get(itemID);
            double totalPrice = item.buy(amount);
            createTransaction(itemID, totalPrice, amount);
            return totalPrice;
        }
        return -1;


    }

    public void createTransaction(String itemID, double totPrice, int amount) {
        Transaction transaction = new Transaction(itemID, totPrice, amount);
        transactions.add(transaction);
        profitPerItem.put(itemID, profitPerItem.get(itemID) + totPrice);
    }

    public String getItemName(String itemID){
        Item item = null;
        String itemName = "";
        if(containsItem(itemID)) {
            item = items.get(itemID);
        }
        itemName = item.getName();
        return itemName;
    }


    public String reviewItem(String itemID, String reviewComment, int reviewGrade)
    {
        if(containsItem(itemID))
        {
            Item item = items.get(itemID);
            if(reviewGrade>=1 && reviewGrade<6)
            {
                item.addReview(reviewGrade, reviewComment);
                return "Your item review was registered successfully.";
            }
            else
            {
                return "Grade values must be between 1 and 5.";
            }
        }
        return String.format("Item %s was not registered yet.", itemID);

    }

    public String reviewItem(String itemID, int reviewGrade) {
        String result = reviewItem(itemID, "", reviewGrade);
        return result;
    }

    public String getItemCommentsPrinted(String itemID) {
        String result ="";
        List<String> comments = getItemComments(itemID);
        for(int i=0;i<comments.size();i++)
        {
            result+= comments.get(i) +EOL;
        }
        return  result;
    }



    public List<String> getItemComments(String itemID) {
        ArrayList<String> comments = new ArrayList<String>();
        if(!itemID.isBlank())
        {
            Item item = items.get(itemID);
            for(String comment : item.getItemComments())
            {
                comments.add(comment);
            }
        }
        return  comments;
    }

    public double getItemMeanGrade(String itemID) {
        if(containsItem(itemID))
        {
            Item item = items.get(itemID);
            if(item.hasReview())
            {
                return item.calcMeanGrade();
            }
            else
            {
                return 0.0;
            }
        }
        return -1.0;
    }

    public int getNumberOfReviews(String itemID) {
        int reviewSize=0;
        if(containsItem(itemID))
        {
            Item item = items.get(itemID);
            if(item.hasReview())
            {
                reviewSize = item.reviewSize();
            }
            else
            {
                reviewSize=0;
            }
        }
        return  reviewSize;
    }

    public String getPrintedItemReview(String itemID, int reviewNumber) {
        if(containsItem((itemID)))
        {
            Item item = items.get(itemID);
            if(item.hasReview())
            {
                return item.getOneReview(reviewNumber);
            }
            else
            {
                return String.format("Item %s has not been reviewed yet.", item.getName());
            }
        }
        else
        {
            return "Item" + itemID + " was not registered yet.";
        }

    }

    public String getPrintedReviews(String itemID) {
        if(containsItem(itemID))
        {
            Item item = items.get(itemID);
            if(item.hasReview())
            {
                return "Review(s) for " + items.get(itemID).toString() + EOL + item.getAllReviews();
            }
            else
            {
                return String.format("Review(s) for " + items.get(itemID).toString() + EOL +
                        "The item %s has not been reviewed yet.",item.getName());
            }
        }
        else
        {
            return "Item " + itemID + " was not registered yet.";
        }
    }

    public String printMostReviewedItems() {
        String result = "";
        List<String> mostReviewedItems = getMostReviewedItems();
        if(!items.isEmpty())
        {
            if(mostReviewedItems.isEmpty())
            {
                result="No items were reviewed yet.";
            }
            else
            {
                result = "Most reviews: " + items.get(mostReviewedItems.get(0)).reviewSize() + " review(s) each." + EOL;
                for(String itemID : mostReviewedItems) {
                    result += items.get(itemID) + EOL;
                }
            }
            return  result;
        }
        else
        {
            return "No items registered yet.";
        }


    }

    public List<String> getMostReviewedItems() {
        List<String> mostReviewedItems = new ArrayList<>();
        int maxReview = 0;
        if(!items.isEmpty()){
            for(String itemID : items.keySet()) {
                Item item = items.get(itemID);
                if(item.hasReview() && item.reviewSize() > maxReview) {
                    maxReview = item.reviewSize();
                }
            }

            for(String itemID : items.keySet()) {
                Item item = items.get(itemID);
                if (item.hasReview() && item.reviewSize() == maxReview) {
                    mostReviewedItems.add(itemID);
                }
            }
        }
        return mostReviewedItems;

    }

    public List<String> getLeastReviewedItems() {
        List<String> leastReviewedItems = new ArrayList<>();
        int i=0;
        String firstKey="";
        for(String key : items.keySet())
        {
            if(i==0)
            {
                firstKey = key;
            }
            i++;

        }

        if(!items.isEmpty())
        {

            int minReview = items.get(firstKey).reviewSize();
            for(String itemID : items.keySet()) {
                Item item = items.get(itemID);
                if (item.hasReview() && item.reviewSize() < minReview) {
                    minReview = item.reviewSize();
                }
            }
            for(String itemID : items.keySet()) {
                Item item = items.get(itemID);
                if (item.hasReview() && item.reviewSize() == minReview) {
                    leastReviewedItems.add(itemID);
                }
            }
        }
        return leastReviewedItems;
    }

    public String printLeastReviewedItems()
    {
         if(!items.isEmpty())
         {
            List<String> leastReviewedItems = getLeastReviewedItems();
            String result = "";
            if(leastReviewedItems.isEmpty()) {
                result = "No items were reviewed yet.";
            } else{
                result="Least reviews: " + items.get(leastReviewedItems.get(0)).reviewSize() + " review(s) each."+ EOL;
                for(String itemID : leastReviewedItems){
                    result += items.get(itemID) + EOL;
                }
            }
            return result;
        }
        return "No items registered yet.";
    }


    public double getTotalProfit() {
        double profit = 0;
        for(Transaction transaction : transactions) {
            profit += transaction.getPrice();
        }

        return IO.truncate(profit, 2);
    }

    public String printItemTransactions(String itemID) {
        if(containsItem(itemID)) {
            Item item = items.get(itemID);
            final String PREFIX = String.format(
                    "Transactions for item: %s: %s. %.2f SEK%s",
                    item.getID(),
                    item.getName(),
                    IO.truncate(item.getPrice(), 2),
                    EOL
            );
            String transactions = PREFIX;

            for (Transaction transaction : this.transactions) {
                transactions += transaction.getItemID().equals(itemID) ? transaction + EOL : "";
            }

            if(transactions.equals(PREFIX)) {
                transactions += String.format(
                        "No transactions have been registered for item %s yet.",
                        item.getID()
                );
            }
            return transactions;
        }
        return String.format("Item %s was not registered yet.", itemID);
    }

    public int getTotalUnitsSold() {
        int units = 0;
        for(Transaction transaction : transactions) {
            units += transaction.getAmount();
        }

        return units;
    }

    public int getTotalTransactions() {
        return transactions.size();
    }

    public double getProfit(String itemID) {
        double profit = 0;
        for(Transaction transaction : transactions) {
            profit += transaction.getItemID().equals(itemID) ? transaction.getPrice() : 0;
        }

        return IO.truncate(profit, 2);
    }

    public int getUnitsSolds(String itemID) {
        int units = 0;
        for(Transaction transaction : transactions) {
            units += transaction.getItemID().equals(itemID) ? transaction.getAmount() : 0;
        }

        return units;
    }

    public String printAllTransactions() {
        String res = "All purchases made: " + EOL +
                "Total profit: %.2f SEK" + EOL +
                "Total items sold: %d units" + EOL +
                "Total purchases made: %d transactions" + EOL +
                "------------------------------------" + EOL +
                "%s" +
                "------------------------------------" + EOL;

        String allTransactions = "";
        for(String itemID : profitPerItem.keySet()) { // Includes all transactions, see line 21
            for(Transaction transaction : transactions) {
                if(itemID.equals(transaction.getItemID())) {
                    allTransactions += transaction + EOL;
                }
            }
        }

        int totalUnits = getTotalUnitsSold();
        double totalProfit = getTotalProfit();
        String output = String.format(res, totalProfit, totalUnits, transactions.size(), allTransactions);
        return output;

    }

    public String printWorseReviewedItems() {
        if(!items.isEmpty()){
            List<String> worstReviewedItems = getWorseReviewedItems();
            String result="";
            if(worstReviewedItems.isEmpty()){
                result="No items were reviewed yet.";
            }else{
                result = "Items with worst mean reviews:" + EOL
                        + "Grade: " + items.get(worstReviewedItems.get(0)).calcMeanGrade() + EOL;
                for(String itemID : worstReviewedItems){
                    result += items.get(itemID) + EOL;
                }
            }
            return result;
        }
        return "No items registered yet.";
    }

    public String printBestReviewedItems() {
        if(!items.isEmpty()){
            List<String> bestReviewedItems = getBestReviewedItems();
            String result="";
            if(bestReviewedItems.isEmpty()) {
                result = "No items were reviewed yet.";
            }else{
                result = "Items with best mean reviews:" + EOL
                        + "Grade: " + items.get(bestReviewedItems.get(0)).calcMeanGrade() + EOL;
                for(String itemID : bestReviewedItems){
                    result +=items.get(itemID) + EOL;
                }
            }
            return result;
        }
        return "No items registered yet.";
    }

    public List<String> getWorseReviewedItems() {
        List<String> worstReviewedItems = new ArrayList<>();
        int i=0;
        String firstKey="";
        for(String key : items.keySet())
        {
            if(i==0)
            {
                firstKey = key;
            }
            i++;

        }


        if(!items.isEmpty()){
            double leastMeanReview = items.get(firstKey).calcMeanGrade();
            for(String itemID : items.keySet()) {
                Item item = items.get(itemID);
                if (item.hasReview() && item.calcMeanGrade() < leastMeanReview) {
                    leastMeanReview = item.calcMeanGrade();
                }
            }

            for(String itemID : items.keySet()) {
                Item item = items.get(itemID);
                if (item.hasReview() && item.calcMeanGrade() == leastMeanReview) {
                    worstReviewedItems.add(itemID);
                }
            }
        }
        return worstReviewedItems;
    }

    public List<String> getBestReviewedItems() {
        List<String> bestReviewedItems = new ArrayList<>();
        double bestMeanReview = 0.00;
        if(!items.isEmpty()){
            for(String itemID : items.keySet()) {
                Item item = items.get(itemID);
                if(item.hasReview() && item.calcMeanGrade() > bestMeanReview) {
                    bestMeanReview = item.calcMeanGrade();
                }
            }

            for(String itemID : items.keySet()) {
                Item item = items.get(itemID);
                if(item.hasReview() && item.calcMeanGrade() == bestMeanReview) {
                    bestReviewedItems.add(itemID);
                }
            }
        }
        return bestReviewedItems;
    }

    public String printAllReviews() {
        final String PREFIX = "All registered reviews:" + EOL +
                "------------------------------------" + EOL;
        String result = PREFIX;
        if(!items.isEmpty()) {
            for (String itemID : items.keySet()) {
                Item item = items.get(itemID);
                if (item.hasReview()) {
                    result += "Review(s) for " + printItem(itemID) + EOL +
                            item.getAllReviews() +
                            "------------------------------------" + EOL;
                }
            }
            if(result.equals(PREFIX)) {
                return "No items were reviewed yet.";
            }
            return result;
        }
        return "No items registered yet." ;
    }

    public String updateItemName(String itemID, String newName) {
        String result;
        if(containsItem(itemID) && !newName.isEmpty())
        {
            items.get(itemID).setName(newName);
            result = "Item "+itemID+" was updated successfully.";
        }
        else if(containsItem(itemID))
        {
            result = "Invalid data for item.";
        }
        else
        {
            result = "Item "+itemID+" was not registered yet.";
        }
        return  result;
    }

    public String updateItemPrice(String itemID, double newPrice) {
        String result ="";
        if(containsItem(itemID) && newPrice>0)
        {
            items.get(itemID).setPrice(newPrice);
            result = "Item "+itemID+" was updated successfully.";
        }
        else if(containsItem(itemID))
        {
            result = "Invalid data for item.";
        }
        else
        {
            result = "Item "+itemID+" was not registered yet.";
        }
        return  result;

    }

    public String printAllItems()
    {
        String result="";
        if(items.size()>0)
        {
            result += "All registered items:" + EOL;
            for (Map.Entry<String,Item> itemEntry: items.entrySet()){
                result+=itemEntry.getValue()+System.lineSeparator();

            }

        }
        else
        {
            result = "No items registered yet.";
        }
        return  result;

    }

    public String printMostProfitableItems() {
        if(!items.isEmpty()) {
            if(!profitPerItem.isEmpty()) {
                double maxProfit = 0;
                for (String itemID : profitPerItem.keySet()) {
                    double currentProfit = profitPerItem.get(itemID);
                    maxProfit = Math.max(currentProfit, maxProfit);
                }

                String result = "";
                double sum = 0;
                for (String itemID : profitPerItem.keySet()) {
                    if (profitPerItem.get(itemID) == maxProfit) {
                        Item item = items.get(itemID);
                        result += item + EOL;
                        sum += maxProfit;
                    }
                }
                result = String.format(
                        "Most profitable items: %sTotal profit: %.2f SEK%s%s",
                        EOL,
                        IO.truncate(sum, 2),
                        EOL,
                        result
                );
                return result;
            }
            return "No items were bought yet.";
        }
        return "No items registered yet.";
    }


    public String createEmployee(String employeeID, String employeeName, double salary) throws Exception {
        Employee regularEmployee = new RegularEmployee(employeeID, employeeName, salary);
        employees.put(employeeID,regularEmployee);
        return String.format("Employee %s was registered successfully.", employeeID);
    }

    public String printEmployee(String employeeID) throws Exception {
        if(!employees.containsKey(employeeID))
        {
            throw  new InvalidEmployeeException(employeeID);
        }
        String result = employees.get(employeeID).toString();
        return  result;
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree) throws Exception {
        Employee manager = new Manager(employeeID, employeeName, grossSalary, Degree.getDegree(degree));
        employees.put(employeeID,manager);
        String result = String.format("Employee %s was registered successfully.", employeeID);
        return  result;
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, int gpa) throws Exception {
        Employee intern = new Intern(employeeID, employeeName, grossSalary, gpa);
        employees.put(employeeID, intern);
        return String.format("Employee %s was registered successfully.", employeeID);
    }

    public double getNetSalary(String employeeID) throws Exception {
    if(!employees.containsKey(employeeID)) {
        throw new InvalidEmployeeException(employeeID);
    }
    Employee employee = employees.get(employeeID);
    return employee.getNetSalary();
}

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String dept) throws Exception {
        Employee director = new Director(employeeID, employeeName, grossSalary,Degree.getDegree(degree),Department.getDepartment(dept));
        employees.put(employeeID, director);
        return String.format("Employee %s was registered successfully.", employeeID);
    }

    public String removeEmployee(String empID) throws Exception {
        if(!employees.containsKey(empID)) {
            throw new InvalidEmployeeException(empID);
        }
        employees.remove(empID);
        return String.format("Employee %s was successfully removed.", empID);
    }

    public String printAllEmployees() throws Exception {
        if(employees.isEmpty()) {
            throw new InvalidEmployeeException(EmployeeExceptionCase.NO_EMPLOYEES_REGISTERED);
        }
        String result = "All registered employees:" + EOL;
        for(String employeeID : employees.keySet()) {
            result += employees.get(employeeID).toString() + EOL;
        }

        return result;
    }


    public double getTotalNetSalary() throws Exception {
        if(employees.isEmpty()) {
            throw new InvalidEmployeeException(EmployeeExceptionCase.NO_EMPLOYEES_REGISTERED);
        }
        double totalNetSalary = 0.0;
        for (String employeeID : employees.keySet()){
            Employee employee= employees.get(employeeID);
            totalNetSalary += employee.getNetSalary();
        }
        return IO.truncate(totalNetSalary, 2);
    }

    public String printEmployees(List<Employee> employees){
        String result = "";
        for (Employee employee : employees){
            result += employee + EOL;
        }
        return result;
    }

    public String printSortedEmployees() throws Exception {
        List<Employee> sortedEmployees = new ArrayList<>();
        for (String employeeID : employees.keySet()){
            Employee employee = employees.get(employeeID);
            sortedEmployees.add(employee);
        }
        if(sortedEmployees.isEmpty()) {
            throw new InvalidEmployeeException(EmployeeExceptionCase.NO_EMPLOYEES_REGISTERED);
        }
        String result = "Employees sorted by gross salary (ascending order):" + EOL;
        Collections.sort(sortedEmployees);
        result += printEmployees(sortedEmployees);
        return result;
    }


    public String updateEmployeeName(String empID, String newName) throws Exception
    {
        if(!employees.containsKey(empID)) {
            throw new InvalidEmployeeException(empID);
        }
        if(newName.isBlank()) {
            throw new InvalidEmployeeException(EmployeeExceptionCase.INVALID_EMPLOYEE_NAME);
        }
        employees.get(empID).setName(newName);

        return String.format("Employee %s was updated successfully", empID);
    }


    public String updateManagerDegree(String empID, String newDegree) throws Exception {
        if(!employees.containsKey(empID)) {
            throw new InvalidEmployeeException(empID);
        }

        Employee employee = employees.get(empID);
        if(!(employee.isRole(Role.MANAGER) || employee.isRole(Role.DIRECTOR))) {
            throw new InvalidEmployeeException(EmployeeExceptionCase.NO_COMPATIBLE_TYPE);
        }

        Manager manager = (Manager) employee;
        manager.setDegree(Degree.getDegree(newDegree));

        return String.format("Employee %s was updated successfully", empID);
    }


    public String updateInternGPA(String empID, int newGPA) throws Exception {
        if(!employees.containsKey(empID)) {
            throw new InvalidEmployeeException(empID);
        }

        Employee employee = employees.get(empID);

        if(!employee.isRole(Role.INTERN)) {
            throw new InvalidEmployeeException(EmployeeExceptionCase.NO_COMPATIBLE_TYPE);
        }

        Intern intern = (Intern) employee;
        intern.setGpaValue(newGPA);

        return String.format("Employee %s was updated successfully", empID);
    }



    public String updateDirectorDept(String empID, String newDepartment) throws Exception {
        if(!employees.containsKey(empID)) {
            throw new InvalidEmployeeException(empID);
        }

        Employee employee = employees.get(empID);
        if(!employee.isRole(Role.DIRECTOR)) {
            throw new InvalidEmployeeException(EmployeeExceptionCase.NO_COMPATIBLE_TYPE);
        }

        Director director = (Director) employee;
        director.setDepartment(Department.getDepartment(newDepartment));

        return String.format("Employee %s was updated successfully", empID);
    }

    public String updateGrossSalary(String empID, double newSalary) throws Exception {
        if(!employees.containsKey(empID)) {
            throw new InvalidEmployeeException(empID);
        }
        if(newSalary <= 0.00) {
            throw new InvalidEmployeeException(EmployeeExceptionCase.INVALID_EMPLOYEE_SALARY);
        }
        employees.get(empID).setRawSalary(newSalary);

        return String.format("Employee %s was updated successfully",empID);
    }



    public Map<String, Integer> mapEachDegree() throws Exception {
        if(employees.isEmpty()) {
            throw new InvalidEmployeeException(EmployeeExceptionCase.NO_EMPLOYEES_REGISTERED);
        }
        TreeMap<String, Integer> degreeMapping = new TreeMap<>();
        int bscNum = 0;
        int mscNum = 0;
        int phdNum = 0;
        for (String employeeID : employees.keySet()){
            Employee employee = employees.get(employeeID);
            if(employee instanceof Manager) {
                Manager managerOrDirector = (Manager) employee;
                switch(managerOrDirector.getDegree()) {
                    case BSC:
                        bscNum++;
                        break;
                    case MSC:
                        mscNum++;
                        break;
                    default:
                        phdNum++;
                        break;
                }
            }
        }
        if(bscNum > 0) {
            degreeMapping.put("BSc", bscNum);
        }
        if(mscNum > 0) {
            degreeMapping.put("MSc", mscNum);
        }
        if(phdNum > 0) {
            degreeMapping.put("PhD", phdNum);
        }
        return degreeMapping;
    }


    public String promoteToManager(String empID, String degree) throws Exception {
        if (!employees.containsKey(empID)){
            throw new InvalidEmployeeException(empID);
        }

        Employee employee = employees.get(empID);

        if(employee.isRole(Role.MANAGER)) {
            throw new InvalidEmployeeException(EmployeeExceptionCase.NO_COMPATIBLE_TYPE);
        }
        String name = employee.getName();
        double rawSalary = employee.getRawSalary();
        Employee manager = new Manager(empID, name, rawSalary, Degree.getDegree(degree));
        employees.put(empID, manager);
        return empID + " promoted successfully to Manager.";
    }

    public String promoteToDirector(String empID, String degree, String department) throws Exception {
        if (!employees.containsKey(empID)){
            throw new InvalidEmployeeException(empID);
        }

        Employee employee = employees.get(empID);

        if(employee.isRole(Role.DIRECTOR)) {
            throw new InvalidEmployeeException(EmployeeExceptionCase.NO_COMPATIBLE_TYPE);
        }

        String name = employee.getName();
        double rawSalary = employee.getRawSalary();
        Employee director = new Director(empID, name, rawSalary, Degree.getDegree(degree), Department.getDepartment(department));
        employees.put(empID,director);
        return empID + " promoted successfully to Director.";
    }

    public String promoteToIntern(String empID, int gpa) throws Exception {
        if (!employees.containsKey(empID)){
            throw new InvalidEmployeeException(empID);
        }

        Employee employee = employees.get(empID);

        if(employee.isRole(Role.INTERN)) {
            throw new InvalidEmployeeException(EmployeeExceptionCase.NO_COMPATIBLE_TYPE);
        }
        String name = employee.getName();
        double rawSalary = employee.getRawSalary();
        Employee intern = new Intern(empID, name, rawSalary, gpa);

        employees.put(empID,intern);
        return empID + " promoted successfully to Intern.";
    }
}
