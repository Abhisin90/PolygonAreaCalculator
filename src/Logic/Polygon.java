package Logic;

public class Polygon {
    private Vertex[] corners;
    private Line[] sides;
    private Angle[] angles;
    private int scaleFactor = 1;
    private double area;

    Polygon(Vertex[] v) {
        corners = v;
        sides = new Line[4];
        angles = new Angle[4];
        
        // Asume anticlockwise traversal starting from bottom-left vertex and bottom side

        for (int i = 0; i < 4; i++) {
            sides[i] = new Line(corners[i], corners[(i+1)%4]);
        }

        for (int i = 0; i < 4; i++) {
            angles[i] = new Angle(sides[(i+3)%4], sides[i]);
        }
    }

    public Vertex[] getCorners() {
        return this.corners;
    }

    public Line[] getLines() {
        return this.sides;
    }

    public Angle[] getAngles() {
        return this.angles;
    }

    public int getScaleFactor() {
        return this.scaleFactor;
    }

    public double getArea() {
        return this.area;
    }

    public void setScaleFactor(int f) {
        this.scaleFactor = f;
    }

    public void calculateArea() {
        // method to calculate area of the polygon
    }
}
