package notes;

class Point
{
    private double x, y;

    // Default constructor
    Point()
    {
        x = Math.random();
        y = Math.random();
    }

    // Parameterized constructor
    Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    // Getter for x
    double x()
    {
        return x;
    }

    // Getter for y
    double y()
    {
        return y;
    }

    // Calculate the radius
    double r()
    {
        return Math.sqrt(x * x + y * y);
    }

    // Calculate the angle in radians
    double theta()
    {
        return Math.atan2(y, x);
    }

    // Calculate the distance between two points
    double distance(Point p)
    {
        double dx = x - p.x();
        double dy = y - p.y();
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Convert the point to a string representation
    public String toString()
    {
        return "(" + x + "," + y + ")";
    }
}
