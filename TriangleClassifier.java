import java.util.Scanner;

public class TriangleClassifier {

    // NEW METHOD: Display welcome banner
    public static void displayWelcomeBanner() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║    TRIANGLE CLASSIFIER v2.0            ║");
        System.out.println("║    Classify Any Triangle Easily        ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println();
    }

    // MODIFIED: Enhanced validation with positive number check
    public static boolean isValidTriangle(double a, double b, double c) {
        // Check for positive values
        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("Error: All sides must be positive numbers!");
            return false;
        }
        // Check triangle inequality theorem
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

    // MODIFIED: Improved angle classification with epsilon for floating point comparison
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

        // Use epsilon for floating point comparison
        double epsilon = 0.0001;

        if (Math.abs(sumOfSquares - hypotenuseSquare) < epsilon) {
            return "Right-angled";
        } else if (sumOfSquares > hypotenuseSquare) {
            return "Acute-angled";
        } else {
            return "Obtuse-angled";
        }
    }

    // NEW METHOD: Calculate and display additional properties
    public static void displayTriangleProperties(double a, double b, double c) {
        System.out.println("\n--- Additional Properties ---");

        // Calculate perimeter
        double perimeter = a + b + c;
        System.out.printf("Perimeter: %.2f units\n", perimeter);

        // Calculate area using Heron's formula
        double s = perimeter / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        System.out.printf("Area: %.2f square units\n", area);
    }

    // MODIFIED: Enhanced main method with better UI and error handling
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // NEW: Display welcome banner
        displayWelcomeBanner();

        System.out.println("Please enter the three sides of your triangle:\n");

        try {
            System.out.print("Side 1: ");
            double side1 = scanner.nextDouble();

            System.out.print("Side 2: ");
            double side2 = scanner.nextDouble();

            System.out.print("Side 3: ");
            double side3 = scanner.nextDouble();

            System.out.println(); // Blank line for better readability

            // Validate triangle
            if (!isValidTriangle(side1, side2, side3)) {
                System.out.println("\n⚠ These sides do not form a valid triangle!");
                System.out.println("Remember: Sum of any two sides must be greater than the third side.");
                return;
            }

            // Classify triangle
            String sideClassification = classifyBySides(side1, side2, side3);
            String angleClassification = classifyByAngles(side1, side2, side3);

            // Display results with better formatting
            System.out.println("═══════════════════════════════════════");
            System.out.println("         CLASSIFICATION RESULTS        ");
            System.out.println("═══════════════════════════════════════");
            System.out.println("By Sides:  " + sideClassification + " Triangle");
            System.out.println("By Angles: " + angleClassification + " Triangle");

            // NEW: Display additional properties
            displayTriangleProperties(side1, side2, side3);

            System.out.println("\n✓ Classification completed successfully!");

        } catch (Exception e) {
            System.out.println("\n⚠ Error: Please enter valid numeric values!");
        } finally {
            scanner.close();
        }
    }
}