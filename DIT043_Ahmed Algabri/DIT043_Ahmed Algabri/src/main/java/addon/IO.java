package addon;
import java.util.Scanner;
public class IO
{

 public  static  int readInt(String msg)
 {
     Scanner scan = new Scanner(System.in);
     System.out.println(msg);
     int readInt = scan.nextInt();
     return readInt;
 }
 public static double readDouble(String msg)
 {
     Scanner scan = new Scanner(System.in);
     System.out.println(msg);
     double readDouble = scan.nextDouble();
     return readDouble;
 }
 public  static String readString(String msg)
 {
     Scanner scan = new Scanner(System.in);
     System.out.println(msg);
     String readStr = scan.nextLine();
     return  readStr;
 }

    public static double truncate(double num, int decimals) {
        return ((int) (num * Math.pow(10, decimals))) / Math.pow(10, decimals);
    }

    
    public static String truncateToString(double num, int decimals) {
        return String.format("%." + decimals + "f", truncate(num, decimals));
    }


}
