package Logic;

public class Vertex {
    private double x;
    private double y;

    Vertex(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    } 

    public void setY(double y) {
        this.y = y;
    }

    public void setCoordinates(double x, double y) {
        setX(x);
        setY(y);
    }
}
