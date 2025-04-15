public class Arrays {

    public static int[] reverse(int[] inputArray)
    {
        int[] reversedArray = inputArray;
        for (int i = 0; i < reversedArray.length / 2; i++) {
            int temp = reversedArray[i];


            reversedArray[i] = reversedArray[reversedArray.length - i - 1];
            reversedArray[reversedArray.length - i - 1] = temp;
        }
        return reversedArray;

    }

    public static  void printArray(int[] inputArray){

        for (int i=0; i<inputArray.length;i++){

            System.out.print(inputArray[i]+" ");
        }


    }

    public static void main(String[] args) {


        int[] inputArray = {0,1,2,3,4,5,6,7,8,9};
      reverse(inputArray);

      printArray(inputArray);

        }
}
