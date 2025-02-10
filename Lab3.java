import java.util.Scanner;
import java.util.Stack;

public class Lab3 {

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
Stack<String> stack = new Stack<>(); // Create a stack to store strings

while (true) {
System.out.println("\nStack Operations:");
System.out.println("1. Push an element onto the stack");
System.out.println("2. Pop an element from the stack");
System.out.println("3. Display the current stack");
System.out.println("4. Exit");
System.out.print("Enter your choice (1/2/3/4): ");
int choice = scanner.nextInt();
scanner.nextLine(); // Consume the newline character after the integer input

switch (choice) {
case 1:
// Push operation
System.out.print("Enter the element to push: ");
String element = scanner.nextLine();
stack.push(element); // Add the element to the stack
System.out.println("Element pushed: " + element);
displayStack(stack); // Display the stack contents
break;

case 2:
// Pop operation
if (!stack.isEmpty()) {
String poppedElement = stack.pop(); // Remove and return the top element
System.out.println("Element popped: " + poppedElement);
} else {
System.out.println("Stack is empty! Cannot pop.");
}
displayStack(stack); // Display the stack contents
break;

case 3:
// Display the stack
displayStack(stack);
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

// Method to display the contents of the stack
public static void displayStack(Stack<String> stack) {
if (stack.isEmpty()) {
System.out.println("Stack is empty!");
} else {
System.out.println("Current Stack: " + stack);
}
}
}
