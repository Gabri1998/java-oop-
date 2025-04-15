public class Mixer {
 private int num1;
private int num2;
 static int total = 0;

         public Mixer(int num1, int num2) {
         this.num1 = num1;
         this.num2 = num2;
         total = total + num2;
         System.out.println("contructor: total: " + total);
         }

         public String toString() {
         return "num1 = " + num1 + " num2 = " + num2;
        }
         public static void updateTotal(int num1, int num2) {
         num1 = num1 + num2;
         num2 = num1 - num2;
         total = total + num1 + num2;
         System.out.println("method: num1 = " + num1 + " num2 = " + num2 +
                 " total = " + total);
         }

         public static void mixContent(Mixer mA, Mixer mC) {
         int temp1 = mA.num1;
         int temp2 = mA.num2;

         mA.num1 = mC.num1;
         mA.num2 = mC.num2;
         mC.num1 = temp1;
         mC.num2 = temp2;
         }

         public static void main(String[] args)   {


         Mixer mA = new Mixer(1, 2);
         Mixer mB = new Mixer(-1, -2);
         Mixer mC = new Mixer(4, -4);

         mixContent(mA, mB);
         mixContent(mC, mB);
         System.out.println("mA has " + mA);
         System.out.println("mB has " + mB);
         System.out.println("mC has " + mC);
             updateTotal(mA.num2, mB.num2);

              int num1 = 8;
              int num2 = 3;
              updateTotal(num1, num2);
              System.out.println("main: num1 = " + num1 + " num2 = " + num2 +
                      " total = " + total);

              mixContent(mA, mC);
              System.out.println("mA has " + mA);

              mC = mA;
              mC.num1 = 10;
              System.out.println("mA has " + mA);
              System.out.println("mC has " + mC);

              mA = new Mixer(100, 50);
              mC.num1 = num1;
              mC.num2 = num2;
              System.out.println("mA has " + mA);
              System.out.println("mC has " + mC);
              }
 }
