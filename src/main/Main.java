package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            int[][] points = getUserInputPoints();
            int s = getS(points.length);
            ClosestPointsFinder finder = new ClosestPointsFinder(points, s);
            finder.printPoints();
        }
        catch (IllegalArgumentException e) {
            // If the user enters invalid input, ask them if they want to try again
            System.out.println(e.getMessage() + " Choose 1 to try again or 2 to exit");
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextInt() == 1) {
                main(args);
            }
            else {
                return;
            }
        }
    }
    public static int[][] getUserInputPoints() {
        // Get the points from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of points: ");
        if(!scanner.hasNextInt()) {
            throw new IllegalArgumentException("Number of points must be an integer");
        }
        int numPoints = scanner.nextInt();
        int[][] points = new int[numPoints][2];
        for (int i = 0; i < numPoints; i++) {
            System.out.println("Enter point " + (i + 1) + " with a space between x and y: ");
            if(!scanner.hasNextInt()) {
                throw new IllegalArgumentException("Points must be integers");
            }
            points[i][0] = scanner.nextInt();
            if(!scanner.hasNextInt()) {
                throw new IllegalArgumentException("Points must be integers");
            }
            points[i][1] = scanner.nextInt();
        }
        return points;
    }

    public static int getS(int arrSize) {
        // Get the number of points to return
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter desired S: ");
        if(!scanner.hasNextInt()) {
            throw new IllegalArgumentException("S must be an integer");
        }
        int s = scanner.nextInt();
        if(s < 0 || s > arrSize) {
            throw new IllegalArgumentException("S must be positive and less than the number of points");
        }
        return s;
    }
}
