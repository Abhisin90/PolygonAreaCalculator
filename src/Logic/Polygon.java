package Logic;

public class Polygon {
    private Vertex[] corners;
    private Line[] sides;
    private Angle[] angles;
    private double scaleFactor = 1.0;
    private double area;

    Polygon(Vertex[] v) {
        corners = v;
        sides = new Line[4];
        angles = new Angle[4];
        // Assume anticlockwise traversal starting from bottom-left vertex and bottom side

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

    public double getScaleFactor() {
        return this.scaleFactor;
    }

    public double getArea() {
        return this.area;
    }

    public void setScaleFactor(double f) {
        this.scaleFactor = f;
    }

    public void calculateArea() {
        double A = Math.toRadians(this.angles[0].getAngle());
        double C = Math.toRadians(this.angles[2].getAngle());
        double areaLowerTriangle = 0.5 * this.sides[0].getLength() * this.sides[3].getLength() * Math.sin(A);
        double areaUpperTriangle = 0.5 * this.sides[1].getLength() * this.sides[2].getLength() * Math.sin(C);
        this.area = areaLowerTriangle + areaUpperTriangle;
    }
}
