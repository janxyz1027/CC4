import java.util.Scanner;

public class Lab2p2{

// Method to compute the total number of elements in the array
public static int computeTotalElements(int[] dimensions) {
int total = 1;
for (int dim : dimensions) {
total *= dim;
}
return total;
}

// Method to compute the address of an element in the multidimensional array
public static int computeAddress(int baseAddress, int esize, int[] dimensions, int[] indices) {
int[] L = new int[dimensions.length];
L[dimensions.length - 1] = 1;

for (int i = dimensions.length - 2; i >= 0; i--) {
L[i] = L[i + 1] * dimensions[i + 1];
}

int offset = 0;
for (int i = 0; i < indices.length; i++) {
offset += indices[i] * L[i];
}

return baseAddress + esize * offset;
}

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

System.out.println("Record Address Calculation Program");

// Accept user inputs
System.out.print("How many dimensions does the array have? ");
int numDimensions = scanner.nextInt();
int[] dimensions = new int[numDimensions];

System.out.println("Enter the size of each dimension (one by one):");
for (int i = 0; i < numDimensions; i++) {
System.out.print("Size of dimension " + (i + 1) + ": ");
dimensions[i] = scanner.nextInt();
}

int[] indices = new int[numDimensions];
System.out.println("Enter the index for each dimension (one by one):");
for (int i = 0; i < numDimensions; i++) {
System.out.print("Index for dimension " + (i + 1) + ": ");
indices[i] = scanner.nextInt();
}

System.out.print("Enter the base address: ");
int baseAddress = scanner.nextInt();

System.out.print("Enter the element size (in bytes): ");
int esize = scanner.nextInt();

// Compute total elements
int totalElements = computeTotalElements(dimensions);
System.out.println("Total number of elements: " + totalElements);

// Compute address
int address = computeAddress(baseAddress, esize, dimensions, indices);
System.out.println("Address of the element: " + address);

scanner.close();
}
}
