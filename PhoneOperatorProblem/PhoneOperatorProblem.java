package Problems;

import java.util.Random;

public class PhoneOperatorProblem {

    public static void main(String[] args) {

        final int N = 10;

        Phone[] phones = new Phone[N];

        /*
        phones[0] = new Phone(0, 2);
        phones[1] = new Phone(1, 5);
        phones[2] = new Phone(2, 3);
        phones[3] = new Phone(3, 0);
        phones[4] = new Phone(4, 10);
        phones[5] = new Phone(5, 4);
        phones[6] = new Phone(6, 6);
        phones[7] = new Phone(7, 8);
        phones[8] = new Phone(8, 1);
        phones[9] = new Phone(9, 11);
         */

        fillArray(phones);

        buildMaxHeap(phones);

        printArray(phones);
        System.out.println("Is  Heap: " + isMaxHeap(phones));


        addNewCall(phones, 5);
        addNewCall(phones, 5);
        addNewCall(phones, 5);

        printArray(phones);
        System.out.println("Is  Heap: " + isMaxHeap(phones));

        directCall(phones);
        directCall(phones);

        printArray(phones);
        System.out.println("Is  Heap: " + isMaxHeap(phones));

        directCall(phones);

        printArray(phones);
        System.out.println("Is  Heap: " + isMaxHeap(phones));

        deleteWaitCall(phones, 5);
        deleteWaitCall(phones, 4);
        deleteWaitCall(phones, 3);
        deleteWaitCall(phones, 5);
        deleteWaitCall(phones, 5);

        printArray(phones);
        System.out.println("Is  Heap: " + isMaxHeap(phones));

        addNewCall(phones, 5);
        addNewCall(phones, 5);

        printArray(phones);
        System.out.println("Is  Heap: " + isMaxHeap(phones));

        directCall(phones);
        directCall(phones);
        directCall(phones);
        directCall(phones);
        directCall(phones);
        directCall(phones);
        printArray(phones);


    }

    // Fills the array with random numbers that can be equal to the maximum array length
    private static void fillArray(Phone[] array) {

        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            Phone phone = new Phone(i, random.nextInt(array.length) + 1);
            array[i] = phone;
        }

    }

    // print array method
    private static void printArray(Phone[] array) {

        for (Phone phone : array)
            System.out.print(phone + ", ");

        System.out.println();

    }

    private static boolean isMaxHeap(Phone[] array) {

        for (int i = 0; i < array.length / 2; i++) {

            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < array.length && array[left].getKey() > array[i].getKey())
                return false;

            if (right < array.length && array[right].getKey() > array[i].getKey())
                return false;

        }

        return true;

    }

    private static void buildMaxHeap(Phone[] array) {

        for (int i = (array.length / 2) - 1; i >= 0; i--)
            heapify(array, i, array.length);

    }

    private static void increaseCall(Phone[] array, int i) {

        array[i].setKey(array[i].getKey() + 1);

        while (i > 0 && array[i].getKey() > array[(i - 1) / 2].getKey()) {

            swap(array, i, (i - 1) / 2);
            i = (i - 1) / 2;

        }


    }

    private static void decreaseCall(Phone[] array, int i) {

        array[i].setKey(array[i].getKey() - 1);

        heapify(array, i, array.length);


    }


    private static void heapify(Phone[] array, int i, int heapSize) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < heapSize && array[left].getKey() > array[largest].getKey())
            largest = left;

        if (right < heapSize && array[right].getKey() > array[largest].getKey())
            largest = right;

        if (largest != i) {

            swap(array, i, largest);

            heapify(array, largest, heapSize);

        }


    }

    private static int findIndex(Phone[] array, int id) {

        for (int i = 0; i < array.length; i++)
            if (array[i].getId() == id)
                return i;

        return -1;
    }

    private static void swap(Phone[] array, int i, int j) {
        Phone temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void addNewCall(Phone[] array, int id) {

        if (id > array.length || id < 0)
            return;

        increaseCall(array, findIndex(array, id));
        printAddNewCall(array, id);

    }

    public static void deleteWaitCall(Phone[] array, int id) {

        if (id > array.length || id < 0)
            return;

        decreaseCall(array, findIndex(array, id));
        printDeleteCall(array, id);

    }

    public static void directCall(Phone[] array) {

        Phone directedPhone = array[0];

        if (directedPhone.getKey() != 0)
            decreaseCall(array, 0);

        printDirect(directedPhone);

    }

    private static void printAddNewCall(Phone[] array, int id) {
        System.out.println("Add new call the queue to phone " + array[findIndex(array, id)]);
    }

    private static void printDeleteCall(Phone[] array, int id) {
        System.out.println("Leave call the queue: " + array[findIndex(array, id)]);
    }

    private static void printDirect(Phone phone) {
        System.out.println("Directing call to phone " + phone.getId());
    }


}

class Phone {

    private final int id;
    private int key;

    public Phone(int id, int key) {
        this.id = id;
        this.key = key;
    }

    public int getId() {
        return id;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "{ Id : " + id + " Key : " + key + " }";
    }

}