import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading the size of the array and the number of threads from user input
        int arraySize = scanner.nextInt();
        int numOfThreads = scanner.nextInt();
        if(numOfThreads == 0)
            throw new IllegalArgumentException("Must be at least 1 thread");
        // Creating a shared array with the specified size and starting index of 1
        SharedArray theSharedArray = new SharedArray(arraySize,1);

        // Printing the initial state of the array
        theSharedArray.print();

        // Creating an array to hold the worker threads
        Worker[] arrayOfThreads = new Worker[numOfThreads];

        // Initializing each worker thread with the shared array
        for(int i = 0; i < numOfThreads; i++){
            arrayOfThreads[i] = new Worker(theSharedArray);
        }

        // Starting each worker thread
        for (Worker arrayOfThread : arrayOfThreads) {
            arrayOfThread.start();
        }

        // Waiting for each worker thread to finish execution
        for (Worker arrayOfThread : arrayOfThreads) {
            try {
                arrayOfThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int lastCell = theSharedArray.getArrayLength() - 1;
        theSharedArray.printSpecificCell("\nThe total sum is: " , lastCell);
        System.out.println("\n-------------\nDONE");
    }
}