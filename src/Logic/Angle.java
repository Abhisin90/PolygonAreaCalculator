package Logic;

public class Angle {
    private Line line1;
    private Line line2;
    private double oppositeDiagonalLength;
    private double angle;

    public Angle(Line l1, Line l2) {
        this.line1 = l1;
        this.line2 = l2;
        this.angle = 90.0;
        int x1 = l1.getEndPoint1().getX();
        int y1 = l1.getEndPoint1().getY();
        int x2 = l2.getEndPoint2().getX();
        int y2 = l2.getEndPoint2().getY();
        this.oppositeDiagonalLength = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }

    public Line getLine1() {
        return this.line1;
    }

    public Line getLine2() {
        return this.line2;
    }

    public double getOppositeDiagonalLength() {
        return this.oppositeDiagonalLength;
    }

    public double getAngle() {
        return this.angle;
    }

    public void setLine1(Line l) {
        this.line1 = l;
    }

    public void setLine2(Line l) {
        this.line2 = l;
    }

    public void setOppositeDiagonalLength(double oppositeDiagonalLength) {
        this.oppositeDiagonalLength = oppositeDiagonalLength;
    }

    public void setAngle() {
        this.angle = this.calculateAngle();
    }

    public double calculateAngle() {
        double l1 = line1.getLength();
        double l2 = line2.getLength();
        int x1 = line1.getEndPoint1().getX();
        int y1 = line1.getEndPoint1().getY();
        int x2 = line2.getEndPoint2().getX();
        int y2 = line2.getEndPoint2().getY();
        this.oppositeDiagonalLength = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
        double dl = oppositeDiagonalLength;
        double angle = Math.acos((l1*l1 + l2*l2 - dl*dl) / (2*l1*l2));
        angle = Math.round(Math.toDegrees(angle)*100) / 100.0;

        return angle;
    }
}
