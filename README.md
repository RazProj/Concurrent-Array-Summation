### Overview
This project is a Java application designed to sum an array of integers using multiple threads simultaneously. 
The application demonstrates how concurrency can be used to divide a task (summing an array) among multiple worker threads, each processing a portion of the array, and then combining the results.

### Project Structure
*Main.java: The entry point of the application. It initializes the shared array of integers, creates worker threads, and coordinates the concurrent summation process.
* SharedArray.java: Manages the array of integers shared among multiple threads. This class includes methods for accessing and modifying the array, and it handles the synchronization required to ensure thread-safe operations.
* Worker.java: Represents a worker thread that processes a segment of the array. Each worker calculates the sum of its assigned portion of the array and contributes to the overall total.
* run.bat: A batch script to compile and run the Java application easily.

### How to Run the Program
* Ensure that you have the Java Development Kit (JDK 8 or higher) installed on your system.
* Open the command line and navigate to the directory containing the program files.
* Run the program using the provided run.bat script, or by typing the following command:`java Main`.
