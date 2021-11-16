package Logic;

public class Angle {
    private Vertex commonVertex;
    private Line line1;
    private Line line2;
    private double angle;

    Angle(Line l1, Line l2) {
        this.line1 = l1;
        this.line2 = l2;
        Vertex ep11 = l1.getEndPoint1();    // end-point 1 of line 1
        Vertex ep21 = l1.getEndPoint2();    // end-point 2 of line 1
        Vertex ep12 = l2.getEndPoint1();    // end-point 1 of line 2
        Vertex ep22 = l2.getEndPoint2();    // end-point 2 of line 2
        if (ep11 == ep12)
            this.commonVertex = ep11;
        else if (ep11 == ep22)
            this.commonVertex = ep11;
        else if (ep21 == ep12)
            this.commonVertex = ep21;
        else if (ep21 == ep22) 
            this.commonVertex = ep21;
    }

    public Vertex getCommonVertex() {
        return this.commonVertex;
    }

    public Line getLine1() {
        return this.line1;
    }

    public Line getLine2() {
        return this.line2;
    } 

    public double getAngle() {
        return this.angle;
    }

    public void setCommonVertex() {
        Vertex ep11 = this.line1.getEndPoint1();    // end-point 1 of line 1
        Vertex ep21 = this.line1.getEndPoint2();    // end-point 2 of line 1
        Vertex ep12 = this.line2.getEndPoint1();    // end-point 1 of line 2
        Vertex ep22 = this.line2.getEndPoint2();    // end-point 2 of line 2
        if (ep11 == ep12)
            this.commonVertex = ep11;
        else if (ep11 == ep22)
            this.commonVertex = ep11;
        else if (ep21 == ep12)
            this.commonVertex = ep21;
        else if (ep21 == ep22) 
            this.commonVertex = ep21;
    }

    public void setLine1(Line l) {
        this.line1 = l;
    }

    public void setLine2(Line l) {
        this.line2 = l;
    }

    public void setAngle() {
        this.angle = this.calculateAngle();
    }

    public double calculateAngle() {
        return 0;
    }
}
