import java.util.Scanner;
public class practic2 {
public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

         System.out.print("Type the number of elements: ");
         int arraySize = in.nextInt();
         in.nextLine();

         int[] numArray = new int[arraySize];

         for (int i = 0; i < numArray.length; i++) {
             System.out.print("Type element n." + (i + 1) + ": ");
             numArray[i] = in.nextInt();
             in.nextLine();
             }

         int maxElement = numArray[0];
         for(int i = 1; i < numArray.length; i++) {
             if(numArray[i] > maxElement) {
             maxElement = numArray[i];
             }
            }
         System.out.println("Max element is: "+maxElement);

         int totalSum = 0;
         for (int i = 0; i < numArray.length; i++) {
             totalSum = totalSum + numArray[i];
             }
        System.out.println("Total sum is: "+totalSum);
                                                        //We need to convert the division to double, because
                                                        // both totalSum and numArray.length are integers.
                                                         // Otherwise, Java will round to the closest int.
                                                        // Try the code below with and without the conversion
                                                         // to notice the difference in the mean value.
         double mean = totalSum /  (double)numArray.length;
         System.out.println("The mean of all elements is: "+mean);

         in.close();
         }
 }

