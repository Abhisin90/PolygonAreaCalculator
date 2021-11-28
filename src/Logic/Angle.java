package Logic;

public class Angle {
    private Line line1;
    private Line line2;
    private double angle;

    public Angle(Line l1, Line l2) {
        this.line1 = l1;
        this.line2 = l2;
        this.angle = 90.0;
    }

    public double getAngle() {
        return this.angle;
    }

    public void setAngle() {
        this.angle = this.calculateAngle();
    }

    public double calculateAngle() {
        int x1 = line1.getEndPoint1().getX();
        int y1 = line1.getEndPoint1().getY();
        int x2 = line2.getEndPoint2().getX();
        int y2 = line2.getEndPoint2().getY();
        int cvx = line1.getEndPoint2().getX();
        int cvy = line1.getEndPoint2().getY();
        double a1 = Math.atan2(x1 - cvx, y1 - cvy);
        a1 = Math.round(Math.toDegrees(a1) * 100) / 100.0;
        double a2 = Math.atan2(x2 - cvx, y2 - cvy);
        a2 = Math.round(Math.toDegrees(a2) * 100) / 100.0;
        double a = a2 - a1;
        if (a < 0) {
            a += 360;
        }

        return a;
    }
}
