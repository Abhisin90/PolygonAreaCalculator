package Logic;

public class Polygon {
    private Vertex[] corners;
    private Line[] sides;
    private Angle[] angles;
    private double area;

    public Polygon(Vertex[] v) {
        corners = v;
        sides = new Line[4];
        angles = new Angle[4];

        for (int i = 0; i < 4; i++) {
            sides[i] = new Line(corners[i], corners[(i + 1) % 4]);
        }

        for (int i = 0; i < 4; i++) {
            angles[i] = new Angle(sides[(i + 3) % 4], sides[i]);
        }
    }

    public Vertex[] getCorners() {
        return this.corners;
    }

    public Line[] getSides() {
        return this.sides;
    }

    public Angle[] getAngles() {
        return this.angles;
    }

    public double getArea() {
        return this.area;
    }

    public void calculateArea() {
        double a = 0;
        for (int i = 0; i < 4; i++) {
            a += corners[i].getX() * corners[(i + 1) % 4].getY() - corners[(i + 1) % 4].getX() * corners[i].getY();
        }
        this.area = Math.abs(a * 0.5);
    }
}
