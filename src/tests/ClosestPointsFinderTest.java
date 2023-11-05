package tests;

import org.junit.jupiter.api.Test;
import main.ClosestPointsFinder;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClosestPointsFinderTest {
    @Test
    public void testValidInput() {
        int[][] points = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int s = 2;
        ClosestPointsFinder finder = new ClosestPointsFinder(points, s);
        int[][] expected = {{1, 2}, {3, 4}};
        int[][] actual = finder.getClosestPoints();
        assertArrayEquals(expected, actual);
    }
    @Test
    void testRequestMorePointsThanAvailable() {
        int[][] points = {};
        int s = 2;
        assertThrows(IllegalArgumentException.class, () -> {
            new ClosestPointsFinder(points, s);
        });
    }
    @Test
    void testAllPointsAreTheSame() {
        int[][] points = {{1,2}, {1,2}, {1,2}, {1,2}};
        int s = 2;
        ClosestPointsFinder finder = new ClosestPointsFinder(points, s);
        int[][] expected = {{1,2}, {1,2}};
        int[][] actual = finder.getClosestPoints();
        assertArrayEquals(expected, actual);
    }
    @Test
    void testPointsAreNot2D() {
        int[][] points = {{1,2}, {1,2}, {1,2}, {1}};
        int s = 2;
        assertThrows(IllegalArgumentException.class, () -> {
            new ClosestPointsFinder(points, s);
        });
    }
    @Test
    void testEmptyArray() {
        int[][] points = {};
        int s = 0;
        int[][] expected = {};
        int[][] actual = new ClosestPointsFinder(points, s).getClosestPoints();
        assertArrayEquals(expected, actual);
    }
}
