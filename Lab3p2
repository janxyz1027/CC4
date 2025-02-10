import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lab3p2 {

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
Queue<String> queue = new LinkedList<>(); // Create a queue to store strings

while (true) {
System.out.println("\nQueue Operations:");
System.out.println("1. Enqueue an element into the queue");
System.out.println("2. Dequeue an element from the queue");
System.out.println("3. Display the current queue");
System.out.println("4. Exit");
System.out.print("Enter your choice (1/2/3/4): ");
int choice = scanner.nextInt();
scanner.nextLine(); // Consume the newline character after the integer input

switch (choice) {
case 1:
// Enqueue operation
System.out.print("Enter the element to enqueue: ");
String element = scanner.nextLine();
queue.add(element); // Add the element to the queue
System.out.println("Element enqueued: " + element);
displayQueue(queue); // Display the queue contents
break;

case 2:
// Dequeue operation
if (!queue.isEmpty()) {
String dequeuedElement = queue.poll(); // Remove and return the front element
System.out.println("Element dequeued: " + dequeuedElement);
} else {
System.out.println("Queue is empty! Cannot dequeue.");
}
displayQueue(queue); // Display the queue contents
break;

case 3:
// Display the queue
displayQueue(queue);
break;

case 4:
// Exit the program
System.out.println("Exiting the program...");
scanner.close();
return;

default:
System.out.println("Invalid choice! Please enter a valid option.");
}
}
}

// Method to display the contents of the queue
public static void displayQueue(Queue<String> queue) {
if (queue.isEmpty()) {
System.out.println("Queue is empty!");
} else {
System.out.println("Current Queue: " + queue);
}
}
}
