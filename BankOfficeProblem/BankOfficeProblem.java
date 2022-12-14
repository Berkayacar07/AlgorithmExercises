import java.util.Random;

public class BankOfficeProblem {

    public static void main(String[] args) {

        final int POWER = 16;

        final int N = (int) Math.pow(2, POWER);

        final int[] ARRAY = new int[N];

        final int K = 65535;

        fillArray(ARRAY);


        // K = { 1,  N/16  ,  2N/16 ,  3N/16 ,  4N/16 ,  5N/16 ,  6N/16 ,  7N/16 ,  8N/16 ,  9N/16 ,  10N/16 ,  11N/16 ,  12N/16 ,  13N/16 ,  14N/16 ,  15N/16 ,  N-1  }
        // K = { 1 , 4096  ,  8192  ,  12288 ,  16384 ,  20480 ,  24576 ,  28672 ,  32768 ,  36864 ,  40960  ,  45056  ,  49152  ,  53248  ,  57344  ,  61440  , 65535 }

        insertionSort(ARRAY);
        final int[] SHIFTED_ARRAY = rightShift(ARRAY, K);

        long startTime = getTime();
        insertionSort(SHIFTED_ARRAY);
        long endTime = getTime();

        System.out.print("K  =  " + K + " , ");
        System.out.println("Time : " + getTimeDifference(startTime, endTime) + "ms");


    }

    // Fills the array with random numbers that can be equal to the maximum array length
    public static void fillArray(int[] array) {

        Random random = new Random();

        for (int i = 0; i < array.length; i++)
            array[i] = random.nextInt(array.length);

    }

    // print array method
    public static void printArray(int[] array) {

        for (int j : array)
            System.out.print(j + " ");

        System.out.println();

    }

    // return the time in nanoseconds
    public static long getTime() {
        return System.nanoTime();
    }

    // It takes the difference of the nanosecond type time values and converts the result to ms.
    public static double getTimeDifference(long startTime, long finishTime) {
        return (finishTime - startTime)/1000000.0;
    }


    // K is the shift value to the right
    public static int[] rightShift(int[] arr, int k){
        int[] array = new int[arr.length];

        for (int i = 0; i < array.length ; i++) {
            array[(i+k)%array.length]=arr[i];
        }
        return array;
    }

    // Insertion Sort Method
    public static void insertionSort (int [] array) {

        int key;
        int i;

        for ( int j = 1; j < array.length ; j++ ) {

            key = array[j];
            i = j - 1;

            while ( i >= 0 && array [i] > key ) {
                array [ i + 1 ] = array[i] ;
                i--;
            }

            array [ i + 1 ] = key;

        }

    }

}