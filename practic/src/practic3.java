import java.util.Scanner;
public class practic3 {


public static void main(String[] args) {

         Scanner input = new Scanner(System.in);
         int[][] myMatrix = new int[4][3];

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

     input.close();
     }
 }