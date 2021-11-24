import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Point[] points = new Point[n];
        double lineLength = 0;
        double x, y;
        x = sc.nextDouble();
        y = Double.parseDouble(sc.nextLine());
        Point prevPoint = new Point(x, y);
        points[0] = prevPoint;
        for (int i = 1; i < points.length; i++) {
            x = sc.nextDouble();
            y = Double.parseDouble(sc.nextLine());
            Point currPoint = new Point(x, y);
            points[i] = currPoint;
            lineLength += getDistance(prevPoint, currPoint);
            prevPoint = currPoint;
        }
        double midLength = lineLength / 2;
        Point result = findMiddlePoint(points, midLength);
        System.out.println(String.format("%.2f %.2f", result.x, result.y));
    }

    private static Point findMiddlePoint(Point[] points, double midLength){
        double lineDistance = 0;
        Point prevPoint = points[0];
        for (int i = 1; i < points.length; i++) {
            Point currPoint = points[i];
            double distance = getDistance(prevPoint, currPoint);
            if(lineDistance + distance < midLength)
                lineDistance += distance;
            else {
                double distanceFromPointA = midLength - lineDistance;
                double m = (currPoint.y - prevPoint.y) / (currPoint.x - prevPoint.x);
                double angle = Math.atan(m);
                double y = Math.sin(angle) * distanceFromPointA;
                double x = Math.cos(angle) * distanceFromPointA;
                Point result = new Point(prevPoint.x + x, prevPoint.y + y);
                return result;
            }
            prevPoint = currPoint;
        }
        return prevPoint;
    }

    private static double getDistance(Point p1, Point p2){
        double a = p1.x - p2.x;
        double a2 = a * a;
        double b = p1.y - p2.y;
        double b2 = b * b;
        double c = Math.sqrt(a2 + b2);
        return c;
    }

    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
