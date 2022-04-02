package fromUML;

class Line {

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(int x1, int y1, int x2, int y2) {

        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);

    }

    Point start;
    Point end;

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public double length() {
        return start.distance(end);
    }

    @Override
    public String toString() {
        return "Line [end=" + end + ", start=" + start + "]";
    }

}

public class LineDriver {
    public static void main(String[] args) {
        Line l1 = new Line(1, 2, 3, 7);
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 7);
        Line l2 = new Line(p1, p2);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l1.length());
        System.out.println(l2.length());
    }
}
