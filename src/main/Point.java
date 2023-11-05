package main;

public class Point implements Comparable<Point>
{
    private int x;
    private int y;
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    @Override
    public int compareTo(Point other)
    {
        // Compare points by their distance from 0
        return x*x+y*y - other.x*other.x-other.y*other.y;
    }

}
