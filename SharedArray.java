import java.security.SecureRandom;

public class SharedArray {
    private static final SecureRandom generator = new SecureRandom();
    private final int[] array;
    private int index;
    private int sumCount = 2;

    // Constructor to initialize the array with random values and set the starting index
    public SharedArray(int size, int index) {
        if(size == 0)
            throw new IllegalArgumentException("Size can`t be 0 length");
        this.array = new int[size];
        this.index = index;
        for (int i = 0; i < this.array.length; i++) {
            int temp = generator.nextInt(100) + 1; // Generate random values between 1 and 100
            this.array[i] = temp;
        }
    }

    // Synchronized method to perform addition operation on the array
    public synchronized void add() {
        // Check if the index is out of bounds
        if (this.index >= array.length)
            return;

        // Perform the addition operation and update the array
        this.array[this.index] = this.array[this.index] + this.array[this.index - 1];
        this.array[this.index - 1] = 0;

        // Print the sum of the current and previous index values
        System.out.println("The sum of the first " + this.sumCount + " values is: " + this.array[this.index]);
        sumCount++;
        this.index++;
    }

    // Synchronized method to get the current index
    public synchronized int getIndex() {
        return this.index;
    }

    // Method to get the length of the array
    public int getArrayLength() {
        return this.array.length;
    }

    // Method to print the current state of the array
    public void print() {
        System.out.print("The array: ");
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    // Method to print the value of a specific cell in the array
    public void printSpecificCell(String opening,int cell) {
        System.out.println(opening + this.array[cell]);
    }
}
