package main;

import main.Point;

import java.util.*;

public class ClosestPointsFinder {
    private int[][] closestPoints;
    public ClosestPointsFinder(int[][] points, int s) {
        if (points.length < s) {//validate array size
            throw new IllegalArgumentException("Insufficient points in array");
        }
        List<Point> pointList = new ArrayList<>();//using a list instead of a priority queue to avoid time complexity of O(nlogn) for adding all points
        for (int[] point : points) {
            if (point.length != 2) { // validate array values
                throw new IllegalArgumentException("Points must be 2D");
            }
            pointList.add(new Point(point[0], point[1]));
        }
        PriorityQueue<Point> pointsPQ = new PriorityQueue<>(pointList);
        closestPoints = new int[s][2];
        for(int i = 0; i < s; i++) {
            // Add the closest points to the array
            Point point = pointsPQ.poll();
            closestPoints[i][0] = point.getX();
            closestPoints[i][1] = point.getY();
        }
    }

    public void printPoints() {
        // Print the points in the array
        System.out.println("The closest points are: \n");
        for (int[] point : closestPoints) {
            System.out.println(point[0] + " " + point[1]);
        }
    }

    public int[][] getClosestPoints() {
        return closestPoints;
    }
}