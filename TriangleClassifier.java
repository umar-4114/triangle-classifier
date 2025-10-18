import java.util.Scanner;

public class TriangleClassifier {
    
    // Method to check if three sides form a valid triangle
    public static boolean isValidTriangle(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
    
    // Method to classify triangle by sides
    public static String classifyBySides(double a, double b, double c) {
        if (a == b && b == c) {
            return "Equilateral";
        } else if (a == b || b == c || a == c) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }
    
    // Method to classify triangle by angles
    public static String classifyByAngles(double a, double b, double c) {
        // Sort sides to find the longest side
        double[] sides = {a, b, c};
        java.util.Arrays.sort(sides);
        
        double side1 = sides[0];
        double side2 = sides[1];
        double hypotenuse = sides[2];
        
        // Apply Pythagorean theorem
        double sumOfSquares = side1 * side1 + side2 * side2;
        double hypotenuseSquare = hypotenuse * hypotenuse;
        
        if (sumOfSquares == hypotenuseSquare) {
            return "Right-angled";
        } else if (sumOfSquares > hypotenuseSquare) {
            return "Acute-angled";
        } else {
            return "Obtuse-angled";
        }
    }
    
    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Triangle Classifier");
        System.out.println("Enter three sides of the triangle:");
        
        System.out.print("Side 1: ");
        double side1 = scanner.nextDouble();
        
        System.out.print("Side 2: ");
        double side2 = scanner.nextDouble();
        
        System.out.print("Side 3: ");
        double side3 = scanner.nextDouble();
        
        // Validate triangle
        if (!isValidTriangle(side1, side2, side3)) {
            System.out.println("Error: These sides do not form a valid triangle!");
            return;
        }
        
        // Classify triangle
        String sideClassification = classifyBySides(side1, side2, side3);
        String angleClassification = classifyByAngles(side1, side2, side3);
        
        // Display results
        System.out.println("\nTriangle Classification:");
        System.out.println("By Sides: " + sideClassification + " Triangle");
        System.out.println("By Angles: " + angleClassification + " Triangle");
        
        scanner.close();
    }
}