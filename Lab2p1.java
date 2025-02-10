import java.util.Scanner;

public class Lab2p1 {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

System.out.print("Enter the number of dimensions: ");
int dimensions = scanner.nextInt();

int[] sizes = new int[dimensions];
int totalElements = 1;

System.out.println("Enter the size of each dimension:");
for (int i = 0; i < dimensions; i++) {
System.out.print("Size of dimension " + (i + 1) + ": ");
sizes[i] = scanner.nextInt();
totalElements *= sizes[i];
}

System.out.println("Total number of elements: " + totalElements);

int[] indices = new int[dimensions];
System.out.println("Enter the indices of the element to find the address:");
for (int i = 0; i < dimensions; i++) {
System.out.print("Index for dimension " + (i + 1) + ": ");
indices[i] = scanner.nextInt();
}

int baseAddress = 1000; // Example base address
int elementSize = 4; // Assuming each element takes 4 bytes
int address = baseAddress;

for (int i = 0; i < dimensions; i++) {
int offset = indices[i];
for (int j = i + 1; j < dimensions; j++) {
offset *= sizes[j];
}
address += offset * elementSize;
}

System.out.println("Calculated address: " + address);

scanner.close();
}
}
