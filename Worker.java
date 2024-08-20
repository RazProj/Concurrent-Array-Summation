public class Worker extends Thread {
    private final SharedArray sharedArray;


    // Constructor to initialize the worker thread with the shared array
    public Worker(SharedArray currentSharedArray) {
        this.sharedArray = currentSharedArray;
    }

    @Override
    public void run() {
        // Loop to perform operations on the shared array
        for (int i = sharedArray.getIndex(); i < sharedArray.getArrayLength(); i++) {
            sharedArray.add();
        }
    }
}