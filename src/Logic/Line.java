package Logic;

public class Line {
    private Vertex endPoint1;
    private Vertex endPoint2;
    private double slope;
    private double length;

    Line(Vertex p1, Vertex p2) {
        this.endPoint1 = p1;
        this.endPoint2 = p2;
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();
        this.slope = (y1 - y2) / (x1 - x2);
        this.length = Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
    }

    public Vertex getEndPoint1() {
        return endPoint1;
    }

    public Vertex getEndPoint2() {
        return endPoint2;
    }

    public double getSlope() {
        return slope;
    }

    public double getLength() {
        return length;
    }

    public void setEndPoint1(Vertex p1) {
        this.endPoint1 = p1;
    }

    public void setEndPoint2(Vertex p2) {
        this.endPoint2 = p2;
    }

    public void setSlope() {
        this.slope = this.calculateSlope();
    }

    public void setLength(double sf) {
        this.length = this.calculateLength(sf);
    }

    public double calculateSlope() {
        double x1 = this.getEndPoint1().getX();
        double y1 = this.getEndPoint1().getY();
        double x2 = this.getEndPoint2().getX();
        double y2 = this.getEndPoint2().getY();
        return (y1 - y2) / (x1 - x2);
    }

    public double calculateLength(double sf) {
        double x1 = this.getEndPoint1().getX();
        double y1 = this.getEndPoint1().getY();
        double x2 = this.getEndPoint2().getX();
        double y2 = this.getEndPoint2().getY();
        return Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2)) * sf;
    }
}
