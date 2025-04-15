
import java.util.Scanner;

public class practice4 {


 public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

             System.out.print("Type the number of rows: ");
             int rows = input.nextInt();
             input.nextLine();

             System.out.print("Type the number of columns: ");
             int columns = input.nextInt();
             input.nextLine();

             int[][] myMatrix = new int[rows][columns];

             for (int i = 0; i < myMatrix.length; i++) {
                 for (int j = 0; j < myMatrix[i].length; j++) {
                     System.out.print("Type element row "+i+", column"+j+": ");
                     myMatrix[i][j] = input.nextInt();
                     input.nextLine();
                     }
             }

      for (int i = 0; i < myMatrix.length; i++) {
          for (int j = 0; j < myMatrix[i].length; j++) {
              System.out.print(myMatrix[i][j]+ " ");
              }
          System.out.println();
          }

      int matrixSum = 0;
      for (int i = 0; i < myMatrix.length; i++) {
          for (int j = 0; j < myMatrix[i].length; j++) {
              matrixSum = matrixSum + myMatrix[i][j];
              }
          }

      System.out.println("The sum of all elements is "+matrixSum);
      input.close();
     }
 }
